package edu.kh.tteutto.member.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.member.model.vo.Member;

@Repository
public class LoginDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 소셜 로그인 회원 확인
	 * @param email
	 * @return loginMember
	 */
	public Member snsLogin(String email) {
		
		return sqlSession.selectOne("memberMapper.snsLogin", email);
	}

	/** sns 회원가입
	 * @param member
	 * @return result
	 */
	public int signUp2(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memberMapper.signUp2", member);
	}

	/** sns 이메일 중복 확인
	 * @param email
	 * @return result
	 */
	public int emailCheck(String email) {
		return sqlSession.selectOne("memberMapper.emailCheck", email);
	}


}
