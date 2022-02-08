package edu.kh.tteutto.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.tteutto.main.model.service.ClassListService;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@RequestMapping("/main/*")
public class ClassListContoller {
	
	@Autowired
	private ClassListService service;
	
	// 클래스 검색 목록
	@RequestMapping("searchList")
	public String searchList(HttpSession session, Model model, 
			@RequestParam(value="search", required=false) String search,  
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null)
			memberNo = loginMember.getMemberNo();
		
		Pagination pagination = null;
		List<ClassList> searchList = null;
		List<ClassList> recommendList = null;
		
		if (search != null) {
			pagination = service.getPagination(search, page);
			pagination.setLimit(12);
			pagination.setPageSize(5);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("search", search);
			map.put("memberNo", memberNo);
			
			searchList = service.selectSearchList(pagination, map);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("searchList", searchList);
			
		} else {
			recommendList = service.selectRecoList(memberNo);
			model.addAttribute("recommendList", recommendList);
		}
		
		return "main/searchList";
	}
}
