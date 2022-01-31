package edu.kh.tteutto.member.model.vo;

public class Career {

//	강사 이력 테이블
	private int memberNo;
	private int careerNo;
	private String careerContent;
	private String careerImg;
	
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
	public String getCareerImg() {
		return careerImg;
	}
	public void setCareerImg(String careerImg) {
		this.careerImg = careerImg;
	}
	
	@Override
	public String toString() {
		return "Career [memberNo=" + memberNo + ", careerNo=" + careerNo + ", careerContent=" + careerContent
				+ ", careerImg=" + careerImg + "]";
	}
	
}
