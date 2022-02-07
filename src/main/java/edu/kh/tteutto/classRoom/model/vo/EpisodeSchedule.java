package edu.kh.tteutto.classRoom.model.vo;

public class EpisodeSchedule {
	
	private int epNo; //회차 번호
	private int epCount; // 1회차, 2회차....
	private int remainPeopleCnt; //남은 인원수
	private int epPrice; //회차 가격
	private String schdlDt; // 수업 날짜
	private String schdlWeek; // 수업 요일
	private String schdlStartTime; // 수업 시작 시간
	private String schdlEndTime; // 수업 종료 시간
	private int possibleFl; // 수업 신청 가능 여부 (0:불가 1:가능)
	
	private int schdlTime; // 수업 소요시간
	
	 public EpisodeSchedule() {
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

	public int getRemainPeopleCnt() {
		return remainPeopleCnt;
	}

	public void setRemainPeopleCnt(int remainPeopleCnt) {
		this.remainPeopleCnt = remainPeopleCnt;
	}

	public int getEpPrice() {
		return epPrice;
	}

	public void setEpPrice(int epPrice) {
		this.epPrice = epPrice;
	}

	public String getSchdlDt() {
		return schdlDt;
	}

	public void setSchdlDt(String schdlDt) {
		this.schdlDt = schdlDt;
	}

	public String getSchdlWeek() {
		return schdlWeek;
	}

	public void setSchdlWeek(String schdlWeek) {
		this.schdlWeek = schdlWeek;
	}

	public String getSchdlStartTime() {
		return schdlStartTime;
	}

	public void setSchdlStartTime(String schdlStartTime) {
		this.schdlStartTime = schdlStartTime;
	}

	public String getSchdlEndTime() {
		return schdlEndTime;
	}

	public void setSchdlEndTime(String schdlEndTime) {
		this.schdlEndTime = schdlEndTime;
	}

	
	
	public int getPossibleFl() {
		return possibleFl;
	}

	public void setPossibleFl(int possibleFl) {
		this.possibleFl = possibleFl;
	}

	
	
	public int getSchdlTime() {
		return schdlTime;
	}

	public void setSchdlTime(int schdlTime) {
		this.schdlTime = schdlTime;
	}

	@Override
	public String toString() {
		return "EpisodeSchedule [epNo=" + epNo + ", epCount=" + epCount + ", remainPeopleCnt=" + remainPeopleCnt
				+ ", epPrice=" + epPrice + ", schdlDt=" + schdlDt + ", schdlWeek=" + schdlWeek + ", schdlStartTime="
				+ schdlStartTime + ", schdlEndTime=" + schdlEndTime + ", possibleFl=" + possibleFl + ", schdlTime="
				+ schdlTime + "]";
	}

	
	

	
	
	
}
