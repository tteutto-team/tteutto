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
	int selectNoteAlarm(ChatNote cm);

	/** 채팅 알림 갯수
	 * @param cm
	 * @return count2
	 */
	int selectChatAlarm(ChatNote cm);

	/** 알람 삭제
	 * @param memberNo
	 * @return result
	 */
	int clearAlarm(int memberNo);


}
