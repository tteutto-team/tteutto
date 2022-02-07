package edu.kh.tteutto.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		Pagination pagination = null;
		List<ClassList> wishList = null;
		
		pagination = service.getPagination(memberNo, page);
		pagination.setLimit(9);
		
		wishList = service.selectWishList(pagination, memberNo);
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("wishList", wishList);
		
		return "member/studentWishList";
	}
}
