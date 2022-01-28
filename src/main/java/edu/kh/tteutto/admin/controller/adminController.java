package edu.kh.tteutto.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.kh.tteutto.member.model.service.AdminService;
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
	
	@RequestMapping(value="classList", method=RequestMethod.GET)
	@ResponseBody
	public List<Member> classList() {
		
		List<Member> data = service.selectList();
		
		/*
		 * Map<String, Object> data = new HashMap<String, Object>();
		 * 
		 * data.put("data", memberList);
		 */
		
		
		return data;
	}
}
