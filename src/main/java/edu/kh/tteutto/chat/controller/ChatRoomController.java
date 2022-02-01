package edu.kh.tteutto.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat/*")
public class ChatRoomController {

	//채팅방
	@RequestMapping("chatRoom")
	public String selectChatRoom(){
		return "chat/chatRoom";
		
	}
	
	//채팅 목록
	@RequestMapping("chatRoomList")
	public String selectChatRoomList() {
		return "chat/chatRoomList";
	}
	
	//쪽지 목록
	@RequestMapping("messageList")
	public String selectMessageList() {
		return "chat/messageList";
	}
}
