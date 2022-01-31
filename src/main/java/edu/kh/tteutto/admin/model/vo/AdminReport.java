package edu.kh.tteutto.admin.model.vo;

public class AdminReport {
	private int reportNo;
	private int reportDiv;
	private String reportContent;
	private int reportStatus;
	private String reportRequestDate;

	private int registerNo;

	private String reportName;
	private String reportTarget;
	private int reportTargetNo;
	private int reportCount;

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

	public String getReportRequestDate() {
		return reportRequestDate;
	}

	public void setReportRequestDate(String reportRequestDate) {
		this.reportRequestDate = reportRequestDate;
	}

	public int getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportTarget() {
		return reportTarget;
	}

	public void setReportTarget(String reportTarget) {
		this.reportTarget = reportTarget;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public int getReportTargetNo() {
		return reportTargetNo;
	}

	public void setReportTargetNo(int reportTargetNo) {
		this.reportTargetNo = reportTargetNo;
	}

	@Override
	public String toString() {
		return "AdminReport [reportNo=" + reportNo + ", reportDiv=" + reportDiv + ", reportContent=" + reportContent
				+ ", reportStatus=" + reportStatus + ", reportRequestDate=" + reportRequestDate + ", registerNo="
				+ registerNo + ", reportName=" + reportName + ", reportTarget=" + reportTarget + ", reportTargetNo="
				+ reportTargetNo + ", reportCount=" + reportCount + "]";
	}

}
