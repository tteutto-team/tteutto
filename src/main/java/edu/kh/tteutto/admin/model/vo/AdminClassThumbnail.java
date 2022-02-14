package edu.kh.tteutto.admin.model.vo;

public class AdminClassThumbnail {
	private int ThumbnailImgNo;
	private String ThumbnailImgName;
	private int ThumbnailImgLevel;
	private int classNo;
	
	public AdminClassThumbnail() {
	}

	public int getThumbnailImgNo() {
		return ThumbnailImgNo;
	}

	public void setThumbnailImgNo(int thumbnailImgNo) {
		ThumbnailImgNo = thumbnailImgNo;
	}

	public String getThumbnailImgName() {
		return ThumbnailImgName;
	}

	public void setThumbnailImgName(String thumbnailImgName) {
		ThumbnailImgName = thumbnailImgName;
	}

	public int getThumbnailImgLevel() {
		return ThumbnailImgLevel;
	}

	public void setThumbnailImgLevel(int thumbnailImgLevel) {
		ThumbnailImgLevel = thumbnailImgLevel;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	@Override
	public String toString() {
		return "AdminClassThumbnail [ThumbnailImgNo=" + ThumbnailImgNo + ", ThumbnailImgName=" + ThumbnailImgName
				+ ", ThumbnailImgLevel=" + ThumbnailImgLevel + ", classNo=" + classNo + "]";
	}

}
