package edu.kh.tteutto.admin.model.service;

import java.util.List;

import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminTeacher;
import edu.kh.tteutto.member.model.vo.Member;

public interface AdminService {

	/** 회차별 목록 조회
	 * @return data
	 */
	List<Admin> classEpisodeList();

	/** 회차별 신청 승인
	 * @param classNo
	 * @return result
	 */
	int episodeAgree(int classNo);

	/** 회차별 신청 거절
	 * @param classNo
	 * @return result
	 */
	int episodeDeny(int classNo);

	/** 클래스 목록 조회
	 * @return data
	 */
	List<Admin> classList();

	/** 클래스 신청 승인
	 * @param classNo
	 * @return result
	 */
	int classAgree(int classNo);

	/** 클래스 신청 거절
	 * @param classNo
	 * @return result
	 */
	int classDeny(int classNo);

	/** 강사 목록 조회
	 * @return data
	 */
	List<AdminTeacher> teacherList();

	/** 강사 신청 승인
	 * @param memberNo
	 * @return result
	 */
	int teacherAgree(int memberNo);

	/** 강사 신청 거절
	 * @param memberNo
	 * @return result
	 */
	int teacherDeny(int memberNo);

}
