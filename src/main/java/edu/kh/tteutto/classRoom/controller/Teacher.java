package edu.kh.tteutto.classRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher/*")
public class Teacher {
	
	// 클래스 목록
	@RequestMapping("classList")
	public String classList() {
		return "class/teacherClassList";
	}
	
	// 학생 관리(수강 예정)
	@RequestMapping("studentListExpect")
	public String studentListExpect() {
		return "class/teacherStudentListExpect";
	}
	
	// 학생 관리(수강 중)
	@RequestMapping("studentListOngoing")
	public String studentListOngoing() {
		return "class/teacherStudentListOngoing";
	}
}
