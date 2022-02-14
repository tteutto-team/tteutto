package edu.kh.tteutto.chatNote.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.chatNote.model.vo.ChatNote;

@Repository
public class ChatNoteDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 쪽지 보내기
	 * @param cm
	 * @return result
	 */
	public int sendNote(ChatNote cm) {
		return sqlSession.insert("adminMapper.sendNote", cm);
	}

	/** 쪽지 알림 갯수
	 * @param cm
	 * @return count
	 */
	public int selectNoteAlarm(ChatNote cm) {
		return sqlSession.selectOne("adminMapper.selectNoteAlarm", cm);
	}

	/** 채팅 알림 갯수
	 * @param cm
	 * @return count
	 */
	public int selectChatAlarm(ChatNote cm) {
		return sqlSession.selectOne("adminMapper.selectChatAlarm", cm);
	}

	/** 채팅 알람 삭제
	 * @param memberNo
	 * @return result
	 */
	public int clearChatAlarm(int memberNo) {
		return sqlSession.update("chatMapper.clearChatAlarm", memberNo);
	}

	/** 쪽지 알람 삭제
	 * @param memberNo
	 * @return result
	 */
	public int clearNoteAlarm(int memberNo) {
		return sqlSession.update("chatMapper.clearNoteAlarm", memberNo);
	}

	/** 채팅 알림 존재 여부 조회
	 * @param memberNo
	 * @return
	 */
	public int countChatAlarm(int memberNo) {
		return sqlSession.selectOne("chatMapper.countChatAlarm", memberNo);
	}

	/** 쪽지 알림 존재 여부 조회
	 * @param memberNo
	 * @return
	 */
	public int countNoteAlarm(int memberNo) {
		return sqlSession.selectOne("chatMapper.countNoteAlarm", memberNo);
	}
	
}
