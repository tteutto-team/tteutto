package edu.kh.tteutto.notice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.notice.model.dao.NoticeDAO;
import edu.kh.tteutto.notice.model.vo.Faq;
import edu.kh.tteutto.notice.model.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO dao;

	// 공시사항 조회
	@Override
	public List<Notice> selectNoticeList() {
		return dao.selectNoticeList();
	}
	
	// 공지사항 상세 조회
	@Override
	public Notice selectNotice(int noticeNo) {
		return dao.selectNotice(noticeNo);
	}

	// faq 조회
	@Override
	public List<Faq> selectFaqList(int faqDiv) {
		return dao.selectFaqList(faqDiv);
	}
	
	
	
}
