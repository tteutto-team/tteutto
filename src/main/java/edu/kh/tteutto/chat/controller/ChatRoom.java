package edu.kh.tteutto.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat/*")
public class ChatRoom {

	//채팅방
	@RequestMapping("chatRoom")
	public String chatRoom(){
		return "chat/chatRoom";
		
	}
}
