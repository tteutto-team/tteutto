package edu.kh.tteutto.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.kh.tteutto.admin.model.service.AdminService;
import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminTeacher;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@RequestMapping(value="/admin/*")
public class adminController {
	
	@Autowired
	private AdminService service;
	
	// 회차별 신청 관리 이동
	@RequestMapping(value="classEpisodeManage", method=RequestMethod.GET)
	public String classEpisodeManage() {
		return "admin/classEpisodeManage";
	}
	
	
	// 회차별 목록 조회
	@RequestMapping(value="classEpisodeList", method=RequestMethod.GET)
	@ResponseBody
	public List<Admin> classEpisodeList() {
		
		List<Admin> data = service.classEpisodeList();
		
		return data;
	}
	
	
	// 회차별 신청 승인
	@RequestMapping(value="episodeAgree", method=RequestMethod.GET)
	@ResponseBody
	public int episodeAgree(int classNo) {
		
		
		int result = service.episodeAgree(classNo);
		
		
		return result;
	}
	
	// 회차별 신청 거절
	@RequestMapping(value="episodeDeny", method=RequestMethod.GET)
	@ResponseBody
	public int episodeDeny(int classNo) {
		
		
		int result = service.episodeDeny(classNo);
		
		
		return result;
	}
	
	
	
	// 클래스 신청 관리 이동
	@RequestMapping(value="classManage", method=RequestMethod.GET)
	public String classManage() {
		return "admin/classManage";
	}
	
	
	// 클래스 목록 조회
	@RequestMapping(value="classList", method=RequestMethod.GET)
	@ResponseBody
	public List<Admin> classList() {
		
		List<Admin> data = service.classList();
		
		return data;
	}
	
	// 클래스 신청 승인
	@RequestMapping(value="classAgree", method=RequestMethod.GET)
	@ResponseBody
	public int classAgree(int classNo) {
		
		
		int result = service.classAgree(classNo);
		
		
		return result;
	}
	
	// 클래스 신청 거절
	@RequestMapping(value="classDeny", method=RequestMethod.GET)
	@ResponseBody
	public int classDeny(int classNo) {
		
		
		int result = service.classDeny(classNo);
		
		
		return result;
	}
	
	// 회차별 신청 관리 이동
	@RequestMapping(value="teacherManage", method=RequestMethod.GET)
	public String teacherManage() {
		return "admin/teacherManage";
	}
	
	// 강사 목록 조회
	@RequestMapping(value="teacherList", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminTeacher> teacherList(){
		
		List<AdminTeacher> data = service.teacherList();
		
		return data;
	}
	
	// 클래스 신청 승인
	@RequestMapping(value="teacherAgree", method=RequestMethod.GET)
	@ResponseBody
	public int teacherAgree(int memberNo) {
		
		
		int result = service.teacherAgree(memberNo);
		
		
		return result;
	}
	
	// 클래스 신청 승인
	@RequestMapping(value="teacherDeny", method=RequestMethod.GET)
	@ResponseBody
	public int teacherDeny(int memberNo) {
		
		
		int result = service.teacherDeny(memberNo);
		
		
		return result;
	}
	
	// 강사 상세 조회
	@RequestMapping(value="teacher/{memberNo}", method=RequestMethod.GET)
	public String teacher(@PathVariable(value="memberNo", required = false) int memberNo,
							Model model) {
		
		AdminTeacher teacher = service.selectTeacher(memberNo);
		
		model.addAttribute("teacher", teacher);
		
		return "admin/teacher";
	}
}
