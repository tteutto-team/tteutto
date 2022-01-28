package edu.kh.tteutto.member.model.service;

import java.util.List;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Member;

public interface MemberService {

	/** 로그인
	 * @param member
	 * @return loginMember
	 */
	Member login(Member member);

	/** 강사 정보 조회
	 * @param memberNo 
	 * @param memberNo
	 * @return techer
	 */
	Teacher selectTeacherProfile(int memberNo);

	/** 강사 이력 조회
	 * @param memberNo
	 * @return career
	 */
	List<Career> selectTeacherCareer(int memberNo);

	
}
