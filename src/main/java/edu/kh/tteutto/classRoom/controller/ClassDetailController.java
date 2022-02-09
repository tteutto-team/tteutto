package edu.kh.tteutto.classRoom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.classRoom.model.service.ClassDetailService;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailRight;
import edu.kh.tteutto.classRoom.model.vo.ClassRegister;
import edu.kh.tteutto.classRoom.model.vo.ClassReview;

@Controller
@RequestMapping("/class/*")
@SessionAttributes({"loginMember"})
public class ClassDetailController {

	@Autowired
	private ClassDetailService service;

//	// 클래스 상세 페이지 이동
//	@RequestMapping("classDetail")
//	public String selectClassDetail() {
//		return "class/classDetail";
//	}

	// 클래스 상세 페이지 조회(결제박스만)
	@RequestMapping("classDetail")
	public String selectClassDetail(int classNo, Model model, RedirectAttributes ra, HttpSession session) {

		ClassDetailRight cdtr = service.selectClassDetail(classNo);
		
		//클래스 후기평점 조회
		ClassReview crev = service.selectReviewAvg(classNo);
		
		
		//클래스 찜하기 플래그
		int memberNo = 0;
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember != null)
			memberNo = loginMember.getMemberNo();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("memberNo", memberNo);
		map.put("classNo", classNo);
		
		ClassList classList =  service.selectWishFlag(map);
		
		String path = null;
		
		if(cdtr != null) {
			model.addAttribute("cdtr", cdtr);
			model.addAttribute("crev", crev);
			model.addAttribute("classList", classList);
			path = "class/classDetail";
			
		}else { // 경로로 검색시
			
			Util.swalSetMessage("해당 글이 존재하지 않습니다.", null, "info", ra);
			path = "redirect:../";  // 메인페이지로 리다이렉트 
			
		}

		return path;
	}
	
	// 클래스 신청 여부 조회
	@ResponseBody
	@RequestMapping("selectRegisterDt")
	public String selectRegisterDt(int classNo, int memberNo) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
	
		map.put("memberNo", memberNo);
		map.put("classNo", classNo);
		
		String result = service.selectRegisterDt(map);
		
		return result;
	}
	
	
	// 클래스 결제(신청) 후 결제내역 DB 삽입
	@ResponseBody
	@RequestMapping("insertRegister")
	public int insertRegister(Model model, ClassRegister classReg) {
		return service.insertRegister(classReg);
	}
	
	// 찜목록에 추가하기
	@ResponseBody
	@RequestMapping(value="insertWish", method=RequestMethod.POST)
	public int insertWish(int memberNo, int classNo) {
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
	
		map.put("memberNo", memberNo);
		map.put("classNo", classNo);
		
		return service.insertWish(map);
	}
	
	// 찜목록에서 삭제하기
	@ResponseBody
	@RequestMapping(value="deletetWish", method=RequestMethod.POST)
	public int deletetWish(int memberNo, int classNo) {
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
	
		map.put("memberNo", memberNo);
		map.put("classNo", classNo);
		
		return service.deletetWish(map);
	}
	
	
	
}
