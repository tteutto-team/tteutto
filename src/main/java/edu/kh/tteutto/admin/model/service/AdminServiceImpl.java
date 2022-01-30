package edu.kh.tteutto.admin.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.tteutto.admin.model.dao.AdminDAO;
import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminTeacher;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO dao;

	
	// 회차별 목록 조회
	@Override
	public List<Admin> classEpisodeList() {
		return dao.classEpisodeList();
	}

	// 회차별 신청 승인
	@Override
	@Transactional
	public int episodeAgree(int classNo) {
		
		return dao.episodeAgree(classNo);
	}

	// 회차별 신청 거절
	@Override
	@Transactional
	public int episodeDeny(int classNo) {
		return dao.episodeDeny(classNo);
	}

	// 클래스 목록 조회
	@Override
	public List<Admin> classList() {
		return dao.classList();
	}

	// 클래스 신청 승인
	@Override
	@Transactional
	public int classAgree(int classNo) {
		return dao.classAgree(classNo);
	}

	// 클래스 신청 거절
	@Override
	public int classDeny(int classNo) {
		return dao.classDeny(classNo);
	}

	// 강사 목록 조회
	@Override
	public List<AdminTeacher> teacherList() {
		return dao.teacherList();
	}

	// 강사 신청 승인
	@Override
	public int teacherAgree(int memberNo) {
		return dao.teacherAgree(memberNo);
	}

	// 강사 신청 거절
	@Override
	public int teacherDeny(int memberNo) {
		return dao.teacherDeny(memberNo);
	}
	
	
	
	
	
	
	
	

}
