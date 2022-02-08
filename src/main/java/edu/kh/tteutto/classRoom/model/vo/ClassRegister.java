package edu.kh.tteutto.classRoom.model.vo;

import java.util.Date;

public class ClassRegister {

	// 수강신청 테이블 (REGISTER)
	private int regNo; // 수강번호
	private String regNm; // 이름
	private String regPhoneNo; // 연락처
	private String payDt; // 결제일자
	private int payStauts; // 결제상태
	private int regStatus; // 수강신청상태
	
	private int epNo; //회차번호
	
	private String memberNm; // 강사명
	private int classNo; // 클래스번호
	private String className;// 클래스제목
	private int classStatus; // 클래스상태
	private String scheduleDate; // 수업날짜
	private int refundStatus; // 환불상태
	private int refundMoney; // 환불금액
	private int memberNo; // 회원번호
	
	public ClassRegister() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public String getMemberNm() {
		return memberNm;
	}




	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}




	public int getClassNo() {
		return classNo;
	}



	public void setClassNo(int classNo) {
		this.classNo = classNo;
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
	

	public int getEpNo() {
		return epNo;
	}

	public void setEpNo(int epNo) {
		this.epNo = epNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getClassStatus() {
		return classStatus;
	}

	public void setClassStatus(int classStatus) {
		this.classStatus = classStatus;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public int getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(int refundStatus) {
		this.refundStatus = refundStatus;
	}

	public int getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(int refundMoney) {
		this.refundMoney = refundMoney;
	}




	@Override
	public String toString() {
		return "ClassRegister [regNo=" + regNo + ", regNm=" + regNm + ", regPhoneNo=" + regPhoneNo + ", payDt=" + payDt
				+ ", payStauts=" + payStauts + ", regStatus=" + regStatus + ", epNo=" + epNo + ", memberNm=" + memberNm
				+ ", classNo=" + classNo + ", className=" + className + ", classStatus=" + classStatus
				+ ", scheduleDate=" + scheduleDate + ", refundStatus=" + refundStatus + ", refundMoney=" + refundMoney
				+ ", memberNo=" + memberNo + "]";
	}


	
	
	
}	
	