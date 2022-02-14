package edu.kh.tteutto.chatNote.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.chatNote.model.dao.ChatNoteDAO;
import edu.kh.tteutto.chatNote.model.vo.ChatNote;

@Service
public class ChatNoteServiceImple implements ChatNoteService {
	
	@Autowired
	private ChatNoteDAO dao;

	// 쪽지 보내기
	@Override
	public int sendNote(ChatNote cm) {
		return dao.sendNote(cm);
	}
	
	// 쪽지 알림 갯수
	@Override
	public int selectNoteAlarm(ChatNote cm) {
		return dao.selectNoteAlarm(cm);
	}
	
	// 채팅 알림 갯수
	@Override
	public int selectChatAlarm(ChatNote cm) {
		return dao.selectChatAlarm(cm);
	}
	
	// 알람 삭제
	@Override
	public int clearAlarm(int memberNo) {
		
		int result = 0;
		
		int count = dao.countChatAlarm(memberNo);
		
		if(count > 0) {
			result = dao.clearChatAlarm(memberNo);
		}
		
		count = dao.countNoteAlarm(memberNo);
		
		if(count > 0) {
			result = dao.clearNoteAlarm(memberNo);
		}
		
		return result;
	}
}
