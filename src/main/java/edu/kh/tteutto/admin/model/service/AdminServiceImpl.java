package edu.kh.tteutto.admin.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.tteutto.admin.model.dao.AdminDAO;
import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminCalcRefund;
import edu.kh.tteutto.admin.model.vo.AdminNoticeFaq;
import edu.kh.tteutto.admin.model.vo.AdminNoticeImage;
import edu.kh.tteutto.admin.model.vo.AdminReport;
import edu.kh.tteutto.admin.model.vo.AdminTeacher;
import edu.kh.tteutto.common.Util;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO dao;

	
	// 회차별 목록 조회
	@Override
	public List<Admin> classEpisodeList() {
		return dao.classEpisodeList();
	}

	// 회차별 신청 승인
	@Override
	public int episodeAgree(int classNo) {
		
		return dao.episodeAgree(classNo);
	}

	// 회차별 신청 거절
	@Override
	@Transactional
	public int episodeDeny(int classNo) {
		return dao.episodeDeny(classNo);
	}

	// 클래스 목록 조회
	@Override
	public List<Admin> classList() {
		return dao.classList();
	}

	// 클래스 신청 승인
	@Override
	@Transactional
	public int classAgree(int classNo) {
		return dao.classAgree(classNo);
	}

	// 클래스 신청 거절
	@Override
	public int classDeny(int classNo) {
		return dao.classDeny(classNo);
	}
	
	// 유저 목록 조회
	@Override
	public List<Admin> userList() {
		return dao.userList();
	}
	
	// 유저 정보 업데이트
	@Override
	public int userSave(Admin admin) {
		return dao.userSave(admin);
	}
	
	
	
	

	

	// 강사 목록 조회
	@Override
	public List<AdminTeacher> teacherList() {
		return dao.teacherList();
	}

	// 강사 신청 승인
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int teacherAgree(int memberNo) {
		
		int result = dao.teacherAgree(memberNo);
		
		if(result > 0) {
			result = dao.teacherEnrollY(memberNo);
		}
		
		return result;
	}

	// 강사 신청 거절
	@Override
	public int teacherDeny(int memberNo) {
		return dao.teacherDeny(memberNo);
	}
	
	// 강사 정보 조회
	@Override
	public AdminTeacher selectTeacher(int memberNo) {
		return dao.selectTeacher(memberNo);
	}

	// 학생 신고 목록 조회
	@Override
	public List<AdminReport> studentReportList() {
		return dao.studentReportList();
	}

	// 학생 신고 신청 승인/거절
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int reportAgreeDeny(AdminReport adminReport) {
		
		int result = dao.reportAgreeDeny(adminReport);
		
		if(adminReport.getReportStatus() == 2) { // 승인되었을 때 count 증가
			adminReport.setReportCount(adminReport.getReportCount() + 1);
			
			if(adminReport.getReportCount() >= 3) {
				result = dao.memberBan(adminReport);
				
			}
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	// 정산 신청 목록 조회
	@Override
	public List<AdminCalcRefund> calculateList() {
		return dao.calculateList();
	}
	
	// 영수증 생성
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int createReceipt(int calNo) {
		
		// 영수증 생성 전 정산 상태 수정
		int result = dao.calStatus(calNo);
		
		if(result > 0) {
			List<AdminCalcRefund> list = dao.receiptList(calNo);
			
			if(!list.isEmpty()) {
				
				result = dao.createReceipt(list);
				
			}
		}
		
		return result;
	}
	
	// 정산 학생 목록 조회
	@Override
	public List<AdminCalcRefund> receiptStList(int calNo) {
		return dao.receiptStList(calNo);
	}
	
	// 정산 클래스 이름, 강사 이름 조회
	@Override
	public AdminCalcRefund calculateClassTeacher(int calNo) {
		return dao.calculateClassTeacher(calNo);
	}
	
	// 정산 완료 업데이트
	@Override
	public int receiptUpdate(int calNo) {
		return dao.receiptUpdate(calNo);
	}
	
	// 환불 목록 조회
	@Override
	public List<AdminCalcRefund> refundList() {
		return dao.refundList();
	}
	
	// 환불 승인
	@Override
	public int refundAgree(int refundNo) {
		return dao.refundAgree(refundNo);
	}
	
	
	



	

	





	// 공지사항 목록 조회
	@Override
	public List<AdminNoticeFaq> noticeList() {
		return dao.noticeList();
	}

	// 공지사항 삭제
	@Override
	public int noticeDelete(int noticeNo) {
		return dao.noticeDelete(noticeNo);
	}

	// 공지사항 게시글 삽입
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertNotice(AdminNoticeFaq notice, List<MultipartFile> images, String webPath, String serverPath) {
		notice.setNoticeTitle(Util.XSS(notice.getNoticeTitle()));
		notice.setNoticeContent(Util.XSS(notice.getNoticeContent()));
		
		notice.setNoticeContent(Util.changeNewLine(notice.getNoticeContent()));
		
		int noticeNo = dao.insertNotice(notice);
		
		if(noticeNo > 0) {
			
			List<AdminNoticeImage> imgList = new ArrayList<AdminNoticeImage>();
			
			for(int i=0; i<images.size(); i++) {
				if(!images.get(i).getOriginalFilename().equals("")) {
					
					AdminNoticeImage img = new AdminNoticeImage();
					
					img.setImgPath(webPath);
					img.setImgOriginal(images.get(i).getOriginalFilename());
					img.setImgName(Util.fileRename(images.get(i).getOriginalFilename()));
					img.setNoticeNo(notice.getNoticeNo());
					
					imgList.add(img);
					
				} // if end
				
			} // for end
			
			if (!imgList.isEmpty()) {
				int result = dao.insertImgList(imgList);

				if (result == imgList.size()) {
					for (int i = 0; i < imgList.size(); i++) {

						try {
							images.get(i)
							.transferTo(new File(serverPath + "/" + imgList.get(i).getImgName()));
						} catch (Exception e) {
							e.printStackTrace();

						}

					}

				}

			}
			
		}
		
		return noticeNo;
	}
	
	
	// FAQ 목록 조회
	@Override
	public List<AdminNoticeFaq> faqList() {
		return dao.faqList();
	}

	// FAQ 삭제
	@Override
	public int faqDelete(int faqNo) {
		return dao.faqDelete(faqNo);
	}

	// FAQ 게시글 삽입
	@Override
	public int insertFaq(AdminNoticeFaq faq) {
		faq.setFaqQuestion(Util.XSS(faq.getFaqQuestion()));
		faq.setFaqAnswer(Util.XSS(faq.getFaqAnswer()));
		
		faq.setFaqAnswer(Util.changeNewLine(faq.getFaqAnswer()));
		
		int result = dao.insertFaq(faq);
		
		return result;
	}
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	

}
