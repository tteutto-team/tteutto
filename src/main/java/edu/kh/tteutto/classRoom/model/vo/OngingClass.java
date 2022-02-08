package edu.kh.tteutto.classRoom.model.vo;

public class OngingClass {

	private int studentNo;	// 학생 번호

	private String classNo;
	private String className;
	private String epCount;
	private String studentName;	// 학생 이름
	private String memberGender;	// 성별
	private int reportCount;	// 신고 횟수
	
	public OngingClass() {	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getEpCount() {
		return epCount;
	}

	public void setEpCount(String epCount) {
		this.epCount = epCount;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	@Override
	public String toString() {
		return "OngingClass [studentNo=" + studentNo + ", classNo=" + classNo + ", className=" + className
				+ ", epCount=" + epCount + ", studentName=" + studentName + ", memberGender=" + memberGender
				+ ", reportCount=" + reportCount + "]";
	}

	
}
