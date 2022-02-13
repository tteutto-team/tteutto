package edu.kh.tteutto.chatNote.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.tteutto.chatNote.model.service.ChatNoteService;
import edu.kh.tteutto.chatNote.model.vo.ChatNote;
import edu.kh.tteutto.member.model.vo.Member;

@RequestMapping(value="/chatNote/*")
@Controller
public class chatNoteController {

	@Autowired
	private ChatNoteService service;
	
	@RequestMapping(value="alarm", method=RequestMethod.GET)
	@ResponseBody
	public int alarm(HttpSession session) {
		
		int sum = -1;
		
		Member member = (Member)session.getAttribute("loginMember");
		
		if(member != null) {
			int memberNo = member.getMemberNo();
			ChatNote chatNote = new ChatNote();
			chatNote.setMemberNo(memberNo);
			
			int count = service.selectChatAlarm(chatNote);
			int count2 = service.selectNoteAlarm(chatNote);
			sum = count+count2;
			
		}
		
		return sum;
	}
	
	
	@RequestMapping(value="clearAlarm", method=RequestMethod.GET)
	@ResponseBody
	public int clearAlarm(HttpSession session) {
		Member member = (Member)session.getAttribute("loginMember");
		
		int result = 0;
		
		System.out.println(member.getMemberNo());
		
		if(member != null) {
			int memberNo = member.getMemberNo();
			
			result = service.clearAlarm(memberNo);
		}
		
		
		return result;
	}
}
