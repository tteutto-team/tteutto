package edu.kh.tteutto.notice.model.vo;

public class noticeImg {
	private String noticeImgNo;
	private String imgPath;
	private String imgNm;
	private String imgOriginal;
	private String noticeNo;
	
	public noticeImg() { }
	
	public String getNoticeImgNo() {
		return noticeImgNo;
	}

	public void setNoticeImgNo(String noticeImgNo) {
		this.noticeImgNo = noticeImgNo;
	}

	public String getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgNm() {
		return imgNm;
	}

	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}

	public String getImgOriginal() {
		return imgOriginal;
	}

	public void setImgOriginal(String imgOriginal) {
		this.imgOriginal = imgOriginal;
	}
	
}
