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
	private String memberName; // 강사명
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

	@Override
	public String toString() {
		return "Admin [classNo=" + classNo + ", className=" + className + ", classRequestDate=" + classRequestDate
				+ ", episodeCount=" + episodeCount + ", memberName=" + memberName + "]";
	}


}
