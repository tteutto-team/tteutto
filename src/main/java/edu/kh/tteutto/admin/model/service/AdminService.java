package edu.kh.tteutto.admin.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminCalcRefund;
import edu.kh.tteutto.admin.model.vo.AdminClass;
import edu.kh.tteutto.admin.model.vo.AdminEpisode;
import edu.kh.tteutto.admin.model.vo.AdminNoticeFaq;
import edu.kh.tteutto.admin.model.vo.AdminReport;
import edu.kh.tteutto.admin.model.vo.AdminReview;
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
	
	/** 회차 상세 조회
	 * @param episodeNo
	 * @return episodeOne
	 */
	AdminEpisode selectEpisode(int episodeNo);
	
	/** 회차 상세 조회시 검토중으로 업데이트
	 * @param episodeNo
	 * @return result
	 */
	int episodeStatusUpdate(int episodeNo);

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
	
	/** 클래스 상세 조회
	 * @param memberNo
	 * @return
	 */
	AdminClass selectClass(int classNo);
	
	/** 클래스 상세 조회시 검토중으로 업데이트
	 * @param classNo
	 * @return result
	 */
	int classStatusUpdate(int classNo);

	/** 클래스 수정 신청 목록 조회
	 * @return data
	 */
	List<Admin> classUpdateList();

	/** 클래스 수정 승인
	 * @param classNo
	 * @return result
	 */
	int classUpdateAgree(int classNo);

	/** 클래스 수정 거절
	 * @param classNo
	 * @return result
	 */
	int classUpdateDeny(int classNo);

	/** 클래스 수정 상세 조회
	 * @param classNo
	 * @return classOne2
	 */
	AdminClass selectClassUpdate(int classNo);

	/** 클래스 수정 상세 조회시 상태 업데이트
	 * @param classNo
	 * @return result
	 */
	int classUpdateStatus(int classNo);

	
	
	
	
	
	/** 유저 목록 조회
	 * @return data
	 */
	List<Admin> userList();
	
	/** 유저 정보 업데이트
	 * @param admin
	 * @return result
	 */
	int userSave(Admin admin);


	
	
	
	
	

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

	/** 클래스 신고 목록 조회
	 * @return data
	 */
	List<AdminReport> classReportList();

	
	
	
	
	
	
	
	
	
	/** 정산 신청 목록 조회
	 * @return data
	 */
	List<AdminCalcRefund> calculateList();
	
	/** 영수증 생성
	 * @param calNo
	 * @return result
	 */
	int createReceipt(int calNo);
	
	/** 정산 학생 목록 조회
	 * @param calNo
	 * @return data
	 */
	List<AdminCalcRefund> receiptStList(int calNo);

	
	/** 정산 클래스 이름, 강사 이름 조회
	 * @param calNo
	 * @return cal
	 */
	AdminCalcRefund calculateClassTeacher(int calNo);

	/** 정산 완료 업데이트
	 * @param calNo
	 * @return result
	 */
	int receiptUpdate(int calNo);

	/** 환불 목록 조회
	 * @return data
	 */
	List<AdminCalcRefund> refundList();

	/** 환불 승인
	 * @param refundNo
	 * @return result
	 */
	int refundAgree(int refundNo);

	
	
	
	
	
	
	
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

	/** FAQ 목록 조회
	 * @return data
	 */
	List<AdminNoticeFaq> faqList();

	/** FAQ 삭제
	 * @param faqNo
	 * @return result
	 */
	int faqDelete(int faqNo);

	/** FAQ 게시글 삽입
	 * @param faq
	 * @return result
	 */
	int insertFaq(AdminNoticeFaq faq);

	/** 후기 목록 조회
	 * @return data
	 */
	List<AdminReview> reviewList();

	/** 후기 삭제
	 * @param reviewNo
	 * @return result
	 */
	int reviewDeny(int reviewNo);


















}
