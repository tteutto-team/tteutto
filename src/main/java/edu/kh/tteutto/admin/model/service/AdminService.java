package edu.kh.tteutto.admin.model.service;

import java.util.List;

import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.member.model.vo.Member;

public interface AdminService {

	/** 클래스 회차별 목록 조회
	 * @return data
	 */
	List<Admin> selectList();

	/** 회차별 신청 승인
	 * @param classNo
	 * @return result
	 */
	int agree(int classNo);

}
