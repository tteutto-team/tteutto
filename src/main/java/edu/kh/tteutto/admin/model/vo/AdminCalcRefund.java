package edu.kh.tteutto.admin.model.vo;

public class AdminCalcRefund {
	private int calNo;
	private String calRequestNo;
	private int calStatus;
	private int episodeNo;

	private String teacherName;
	private String className;
	private int episodeCount;

	private String studentName;
	private int calPrice;

	private int classProgress;

	public AdminCalcRefund() {
	}

	public int getCalNo() {
		return calNo;
	}

	public void setCalNo(int calNo) {
		this.calNo = calNo;
	}

	public String getCalRequestNo() {
		return calRequestNo;
	}

	public void setCalRequestNo(String calRequestNo) {
		this.calRequestNo = calRequestNo;
	}

	public int getCalStatus() {
		return calStatus;
	}

	public void setCalStatus(int calStatus) {
		this.calStatus = calStatus;
	}

	public int getEpisodeNo() {
		return episodeNo;
	}

	public void setEpisodeNo(int episodeNo) {
		this.episodeNo = episodeNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getCalPrice() {
		return calPrice;
	}

	public void setCalPrice(int calPrice) {
		this.calPrice = calPrice;
	}

	public int getClassProgress() {
		return classProgress;
	}

	public void setClassProgress(int classProgress) {
		this.classProgress = classProgress;
	}

	@Override
	public String toString() {
		return "AdminCalcRefund [calNo=" + calNo + ", calRequestNo=" + calRequestNo + ", calStatus=" + calStatus
				+ ", episodeNo=" + episodeNo + ", teacherName=" + teacherName + ", className=" + className
				+ ", episodeCount=" + episodeCount + ", studentName=" + studentName + ", calPrice=" + calPrice
				+ ", classProgress=" + classProgress + "]";
	}

}
