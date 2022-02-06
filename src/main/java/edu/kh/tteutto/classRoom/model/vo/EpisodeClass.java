package edu.kh.tteutto.classRoom.model.vo;

public class EpisodeClass {

	private int epCount;	// 회차 번호
	private String StudyStatus;	// 클래스 상태
	private String ClassDate;	//날짜
	private int deleteStatus;	//삭제 여부
	private int calStatus;	//정산여부
	
	public EpisodeClass() {	}

	public int getEpCount() {
		return epCount;
	}

	public void setEpCount(int epCount) {
		this.epCount = epCount;
	}

	public String getStudyStatus() {
		return StudyStatus;
	}

	public void setStudyStatus(String studyStatus) {
		StudyStatus = studyStatus;
	}

	public String getClassDate() {
		return ClassDate;
	}

	public void setClassDate(String classDate) {
		ClassDate = classDate;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public int getCalStatus() {
		return calStatus;
	}

	public void setCalStatus(int calStatus) {
		this.calStatus = calStatus;
	}

	@Override
	public String toString() {
		return "EpisodeClass [epCount=" + epCount + ", StudyStatus=" + StudyStatus + ", ClassDate=" + ClassDate
				+ ", deleteStatus=" + deleteStatus + ", calStatus=" + calStatus + "]";
	};

}
