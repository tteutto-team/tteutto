package edu.kh.tteutto.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.kh.tteutto.admin.model.service.AdminService;
import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@RequestMapping(value="/admin/*")
public class adminController {
	
	@Autowired
	private AdminService service;
	
	// 회원가입 페이지 이동
	@RequestMapping(value="classManage", method=RequestMethod.GET)
	public String classManage() {
		return "admin/classManage";
	}
	
	
	// 클래스 회차별 목록 조회
	@RequestMapping(value="classEpisodeList", method=RequestMethod.GET)
	@ResponseBody
	public List<Admin> classEpisodeList() {
		
		List<Admin> data = service.classEpisodeList();
		
		return data;
	}
	
	
	// 클래스 회차별 신청 승인
	@RequestMapping(value="episodeAgree", method=RequestMethod.GET)
	@ResponseBody
	public int episodeAgree(int classNo, int memberNo, String className) {
		
		
		int result = service.episodeAgree(classNo, memberNo, className);
		
		
		return result;
	}
	
	// 클래스 회차별 신청 거절
	@RequestMapping(value="episodeDeny", method=RequestMethod.GET)
	@ResponseBody
	public int episodeDeny(int classNo) {
		
		
		int result = service.episodeDeny(classNo);
		
		
		return result;
	}
	
}
