package edu.kh.tteutto.chatNote.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.chatNote.model.dao.ChatNoteDAO;
import edu.kh.tteutto.chatNote.model.vo.ChatNote;

@Service
public class ChatNoteServiceImple implements ChatNoteService {
	
	@Autowired
	private ChatNoteDAO dao;

	// 회차별 신청 승인 쪽지 보내기
	@Override
	public int episodeAgreeSendNote(ChatNote cm) {
		return dao.episodeAgreeSendNote(cm);
	}
	
	// 회차별 신청 거절 쪽지 보내기
	@Override
	public int episodeDenySendNote(ChatNote cm) {
		return dao.episodeDenySendNote(cm);
	}
	
	
	
}
