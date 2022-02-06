package edu.kh.tteutto.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginMember"})
public class MainPageContoller {
	
	// 메인페이지
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainForward() {
		return "main/main";
	}
	
}