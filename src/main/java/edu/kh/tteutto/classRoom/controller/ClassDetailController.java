package edu.kh.tteutto.classRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.tteutto.classRoom.model.service.ClassDetailService;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;

@Controller
@RequestMapping("/class/*")
public class ClassDetailController {
	
	@Autowired
	private ClassDetailService service;
	
	// 클래스 상세 페이지 조회
	@RequestMapping("classDetail")
	public String selectClassDetail(/* int classNo, Model model */) {
		
//		ClassDetail cdt = service.selectClassDetail(classNo);
		
		
		return "class/classDetail";
	}

}
