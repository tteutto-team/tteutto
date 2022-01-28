package edu.kh.tteutto.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.member.model.dao.AdminDAO;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO dao;

	@Override
	public List<Member> selectList() {
		return dao.selectList();
	}
	
	

}
