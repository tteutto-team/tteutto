package edu.kh.tteutto.classRoom.model.vo;

public class ThumnailImg {
	
	//썸네일 이미지 테이블
	private int thImgNo; //썸네일번호
	private String thImgNm; //썸네일이미지 이름
	private int thImgLevel; // 썸네일 이미지 레벨
	private int classNo; // 클래스 번호
	
	public ThumnailImg() {
		// TODO Auto-generated constructor stub
	}

	public int getThImgNo() {
		return thImgNo;
	}

	public void setThImgNo(int thImgNo) {
		this.thImgNo = thImgNo;
	}

	public String getThImgNm() {
		return thImgNm;
	}

	public void setThImgNm(String thImgNm) {
		this.thImgNm = thImgNm;
	}

	public int getThImgLevel() {
		return thImgLevel;
	}

	public void setThImgLevel(int thImgLevel) {
		this.thImgLevel = thImgLevel;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	@Override
	public String toString() {
		return "ThumnailImg [thImgNo=" + thImgNo + ", thImgNm=" + thImgNm + ", thImgLevel=" + thImgLevel + ", classNo="
				+ classNo + "]";
	}
	
	

}
