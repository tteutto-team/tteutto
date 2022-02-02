package edu.kh.tteutto.admin.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminNoticeFaq;
import edu.kh.tteutto.admin.model.vo.AdminReport;
import edu.kh.tteutto.admin.model.vo.AdminTeacher;
import edu.kh.tteutto.classRoom.model.vo.Teacher;
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

	/** 강사 정보 조회
	 * @param memberNo
	 * @return teacher
	 */
	AdminTeacher selectTeacher(int memberNo);

	/** 학생 신고 목록 조회
	 * @return data
	 */
	List<AdminReport> studentReportList();

	/** 학생 신고 신청 승인/거절 
	 * @param adminReport
	 * @return result
	 */
	int reportAgreeDeny(AdminReport adminReport);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** 공지사항 목록 조회
	 * @return data
	 */
	List<AdminNoticeFaq> noticeList();

	/** 공지사항 삭제
	 * @param noticeNo
	 * @return result
	 */
	int noticeDelete(int noticeNo);

	/** 공지사항 게시글 삽입
	 * @param notice 
	 * @param images
	 * @param webPath
	 * @param serverPath
	 * @return 
	 */
	int insertNotice(AdminNoticeFaq notice, List<MultipartFile> images, String webPath, String serverPath);


}
