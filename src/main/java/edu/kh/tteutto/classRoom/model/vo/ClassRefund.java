package edu.kh.tteutto.classRoom.model.vo;

public class ClassRefund {

	private int refundNo;
	private String refundReqDt;
	private String refundFinDt;
	private int classProgress;
	private int refundMoney;
	private int refundStatus;
	private int regNo;
	private int epNo;
	
	public ClassRefund() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getEpNo() {
		return epNo;
	}



	public void setEpNo(int epNo) {
		this.epNo = epNo;
	}



	public int getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(int refundNo) {
		this.refundNo = refundNo;
	}
	public String getRefundReqDt() {
		return refundReqDt;
	}
	public void setRefundReqDt(String refundReqDt) {
		this.refundReqDt = refundReqDt;
	}
	public String getRefundFinDt() {
		return refundFinDt;
	}
	public void setRefundFinDt(String refundFinDt) {
		this.refundFinDt = refundFinDt;
	}
	public int getClassProgress() {
		return classProgress;
	}
	public void setClassProgress(int classProgress) {
		this.classProgress = classProgress;
	}
	public int getRefundMoney() {
		return refundMoney;
	}
	public void setRefundMoney(int refundMoney) {
		this.refundMoney = refundMoney;
	}
	public int getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(int refundStatus) {
		this.refundStatus = refundStatus;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}



	@Override
	public String toString() {
		return "ClassRefund [refundNo=" + refundNo + ", refundReqDt=" + refundReqDt + ", refundFinDt=" + refundFinDt
				+ ", classProgress=" + classProgress + ", refundMoney=" + refundMoney + ", refundStatus=" + refundStatus
				+ ", regNo=" + regNo + ", epNo=" + epNo + "]";
	}
	

	
	
}
