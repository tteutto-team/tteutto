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

import com.google.gson.Gson;

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
			model.addAttribute("classList", searchList);
			
			if (searchList.isEmpty()) {
				map.put("result", "no");
				recommendList = service.selectRecoList(map);
				model.addAttribute("recommendList", recommendList);
			}
			
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("search", search);
			map.put("pageKey", "search");
			map.put("memberNo", memberNo);
			map.put("result", "no");
			
			recommendList = service.selectRecoList(map);
			model.addAttribute("recommendList", recommendList);
		}
		
		return "main/classList";
	}
	
	// 클래스 목록 옵션
	@ResponseBody
	@RequestMapping("changeOption")
	public String changeOption(HttpSession session, String search, Option option, String type, 
			@RequestParam(value="location", required=false) String location, 
			@RequestParam(value="page", required=false, defaultValue="1") int page,
			@RequestParam(value="ctNo", required=false, defaultValue="0" ) int ctNo,
			@RequestParam(value="ctDetailNo", required=false, defaultValue="0" ) int ctDetailNo) {
		
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null) {
			memberNo = loginMember.getMemberNo();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("price", option.getPrice());
		map.put("classType", option.getClassType());
		map.put("classSort", option.getClassSort());
		map.put("optionFlag", 1);
		map.put("search", search);
		map.put("type", type);
		map.put("memberNo", memberNo);
		map.put("pageKey", "search");
		
		if (location != null) {
			map.put("location", location);
			map.put("pageKey", "location");
		}
		
		if (!option.getSido().equals("선택")) map.put("classArea1", option.getSido());
		else map.put("classArea1", "");
		
		if (!option.getSigoon().equals("선택")) map.put("classArea2", option.getSigoon());
		else map.put("classArea2", "");
		
		if (ctNo == 0) map.put("ctNo", 0);
		else {
			map.put("pageKey", "category");
			map.put("ctNo", ctNo);
		}
		map.put("ctDetailNo", ctDetailNo);
		
		System.out.println(map);
		
		Pagination pagination = service.getPagination(map, page);
		pagination.setLimit(12);
		pagination.setPageSize(5);
		
		List<ClassList> searchList = service.selectSearchList(pagination, map);
		Map<String, Object> result = new HashMap<String, Object>();
		
		System.out.println(pagination);
		
		for(ClassList list : searchList) {
			System.out.println(list);
		}
		
		result.put("pagination", pagination);
		result.put("classList", searchList);
		
		return new Gson().toJson(result);
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
	
	// 주변 클래스 목록
	@RequestMapping("locationClass")
	public String locationClass(HttpSession session, Model model, 
			@RequestParam(value="location", required=false) String location) {
		
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null)
			memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("pageKey", "location");
		map.put("type", "location");
		map.put("location", location);
		map.put("optionFlag", 1);
		
		List<ClassList> locationList = null;
		locationList = service.selectMainList(map);
		
		model.addAttribute("classList", locationList);
		model.addAttribute("type", "location");
		
		return "main/classList";
	}
	
	// 인기 클래스 목록
	@RequestMapping("hotClass")
	public String hotClass(HttpSession session, Model model) {
		
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null)
			memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("pageKey", "hot");
		map.put("type", "hot");
		
		List<ClassList> hotList = null;
		hotList = service.selectMainList(map);
		
		model.addAttribute("classList", hotList);
		model.addAttribute("type", "hot");
		
		return "main/classList";
	}
	
	// 신규 클래스 목록
	@RequestMapping("newClass")
	public String newClass(HttpSession session, Model model) {
		
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null)
			memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("pageKey", "new");
		map.put("type", "new");
		
		List<ClassList> newList = null;
		newList = service.selectMainList(map);
		
		model.addAttribute("classList", newList);
		model.addAttribute("type", "new");
		
		return "main/classList";
	}
	
	// 카테고리 클래스 목록
	@RequestMapping("category")
	public String categoryList(HttpSession session, Model model, int ctNo, 
			@RequestParam(value="ctDetailNo", required=false, defaultValue="0") int ctDetailNo) {
		
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null)
			memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("pageKey", "category");
		map.put("ctNo", ctNo);
		map.put("ctDetailNo", ctDetailNo);
		
		List<ClassList> categoryList = null;
		categoryList = service.selectMainList(map);
		
		model.addAttribute("classList", categoryList);
		
		return "main/categoryList";
	}
}
