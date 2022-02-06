package edu.kh.tteutto.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminCalcRefund;
import edu.kh.tteutto.admin.model.vo.AdminNoticeFaq;
import edu.kh.tteutto.admin.model.vo.AdminNoticeImage;
import edu.kh.tteutto.admin.model.vo.AdminReport;
import edu.kh.tteutto.admin.model.vo.AdminTeacher;

/**
 * @author ChoiSeungYeop
 *
 */
@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 회차별 목록 조회
	 * @return data
	 */
	public List<Admin> classEpisodeList() {
		return sqlSession.selectList("adminMapper.classEpisodeList");
	}

	
	/** 회차별 신청 승인
	 * @param classNo
	 * @return result
	 */
	public int episodeAgree(int classNo) {
		return sqlSession.update("adminMapper.episodeAgree", classNo);
	}


	/** 회차별 신청 거절
	 * @param classNo
	 * @return result
	 */
	public int episodeDeny(int classNo) {
		return sqlSession.update("adminMapper.episodeDeny", classNo);
	}


	/** 클래스 목록 조회
	 * @return
	 */
	public List<Admin> classList() {
		return sqlSession.selectList("adminMapper.classList");
	}


	/** 클래스 신청 승인
	 * @param classNo
	 * @return result
	 */
	public int classAgree(int classNo) {
		return sqlSession.update("adminMapper.classAgree", classNo);
	}


	/** 클래스 신청 거절
	 * @param classNo
	 * @return result
	 */
	public int classDeny(int classNo) {
		return sqlSession.update("adminMapper.classDeny", classNo);
	}
	
	/** 유저 목록 조회
	 * @return data
	 */
	public List<Admin> userList() {
		return sqlSession.selectList("adminMapper.userList");
	}
	
	/** 유저 정보 업데이트
	 * @param admin
	 * @return result
	 */
	public int userSave(Admin admin) {
		return sqlSession.update("adminMapper.userSave", admin);
	}
	
	
	


	/** 강사 목록 조회
	 * @return data
	 */
	public List<AdminTeacher> teacherList() {
		return sqlSession.selectList("adminMapper.teacherList");
	}

	/** 강사 신청 승인
	 * @param memberNo
	 * @return result
	 */
	public int teacherAgree(int memberNo) {
		return sqlSession.update("adminMapper.teacherAgree", memberNo);
	}
	
	/** 강사 신청 승인 Enroll 업데이트
	 * @param memberNo
	 * @return result
	 */
	public int teacherEnrollY(int memberNo) {
		return sqlSession.update("adminMapper.teacherEnrollY", memberNo);
	}

	/** 강사 신청 거절
	 * @param memberNo
	 * @return result
	 */
	public int teacherDeny(int memberNo) {
		return sqlSession.update("adminMapper.teacherDeny", memberNo);
	}

	
	/** 강사 정보 조회
	 * @param memberNo
	 * @return teacher
	 */
	public AdminTeacher selectTeacher(int memberNo) {
		return sqlSession.selectOne("adminMapper.selectTeacher", memberNo);
	}


	/** 학생 신고 목록 조회
	 * @return data
	 */
	public List<AdminReport> studentReportList() {
		return sqlSession.selectList("adminMapper.studentReportList");
	}


	/** 학생 신고 신청 승인/거절
	 * @param adminReport
	 * @return result
	 */
	public int reportAgreeDeny(AdminReport adminReport) {
		return sqlSession.update("adminMapper.reportAgreeDeny", adminReport);
	}


	/** 계정 정지
	 * @param adminReport
	 * @return result
	 */
	public int memberBan(AdminReport adminReport) {
		return sqlSession.update("adminMapper.memberBan", adminReport);
	}


	
	
	
	
	
	
	
	
	/** 정산 신청 목록 조회
	 * @return data
	 */
	public List<AdminCalcRefund> calculateList() {
		return sqlSession.selectList("adminMapper.calculateList");
	}
	
	/** 정산 상태 수정
	 * @param calNo
	 * @return result
	 */
	public int calStatus(int calNo) {
		return sqlSession.update("adminMapper.calStatus", calNo);
	}
	
	
	/** 영수증 목록
	 * @param calNo
	 * @return list
	 */
	public List<AdminCalcRefund> receiptList(int calNo) {
		return sqlSession.selectList("adminMapper.receiptList", calNo);
	}
	
	/** 영수증 생성
	 * @param list
	 * @return result
	 */
	public int createReceipt(List<AdminCalcRefund> list) {
		return sqlSession.insert("adminMapper.createReceipt", list);
	}
	
	/** 정산 학생 목록 조회
	 * @param calNo
	 * @return data
	 */
	public List<AdminCalcRefund> receiptStList(int calNo) {
		return sqlSession.selectList("adminMapper.receiptStList", calNo);
	}

	/** 정산 클래스 이름, 강사 이름 조회
	 * @param calNo
	 * @return cal
	 */
	public AdminCalcRefund calculateClassTeacher(int calNo) {
		return sqlSession.selectOne("adminMapper.calculateClassTeacher", calNo);
	}
	
	/** 정산 완료 업데이트
	 * @param calNo
	 * @return result
	 */
	public int receiptUpdate(int calNo) {
		return sqlSession.update("adminMapper.receiptUpdate", calNo);
	}


	/** 환불 목록 조회
	 * @return data
	 */
	public List<AdminCalcRefund> refundList() {
		return sqlSession.selectList("adminMapper.refundList");
	}
	
	/** 환불 승인
	 * @param refundNo
	 * @return result
	 */
	public int refundAgree(int refundNo) {
		return sqlSession.update("adminMapper.refundAgree", refundNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	/** 공지사항 목록 조회
	 * @return data
	 */
	public List<AdminNoticeFaq> noticeList() {
		return sqlSession.selectList("adminMapper.noticeList");
	}


	/** 공지사항 삭제
	 * @param noticeNo
	 * @return result
	 */
	public int noticeDelete(int noticeNo) {
		return sqlSession.delete("adminMapper.noticeDelete", noticeNo);
	}


	/** 공지사항 게시글 삽입
	 * @param notice
	 * @return result
	 */
	public int insertNotice(AdminNoticeFaq notice) {
		return sqlSession.insert("adminMapper.insertNotice", notice);
	}


	/** 공지사항 이미지 삽입
	 * @param imgList
	 * @return result
	 */
	public int insertImgList(List<AdminNoticeImage> imgList) {
		return sqlSession.insert("adminMapper.insertImgList", imgList);
	}


	/** FAQ 목록 조회
	 * @return data
	 */
	public List<AdminNoticeFaq> faqList() {
		return sqlSession.selectList("adminMapper.faqList");
	}


	/** FAQ 삭제
	 * @param faqNo
	 * @return result
	 */
	public int faqDelete(int faqNo) {
		return sqlSession.delete("adminMapper.faqDelete", faqNo);
	}


	/** FAQ 게시글 삽입
	 * @param faq
	 * @return result
	 */
	public int insertFaq(AdminNoticeFaq faq) {
		return sqlSession.insert("adminMapper.insertFaq", faq);
	}

























}
