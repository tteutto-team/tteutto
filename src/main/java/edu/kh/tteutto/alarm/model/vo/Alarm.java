package edu.kh.tteutto.alarm.model.vo;

public class Alarm {

	private int alarmNo; // 알림 시퀀스 번호 (삭제할 때 쓸 수 있음)
	private String alarmContent; // 알림 내용
	private int alarmSt; // 알림 상태 (0: 읽음, 1: 안읽음)
	private int memberNo; //알림 받을 회원 번호
	private String alarmUrl; //알림 클릭시 이동할 URL
	
	public Alarm() {
		// TODO Auto-generated constructor stub
	}

	public int getAlarmNo() {
		return alarmNo;
	}

	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}

	public String getAlarmContent() {
		return alarmContent;
	}

	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}

	public int getAlarmSt() {
		return alarmSt;
	}

	public void setAlarmSt(int alarmSt) {
		this.alarmSt = alarmSt;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getAlarmUrl() {
		return alarmUrl;
	}

	public void setAlarmUrl(String alarmUrl) {
		this.alarmUrl = alarmUrl;
	}

	@Override
	public String toString() {
		return "Alarm [alarmNo=" + alarmNo + ", alarmContent=" + alarmContent + ", alarmSt=" + alarmSt + ", memberNo="
				+ memberNo + ", alarmUrl=" + alarmUrl + "]";
	}
	
	
	
	
}
