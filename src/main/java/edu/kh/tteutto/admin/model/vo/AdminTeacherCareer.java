package edu.kh.tteutto.admin.model.vo;

public class AdminTeacherCareer {

	private int careerNo;
	private String careerContent;
	private String careerImg;
	private int memberNo;

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

	public String getCareerImg() {
		return careerImg;
	}

	public void setCareerImg(String careerImg) {
		this.careerImg = careerImg;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "AdminTeacherCareer [careerNo=" + careerNo + ", careerContent=" + careerContent + ", careerImg="
				+ careerImg + ", memberNo=" + memberNo + "]";
	}

}
