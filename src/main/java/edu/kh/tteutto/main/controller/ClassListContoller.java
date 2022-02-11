package edu.kh.tteutto.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.tteutto.main.model.service.ClassListService;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Option;
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
		
		if (search != null && !search.equals("")) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("search", search);
			map.put("memberNo", memberNo);
			map.put("pageKey", "search");
			
			pagination = service.getPagination(map, page);
			pagination.setLimit(12);
			pagination.setPageSize(5);
			
			searchList = service.selectSearchList(pagination, map);
			
			model.addAttribute("pagination", pagination);
			model.addAttribute("searchList", searchList);
			
			if (searchList.isEmpty()) {
				map.put("result", "no");
				recommendList = service.selectRecoList(map);
				model.addAttribute("recommendList", recommendList);
			}
			
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("search", search);
			map.put("memberNo", memberNo);
			map.put("pageKey", "search");
			map.put("result", "no");
			
			recommendList = service.selectRecoList(map);
			model.addAttribute("recommendList", recommendList);
		}
		
		return "main/classList";
	}
	
	// 클래스 검색 목록 옵션
	@ResponseBody
	@RequestMapping("changeOption")
	public String changeOption(Option option) {
		
		
		
		
		System.out.println(option);
		return null;
	}
	
	// 클래스 테마 목록
	@RequestMapping("themeList")
	public String themeList(HttpSession session, Model model, int themeNo) {
		
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null)
			memberNo = loginMember.getMemberNo();
		
		List<ClassList> themeList = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("themeNo", themeNo);
		map.put("pageKey", "theme");
		
		themeList = service.selectThemeList(map);
		model.addAttribute("themeList", themeList);
		
		return "main/themeList";
	}
}
