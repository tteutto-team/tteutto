package edu.kh.tteutto.classRoom.model.vo;

public class ClassReport {

	private int reportNo;
	private int reportDiv;
	private String reportContent;
	private int reportStatus;
	private int regNo;
	private String reportReqDate;

	public ClassReport() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getReportDiv() {
		return reportDiv;
	}

	public void setReportDiv(int reportDiv) {
		this.reportDiv = reportDiv;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public int getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(int reportStatus) {
		this.reportStatus = reportStatus;
	}

	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public String getReportReqDate() {
		return reportReqDate;
	}

	public void setReportReqDate(String reportReqDate) {
		this.reportReqDate = reportReqDate;
	}


	@Override
	public String toString() {
		return "ClassReport [reportNo=" + reportNo + ", reportDiv=" + reportDiv + ", reportContent=" + reportContent
				+ ", reportStatus=" + reportStatus + ", regNo=" + regNo + ", reportReqDate=" + reportReqDate + "]";
	}

	
	
}
