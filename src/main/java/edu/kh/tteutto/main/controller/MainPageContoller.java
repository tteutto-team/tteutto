package edu.kh.tteutto.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.tteutto.main.model.service.ClassListService;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@SessionAttributes({"loginMember"})
public class MainPageContoller {
	
	@Autowired
	private ClassListService service;
	
	// 메인 페이지
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main(HttpSession session, Model model) {
		
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null)
			memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		
		// 내 주변 클래스 추천 목록
		map.put("pageKey", "surround");
		
		List<ClassList> surroundList = null;
		surroundList = service.selectMainList(map);
		
		model.addAttribute("surroundList", surroundList);
		
		// 인기 클래스 추천 목록
//		map.put("pageKey", "hot");
//		
//		List<ClassList> hotList = null;
//		hotList = service.selectMainList(map);
//		
//		model.addAttribute("hotList", hotList);
//		
//		// 신규 클래스 추천 목록
//		map.put("pageKey", "new");
//		
//		List<ClassList> newList = null;
//		newList = service.selectMainList(map);
//		
//		model.addAttribute("newList", newList);
		
		return "main/main";
	}
}
