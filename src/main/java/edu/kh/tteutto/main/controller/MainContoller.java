package edu.kh.tteutto.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContoller {

	@RequestMapping("/main/search")
	public String searchList() {
		return "main/search";
	}
}
