package edu.kh.tteutto.member.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;

public interface MemberService {

	/** 로그인
	 * @param member
	 * @return loginMember
	 */
	Member login(Member member);

	
	/** 이메일 중복 검사
	 * @param inputEmail
	 * @return result
	 */
	int emailDupCheck(String inputEmail);

	/** 회원가입
	 * @param member
	 * @return result
	 */
	int signUp(Member member);
	
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


	/** 회원 인증테이블에 이메일 중복 확인
	 * @param inputEmail
	 * @return result
	 */
	int emailDupCheck2(String inputEmail);

	/** 회원가입 이메일 인증번호 저장
	 * @param map
	 * @return result
	 */
	int sendMailTest(Map<String, String> map);

	/** 회원가입 이메일 인증번호 수정
	 * @param map
	 * @return
	 */
	int updateMailTest(Map<String, String> map);

	/** 이메일 인증 확인
	 * @param map
	 * @return result
	 */
	int checkCert(Map<String, String> map);

	/** 비밀번호 변경전 확인
	 * @param certified
	 * @return result
	 */
	int changeConfirm(Certified certified);

	/** 비밀번호 변경
	 * @param member
	 * @return result
	 */
	int changePw(Member member);


	/** 인증번호 지우기
	 * @param certified
	 * @return result
	 */
	int updateCert(Certified certified);






	
}
