package edu.kh.tteutto.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.member.model.dao.MemberDAO;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;

	// 로그인
	@Override
	public Member login(Member member) {
		Member loginMember = dao.login(member.getMemberEmail());
		System.out.println(loginMember);
		return null;
	}
	
	
	
}
