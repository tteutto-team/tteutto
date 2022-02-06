package edu.kh.tteutto.chat.model.vo;

public class ChatRoom {

	private int chatRoomNo; // 채팅방 번호
	private int chatRoomSt; // 채팅방 상태 (0: 채팅진행중, 1: 삭제된채팅방)
	private int chatMemberSt; // 회원 상태 (0: 참여중 1: 나감)
	private int chatTeacherSt; // 강사 상태 (0: 참여중 1: 나감)
	private int memberNo; // 회원 번호
	private int teacherNo; // 강사 번호
	
	private String memberNm; // 채팅 상대 이름
	private int unreadMsgCnt; // 채팅방 당 안읽은 메세지 갯수
	
	private String teacherNm; // 수강생 모드일 경우 채팅상대(강사)이름
	private String teacherImg; // 수강생 모드일 경우 채팅상대(강사) 이미지
	
	private ChatMessage chatMessage; 
	
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

	public int getUnreadMsgCnt() {
		return unreadMsgCnt;
	}

	public void setUnreadMsgCnt(int unreadMsgCnt) {
		this.unreadMsgCnt = unreadMsgCnt;
	}

	public String getTeacherNm() {
		return teacherNm;
	}

	public void setTeacherNm(String teacherNm) {
		this.teacherNm = teacherNm;
	}

	public String getTeacherImg() {
		return teacherImg;
	}

	public void setTeacherImg(String teacherImg) {
		this.teacherImg = teacherImg;
	}


	public ChatMessage getChatMessage() {
		return chatMessage;
	}

	public void setChatMessage(ChatMessage chatMessage) {
		this.chatMessage = chatMessage;
	}

	@Override
	public String toString() {
		return "ChatRoom [chatRoomNo=" + chatRoomNo + ", chatRoomSt=" + chatRoomSt + ", chatMemberSt=" + chatMemberSt
				+ ", chatTeacherSt=" + chatTeacherSt + ", memberNo=" + memberNo + ", teacherNo=" + teacherNo
				+ ", memberNm=" + memberNm + ", unreadMsgCnt=" + unreadMsgCnt + ", teacherNm=" + teacherNm
				+ ", teacherImg=" + teacherImg + ", chatMessage=" + chatMessage + "]";
	}
	
	
	
	
	
	
}
