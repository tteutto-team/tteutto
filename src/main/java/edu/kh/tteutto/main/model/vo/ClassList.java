package edu.kh.tteutto.main.model.vo;

public class ClassList {
	private int classNo;		// 클래스번호
	private String classArea;	// 수업등록지역
	private int classType;		// 수업형태
	private String className;	// 수업제목
	
	private String thumbnailImageName;	// 썸네일이미지명
	private String categoryName;		// 카테고리명
	private String teacherImage;		// 프로필사진
	private String memberName;			// 회원명
	private String categoryDetailName;	// 세부카테고리명
	private int memberNo;				// 회원번호
	private int themeNo;				// 테마번호
	private String themeImage;			// 테마이미지
	private String themeColor;			// 테마컬러
	
	private int episodeCount;	// 회차카운트
	private double starAverage;	// 별점평균
	private int heartCount;		// 찜개수
	private int heartFlag;		// 찜여부
	private int episodePrice;	// 수업료
	
	public ClassList() {}

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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCategoryDetailName() {
		return categoryDetailName;
	}

	public void setCategoryDetailName(String categoryDetailName) {
		this.categoryDetailName = categoryDetailName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getThemeNo() {
		return themeNo;
	}

	public void setThemeNo(int themeNo) {
		this.themeNo = themeNo;
	}

	public String getThemeImage() {
		return themeImage;
	}

	public void setThemeImage(String themeImage) {
		this.themeImage = themeImage;
	}

	public String getThemeColor() {
		return themeColor;
	}

	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public double getStarAverage() {
		return starAverage;
	}

	public void setStarAverage(double starAverage) {
		this.starAverage = starAverage;
	}

	public int getHeartFlag() {
		return heartFlag;
	}

	public void setHeartCount(int heartCount) {
		this.heartCount = heartCount;
	}
	
	public int getEpisodePrice() {
		return episodePrice;
	}
	
	public void setHeartFlag(int heartFlag) {
		this.heartFlag = heartFlag;
	}

	public int getHeartCount() {
		return heartCount;
	}

	public void setEpisodePrice(int episodePrice) {
		this.episodePrice = episodePrice;
	}

	@Override
	public String toString() {
		return "ClassList [classNo=" + classNo + ", classArea=" + classArea + ", classType=" + classType
				+ ", className=" + className + ", thumbnailImageName=" + thumbnailImageName + ", categoryName="
				+ categoryName + ", teacherImage=" + teacherImage + ", memberName=" + memberName
				+ ", categoryDetailName=" + categoryDetailName + ", memberNo=" + memberNo + ", themeNo=" + themeNo
				+ ", themeImage=" + themeImage + ", themeColor=" + themeColor + ", episodeCount=" + episodeCount
				+ ", starAverage=" + starAverage + ", heartCount=" + heartCount + ", heartFlag=" + heartFlag
				+ ", episodePrice=" + episodePrice + "]";
	}
}
