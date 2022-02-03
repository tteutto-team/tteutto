package edu.kh.tteutto.classRoom.model.vo;

//import java.util.Date;

public class ClassDetail {
	
	//클래스 테이블
	private int classNo;
	private String classArea;
	private int classType;
	private int classPerson;
	private int classMinPerson;
	private int classMaxPerson;
	private String className;
	private String classIntro;  // data_type : CLOB  //수업소개
	private String classLevel;  // char // 난이도
	private String classReqDate;  // date // 승인요청일자
	private int classStatus; //클래스 상태
	private int categoryNo; //카테고리 번호
	private int memberNo; //회원번호
	private int categoryDetailNo; // 세부카테고리번호
	
	//클래스 카테고리 테이블
	private String categoryNm; //카테고리명
	
	
	
//	// SNS 테이블
//	private int snsNo; // sns 번호
//	private String snsLink; // sns 링크
//	private int snsDivision; //sns 구분번호
	
	
	
	public ClassDetail() {
		// TODO Auto-generated constructor stub
	}



	public int getClassNo() {
		return classNo;
	}



	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}



	public String getClassArea() {
		return classArea;
	}



	public void setClassArea(String classArea) {
		this.classArea = classArea;
	}



	public int getClassType() {
		return classType;
	}



	public void setClassType(int classType) {
		this.classType = classType;
	}



	public int getClassPerson() {
		return classPerson;
	}



	public void setClassPerson(int classPerson) {
		this.classPerson = classPerson;
	}



	public int getClassMinPerson() {
		return classMinPerson;
	}



	public void setClassMinPerson(int classMinPerson) {
		this.classMinPerson = classMinPerson;
	}



	public int getClassMaxPerson() {
		return classMaxPerson;
	}



	public void setClassMaxPerson(int classMaxPerson) {
		this.classMaxPerson = classMaxPerson;
	}

	public String getclassName() {
		return className;
	}
	public void setclassName(String className) {
		this.className = className;
	}



	public String getClassIntro() {
		return classIntro;
	}



	public void setClassIntro(String classIntro) {
		this.classIntro = classIntro;
	}



	public String getClassLevel() {
		return classLevel;
	}



	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}



	public String getClassReqDate() {
		return classReqDate;
	}



	public void setClassReqDate(String classReqDate) {
		this.classReqDate = classReqDate;
	}



	public int getClassStatus() {
		return classStatus;
	}



	public void setClassStatus(int classStatus) {
		this.classStatus = classStatus;
	}



	public int getCategoryNo() {
		return categoryNo;
	}



	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public int getCategoryDetailNo() {
		return categoryDetailNo;
	}



	public void setCategoryDetailNo(int categoryDetailNo) {
		this.categoryDetailNo = categoryDetailNo;
	}



	public String getCategoryNm() {
		return categoryNm;
	}



	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}



	@Override
	public String toString() {
		return "ClassDetail [classNo=" + classNo + ", classArea=" + classArea + ", classType=" + classType
				+ ", classPerson=" + classPerson + ", classMinPerson=" + classMinPerson + ", classMaxPerson="
				+ classMaxPerson + ", className=" + className + ", classIntro=" + classIntro + ", classLevel="
				+ classLevel + ", classReqDate=" + classReqDate + ", classStatus=" + classStatus + ", categoryNo="
				+ categoryNo + ", memberNo=" + memberNo + ", categoryDetailNo=" + categoryDetailNo + ", categoryNm="
				+ categoryNm + "]";
	}
	

	
	


	
	
	
	

}
