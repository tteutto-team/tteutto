package edu.kh.tteutto.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.tteutto.admin.model.dao.AdminDAO;
import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO dao;

	
	// 클래스 회차별 목록 조회
	@Override
	public List<Admin> classEpisodeList() {
		return dao.classEpisodeList();
	}

	// 회차별 신청 승인
	@Override
	@Transactional
	public int episodeAgree(int classNo, int memberNo, String className) {
		
		int result = dao.episodeAgree(classNo);
		
		if(result > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("memberNo", memberNo);
			map.put("className", className);
			
			result = dao.sendNote(map);
		}
		
		return result;
	}
	
	
	
	

}
