package edu.kh.tteutto.admin.model.vo;

import java.util.List;

public class AdminNoticeFaq {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;

	private int faqNo;
	private int faqDiv;
	private String faqQuestion;
	private String faqAnswer;

	private List<AdminNoticeImage> imgList;
	
	public AdminNoticeFaq() {
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public int getFaqDiv() {
		return faqDiv;
	}

	public void setFaqDiv(int faqDiv) {
		this.faqDiv = faqDiv;
	}

	public String getFaqQuestion() {
		return faqQuestion;
	}

	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}

	public String getFaqAnswer() {
		return faqAnswer;
	}

	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}

	public List<AdminNoticeImage> getImgList() {
		return imgList;
	}

	public void setImgList(List<AdminNoticeImage> imgList) {
		this.imgList = imgList;
	}

	@Override
	public String toString() {
		return "AdminNoticeFaq [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent="
				+ noticeContent + ", noticeDate=" + noticeDate + ", faqNo=" + faqNo + ", faqDiv=" + faqDiv
				+ ", faqQuestion=" + faqQuestion + ", faqAnswer=" + faqAnswer + ", imgList=" + imgList + "]";
	}

}
