package edu.kh.tteutto.notice.model.vo;

import java.util.List;

public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDt;
	private String noticeImgNo;
	private List<noticeImg> imgList;
	
	
	public Notice() { }

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

	public String getNoticeDt() {
		return noticeDt;
	}

	public void setNoticeDt(String noticeDt) {
		this.noticeDt = noticeDt;
	}

	public String getNoticeImgNo() {
		return noticeImgNo;
	}

	public void setNoticeImgNo(String noticeImgNo) {
		this.noticeImgNo = noticeImgNo;
	}

	public List<noticeImg> getImgList() {
		return imgList;
	}

	public void setImgList(List<noticeImg> imgList) {
		this.imgList = imgList;
	}
	
}
