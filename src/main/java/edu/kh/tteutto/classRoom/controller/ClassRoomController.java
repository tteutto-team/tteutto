package edu.kh.tteutto.classRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.tteutto.classRoom.model.service.TeacherService;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@RequestMapping("/teacher/*")
public class ClassRoomController {
	
	@Autowired
	private TeacherService service;
	
	// 클래스 목록
	@RequestMapping(value = "classList", method = RequestMethod.GET)
	public String classList(@ModelAttribute("loginMember") Member loginMember, Model model) {
		
//		int memberNo = loginMember.getMemberNo();
		int memberNo = 3;
		
		List<ClassDetail> classList = service.selectClassList(memberNo);
		
		model.addAttribute("loginMember", loginMember);
		model.addAttribute("classList", classList);
		
		
		return "class/teacherClassList";
	}
	
	@ResponseBody
	@RequestMapping(value = "classEpisode", method=RequestMethod.POST)
	public String classEpisode(String classId) {
		
		System.out.println("classId: " + classId);
		
		List<EpisodeClass> episodeList = service.selectClassEpisode(classId);
		
		System.out.println("episodeList? " + episodeList);
		
		return "null";
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
