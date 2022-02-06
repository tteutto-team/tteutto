package edu.kh.tteutto.admin.model.vo;

public class Admin {

	// ************ 필드 **************
	// 클래스 테이블
	private int classNo; // 클래스 번호
	private String className; // 클래스 이름
	private String classRequestDate; // 클래스 생성 날짜

	// 클래스 회차 테이블
	private int episodeCount; // 클래스 회차

	// 회원
	private int memberNo; // 회원 번호
	private String memberName; // 강사명
	private int memberGrade; // 회원구분
	private int memberStatus; // 회원 상태
	private String memberBirth; // 생년월일
	private char memberGender; // 성별
	private String memberPhone; // 전화번호
	private char teacherEnroll; // 강사 등록 여부

	// ************ 필드 **************

	// 생성자
	public Admin() {
	}

	// getter / setter
	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassRequestDate() {
		return classRequestDate;
	}

	public void setClassRequestDate(String classRequestDate) {
		this.classRequestDate = classRequestDate;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public int getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(int memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public char getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(char memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public char getTeacherEnroll() {
		return teacherEnroll;
	}

	public void setTeacherEnroll(char teacherEnroll) {
		this.teacherEnroll = teacherEnroll;
	}

	@Override
	public String toString() {
		return "Admin [classNo=" + classNo + ", className=" + className + ", classRequestDate=" + classRequestDate
				+ ", episodeCount=" + episodeCount + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", memberGrade=" + memberGrade + ", memberStatus=" + memberStatus + ", memberBirth=" + memberBirth
				+ ", memberGender=" + memberGender + ", memberPhone=" + memberPhone + ", teacherEnroll=" + teacherEnroll
				+ "]";
	}

}
