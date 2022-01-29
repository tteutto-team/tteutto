package edu.kh.tteutto.chatNote.model.service;

import edu.kh.tteutto.chatNote.model.vo.ChatNote;

public interface ChatNoteService {

	/** 회차별 신청 승인 쪽지 보내기
	 * @param cm
	 * @return result
	 */
	int episodeAgreeSendNote(ChatNote cm);

	/** 회차별 신청 거절 쪽지 보내기
	 * @param cm
	 * @return result
	 */
	int episodeDenySendNote(ChatNote cm);

}
