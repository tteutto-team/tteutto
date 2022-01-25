package edu.kh.tteutto.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	// 이용약관
	@RequestMapping("terms")
	public String terms() {
		return "notice/terms";
	}
	
	// 공지사항 FAQ 페이지
	@RequestMapping("faq")
	public String faq() {
		return "notice/faq";
	}
	
	// 공지사항 목록 페이지
	@RequestMapping("noticeList")
	public String notice_list() {
		return "notice/noticeList";
	}
	
	// 공지사항 상세페이지
	@RequestMapping("noticeView")
	public String view() {
		return "notice/noticeView";
	}
}
