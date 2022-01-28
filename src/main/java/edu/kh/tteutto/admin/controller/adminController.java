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
	@RequestMapping(value="classList", method=RequestMethod.GET)
	@ResponseBody
	public List<Admin> classList() {
		
		List<Admin> data = service.selectList();
		
		/*
		 * Map<String, Object> data = new HashMap<String, Object>();
		 * 
		 * data.put("data", memberList);
		 */
		
		return data;
	}
	
	
	// 클래스 회차별 신청 승인
	@RequestMapping(value="agree", method=RequestMethod.GET)
	@ResponseBody
	public int agree(int classNo) {
		
		
		int result = service.agree(classNo);
		
		
		return result;
	}
}
