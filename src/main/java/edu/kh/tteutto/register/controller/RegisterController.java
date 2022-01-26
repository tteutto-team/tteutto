package edu.kh.tteutto.register.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="register/*")
public class RegisterController {

		// 클래스 등록
		@RequestMapping(value="class", method=RequestMethod.GET)
		public String classRegister() {
			return "class/classInsert1";
		}
		
		// 클래스 스케쥴 등록
		@RequestMapping(value="schedule", method=RequestMethod.GET)
		public String classRegisterSchedule() {
			return "class/classInsert2";
		}
		
		// 주소검색 팝업창
		@RequestMapping("addrPopup")
		public String addrPopup() {
			return "class/jusoPopup";
		}

}
