package myjava;

public class Student {
	private String name;    //定义姓名
	private String no;      //定义学号
	private int sex;        //定义性别
	private int age;        //定义年龄
	private String major;   //定义专业
	private int classMajor;  //定义班级
	int courseNum = 3;
	private Grade[] grades = new Grade[courseNum];	//定义成绩数组

	//构造函数
	public Student(String name, String no, int sex, int age, String major, int classMajor,Grade[] grades)  {
		setName(name);
		setNo(no);
		setSex(sex);
		setAge(age);
		setMajor(major);
		setClassMajor(classMajor);
		setGrades(grades);
	}

	//无参构造
	public Student() {
	}
	//定义获取成绩 成员方法
	public Grade[] getGrades() {
		return grades;
	}
	//定义设置成绩 成员方法
	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}

	//定义获取姓名 成员方法
	public String getName() {
		return name;
	}

	//定义设置姓名 成员方法
	public void setName(String name) {
		this.name = name;
	}

	//定义获取学号 成员方法
	public String getNo() {
		return no;
	}

	//定义设置学号 成员方法
	public void setNo(String no) {
		this.no = no;
	}

	//定义获取性别 成员方法
	public int getSex() {
		return sex;
	}

	//定义设置性别 成员方法
	public int setSex(int sex) {
		if (sex == 1 || sex == 2) {
			this.sex = sex;
			return 1;
		} else return 0;
	}

	//定义获取年龄 成员方法
	public int getAge() {
		return age;
	}

	//定义设置年龄 成员方法
	public int setAge(int age) {
		if (age > 0) {
			this.age = age;
			return 1;
		} else return 0;
	}

	//定义获取专业 成员方法
	public String getMajor() {
		return major;
	}

	//定义设置专业 成员方法
	public void setMajor(String major) {
		this.major = major;
	}

	//定义获取班级 成员方法
	public int getClassMajor() {
		return classMajor;
	}

	//定义设置班级 成员方法
	public int setClassMajor(int classMajor) {
		if (classMajor > 0) {
			this.classMajor = classMajor;
			return 1;
		} else return 0;
	}

	//定义获取成员变量信息 方法
	public String toString() {
		char sexPrint;
		if (sex == 1) {
			sexPrint = '男';
		} else if (sex == 2) sexPrint = '女';
		else sexPrint = '?';

		return "Student{" + "name='" + name + '\'' + ", no='" + no + '\'' + ", sex=" + sexPrint + ", age=" + age +
				", major='" + major + '\'' + ", classMajor=" + classMajor + '}';
	}
}
