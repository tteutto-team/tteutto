package edu.kh.tteutto.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping(value="/admin/*")
public class adminController {
	
	// 회원가입 페이지 이동
	@RequestMapping(value="classManage", method=RequestMethod.GET)
	public String classManage() {
		return "admin/classManage";
	}
	
	@RequestMapping(value="classList", method=RequestMethod.GET)
	@ResponseBody
	public String classList() {
		System.out.println("ajax");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "user01");
		map.put("name", "유저일");
		map.put("name2", "유저일");
		map.put("gender", "유저일");
		System.out.println(map);
		
		return new Gson().toJson(map);
	}
}
