package myjava;

public class Grade {
	final int OK = 1;
	final int ERROR = 0;
//	private String studentNo;
//	private int chineseGrade;
//	private int mathGrade;
//	private int englishGrade;
////构造函数
//	public Grade(String studentNo,int chineseGrade,int mathGrade,int englishGrade){
//		this.studentNo = studentNo;
//		this.chineseGrade = chineseGrade;
//		this.mathGrade = mathGrade;
//		this.englishGrade = englishGrade;
//	}
//	public int getChinese() {
//		return chineseGrade;
//	}
//
//	public int setChinese(int chinese) {
//		if(chinese>=0){
//			this.chineseGrade = chinese;
//			return 1;
//		}
//		else return 0;
//	}
//
//	public int getMath() {
//		return mathGrade;
//	}
//
//	public void setMath(int math) {
//		if(math>=0)
//			this.mathGrade = math;
//	}
//
//	public int getEnglish() {
//		return englishGrade;
//	}
//
//	public void setEnglish(int english) {
//		if(english>=0)
//			this.englishGrade = english;
//	}
//
//	@Override
//	public String toString() {
//		return "Grade{" +
//				"studentNo='" + studentNo + '\'' +
//				", chineseGrade=" + chineseGrade +
//				", mathGrade=" + mathGrade +
//				", englishGrade=" + englishGrade +
//				'}';
//	}
	private String courseName;
	private double courseGrade;
//获取课程名字
	public String getCourseName() {
		return courseName;
	}
//设置课程名字
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
//获取课程成绩
	public double getCourseGrade() {
		return courseGrade;
	}
//设置课程成绩
	public void setCourseGrade(double courseGrade) {
		if(courseGrade >= 0){
			this.courseGrade = courseGrade;
			return;
		}
		else{
			System.out.println("输入错误！");
			return;
		}
	}
}
