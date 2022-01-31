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
	
}
