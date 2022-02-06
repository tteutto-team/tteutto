package edu.kh.tteutto.classRoom.model.vo;

public class ClassDetailImage {

	// 클래스 소개 이미지 테이블(INTRO_IMG)
	private int introImgNo;
	private String introImgNm;
	
	// 썸네일 이미지 테이블
	private int thImgNo; // 썸네일 이미지 번호
	private String thImgNm; // 썸네일 이미지명
	private int thImgLevel; // 썸네일 이미지 위치
	private int classNo; // 클래스번호
	
	public ClassDetailImage() {
		// TODO Auto-generated constructor stub
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getIntroImgNo() {
		return introImgNo;
	}

	public void setIntroImgNo(int introImgNo) {
		this.introImgNo = introImgNo;
	}

	public String getIntroImgNm() {
		return introImgNm;
	}

	public void setIntroImgNm(String introImgNm) {
		this.introImgNm = introImgNm;
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

	@Override
	public String toString() {
		return "ClassDetailImage [introImgNo=" + introImgNo + ", introImgNm=" + introImgNm + ", thImgNo=" + thImgNo
				+ ", thImgNm=" + thImgNm + ", thImgLevel=" + thImgLevel + ", classNo=" + classNo + "]";
	}


	
}
