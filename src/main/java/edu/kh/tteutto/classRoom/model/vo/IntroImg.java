package edu.kh.tteutto.classRoom.model.vo;

public class IntroImg {

	private int introImgNo;
	private String introImgName;
	private int classNo;

	public IntroImg() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IntroImg [classNo=" + classNo + ", introImgName=" + introImgName + ", introImgNo=" + introImgNo + "]";
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getIntroImgName() {
		return introImgName;
	}

	public void setIntroImgName(String introImgName) {
		this.introImgName = introImgName;
	}

	public int getIntroImgNo() {
		return introImgNo;
	}

	public void setIntroImgNo(int introImgNo) {
		this.introImgNo = introImgNo;
	}

}
