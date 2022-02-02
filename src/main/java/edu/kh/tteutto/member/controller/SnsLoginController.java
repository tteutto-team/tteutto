package edu.kh.tteutto.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.tteutto.member.model.service.LoginService;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.member.model.vo.SnsLogin;

@Controller
@RequestMapping(value="/member/*")
public class SnsLoginController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private LoginService ls;
	
	
	
	// 카카오 로그인
	@RequestMapping(value="kakaoLogin", method=RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Exception {
		
		String path = "https://kauth.kakao.com/oauth/authorize?client_id=c3cd9a114b94b9c27733f5051708079c&redirect_uri=http://localhost:8080/tteutto/member/kakaoLogin&response_type=code";
		
		
		System.out.println("#########" + code);
		
		// 위에서 만든 코드 아래에 코드 추가
		String access_Token = ls.getAccessToken(code);
		
		HashMap<String, Object> userInfo = ls.getUserInfo(access_Token);
		System.out.println("###access_Token#### : " + access_Token);
		System.out.println("###email#### : " + userInfo.get("email"));
		
		// session.invalidate();
		// session.setAttribute("loginMember", userInfo);
		return "redirect:/";
		
    }
	
	// 네이버 로그인 콜백 페이지 이동
	@RequestMapping(value="callback", method=RequestMethod.GET)
	public String callBack(){
		return "member/callback";
	}

	// 네이버 데이터 받아오기
	@RequestMapping(value="naverSave", method=RequestMethod.POST)
	public @ResponseBody String naverSave(@RequestParam("n_email") String n_email) {
	System.out.println("#############################################");
	System.out.println(n_email);
	System.out.println("#############################################");

	SnsLogin naver = new SnsLogin();
	naver.setN_email(n_email);
    
	// ajax에서 성공 결과에서 ok인지 no인지에 따라 다른 페이지에 갈 수 있게끔 result의 기본값을 "no"로 선언
	String result = "no";
    
	if(naver!=null) {
		// naver가 비어있지 않는다는건 데이터를 잘 받아왔다는 뜻이므로 result를 "ok"로 설정
		result = "ok";
	}

	return result;
    
	}
}
