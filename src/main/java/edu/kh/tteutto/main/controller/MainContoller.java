package edu.kh.tteutto.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContoller {

	// 클래스 검색 목록
	@RequestMapping("/main/searchList")
	public String searchList() {
		return "main/searchList";
	}
}