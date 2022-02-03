package edu.kh.tteutto.classRoom.model.vo;

public class ClassRegister {

	// 수강신청 테이블 (REGISTER)
	private int regNo; // 수강번호
	private String regNm; // 이름
	private String regPhoneNo; // 연락처
	private String payDt; // 결제일자
	private int payStauts; // 결제상태
	private int regStatus; // 수강신청상태
	
	
	public ClassRegister() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "ClassRegister [regNo=" + regNo + ", regNm=" + regNm + ", regPhoneNo=" + regPhoneNo + ", payDt=" + payDt
				+ ", payStauts=" + payStauts + ", regStatus=" + regStatus + "]";
	}
	
	
	
	
}
