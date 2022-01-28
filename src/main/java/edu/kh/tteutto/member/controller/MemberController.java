package edu.kh.tteutto.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.tteutto.member.model.service.MemberService;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
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
	
	// 로그인
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login2(Member member,
			@RequestParam(value="save", required=false) String save, HttpServletRequest req,
			HttpServletResponse resp) {
		
		System.out.println(member.getMemberEmail());
		System.out.println(member.getMemberPw());
		
		Member loginMember = service.login(member);
		return null;
	}
	
	// 비밀번호 찾기 페이지 이동
	@RequestMapping(value="findPw", method=RequestMethod.GET)
	public String findPw() {
		return "member/findPw";
	}
	
	// 학생 마이페이지 클래스 목록 이동
	@RequestMapping(value="studentClassList", method=RequestMethod.GET)
	public String studentClassList() {
		return "member/studentClassList";
	}
	
	// 학생 마이페이지 후기 목록 이동
	@RequestMapping(value="studentCommentList", method=RequestMethod.GET)
	public String studentCommentList() {
		return "member/studentCommentList";
	}
	
	// 학생 마이페이지 후기 목록 이동
	@RequestMapping(value="studentWishList", method=RequestMethod.GET)
	public String studentWishList() {
		return "member/studentWishList";
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
	
	// 강사 신청 페이지 이동
	@RequestMapping(value="teacherRegister", method=RequestMethod.GET)
	public String teacherRegister() {
		return "member/teacherRegister";
	}
}
