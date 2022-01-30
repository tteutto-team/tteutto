package edu.kh.tteutto.member.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 로그인
	 * @param memberEmail
	 * @return loginMember
	 */
	public Member login(String memberEmail) {
		return sqlSession.selectOne("memberMapper.login", memberEmail);
	}
	
	/** 이메일 중복 검사
	 * @param inputEmail
	 * @return result
	 */
	public int emailDupCheck(String inputEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck", inputEmail);
	}
	
	/** 강사 정보 조회
	 * @param memberNo
	 * @return teacher
	 */
	public Teacher selectTeacherProfile(int memberNo) {
		return sqlSession.selectOne("memberMapper.selectTeacherProfile", memberNo);
	}

	/** 강사 이력 조회
	 * @param memberNo
	 * @return career
	 */
	public List<Career> selectTeacherCareer(int memberNo) {
		return sqlSession.selectList("memberMapper.selectTeacherCareer", memberNo);
	}

	/** 회원가입
	 * @param member
	 * @return result
	 */
	public int signUp(Member member) {
		return sqlSession.insert("memberMapper.signUp", member);
	}

	/** 회원 인증테이블에 이메일 중복 확인
	 * @param inputEmail
	 * @return result
	 */
	public int emailDupCheck2(String inputEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck2", inputEmail);
	}
	
	/** 회원가입 이메일 인증번호 저장
	 * @param map
	 * @return result
	 */
	public int sendMailTest(Map<String, String> map) {
		return sqlSession.insert("memberMapper.sendMailTest", map);
	}

	/** 회원가입 이메일 인증번호 수정
	 * @param map
	 * @return
	 */
	public int updateMailTest(Map<String, String> map) {
		return sqlSession.update("memberMapper.updateMailTest", map);
	}
	
	/** 이메일 인증 번호 확인
	 * @param map
	 * @return result
	 */
	public int checkCert(Map<String, String> map) {
		return sqlSession.selectOne("memberMapper.checkCert", map);
	}

	public int changeConfirm(Certified certified) {
		return sqlSession.selectOne("memberMapper.changeConfirm", certified);
	}

	public int changePw(Member member) {
		return sqlSession.update("memberMapper.changePw", member);
	}

	public int updateCert(Certified certified) {
		return sqlSession.update("memberMapper.updateCert", certified);
	}




	

}
