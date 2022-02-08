package edu.kh.tteutto.classRoom.model.vo;

public class EpisodeClass {

	private int classNo;	// 클래스 번호
	private int epNo;	// 회차 구분 번호(자동 증가)
	private int epCount;	// 회차 번호
	private String studyStatus;	// 클래스 상태(진행 중 == 0 || 진행 예정 == 1)
	private String startDate;	// 클래스 시작 날짜
	private String endDate;	// 클래스 끝 날짜
	private int deleteStatus;	//삭제 여부
	private int calStatus;	//정산여부 [-2: 정산 불가능, -1: 정산 가능, 0: 대기, 1: 완료] 
	private String date;	// 최종 날짜
	
	
	public EpisodeClass() {	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getEpNo() {
		return epNo;
	}

	public void setEpNo(int epNo) {
		this.epNo = epNo;
	}

	public int getEpCount() {
		return epCount;
	}

	public void setEpCount(int epCount) {
		this.epCount = epCount;
	}

	public String getStudyStatus() {
		return studyStatus;
	}

	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "EpisodeClass [classNo=" + classNo + ", epNo=" + epNo + ", epCount=" + epCount + ", studyStatus="
				+ studyStatus + ", startDate=" + startDate + ", endDate=" + endDate + ", deleteStatus=" + deleteStatus
				+ ", calStatus=" + calStatus + ", date=" + date + "]";
	}

}
