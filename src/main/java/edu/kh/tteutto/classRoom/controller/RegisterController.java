package edu.kh.tteutto.classRoom.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.tteutto.classRoom.model.service.ClassRegisterService;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailImage;
import edu.kh.tteutto.classRoom.model.vo.Episode;
import edu.kh.tteutto.classRoom.model.vo.EpisodeSchedule;
import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.member.model.service.MemberService;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@SessionAttributes({ "loginMember", "openClass" })
@RequestMapping(value="register/*")
public class RegisterController {
	
		@Autowired
		private ClassRegisterService service;

		// 클래스 등록 페이지 이동
		@RequestMapping(value="class", method=RequestMethod.GET)
		public String classRegister(HttpSession session) {
			if(session.getAttribute("loginMember") != null) {
				return "class/classInsert1";			
			}else {
				return "member/login";
			}
		}
		
		// 클래스 스케쥴 등록 페이지 이동
		@RequestMapping(value="schedule/{no}", method=RequestMethod.GET)
		public String classRegisterSchedule(HttpSession session, @PathVariable (value = "no", required = false) int no,
											@ModelAttribute("loginMember") Member loginMember, RedirectAttributes ra) {
			
			String path = "";
			
			if(session.getAttribute("loginMember") != null) {
				
				int teacherNo = service.teacherNo(no);
				
				if(teacherNo == loginMember.getMemberNo()) {
					
					ClassDetail cdt = service.classSelect(no);
					
					session.setAttribute("cdt", cdt);
					
					path = "class/classInsert2";	
				}else {
					ra.addFlashAttribute("message", "잘못된 접근 입니다.");
					path = "redirect:/";
				}
		
			}else {
				ra.addFlashAttribute("message", "로그인 후 이용해주세요.");
				path = "member/login";
			}
			
			return path;
			
		}
		
		// 주소검색 팝업창
		@RequestMapping("addrPopup")
		public String addrPopup() {
			return "class/jusoPopup";
		}
		
		// 클래스 등록
		@RequestMapping(value="class", method=RequestMethod.POST)
		public String classInsert(RedirectAttributes ra, @ModelAttribute("loginMember") Member loginMember,
								  ClassDetail cdt, String classArea1, String classArea2,
								  @RequestParam(value="images", required=false) List<MultipartFile> images, 
								  HttpSession session){
			
			// 시군 추가
			String area = classArea1 + " " + classArea2;
			cdt.setClassArea(area);
			cdt.setMemberNo(loginMember.getMemberNo());
			
			String webPath = "/resources/images/class/"; // (DB에 저장되는 경로)
			String serverPath = session.getServletContext().getRealPath(webPath);

			int result = service.classInsert(cdt, images, webPath, serverPath);
			
			if(result > 0) {
				Util.swalSetMessage("클래스 신청 완료", "관리자 승인을 기다려주세요.", "success", ra);			
				return "redirect:/";
			}else {
				Util.swalSetMessage("클래스 신청 실패", "관리자에게 문의해주세요.", "error", ra);			
				return "redirect:/";
			}
			
		}
		
		

		// 클래스 미리보기 페이지
		@RequestMapping("preview")
		public String classPreview(HttpSession session) {
			
			if(session.getAttribute("loginMember") != null) {
			
				return "class/classDetailPreview";
				
			}else {
				return "member/login";
			}
			
		}
		
		// 임시저장
		@RequestMapping("save")
		public String classSave(HttpSession session, RedirectAttributes ra,
								String classArea1, String classArea2, ClassDetail cdt, 
								HttpServletRequest req, HttpServletResponse resp, String marketing) {
			String area = classArea1 + " " + classArea2;
			cdt.setClassArea(area);
			
			System.out.println(cdt);
			
			session.setAttribute("mark", marketing);
			session.setAttribute("cdt", cdt);
			
			/*
			Cookie cookie = new Cookie("classLevel", cdt.getClassLevel());
			
			cookie.setMaxAge(60 * 60 * 24 * 30);
			
			cookie.setPath(req.getContextPath());
			
			resp.addCookie(cookie);
			*/
			
			ra.addFlashAttribute("message", "임시저장이 완료되었습니다.");
			
			return "class/classInsert1";
		}
		
		// 클래스 스케쥴 등록
		@RequestMapping(value="schedule", method=RequestMethod.POST)
		public String insertClassSchedule(RedirectAttributes ra, @ModelAttribute("loginMember") Member loginMember,
										  Episode episode, EpisodeSchedule episodeSd, String roadAddrPart1, String addrDetail) {
			
			// 주소 합치기
			String epPlace = roadAddrPart1 + " " + addrDetail;
			episode.setEpPlace(epPlace);
			
			// 테스트용 클래스 데이터 //
			//episode.setClassNo(101);
			
			// 날짜 넣기
			List<EpisodeSchedule> epsList = new ArrayList<EpisodeSchedule>();
			String dt = episodeSd.getSchdlDt();
			String wk = episodeSd.getSchdlWeek();
			String st = episodeSd.getSchdlStartTime();
			String et = episodeSd.getSchdlEndTime();

			String[] schdlDt = dt.split(",");
			String[] schdlWk = wk.split(",");
			String[] schdlSt = st.split(",");
			String[] schdlEt = et.split(",");

			for(int i=0; i<schdlSt.length; i++) {
				if(schdlSt[i] == "9") {
					schdlSt[i] = "0" + schdlSt[i] + ":00";
				}else {
					schdlSt[i] = schdlSt[i] + ":00";
				}
				
			}
			
			for(int i=0; i<schdlDt.length; i++) {
				EpisodeSchedule eps = new EpisodeSchedule();
				eps.setEpPrice(episodeSd.getEpPrice());
				eps.setSchdlDt(schdlDt[i]);
				eps.setSchdlWeek(schdlWk[i]);
				eps.setSchdlStartTime(schdlSt[i]);
				eps.setSchdlEndTime(schdlEt[i]);
				eps.setSchdlTime(episodeSd.getSchdlTime());
				
				epsList.add(eps);
			}
			
			int result = service.insertClassSchedule(episode, epsList);
			
			if(result > 0) {
				Util.swalSetMessage("클래스 스케쥴 등록 완료", null, "success", ra);			
				return "redirect:/";
			}else {
				Util.swalSetMessage("클래스 스케줄 등록 실패", "관리자에게 문의해주세요", "error", ra);			
				return "redirect:/";
			}
			
		}
		
		
}
