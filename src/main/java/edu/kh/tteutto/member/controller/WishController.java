package edu.kh.tteutto.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.service.WishService;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/member2/*")
public class WishController {
	
	@Autowired
	private WishService service;
	
	// 찜한 클래스
	@RequestMapping("studentWishList")
	public String studentWishList(Model model, 
			@ModelAttribute("loginMember") Member loginMember, 
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("pageKey", "wish");
		
		Pagination pagination = null;
		List<ClassList> wishList = null;
		
		pagination = service.getPagination(map, page);
		pagination.setLimit(9);
		pagination.setPageSize(5);
		
		wishList = service.selectWishList(pagination, map);
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("wishList", wishList);
		
		return "member/studentWishList";
	}
	
	// 찜한 클래스 삽입 & 삭제
	@ResponseBody
	@RequestMapping("changeHeart")
	public int changeHeart(int classNo, 
			@ModelAttribute("loginMember") Member loginMember) {
		
		int memberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("classNo", classNo);
		
		return service.changeHeart(map);
	}
}
