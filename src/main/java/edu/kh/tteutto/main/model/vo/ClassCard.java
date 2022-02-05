package edu.kh.tteutto.main.model.vo;

public class ClassCard {
	// 클래스
	private int classNo;		// 클래스번호
	private String classArea;	// 수업등록지역
	private int classType;		// 수업형태
	private String className;	// 수업제목
	
	// 썸네일이미지
	private String thumbnailImageName;	// 썸네일이미지번호
	private int thumbnailImageLevel;	// 썸네일이미지명
	
	// 클래스카테고리
	private int categoryNo;			// 카테고리번호
	private String categoryName;	// 카테고리명
	
	// 강사
	private String teacherImage;	// 프로필사진
	
	// 회원
	private int memberNo;		// 회원번호
	private String memberName;	// 회원명
	
	// 클래스회차
	private int episodeNo;	// 회차번호
	
	// 수강신청
	private int registerNo;	// 수강번호
	
	// 후기
	private int reviewStar;	// 후기별점
	
	// 세부카테고리
	private int categoryDetailNo;		// 세부카테고리번호
	private String categoryDetailName;	// 세부카테고리명
	
	public ClassCard() {}
	
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public String getClassArea() {
		return classArea;
	}
	public void setClassArea(String classArea) {
		this.classArea = classArea;
	}
	public int getClassType() {
		return classType;
	}
	public void setClassType(int classType) {
		this.classType = classType;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getThumbnailImageName() {
		return thumbnailImageName;
	}
	public void setThumbnailImageName(String thumbnailImageName) {
		this.thumbnailImageName = thumbnailImageName;
	}
	public int getThumbnailImageLevel() {
		return thumbnailImageLevel;
	}
	public void setThumbnailImageLevel(int thumbnailImageLevel) {
		this.thumbnailImageLevel = thumbnailImageLevel;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTeacherImage() {
		return teacherImage;
	}
	public void setTeacherImage(String teacherImage) {
		this.teacherImage = teacherImage;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getEpisodeNo() {
		return episodeNo;
	}
	public void setEpisodeNo(int episodeNo) {
		this.episodeNo = episodeNo;
	}
	public int getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	public int getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}
	public int getCategoryDetailNo() {
		return categoryDetailNo;
	}
	public void setCategoryDetailNo(int categoryDetailNo) {
		this.categoryDetailNo = categoryDetailNo;
	}
	public String getCategoryDetailName() {
		return categoryDetailName;
	}
	public void setCategoryDetailName(String categoryDetailName) {
		this.categoryDetailName = categoryDetailName;
	}
	
	@Override
	public String toString() {
		return "ClassCard [classNo=" + classNo + ", classArea=" + classArea + ", classType=" + classType
				+ ", className=" + className + ", thumbnailImageName=" + thumbnailImageName + ", thumbnailImageLevel="
				+ thumbnailImageLevel + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName
				+ ", teacherImage=" + teacherImage + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", episodeNo=" + episodeNo + ", registerNo=" + registerNo + ", reviewStar=" + reviewStar
				+ ", categoryDetailNo=" + categoryDetailNo + ", categoryDetailName=" + categoryDetailName + "]";
	}
}
