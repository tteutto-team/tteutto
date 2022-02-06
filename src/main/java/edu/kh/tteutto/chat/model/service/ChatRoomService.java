package edu.kh.tteutto.chat.model.service;

import java.util.List;

import org.springframework.ui.Model;

import edu.kh.tteutto.chat.model.vo.ChatMessage;
import edu.kh.tteutto.chat.model.vo.ChatRoom;

public interface ChatRoomService {

	/** 채팅방 목록 조회
	 * @return chatRoomList
	 */
	List<ChatRoom> chatRoomList();

	/** 채팅방 열기
	 * @param room
	 * @return chatRoom
	 */
	int openChatRoom(ChatRoom room);


	/** 채팅방 입장 + 채팅 내역(메세지) 조회
	 * @param chatRoom
	 * @return list
	 */
	List<ChatMessage> joinChatRoom(ChatRoom chatRoom);


}
