package edu.kh.tteutto.chat.websocket;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import edu.kh.tteutto.chat.model.service.ChatRoomService;
import edu.kh.tteutto.chat.model.vo.ChatMessage;
import edu.kh.tteutto.chat.model.vo.ChatRoom;
import edu.kh.tteutto.member.model.vo.Member;

//웹소켓 관련 요청/응답 코드 작성하는 클래스 ( bean으로 등록함)
public class ChatWebsocketHandler extends TextWebSocketHandler{

	@Autowired
	private ChatRoomService service;
	
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
	
	// 클라이언트와 연결이 완료되고 통신할 준비가 되면 실행 !!
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		// 웹소켓 요청을 보낸 클라이언트와 통신할 수 있는 객체를 sessions에 추가
		// => 클라이언트 정보를 한곳에 모음
		sessions.add(session);
		
		System.out.println(session.getId() +"연결됨");
	}

	//클라이언트로부터 웹소켓 통신으로 텍스트 메세지를 전달받은 경우 실행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		// 전송된 데이터확인
		//System.out.println("전달 받은 내용 : " + message.getPayloadLength());
		
		int result = 0;
		ObjectMapper objectMapper = new ObjectMapper();
		ChatMessage cm = objectMapper.readValue(message.getPayload(), ChatMessage.class);
		
		System.out.println("변경된 cm : " + cm);
		
		if(cm.getTeacherNo() > 0 || cm.getStudentNo() > 0) {
			int count = service.countChatRoomNo2(cm);
			
			if(count > 0) {
				cm.setChatRoomNo(service.selectChatRoomNo2(cm));
			}
			
		}
		
		if(cm.getChatRoomNo() <= 0) {
			service.insertChatRoom(cm);
		}
		System.out.println("확인 후 cm : " + cm);
		
		// 채팅 내용 DB에 저장
		
		if(cm.getMode() >= 0) {
			int number = service.selectOtherMember(cm);
			
			if(cm.getMode() == 0) {
				cm.setTeacherNo(number);
			}else{
				cm.setStudentNo(number);
			}
		}
		System.out.println("asdfasdf : " + cm);
		result = service.insertMessage(cm);
		
		// 채팅방 생성내용 DB에 삽입... 컨트롤러에서? 웹소켓에서..?... (chatRoomController 에 joinChatRoom)
		// 여기서 채팅방 생성내용을 DB에 삽입해야하는데 --- INSERT INTO CHAT_ROOM VALUSE (#{chatRoomNo}, DEFAULT, DEFAULT, DEFAULT, #{memberNo}, (SELECT MEMBER_NO FROM CLASS WHERE CLASS_NO=#{teacherNo}))
		// memberNo를 어떻게 받아오지?..
		
		if(result > 0) {
			
			// sessions: 웹소켓 요청을 보낸 모든 클라이언트의 세션정보가 담김
			for(WebSocketSession wss : sessions) {
				System.out.println(wss.getAttributes());
				//int chatRoomNo = (Integer)wss.getAttributes().get("chatRoomNo");
				int loginMemberNo = ((Member)wss.getAttributes().get("loginMember")).getMemberNo();
				System.out.println(loginMemberNo);
				// 메세지에 있는 방번호 , 채팅방에 있으면서 같은 방번호를 갖고있는 회원의 경우
				//if(chatRoomNo == cm.getChatRoomNo()) {
				if(loginMemberNo == cm.getMemberNo() || loginMemberNo == cm.getOtherMemberNo() ) {
					
					Map<String, Object> map = new HashMap<String, Object>();
					
					
					
					// 얻어온 데이터를 모두에게 뿌림
					map.put("cm", cm);
					
					// 채팅 알림
					if(loginMemberNo == cm.getOtherMemberNo()) {
						int count = service.sendAlarm(cm);
						int count2 = service.sendAlarm2(cm);
						
						int sum = (count + count2);
						map.put("sum", sum);
						
					}
					wss.sendMessage(new TextMessage(new Gson().toJson(map)));
				}
				
				
				
			}
			
			
			
			
		}
	}

	// 클라이언트와 연결이 종료되면 실행!
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		sessions.remove(session);
	}

	
}
