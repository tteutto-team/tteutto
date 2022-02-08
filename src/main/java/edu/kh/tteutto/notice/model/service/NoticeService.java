package edu.kh.tteutto.notice.model.service;

import java.util.List;

import edu.kh.tteutto.notice.model.vo.Faq;
import edu.kh.tteutto.notice.model.vo.Notice;

public interface NoticeService {

	
	/** 공지사항 조회
	 * @return notice
	 */
	List<Notice> selectNoticeList();

	/** 게시글 상세 조회
	 * @param noticeNo
	 * @return notice
	 */
	Notice selectNotice(int noticeNo);

	
	/** faq 조회
	 * @param faqDiv
	 * @return faqList
	 */
	List<Faq> selectFaqList(int faqDiv);

}
