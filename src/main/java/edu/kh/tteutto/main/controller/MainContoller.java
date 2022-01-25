package edu.kh.tteutto.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/*")
public class MainContoller {
	
	// 클래스 검색 목록
	@RequestMapping("searchList")
	public String searchList() {
		return "main/searchList";
	}

}