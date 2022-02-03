package edu.kh.tteutto.admin.model.vo;

public class AdminNoticeImage {
	private int noticeImgNo;
	private int noticeNo;
	private String imgPath;
	private String imgName;
	private String imgOriginal;
	
	public AdminNoticeImage() {
	}

	public int getNoticeImgNo() {
		return noticeImgNo;
	}

	public void setNoticeImgNo(int noticeImgNo) {
		this.noticeImgNo = noticeImgNo;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgOriginal() {
		return imgOriginal;
	}

	public void setImgOriginal(String imgOriginal) {
		this.imgOriginal = imgOriginal;
	}

	@Override
	public String toString() {
		return "AdminNoticeImage [noticeImgNo=" + noticeImgNo + ", noticeNo=" + noticeNo + ", imgPath=" + imgPath
				+ ", imgName=" + imgName + ", imgOriginal=" + imgOriginal + "]";
	}

}
