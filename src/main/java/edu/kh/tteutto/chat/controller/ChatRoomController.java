package edu.kh.tteutto.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String selectChatRoomList(@ModelAttribute("loginMember") Member loginMember,
									@RequestParam(value="mode", required=false, defaultValue="0")  int mode, 
									Model model) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("mode", mode);
		map.put("memberNo", loginMember.getMemberNo());
		
		List<ChatRoom> chatRoomList = service.chatRoomList(map);
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
								RedirectAttributes ra, Model model){
		
		// loginMember에서 회원 번호 얻어와 room에 추가
		room.setMemberNo(loginMember.getMemberNo());
		int chatRoomNo = 0;
		
		// 채팅방 번호가 있음 == 기존에 존재하던 채팅방
		if(room.getChatRoomNo() > 0) {
			ChatRoom cr = service.selectChatRoom(room.getChatRoomNo());
			chatRoomNo = room.getChatRoomNo();
			List<ChatMessage> list = service.selectChatMessage(chatRoomNo);
			model.addAttribute("list", list);
			model.addAttribute("cr", cr);
			
		}else {
			// 채팅방 번호는 없고 클래스 번호가 있음. 
			//-> 학생이 상세페이지에서 실시간 채팅 버튼을 누른 경우
			Map<String, Object> map = service.openChatRoom(room);
			model.addAttribute("teacherInfo", map); // 강사 정보 조회
			
			int crNo = Integer.parseInt(String.valueOf(map.get("CHAT_ROOM_NO")));
			// 채팅방 번호 있음 == 이전 채팅 내용이 있음 -> 채팅 내역을 조회
			if(crNo > 0) {
				List<ChatMessage> list = service.selectChatMessage(crNo);
				model.addAttribute("list", list);
			}
			
		}
			
		model.addAttribute("chatRoomNo", chatRoomNo);
		
		return "chat/chatRoom";
		
	}
	
	// 강사(or학생) -> 학생(or강사)에게 채팅메세지를 보내는 순간
	// 채팅방 DB 삽입(생성) + 이전채팅 내역 얻어오기
	/*@RequestMapping("/chat/room/{chatRoomNo}")
	public String joinChatRoom(@PathVariable("chatRoomNo") int chatRoomNo,
								@ModelAttribute("loginMember") Member loginMember, 
								ChatRoom chatRoom,
								RedirectAttributes ra, Model model) {
		
		// 1. 방번호, 회원번호 저장
		chatRoom = new ChatRoom();
		
		chatRoom.setChatRoomNo(chatRoomNo);
		chatRoom.setMemberNo(loginMember.getMemberNo());
		
		// 2. 강사(or학생) -> 학생(or강사)에게 채팅메세지를 보내는 순간
		// 채팅방 생성 + 채팅 내역(메세지) 조회하는 service 호출
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
		
		
	}*/
	
	
	
	//쪽지 목록 조회
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
