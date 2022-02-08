package edu.kh.tteutto.admin.model.vo;

public class AdminEpisodeSchedule {
	private int scheduleNo;
	private String scheduleDate;
	private String scheduleWeek;
	private String scheduleStartTime;
	private String scheduleEndTime;
	private int scheduleTime;
	private int episodeNo;

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleWeek() {
		return scheduleWeek;
	}

	public void setScheduleWeek(String scheduleWeek) {
		this.scheduleWeek = scheduleWeek;
	}

	public String getScheduleStartTime() {
		return scheduleStartTime;
	}

	public void setScheduleStartTime(String scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}

	public String getScheduleEndTime() {
		return scheduleEndTime;
	}

	public void setScheduleEndTime(String scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}

	public int getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(int scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public int getEpisodeNo() {
		return episodeNo;
	}

	public void setEpisodeNo(int episodeNo) {
		this.episodeNo = episodeNo;
	}

	@Override
	public String toString() {
		return "AdminEpisodeSchedule [scheduleNo=" + scheduleNo + ", scheduleDate=" + scheduleDate + ", scheduleWeek="
				+ scheduleWeek + ", scheduleStartTime=" + scheduleStartTime + ", scheduleEndTime=" + scheduleEndTime
				+ ", scheduleTime=" + scheduleTime + ", episodeNo=" + episodeNo + "]";
	}

}
