package edu.kh.tteutto.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.member.model.dao.MemberDAO;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	

	// 로그인
	@Override
	public Member login(Member member) {
		
		String encPw = encoder.encode(member.getMemberPw());
		Member loginMember = dao.login(member.getMemberEmail());
		
		if(loginMember != null && encoder.matches(member.getMemberPw(), loginMember.getMemberPw())) {
			
			loginMember.setMemberPw(null);
		}else {
			loginMember = null;
		}
		return loginMember;
	}
	
	// 이메일 중복 검사
	@Override
	public int emailDupCheck(String inputEmail) {
		return dao.emailDupCheck(inputEmail);
	}
	
	// 회원 인증테이블에 이메일 중복 확인
	@Override
	public int emailDupCheck2(String inputEmail) {
		return dao.emailDupCheck2(inputEmail);
	}
	
	// 회원가입 이메일 인증번호 저장
	@Override
	public int sendMailTest(Map<String, String> map) {
		return dao.sendMailTest(map);
	}
		
	
	// 회원가입 이메일 인증번호 수정
	@Override
	public int updateMailTest(Map<String, String> map) {
		return dao.updateMailTest(map);
	}

	// 이메일 인증 확인
	@Override
	public int checkCert(Map<String, String> map) {
		return dao.checkCert(map);
	}

	// 회원가입
	@Transactional()
	@Override
	public int signUp(Member member) {
		
		String encPw = encoder.encode(member.getMemberPw());
		
		member.setMemberPw(encPw);
		
		return dao.signUp(member);
	}

	// 비밀번호 변경전 확인
	@Override
	public int changeConfirm(Certified certified) {
		return dao.changeConfirm(certified);
	}

	// 비밀번호 변경
	@Override
	public int changePw(Member member) {
		
		String encPw = encoder.encode(member.getMemberPw());
		
		member.setMemberPw(encPw);
		return dao.changePw(member);
	}
	
	@Override
	public int updateCert(Certified certified) {
		return dao.updateCert(certified);
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
