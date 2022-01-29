package edu.kh.tteutto.chatNote.model.vo;

public class ChatNote {

	// 쪽지 테이블 필드
	private int noteNo;
	private String noteContent;
	private int noteStatus;
	private int memberNo;

	private int flag; // 0 : 회차별 승인, 1 : 회차별 거절

	public int getNoteNo() {
		return noteNo;
	}

	public void setNoteNo(int noteNo) {
		this.noteNo = noteNo;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public int getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(int noteStatus) {
		this.noteStatus = noteStatus;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "ChatNote [noteNo=" + noteNo + ", noteContent=" + noteContent + ", noteStatus=" + noteStatus
				+ ", memberNo=" + memberNo + ", flag=" + flag + "]";
	}

	
}
