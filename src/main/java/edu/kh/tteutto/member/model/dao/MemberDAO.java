package edu.kh.tteutto.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.member.model.vo.Career;
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
		
		Member loginMember = sqlSession.selectOne("memberMapper.login", memberEmail);
		
		return loginMember;
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
	

	

}
