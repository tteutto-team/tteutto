package edu.kh.tteutto.classRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class/*")
public class ClassDetailController {
	
	// 클래스 상세 페이지
	@RequestMapping("classDetail")
	public String classList() {
		return "class/classDetail";
	}

}
