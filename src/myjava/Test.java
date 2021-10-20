package myjava;

import java.util.Scanner;

/**
 * -> equals方法使用的时候，对象必须初始化过，String不可以是null
 * 查找或删除的时候，按照姓名时，如果有重名的
 * 新建学生的时候，检查学生数组中是否已有此学号
 * 查找学生的时候如果学号或姓名不存在？    return值！=null
 * 213行？
 */
public class Test {

    public static int init = 0;         //学生人数计数器
    static final int COURSE_NUM = 3;    //定义初始课程数目

    public static void main(String[] args) {
        final int STUDENT_SUM = 100;                //定义初始化学生人数
        Student[] stu = new Student[STUDENT_SUM];   //定义学生 对象数组
        Scanner inPut = new Scanner(System.in);

        //初始化学生，学号，姓名设为0
        for (int i = 0; i < stu.length; i++) {
            stu[i] = new Student();
            stu[i].setNo("0");
            stu[i].setName("0");

        }
        //定义主菜单选择
        int myMenuSelect;
        //3.主循环
        while (true) {
            //打印主菜单
            printMenu();
            //从键盘输入主菜单选项
            myMenuSelect = inPut.nextInt();
            switch (myMenuSelect) {
                case 1:     //添加学生
                    stu = testAddStudent(stu);
                    break;
                case 2:     //查找学生
                    testSearchStudent(stu);
                    break;
                case 3:     //修改学生信息
                    stu = testUpdateStudent(stu);
                    break;
                case 4:     //删除学生
                    stu = testDeleteStudent(stu);
                    break;
                case 5:     //查询成绩
                    testSearchStudentGrade(stu);
                    break;
                case 0:     //退出系统
                    System.out.println("欢迎再次使用！");
                    return;
                default:
                    System.out.println("输入错误，请重新输入：");
                    break;
            }//switch OVER
        }//主while Over
    }

    //打印菜单
    public static void printMenu() {
        System.out.println("*************************");
        System.out.println("***** 1 -> 添加学生  *****");
        System.out.println("***** 2 -> 查找学生  *****");
        System.out.println("***** 3 -> 修改学生  *****");
        System.out.println("***** 4 -> 删除学生  *****");
        System.out.println("***** 5 -> 查询成绩  *****");
        System.out.println("***** 0 -> 退出系统  *****");
        System.out.println("*************************");
        System.out.println("学生总人数：" + init);
        System.out.println("请输入您的选择：");

    }

    //添加学生
    public static Student[] testAddStudent(Student[] stu) {
        Service service = new Service(stu);
        service.addStudent(newAddStudent());
        init++;                                 //学生人数计数器+1
        return service.findAllStudent();        //返回学生数组
    }

    //查找学生
    public static void testSearchStudent(Student[] stu) {
        Scanner inPut = new Scanner(System.in);
        Service service = new Service(stu);
        //选择查找方式
        int mySearchSelect;
        System.out.println("请选择 按学号查找(1) 或 按姓名查找(2)，默认1");
        mySearchSelect = inPut.nextInt();
        if (mySearchSelect == 1) {
            String findNo;
            System.out.println("请输入要查找的学号：");
            findNo = inPut.next();
            //当查找学生不存在时，返回null，再打印会出错
            if (service.findStudentByNo(findNo) != null) {
                System.out.println("您查找的信息如下：");
                System.out.println(service.findStudentByNo(findNo).toString());
            }
        } else {
            String findName;
            System.out.println("请输入要查找的姓名：");
            findName = inPut.next();
            if (service.findStudentByName(findName) != null) {
                System.out.println("您查找的信息如下：");
                System.out.println(service.findStudentByName(findName).toString());
            }
        }
    }//testSearchStudent Over

    //修改学生信息
    public static Student[] testUpdateStudent(Student[] stu) {
        Scanner inPut = new Scanner(System.in);
        Service service = new Service(stu);
        Student tempStudent;        //定义一个临时对象
        String findNo;
        //选择查找方式
        int mySearchSelect;
        System.out.println("请选择 按学号查找并修改(1) 或 按姓名查找并修改(2)，默认1");
        mySearchSelect = inPut.nextInt();
        if (mySearchSelect == 1) {
            System.out.println("请输入要查找的学号：");
            findNo = inPut.next();
            if (service.findStudentByNo(findNo) != null) {
                System.out.println("您要修改的学生信息如下：");
                System.out.println(service.findStudentByNo(findNo).toString());
                for(int j=0;j<service.findStudentByNo(findNo).getGrades().length;j++){
                    System.out.println(service.findStudentByNo(findNo).getGrades()[j].getCourseName()+"的成绩是：\t"+service.findStudentByNo(findNo).getGrades()[j].getCourseGrade());
                }
                tempStudent = service.findStudentByNo(findNo);
            } else return service.findAllStudent();
        } else {
            String findName;
            System.out.println("请输入要查找的姓名：");
            findName = inPut.next();
            if (service.findStudentByName(findName) != null) {
                System.out.println("您要修改的学生信息如下：");
                System.out.println(service.findStudentByName(findName).toString());
                tempStudent = service.findStudentByName(findName);
                findNo = tempStudent.getNo();
            } else return service.findAllStudent();
        }
        service.updateStudent(findNo, newAddStudent());
        return service.findAllStudent();
    }//testUpdateStudent Over

