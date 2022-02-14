package edu.kh.tteutto.chat.model.vo;

public class ChatMessage {

	private int msgNo; // 채팅 메세지 번호
	private String msgContent; //메세지 내용
	private String msgDt; //메세지 전송시간
	private int msgSt; //메시지 상태 (0: 안읽음, 1:읽음) - default : 0
	private int chatRoomNo; // 채팅방 번호
	private int memberNo; // 회원번호 (메세지 전송한 회원구분)
	private int otherMemberNo; // 메세지를 받는 상대 회원 번호
	
	private String memberNm; //상대방 회원명
	private String teacherNm; //강사님 회원명
	
	private String modeSpan;
	
	public ChatMessage() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getModeSpan() {
		return modeSpan;
	}



	public void setModeSpan(String modeSpan) {
		this.modeSpan = modeSpan;
	}



	public int getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMsgDt() {
		return msgDt;
	}

	public void setMsgDt(String msgDt) {
		this.msgDt = msgDt;
	}

	public int getMsgSt() {
		return msgSt;
	}

	public void setMsgSt(int msgSt) {
		this.msgSt = msgSt;
	}

	public int getChatRoomNo() {
		return chatRoomNo;
	}

	public void setChatRoomNo(int chatRoomNo) {
		this.chatRoomNo = chatRoomNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	
	
	public String getTeacherNm() {
		return teacherNm;
	}

	public void setTeacherNm(String teacherNm) {
		this.teacherNm = teacherNm;
	}

	public int getOtherMemberNo() {
		return otherMemberNo;
	}

	public void setOtherMemberNo(int otherMemberNo) {
		this.otherMemberNo = otherMemberNo;
	}



	@Override
	public String toString() {
		return "ChatMessage [msgNo=" + msgNo + ", msgContent=" + msgContent + ", msgDt=" + msgDt + ", msgSt=" + msgSt
				+ ", chatRoomNo=" + chatRoomNo + ", memberNo=" + memberNo + ", otherMemberNo=" + otherMemberNo
				+ ", memberNm=" + memberNm + ", teacherNm=" + teacherNm + ", modeSpan=" + modeSpan + "]";
	}


	
	
	
	
	
}
