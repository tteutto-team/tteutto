package edu.kh.tteutto.notice.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.notice.model.vo.Notice;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 게시글 조회
	 * @return notice
	 */
	public List<Notice> selectNoticeList() {
		return sqlSession.selectList("noticeMapper.selectNoticeList");
	}

	public Notice selectNotice(int noticeNo) {
		return sqlSession.selectOne("noticeMapper.selectNotice", noticeNo);
	}

}
