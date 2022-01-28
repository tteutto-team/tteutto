package edu.kh.tteutto.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.member.model.dao.MemberDAO;
import edu.kh.tteutto.member.model.vo.Career;
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
	
	// 강사 정보 조회
	@Override
	public Teacher selectTeacherProfile(int memberNo) {
		return dao.selectTeacherProfile(memberNo);
	}
	
	// 강사 이력 조회
	@Override
	public List<Career> selectTeacherCareer(int memberNo) {
		return dao.selectTeacherCareer(memberNo);
	}
	
}
