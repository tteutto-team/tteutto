package edu.kh.tteutto.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.member.model.dao.MemberDAO;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	// @Autowired
	// private BCryptPasswordEncoder encoder;

	// 로그인
	@Override
	public Member login(Member member) {
		
		//String encPw = encoder.encode(member.getMemberPw());
		//System.out.println(encPw);
		Member loginMember = dao.login(member.getMemberEmail());
		
		return null;
	}
	
	
	
}
