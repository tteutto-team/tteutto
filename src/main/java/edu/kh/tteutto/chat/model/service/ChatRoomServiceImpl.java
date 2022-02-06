package edu.kh.tteutto.chat.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.kh.tteutto.chat.model.dao.ChatRoomDAO;
import edu.kh.tteutto.chat.model.vo.ChatMessage;
import edu.kh.tteutto.chat.model.vo.ChatRoom;

@Service
public class ChatRoomServiceImpl implements ChatRoomService{
	
	@Autowired
	private ChatRoomDAO dao;

	// 채팅방 목록조회
	@Override
	public List<ChatRoom> chatRoomList() {
		return dao.chatRoomList();
	}

	// 채팅방 열기
	@Override
	public int openChatRoom(ChatRoom room) {
		
		int result = dao.openChatRoom(room);
		
		if(result > 0 ) { //성공
			return room.getChatRoomNo();
		
		}else { //실패
			return 0;
		}
		
	}

	// 채팅방 입장 + 채팅 내역(메세지) 조회
	@Override
	public List<ChatMessage> joinChatRoom(ChatRoom chatRoom) {
		// 1. 파라미터로 전달받은 방번호와 일치하는 방이 DB에 있는지 검사
				int result = dao.existsChatRoom(chatRoom.getChatRoomNo());
				
				// 2-1. 방이 있는 경우 
				if( result > 0) {
					
					// 2-1-1. CHAT_ROOM_JOIN 테이블에 삽입 DAO 호출
					try {
						
						dao.joinChatRoom(chatRoom); //재입장 시 유니크 제약조건 위배 예외 발생
					}catch(Exception e) {} //->아무것도 적지않고 처리
					
					
					// 2-1-2. 해당 방번호와 일치하는 모든 메세지를 CHAT_MESSAGE 테이블에서 조회
					return dao.selectChatMessage(chatRoom.getChatRoomNo());
					
				}else { // 2-2. 방이 없는 경우
					return null;
				}
	
	}

	
	
	
	
}
