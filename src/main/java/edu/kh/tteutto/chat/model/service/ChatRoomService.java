package edu.kh.tteutto.chat.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import edu.kh.tteutto.chat.model.vo.ChatMessage;
import edu.kh.tteutto.chat.model.vo.ChatRoom;
import edu.kh.tteutto.chatNote.model.vo.ChatNote;

public interface ChatRoomService {

	/** 채팅방 목록 조회
	 * @param map 
	 * @return chatRoomList
	 */
	List<ChatRoom> chatRoomList(Map<String, Integer> map);

	/** 채팅방 열기
	 * @param room
	 * @return chatRoom
	 */
	Map<String, Object> openChatRoom(ChatRoom room);


	/** 채팅 내용 삽입
	 * @param cm
	 * @return result
	 */
	int insertMessage(ChatMessage cm);

	
	/** 채팅 내역(메세지) 조회
	 * @param chatRoom
	 * @return list
	 */
	List<ChatMessage> selectChatMessage(int chatRoomNo);

	
	/** 채팅방 정보 조회
	 * @param chatRoomNo
	 * @return cr
	 */
	ChatRoom selectChatRoom(int chatRoomNo);

	/** 채팅방 생성
	 * @param cm
	 * @return result
	 */
	int insertChatRoom(ChatMessage cm);

	/** 쪽지 조회
	 * @param memberNo
	 * @return chatNote
	 */
	List<ChatNote> selectMessageList(int memberNo);

	/** 채팅 알림
	 * @param cm
	 * @return count
	 */
	int sendAlarm(ChatMessage cm);

	/** 채팅알림2
	 * @param cm
	 * @return count2
	 */
	int sendAlarm2(ChatMessage cm);




}
