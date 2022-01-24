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
}
