package edu.kh.tteutto.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageContoller {
	
	// 메인페이지
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainForward() {
		
		return "main/main";
	}
	
}