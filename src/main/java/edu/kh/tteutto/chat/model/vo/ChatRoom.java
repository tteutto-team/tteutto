package edu.kh.tteutto.chat.model.vo;

public class ChatRoom {

	private int chatRoomNo; // 채팅방 번호
	private int chatRoomSt; // 채팅방 상태 (0: 채팅진행중, 1: 삭제된채팅방)
	private int chatMemberSt; // 회원 상태 (0: 참여중 1: 나감)
	private int chatTeacherSt; // 강사 상태 (0: 참여중 1: 나감)
	private int memberNo; // 회원 번호
	private int teacherNo; // 강사 번호
	
	private String memberNm; 
	private String teacherNm; 
	private String memberImg; // 수강생/강사 이미지
	private String recentChatContent; // 최근 메세지
	private String recentMsgDt; // 최근 메세지 전송 일자
	
	private int classNo;
	
	private int mode; // 수강생, 강사 모드 구분 (0: 수강생, 1: 강사)
	
	
	public ChatRoom() {
		// TODO Auto-generated constructor stub
	}



	public int getChatRoomNo() {
		return chatRoomNo;
	}



	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
	}



	public int getChatRoomSt() {
		return chatRoomSt;
	}



	public void setChatRoomSt(int chatRoomSt) {
		this.chatRoomSt = chatRoomSt;
	}



	public int getChatMemberSt() {
		return chatMemberSt;
	}



	public void setChatMemberSt(int chatMemberSt) {
		this.chatMemberSt = chatMemberSt;
	}



	public int getChatTeacherSt() {
		return chatTeacherSt;
	}



	public void setChatTeacherSt(int chatTeacherSt) {
		this.chatTeacherSt = chatTeacherSt;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public int getTeacherNo() {
		return teacherNo;
	}



	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}



	public String getMemberNm() {
		return memberNm;
	}



	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}



	public String getMemberImg() {
		return memberImg;
	}



	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}



	public String getRecentChatContent() {
		return recentChatContent;
	}



	public void setRecentChatContent(String recentChatContent) {
		this.recentChatContent = recentChatContent;
	}



	public String getRecentMsgDt() {
		return recentMsgDt;
	}



	public void setRecentMsgDt(String recentMsgDt) {
		this.recentMsgDt = recentMsgDt;
	}



	public int getClassNo() {
		return classNo;
	}



	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}



	public int getMode() {
		return mode;
	}



	public void setMode(int mode) {
		this.mode = mode;
	}



	public String getTeacherNm() {
		return teacherNm;
	}



	public void setTeacherNm(String teacherNm) {
		this.teacherNm = teacherNm;
	}



	@Override
	public String toString() {
		return "ChatRoom [chatRoomNo=" + chatRoomNo + ", chatRoomSt=" + chatRoomSt + ", chatMemberSt=" + chatMemberSt
				+ ", chatTeacherSt=" + chatTeacherSt + ", memberNo=" + memberNo + ", teacherNo=" + teacherNo
				+ ", memberNm=" + memberNm + ", teacherNm=" + teacherNm + ", memberImg=" + memberImg
				+ ", recentChatContent=" + recentChatContent + ", recentMsgDt=" + recentMsgDt + ", classNo=" + classNo
				+ ", mode=" + mode + "]";
	}


	
	









	


	
	
}
