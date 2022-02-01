package edu.kh.tteutto.admin.model.vo;

public class AdminTeacherCareer {

	private int careerNo;
	private String careerContent;
	private int memberNo;
	private String imgPath;
	private String imgName;
	private String imgOriginal;

	public AdminTeacherCareer() {
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

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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
		return "AdminTeacherCareer [careerNo=" + careerNo + ", careerContent=" + careerContent + ", memberNo="
				+ memberNo + ", imgPath=" + imgPath + ", imgName=" + imgName + ", imgOriginal=" + imgOriginal + "]";
	}

}
