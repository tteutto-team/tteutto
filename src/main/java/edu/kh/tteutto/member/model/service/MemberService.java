package edu.kh.tteutto.member.model.service;

import edu.kh.tteutto.member.model.vo.Member;

public interface MemberService {

	/** 로그인
	 * @param member
	 * @return loginMember
	 */
	Member login(Member member);

}
