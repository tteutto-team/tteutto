package edu.kh.tteutto.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	// 회원가입 페이지 이동
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String signUp() {
		return "member/signup";
	}
	
	// 회원가입 페이지 이동
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	// 비밀번호 찾기 페이지 이동
	@RequestMapping(value="findPw", method=RequestMethod.GET)
	public String findPw() {
		return "member/findPw";
	}
	
	// 학생 프로필 페이지 이동
	@RequestMapping(value="studentProfile", method=RequestMethod.GET)
	public String studentProfile() {
		return "member/studentProfile";
	}
	
	// 강사 프로필 페이지 이동
	@RequestMapping(value="teacherProfile", method=RequestMethod.GET)
	public String teacherProfile() {
		return "member/teacherProfile";
	}
	
}
