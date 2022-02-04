package edu.kh.tteutto.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import edu.kh.tteutto.admin.model.service.AdminService;
import edu.kh.tteutto.admin.model.vo.Admin;
import edu.kh.tteutto.admin.model.vo.AdminCalcRefund;
import edu.kh.tteutto.admin.model.vo.AdminNoticeFaq;
import edu.kh.tteutto.admin.model.vo.AdminReport;
import edu.kh.tteutto.admin.model.vo.AdminTeacher;
import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@RequestMapping(value="/admin/*")
public class adminController {
	
	@Autowired
	private AdminService service;
	
	// 회차별 신청 관리 이동
	@RequestMapping(value="classEpisodeManage", method=RequestMethod.GET)
	public String classEpisodeManage() {
		return "admin/classEpisodeManage";
	}
	
	
	// 회차별 목록 조회
	@RequestMapping(value="classEpisodeList", method=RequestMethod.GET)
	@ResponseBody
	public List<Admin> classEpisodeList() {
		
		List<Admin> data = service.classEpisodeList();
		
		return data;
	}
	
	
	// 회차별 신청 승인
	@RequestMapping(value="episodeAgree", method=RequestMethod.GET)
	@ResponseBody
	public int episodeAgree(int classNo) {
		
		
		int result = service.episodeAgree(classNo);
		
		
		return result;
	}
	
	// 회차별 신청 거절
	@RequestMapping(value="episodeDeny", method=RequestMethod.GET)
	@ResponseBody
	public int episodeDeny(int classNo) {
		
		
		int result = service.episodeDeny(classNo);
		
		
		return result;
	}
	
	
	
	// 클래스 신청 관리 이동
	@RequestMapping(value="classManage", method=RequestMethod.GET)
	public String classManage() {
		return "admin/classManage";
	}
	
	
	// 클래스 목록 조회
	@RequestMapping(value="classList", method=RequestMethod.GET)
	@ResponseBody
	public List<Admin> classList() {
		
		List<Admin> data = service.classList();
		
		return data;
	}
	
	// 클래스 신청 승인
	@RequestMapping(value="classAgree", method=RequestMethod.GET)
	@ResponseBody
	public int classAgree(int classNo) {
		
		
		int result = service.classAgree(classNo);
		
		
		return result;
	}
	
	// 클래스 신청 거절
	@RequestMapping(value="classDeny", method=RequestMethod.GET)
	@ResponseBody
	public int classDeny(int classNo) {
		
		
		int result = service.classDeny(classNo);
		
		
		return result;
	}
	
	// 회차별 신청 관리 이동
	@RequestMapping(value="teacherManage", method=RequestMethod.GET)
	public String teacherManage() {
		return "admin/teacherManage";
	}
	
