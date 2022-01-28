package edu.kh.tteutto.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.admin.model.dao.AdminDAO;
import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO dao;

	
	// 클래스 회차별 목록 조회
	@Override
	public List<Admin> selectList() {
		return dao.selectList();
	}

	// 회차별 신청 승인
	@Override
	public int agree(int classNo) {
		return dao.agree(classNo);
	}
	
	
	
	

}
