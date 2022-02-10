package edu.kh.tteutto.chat.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.chat.model.vo.ChatMessage;
import edu.kh.tteutto.chat.model.vo.ChatRoom;

@Repository
public class ChatRoomDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 채팅방 목록조회
	 * @return chatRoomList
	 */
	public List<ChatRoom> chatRoomList() {
		return sqlSession.selectList("chatMapper.chatRoomList");
	}

	
	
	/** 채팅방 열기
	 * @param room
	 * @return result
	 */
	public int openChatRoom(ChatRoom room) {
		return sqlSession.insert("chatMapper.openChatRoom", room);
	}



	/** 채팅방 존재 여부 확인
	 * @param chatRoomNo
	 * @return result
	 */
	public int existsChatRoom(int chatRoomNo) {
		
		return sqlSession.selectOne("chatMapper.existsChatRoom", chatRoomNo);
	}



//	/** 채팅방 입장
//	 * @param chatRoom
//	 */
//	public void joinChatRoom(ChatRoom chatRoom) {
//		sqlSession.insert("chatMapper.joinChatRoom", chatRoom);
//	}



	/** 채팅 메세지 조회
	 * @param chatRoomNo
	 * @return list
	 */
	public List<ChatMessage> selectChatMessage(int chatRoomNo) {
		return sqlSession.selectList("chatMapper.selectChatMessage", chatRoomNo);
	}



	/** 이미 같은 강사, 학생이 들어가있는 채팅방 번호를 조회 (없으면 0)
	 * @param room
	 * @return
	 */
	public int selectChatRoomNo(ChatRoom room) {
		return sqlSession.selectOne("chatMapper.selectChatRoomNo", room);
	}



	/** 채팅 내용 삽입
	 * @param cm
	 * @return result
	 */
	public int insertMessage(ChatMessage cm) {
		return sqlSession.insert("chatMapper.insertMessage", cm);
	}






	
}
