package edu.kh.tteutto.chatNote.model.service;

import edu.kh.tteutto.chatNote.model.vo.ChatNote;

public interface ChatNoteService {

	/** 쪽지 보내기
	 * @param cm
	 * @return result
	 */
	int sendNote(ChatNote cm);

	/** 쪽지 알림 갯수
	 * @param cm
	 * @return count
	 */
	int selectNoteNotice(ChatNote cm);


}
