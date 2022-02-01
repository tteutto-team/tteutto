package edu.kh.tteutto.member.model.vo;

public class Career {

//	강사 이력 테이블
	private int memberNo;
	private int careerNo;
	private String careerContent;
	private String imgPath;
	private String imgName;
	private String imgOriginal;
	
	
	public Career() {
		// TODO Auto-generated constructor stub
	}
	

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getCareerNo() {
		return careerNo;
	}

	public void setCareerNo(int careerNo) {
		this.careerNo = careerNo;
	}

	public String getCareerContent() {
		return careerContent;
	}

	public void setCareerContent(String careerContent) {
		this.careerContent = careerContent;
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
		return "Career [memberNo=" + memberNo + ", careerNo=" + careerNo + ", careerContent=" + careerContent
				+ ", imgPath=" + imgPath + ", imgName=" + imgName + ", imgOriginal=" + imgOriginal + "]";
	}


}