    //删除学生
    public static Student[] testDeleteStudent(Student[] stu) {
        Scanner inPut = new Scanner(System.in);
        Service service = new Service(stu);
        String delNo;
        Student tempStudent;        //定义临时对象
        //选择查找方式
        int mySearchSelect;
        System.out.println("请选择 按学号查找并删除(1) 或 按姓名查找并删除(2)，默认1");
        mySearchSelect = inPut.nextInt();
        if (mySearchSelect == 1) {
            System.out.println("请输入要删除的学号：");
            delNo = inPut.next();
            if (service.findStudentByNo(delNo) != null) {
                System.out.println("您要删除的学生信息如下：");
                System.out.println(service.findStudentByNo(delNo).toString());
                tempStudent = service.findStudentByNo(delNo);
            } else return service.findAllStudent();
        } else {
            String delName;
            System.out.println("请输入要删除的姓名：");
            delName = inPut.next();
            if (service.findStudentByName(delName) != null) {
                System.out.println("您要删除的学生信息如下：");
                System.out.println(service.findStudentByName(delName).toString());
                tempStudent = service.findStudentByName(delName);
                delNo = tempStudent.getNo();
            } else return service.findAllStudent();
        }
        //删除再次确认？
        int deleteConfirmChoose;
        System.out.println("请再次确认是否删除？是(1)否(0)");
        deleteConfirmChoose = inPut.nextInt();
        if (deleteConfirmChoose == 1) {
            service.deleteStudent(delNo);
            init--;                         //学生人数-1
        }
        return service.findAllStudent();
    }

    //查找指定成绩
    public static void testSearchStudentGrade(Student[] stu) {
        Scanner inPut = new Scanner(System.in);
        Service service = new Service(stu);
        Student tempStudent;     //定义临时对象
        int mySearchSelect;
        System.out.println("请选择 按学号查询(1) 或 按姓名查询(2)，默认1");
        mySearchSelect = inPut.nextInt();
        if (mySearchSelect == 1) {
            String findNo;
            System.out.println("请输入要查询的学号：");
            findNo = inPut.next();
            if (service.findStudentByNo(findNo) != null) {
                tempStudent = service.findStudentByNo(findNo);
                service.searchStudentGrades(tempStudent);
            }
        }
        else {
            String findName;
            System.out.println("请输入要查询的姓名：");
            findName = inPut.next();
            if (service.findStudentByName(findName) != null) {
                tempStudent = service.findStudentByName(findName);
                service.searchStudentGrades(tempStudent);
            }
        }
//        service.searchStudentGrades(tempStudent);   -》-》=》=》不可以在这里用tempStudent？？？
    }//testSearchStudentGrade Over

    //新定义学生
    public static Student newAddStudent() {
        Scanner inPut = new Scanner(System.in);
        String addName;    //定义姓名
        String addNo;      //定义学号
        int addSex;       //定义性别
        int addAge;        //定义年龄
        String addMajor;   //定义专业
        int addClassMajor;  //定义班级
        String courseNameThis; //定义课程名称
        double courseGradeThis;//定义课程成绩
        Grade[] grades = new Grade[COURSE_NUM];     //定义成绩
        System.out.println("请输入姓名：");
        addName = inPut.next();
        System.out.println("请输入学号：");
        addNo = inPut.next();
        while (true) {
            System.out.println("请输入性别(男1女2)：");
            addSex = inPut.nextInt();
            if (addSex != 1 && addSex != 2) {
                System.out.println("输入有误，请重新输入！");
            } else break;
        }
        while (true) {
            System.out.println("请输入年龄：");
            addAge = inPut.nextInt();
            if (addAge < 1) {
                System.out.println("输入有误，请重新输入！");
            } else break;
        }
        System.out.println("请输入专业：");
        addMajor = inPut.next();
        while (true) {
            System.out.println("请输入班级：");
            addClassMajor = inPut.nextInt();
            if (addClassMajor < 1) {
                System.out.println("输入有误，请重新输入！");
            } else break;
        }
        for (int j = 0; j < grades.length; j++) {
            System.out.println("请输入课程" + (j + 1) + "的名称：");
            courseNameThis = inPut.next();
            grades[j] = new Grade();
            grades[j].setCourseName(courseNameThis);
            System.out.println("请输入课程" + (j + 1) + courseNameThis + "的成绩：");
            courseGradeThis = inPut.nextDouble();
            grades[j].setCourseGrade(courseGradeThis);
        }
        return (new Student(addName, addNo, addSex, addAge, addMajor, addClassMajor, grades));
    }
}
