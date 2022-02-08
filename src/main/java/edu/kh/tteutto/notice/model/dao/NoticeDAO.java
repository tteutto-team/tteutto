package edu.kh.tteutto.notice.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.notice.model.vo.Faq;
import edu.kh.tteutto.notice.model.vo.Notice;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 공지사항 목록 조회
	 * @return notice
	 */
	public List<Notice> selectNoticeList() {
		return sqlSession.selectList("noticeMapper.selectNoticeList");
	}

	/** 공지사항 상세 조회
	 * @param noticeNo
	 * @return
	 */
	public Notice selectNotice(int noticeNo) {
		return sqlSession.selectOne("noticeMapper.selectNotice", noticeNo);
	}

	/** faq 조회
	 * @param faqDiv
	 * @return fqaList
	 */
	public List<Faq> selectFaqList(int faqDiv) {
		return sqlSession.selectList("noticeMapper.selectFaqList", faqDiv);
	}

}
