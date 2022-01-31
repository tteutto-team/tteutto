package edu.kh.tteutto.classRoom.model.vo;

import java.util.Date;

public class ClassDetail {
	
	//클래스 테이블
	private int classNo;
	private String classArea;
	private int classType;
	private int classPerson;
	private int classMinPerson;
	private int classMaxPerson;
	private String classaName;
	private String classIntro;  // data_type : CLOB  //수업소개
	private String classLevel;  // char // 난이도
	private String classReqDate;  // date // 승인요청일자
	private int classStatus; //클래스 상태
	private int categoryNo; //카테고리 번호
	private int memberNo; //회원번호
	
	//클래스 카테고리 테이블
	private String categoryNm; //카테고리명
	
	// EPISODE 테이블 (회차)
	private int epNo; //회차 번호
	private int epPrice; //수업료
	private int epStatus; //회차 상태
	private int epCount; // 회차 카운트
	
	// 클래스 소개 이미지 테이블(INTRO_IMG)
	private int introImgNo;
	private String introImgNm;
	
	// 수강신청 테이블 (REGISTER)
	private int regNo; // 수강번호
	private String regNm; // 이름
	private String regPhoneNo; // 연락처
	private String payDt; // 결제일자
	private int payStauts; // 결제상태
	private int regStatus; // 수강신청상태
	
	//후기 테이블 
	private int reviewNo; // 후기번호
	private int reviewStar; //후기별점
	private String reviewContent; //후기 내용
	private String reviewDt; // 후기 작성일자
	private String reviewStatus; //후기 상태
	
	// SNS 테이블
	private int snsNo; // sns 번호
	private String snsLink; // sns 링크
	private int snsDivision; //sns 구분번호
	
	
	// 강사 테이블
	private String teacherImg; //강사 프로필사진
	private String teacherIntro; //강사소개
	
	
	// 썸네일 이미지 테이블
	private int thImgNo; // 썸네일 이미지 번호
	private String thImgNm; // 썸네일 이미지명
	private int thImgLevel; // 썸네일 이미지 위치
	
	
	
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
	public String getClassaName() {
		return classaName;
	}
	public void setClassaName(String classaName) {
		this.classaName = classaName;
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
	public String getCategoryNm() {
		return categoryNm;
	}
	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}
	public int getEpNo() {
		return epNo;
	}
	public void setEpNo(int epNo) {
		this.epNo = epNo;
	}
	public int getEpPrice() {
		return epPrice;
	}
	public void setEpPrice(int epPrice) {
		this.epPrice = epPrice;
	}
	public int getEpStatus() {
		return epStatus;
	}
	public void setEpStatus(int epStatus) {
		this.epStatus = epStatus;
	}
	public int getEpCount() {
		return epCount;
	}
	public void setEpCount(int epCount) {
		this.epCount = epCount;
	}
	public int getIntroImgNo() {
		return introImgNo;
	}
	public void setIntroImgNo(int introImgNo) {
		this.introImgNo = introImgNo;
	}
	public String getIntroImgNm() {
		return introImgNm;
	}
	public void setIntroImgNm(String introImgNm) {
		this.introImgNm = introImgNm;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getRegNm() {
		return regNm;
	}
	public void setRegNm(String regNm) {
		this.regNm = regNm;
	}
	public String getRegPhoneNo() {
		return regPhoneNo;
	}
	public void setRegPhoneNo(String regPhoneNo) {
		this.regPhoneNo = regPhoneNo;
	}
	public String getPayDt() {
		return payDt;
	}
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	public int getPayStauts() {
		return payStauts;
	}
	public void setPayStauts(int payStauts) {
		this.payStauts = payStauts;
	}
	public int getRegStatus() {
		return regStatus;
	}
	public void setRegStatus(int regStatus) {
		this.regStatus = regStatus;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDt() {
		return reviewDt;
	}
	public void setReviewDt(String reviewDt) {
		this.reviewDt = reviewDt;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public int getSnsNo() {
		return snsNo;
	}
	public void setSnsNo(int snsNo) {
		this.snsNo = snsNo;
	}
	public String getSnsLink() {
		return snsLink;
	}
	public void setSnsLink(String snsLink) {
		this.snsLink = snsLink;
	}
	public int getSnsDivision() {
		return snsDivision;
	}
	public void setSnsDivision(int snsDivision) {
		this.snsDivision = snsDivision;
	}
	public String getTeacherImg() {
		return teacherImg;
	}
	public void setTeacherImg(String teacherImg) {
		this.teacherImg = teacherImg;
	}
	public String getTeacherIntro() {
		return teacherIntro;
	}
	public void setTeacherIntro(String teacherIntro) {
		this.teacherIntro = teacherIntro;
	}
	public int getThImgNo() {
		return thImgNo;
	}
	public void setThImgNo(int thImgNo) {
		this.thImgNo = thImgNo;
	}
	public String getThImgNm() {
		return thImgNm;
	}
	public void setThImgNm(String thImgNm) {
		this.thImgNm = thImgNm;
	}
	public int getThImgLevel() {
		return thImgLevel;
	}
	public void setThImgLevel(int thImgLevel) {
		this.thImgLevel = thImgLevel;
	}


	@Override
	public String toString() {
		return "ClassDetail [classNo=" + classNo + ", classArea=" + classArea + ", classType=" + classType
				+ ", classPerson=" + classPerson + ", classMinPerson=" + classMinPerson + ", classMaxPerson="
				+ classMaxPerson + ", classaName=" + classaName + ", classIntro=" + classIntro + ", classLevel="
				+ classLevel + ", classReqDate=" + classReqDate + ", classStatus=" + classStatus + ", categoryNo="
				+ categoryNo + ", memberNo=" + memberNo + ", categoryNm=" + categoryNm + ", epNo=" + epNo + ", epPrice="
				+ epPrice + ", epStatus=" + epStatus + ", epCount=" + epCount + ", introImgNo=" + introImgNo
				+ ", introImgNm=" + introImgNm + ", regNo=" + regNo + ", regNm=" + regNm + ", regPhoneNo=" + regPhoneNo
				+ ", payDt=" + payDt + ", payStauts=" + payStauts + ", regStatus=" + regStatus + ", reviewNo="
				+ reviewNo + ", reviewStar=" + reviewStar + ", reviewContent=" + reviewContent + ", reviewDt="
				+ reviewDt + ", reviewStatus=" + reviewStatus + ", snsNo=" + snsNo + ", snsLink=" + snsLink
				+ ", snsDivision=" + snsDivision + ", teacherImg=" + teacherImg + ", teacherIntro=" + teacherIntro
				+ ", thImgNo=" + thImgNo + ", thImgNm=" + thImgNm + ", thImgLevel=" + thImgLevel + "]";
	}


	
	
	
	

}
