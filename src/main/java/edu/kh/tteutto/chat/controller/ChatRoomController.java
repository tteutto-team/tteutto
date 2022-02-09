package edu.kh.tteutto.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.tteutto.chat.model.service.ChatRoomService;
import edu.kh.tteutto.chat.model.vo.ChatMessage;
import edu.kh.tteutto.chat.model.vo.ChatRoom;
import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@SessionAttributes({"loginMember", "chatRoomNo"})
public class ChatRoomController {
	
	@Autowired
	private ChatRoomService service;

	
	//채팅 목록
	@RequestMapping("/chat/chatRoomList")
	public String selectChatRoomList(Model model) {
		
		List<ChatRoom> chatRoomList = service.chatRoomList();
		model.addAttribute("chatRoomList", chatRoomList);
		
		return "chat/chatRoomList";
	}
	
	// 채팅방이 만들어지는 과정
	// 1. 클래스 상세페이지에서 실시간톡 버튼 클릭
	// 2. 해당 클래스 담당 강사와 채팅할 수 있는 채팅방에 입장(채팅방 만들어지기 전)
	// 3. 세션에 로그인된 회원이 메세지 1개 이상 전송 시 해당 강사와 로그인 회원의 1:1 채팅방 생성
	// => 결국.. 실시간톡 버튼 == 채팅방 생성 버튼 ?
	
	//채팅방 열기
	@RequestMapping("/chat/chatRoom")
	public String openChatRoom(ChatRoom room, /*커맨드객체*/
								@ModelAttribute("loginMember") Member loginMember,
								RedirectAttributes ra){
		
		// loginMember에서 회원 번호 얻어와 room에 추가
		room.setMemberNo(loginMember.getMemberNo());
		
		//채팅방 여는 service 호출 , 생성된 방 번호 얻어오기
		int chatRoomNo = service.openChatRoom(room);
		
		String path = "redirect:/chat/";
		
		if(chatRoomNo > 0) {
			path += "room/" + chatRoomNo; // /chat/room/1
		}else {
			Util.swalSetMessage("채팅방 생성 실패", null, "error", ra);
			path += "chatRoomList";
		}
		
		return path;
		
	}
	
	
	// 채팅방 입장 + 이전채팅 내역 얻어오기
	@RequestMapping("/chat/room/{chatRoomNo}")
	public String joinChatRoom(@PathVariable("chatRoomNo") int chatRoomNo,
								@ModelAttribute("loginMember") Member loginMember,
								ChatRoom chatRoom,
								RedirectAttributes ra, Model model) {
		
		// 1. 방번호, 회원번호 저장
		chatRoom = new ChatRoom();
		
		chatRoom.setChatRoomNo(chatRoomNo);
		chatRoom.setMemberNo(loginMember.getMemberNo());
		
		// 2. 채팅방 입장 + 채팅 내역(메세지) 조회하는 service 호출
		List<ChatMessage> list = service.joinChatRoom(chatRoom);
		
		// 3. 채팅방이 존재하면 조회한 채팅 내역과 채팅 번호를 jsp로 포워드
		if(list != null) {
			
			model.addAttribute("list", list);
			model.addAttribute("chatRoomNo", chatRoomNo); //session에 올림
			
			return "chat/chatRoom";
			 
		}else { // 채팅방이 존재하지 않으면 채팅목록으로 리다이렉트
			
			Util.swalSetMessage("채팅방이 존재하지 않습니다.", null, "info", ra);
			
			return "redirect:../chatRoomList";
		}
		
		
	}
	
	
	
	//쪽지 목록
	@RequestMapping("/chat/messageList")
	public String selectMessageList() {
		return "chat/messageList";
	}
	
	
	
//	HttpSessionRequiredException : Session 값을 얻어오려고 했으나, 없는 경우 발생하는 예외
//  -> 채팅장 입장 시 로그인이 되어있지 않은 경우
//     == 주소로 채팅방에 강제 접근
	@ExceptionHandler(HttpSessionRequiredException.class)
	public String exceptionHandler(Exception e, RedirectAttributes ra) {
		Util.swalSetMessage("로그인 후 이용해주세요.", null, "info", ra);
		return "redirect:../member/login";   
	}
}
