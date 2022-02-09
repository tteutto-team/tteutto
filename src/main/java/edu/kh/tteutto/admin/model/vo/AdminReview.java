package edu.kh.tteutto.admin.model.vo;

public class AdminReview {
	private int reviewNo;
	private int reviewStar;
	private String reviewContent;
	private String reviewDate;
	private int reviewStatus;
	private int registerNo;

	private int memberNo;
	private String memberName;
	private int episodeCount;
	private String className;

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(int reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public int getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "AdminReview [reviewNo=" + reviewNo + ", reviewStar=" + reviewStar + ", reviewContent=" + reviewContent
				+ ", reviewDate=" + reviewDate + ", reviewStatus=" + reviewStatus + ", registerNo=" + registerNo
				+ ", memberNo=" + memberNo + ", memberName=" + memberName + ", episodeCount=" + episodeCount
				+ ", className=" + className + "]";
	}

}
