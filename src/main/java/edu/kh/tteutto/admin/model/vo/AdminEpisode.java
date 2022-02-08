package edu.kh.tteutto.admin.model.vo;

import java.util.List;

public class AdminEpisode {
	private int episodeNo;
	private int episodePrice;
	private int episodeStatus;
	private int episodeCount;
	private String episodePlace;

	private List<AdminEpisodeSchedule> scheduleList;

	public int getEpisodeNo() {
		return episodeNo;
	}

	public void setEpisodeNo(int episodeNo) {
		this.episodeNo = episodeNo;
	}

	public int getEpisodePrice() {
		return episodePrice;
	}

	public void setEpisodePrice(int episodePrice) {
		this.episodePrice = episodePrice;
	}

	public int getEpisodeStatus() {
		return episodeStatus;
	}

	public void setEpisodeStatus(int episodeStatus) {
		this.episodeStatus = episodeStatus;
	}

	public int getEpisodeCount() {
		return episodeCount;
	}

	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}

	public String getEpisodePlace() {
		return episodePlace;
	}

	public void setEpisodePlace(String episodePlace) {
		this.episodePlace = episodePlace;
	}

	public List<AdminEpisodeSchedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<AdminEpisodeSchedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	@Override
	public String toString() {
		return "AdminEpisode [episodeNo=" + episodeNo + ", episodePrice=" + episodePrice + ", episodeStatus="
				+ episodeStatus + ", episodeCount=" + episodeCount + ", episodePlace=" + episodePlace
				+ ", scheduleList=" + scheduleList + "]";
	}

}