	// 강사 목록 조회
	@RequestMapping(value="teacherList", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminTeacher> teacherList(){
		
		List<AdminTeacher> data = service.teacherList();
		
		return data;
	}
	
	// 클래스 신청 승인
	@RequestMapping(value="teacherAgree", method=RequestMethod.GET)
	@ResponseBody
	public int teacherAgree(int memberNo) {
		
		
		int result = service.teacherAgree(memberNo);
		
		
		return result;
	}
	
	// 클래스 신청 승인
	@RequestMapping(value="teacherDeny", method=RequestMethod.GET)
	@ResponseBody
	public int teacherDeny(int memberNo) {
		
		
		int result = service.teacherDeny(memberNo);
		
		
		return result;
	}
	
	// 강사 상세 조회
	@RequestMapping(value="teacher/{memberNo}", method=RequestMethod.GET)
	public String teacher(@PathVariable(value="memberNo", required = false) int memberNo,
							Model model) {
		
		AdminTeacher teacher = service.selectTeacher(memberNo);
		
		model.addAttribute("teacher", teacher);
		
		return "admin/teacher";
	}
	
	// 학생 신고 관리 이동
	@RequestMapping(value="studentReportManage", method=RequestMethod.GET)
	public String studentReportManage() {
		return "admin/studentReportManage";
	}
	
	// 강사 목록 조회
	@RequestMapping(value="studentReportList", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminReport> studentReportList(){
		
		List<AdminReport> data = service.studentReportList();
		
		return data;
	}
	
	// 학생 신고 신청 승인/거절
	@RequestMapping(value="reportAgreeDeny", method=RequestMethod.GET)
	@ResponseBody
	public int reportAgreeDeny(AdminReport adminReport) {
		
		int result = service.reportAgreeDeny(adminReport);
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 정산 페이지 이동
	@RequestMapping(value="calculateManage", method=RequestMethod.GET)
	public String calculateManage() {
		return "admin/calculateManage";
	}
	
	// 정산 신청 목록 조회
	@RequestMapping(value="calculateList", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminCalcRefund> calculateList(){
		
		List<AdminCalcRefund> data = service.calculateList();
		
		return data;
	}
	
	// 영수증 생성
	@RequestMapping(value="createReceipt", method=RequestMethod.GET)
	@ResponseBody
	public int createReceipt(int calNo) {
		
		int result = service.createReceipt(calNo);
		
		return result;
	}
	
	// 정산 학생 목록 페이지 이동
	@RequestMapping(value="calculate/{calNo}", method=RequestMethod.GET)
	public String calculate(@PathVariable(value="calNo", required = false) int calNo, Model model, RedirectAttributes ra) {
		
		AdminCalcRefund cal = service.calculateClassTeacher(calNo);
		
		if(cal != null) {
			model.addAttribute("cal", cal);
			model.addAttribute("paramCalNo", calNo);
			
			return "admin/calculate";
		}else {
			Util.swalSetMessage("영수증 생성먼저 해주세요.", null, "error", ra);
			
			return "redirect:../calculateManage";
		}
		
		
	}
	
	// 정산 학생 목록 조회
	@RequestMapping(value="calculate/receiptList", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminCalcRefund> receiptList(int calNo){
		
		List<AdminCalcRefund> data = service.receiptStList(calNo);
		
		return data;
	}
	
	// 정산 완료 업데이트
	@RequestMapping(value="receiptUpdate", method=RequestMethod.POST)
	@ResponseBody
	public int receiptUpdate(int calNo, RedirectAttributes ra) {
		
		int result = service.receiptUpdate(calNo);
		
		return result;
	}
	
	// 환불 관리 페이지 이동
	@RequestMapping(value="refundManage", method=RequestMethod.GET)
	public String refundManage() {
		return "admin/refundManage";
	}
	
	// 환불 목록 조회
	@RequestMapping(value="refundList", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminCalcRefund> refundList(){
		
		List<AdminCalcRefund> data = service.refundList();
		
		return data;
	} 
	
	// 환불 승인
	@RequestMapping(value="refundAgree", method=RequestMethod.GET)
	@ResponseBody
	public int refundAgree(int refundNo) {
		
		int result = service.refundAgree(refundNo);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	// 공지사항 페이지 이동
	@RequestMapping(value="noticeManage", method=RequestMethod.GET)
	public String noticeManage() {
		return "admin/noticeManage";
	}
	
	// 공지사항 목록 조회
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminNoticeFaq> noticeList(){
		
		List<AdminNoticeFaq> data = service.noticeList();
		
		return data;
	}
	
	// 공지사항 삭제
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	@ResponseBody
	public int noticeDelete(int noticeNo){
		
		return service.noticeDelete(noticeNo);
	}
	
	// 공지사항 글쓰기 페이지 이동
	@RequestMapping(value="noticeInsert", method=RequestMethod.GET)
	public String noticeInsert() {
		return "admin/noticeInsert";
	}
	
	// 공지사항 게시글 삽입
	@RequestMapping(value="noticeInsert", method=RequestMethod.POST)
	public String insertNotice(@RequestParam(value="images", required=false) List<MultipartFile> images,
								HttpSession session,
								RedirectAttributes ra, AdminNoticeFaq notice) {
		
		String webPath = "/resources/images/notice/"; // (DB에 저장되는 경로)
		
		String serverPath = session.getServletContext().getRealPath(webPath);
		
		int result = service.insertNotice(notice, images, webPath, serverPath);

		if(result > 0) {
			Util.swalSetMessage("게시글 삽입 완료", null, "success", ra);
		}else {
			Util.swalSetMessage("게시글 삽입 실패", null, "error", ra);
		}
		
		return "redirect:/admin/noticeManage";
	}
	
	// FAQ 페이지 이동
	@RequestMapping(value="faqManage", method=RequestMethod.GET)
	public String faqManage() {
		return "admin/faqManage";
	}
	
	// FAQ 목록 조회
	@RequestMapping(value="faqList", method=RequestMethod.GET)
	@ResponseBody
	public List<AdminNoticeFaq> faqList(){
		
		List<AdminNoticeFaq> data = service.faqList();
		
		return data;
	}
	
	// FAQ 삭제
	@RequestMapping(value="faqDelete", method=RequestMethod.GET)
	@ResponseBody
	public int faqDelete(int faqNo){
		
		return service.faqDelete(faqNo);
	}
	
	// FAQ 글쓰기 페이지 이동
	@RequestMapping(value="faqInsert", method=RequestMethod.GET)
	public String faqInsert() {
		return "admin/faqInsert";
	}
	
	// FAQ 게시글 삽입
	@RequestMapping(value="faqInsert", method=RequestMethod.POST)
	public String insertFaq(AdminNoticeFaq faq, RedirectAttributes ra) {
		
		System.out.println(faq);
		
		int result = service.insertFaq(faq);

		if(result > 0) {
			Util.swalSetMessage("게시글 삽입 완료", null, "success", ra);
		}else {
			Util.swalSetMessage("게시글 삽입 실패", null, "error", ra);
		}
		
		return "redirect:/admin/faqManage";
	}
}
