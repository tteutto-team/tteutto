package edu.kh.tteutto.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.notice.model.service.NoticeService;
import edu.kh.tteutto.notice.model.vo.Notice;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	
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
	public String notice_list(Model model) {
		List<Notice> notice = service.selectNoticeList();
		model.addAttribute("notice", notice);
		return "notice/noticeList";
	}
	
	// 공지사항 상세페이지
	@RequestMapping("noticeView/{noticeNo}")
	public String view(@PathVariable("noticeNo") int noticeNo,
			Model model,RedirectAttributes ra) {
		
		Notice notice = service.selectNotice(noticeNo);
		String path = null;
		
		if(notice != null) {
			model.addAttribute("notice", notice);
			path = "notice/noticeView";
		}else {
			Util.swalSetMessage("해당 공지사항이 존재하지 않습니다.", null, "info", ra);
			path = "redirect:../noticeList";
		}
		return "notice/noticeView";
	}
}
