package edu.kh.tteutto.classRoom.controller;
import java.io.File;
import java.io.IOException;
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

import com.google.gson.JsonObject;

import edu.kh.tteutto.classRoom.model.service.ClassRegisterService;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.ClassDetailImage;
import edu.kh.tteutto.classRoom.model.vo.Episode;
import edu.kh.tteutto.classRoom.model.vo.EpisodeSchedule;
import edu.kh.tteutto.classRoom.model.vo.IntroImg;
import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.member.model.service.MemberService;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@SessionAttributes({ "loginMember"})
@RequestMapping(value="register/*")
public class RegisterController {
	
		@Autowired
		private ClassRegisterService service;

		// 클래스 등록 페이지 이동
		@RequestMapping(value="class", method=RequestMethod.GET)
		public String classRegister(HttpSession session, Model model) {
			if(session.getAttribute("loginMember") != null) {
				
				return "class/classInsert1";			
			}else {
				return "member/login";
			}
		}
		
		// 클래스 스케쥴 등록 페이지 이동
		@RequestMapping(value="schedule/{no}", method=RequestMethod.GET)
		public String classRegisterSchedule(HttpSession session, @PathVariable (value = "no", required = false) int no,
											RedirectAttributes ra) {
			
			String path = "";
			
			if(session.getAttribute("loginMember") != null) { // 로그인 되있니?
				
				int classUse = service.classUse(no); // 존재하는 클래스인지 
				if(classUse > 0) {
					
					int teacherNo = service.teacherNo(no);
					Member loginMember = (Member)session.getAttribute("loginMember");
					
					if(teacherNo == loginMember.getMemberNo()) { // 로그인 멤버 - 클래스 등록된 강사 일치
						
						ClassDetail cdt = service.classSelect(no);
						
						if(cdt.getClassStatus() == 2) { // 클래스가 승인 됐는지 확인
							
							
							int epCount = service.checkEpCount(cdt.getClassNo());
							
							if(session.getAttribute("openClass") != null) {
								session.removeAttribute("openClass");
								//System.out.println("지우");
							}
							if(session.getAttribute("openCount") != null) {
								session.removeAttribute("openCount");
								//System.out.println("한지우");
							}
							
							session.setAttribute("openCount", epCount);		
							session.setAttribute("openClass", cdt);
							
							path = "class/classInsert2";	
							
						}else {
							ra.addFlashAttribute("message", "아직 승인되지 않은 클래스입니다.");
							path = "redirect:/";
						}
	
					}else {
						ra.addFlashAttribute("message", "잘못된 접근 입니다.");
						path = "redirect:/";
					}
			
				}else {
					ra.addFlashAttribute("message", "로그인 후 이용해주세요.");
					path = "member/login";
				}

			}else {
				ra.addFlashAttribute("message", "존재하지 않는 클래스입니다.");
				path = "redirect:/";
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
								  HttpSession session, @RequestParam(value="introImgName", required=false, defaultValue="null") String introImgName 
								  ){

			// 소개 이미지 받아오기
			String[] intro = introImgName.split(",");
			
			List<IntroImg> introImg = new ArrayList<IntroImg>();
			
			if(introImgName != null) {
				
				for(int i=0; i<intro.length; i++) {
					IntroImg it = new IntroImg();
					it.setIntroImgName(intro[i]);
					introImg.add(it);
				}
				
			}
			
			System.out.println(introImg);
		

			// 시군 추가
			String area = classArea1 + " " + classArea2;
			cdt.setClassArea(area);
			cdt.setMemberNo(loginMember.getMemberNo());
			
			String webPath = "/resources/images/class/"; // (DB에 저장되는 경로)
			String serverPath = session.getServletContext().getRealPath(webPath);

			int result = service.classInsert(cdt, images, webPath, serverPath, introImg);
			
			//service.introInsert(introImg);
			
			if(result > 0) {
				Util.swalSetMessage("클래스 신청 완료", "관리자 승인을 기다려주세요.", "success", ra);			
				return "redirect:/";
			}else {
				Util.swalSetMessage("클래스 신청 실패", "관리자에게 문의해주세요.", "error", ra);			
				return "redirect:/";
			}
			
		}
		
		/*
		@RequestMapping(value="class", method=RequestMethod.POST)
		public String classInsert(RedirectAttributes ra, @RequestParam(value="images", required=false) List<MultipartFile> images,
								  String classArea1, String classArea2, 
								  @RequestParam(value="introImgName", required=false, defaultValue="null") String introImgName,
								  ClassDetail cdt) {
			
			System.out.println(images);
			System.out.println(classArea1 + "  hhhh  " + classArea2);
			System.out.println(introImgName);
			System.out.println(cdt);
			
			
			ra.addFlashAttribute("message", "아직 승인되지 않은 클래스입니다.");
			return "redirect:/";
			
		}
		*/

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
								HttpServletRequest req, HttpServletResponse resp, String marketing,
								int sidoVal, int sigoonVal) {
			String area = classArea1 + " " + classArea2;
			cdt.setClassArea(area);
			
			session.setAttribute("mark", marketing);
			session.setAttribute("tempClass", cdt);
			session.setAttribute("sidoVal", sidoVal);
			session.setAttribute("sigoonVal", sigoonVal);
			
			ra.addFlashAttribute("message", "임시저장이 완료되었습니다.");
			
			return "redirect:/";
		}
		
		
		// 임시저장 스케쥴
		@RequestMapping("save2")
		public String scheduleSave(HttpSession session, RedirectAttributes ra, HttpServletResponse resp,
								HttpServletRequest req, int epPrice,
								@RequestParam(value="timePrice", required=false, defaultValue="0") int timePrice, 
								@RequestParam(value="timePrice2", required=false, defaultValue="0") int timePrice2, 
								@RequestParam(value="sumClass", required=false, defaultValue="0") int sumClass,
								 String roadAddrPart1, String addrDetail, 
								@RequestParam(value="schdlTime", required=false, defaultValue="0") int schdlTime,
								@RequestParam(value="schdlTime2", required=false, defaultValue="0") int schdlTime2,
								@RequestParam(value="susuryo", required=false, defaultValue="0") int susuryo
								) {
			
			session.setAttribute("timePrice", timePrice);
			session.setAttribute("timePrice2", timePrice2);
			session.setAttribute("sumClass", sumClass);
			session.setAttribute("epPrice", epPrice);
			session.setAttribute("roadAddrPart1", roadAddrPart1);
			session.setAttribute("addrDetail", addrDetail);
			session.setAttribute("schdlTime", schdlTime);
			session.setAttribute("schdlTime2", schdlTime2);
			session.setAttribute("susuryo", susuryo);
			
			
			ra.addFlashAttribute("message", "임시저장이 완료되었습니다.");
			
			return "redirect:/";
		}
		
		
		// 클래스 스케쥴 등록
		@RequestMapping(value="schedule", method=RequestMethod.POST)
		public String insertClassSchedule(RedirectAttributes ra, @ModelAttribute("loginMember") Member loginMember,
										  HttpSession session,
										  Episode episode, EpisodeSchedule episodeSd, String roadAddrPart1, 
										  String addrDetail ) {
			// openClass 값 가져오기			
			ClassDetail openClass = (ClassDetail)session.getAttribute("openClass");
			//System.out.println(openClass);
			
			// 주소 합치기
			String epPlace = roadAddrPart1 + " " + addrDetail;
			episode.setEpPlace(epPlace);
			
			// 클래스 번호 가져오기
			episode.setClassNo(openClass.getClassNo());
			
			// 추가 회차 등록인지 검사용
			int epCount = service.checkEpCount(openClass.getClassNo());
			//System.out.println(epCount);
			
			int result = 0; // 결과용 변수
			
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
			
			if(epCount > 0) {
				// 회차를 추가하는구나~
				
				if(openClass.getClassType() > 0) { // 정규면
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
					
					result = service.insertClassScheduleplus(episode, epsList, epCount);
				}else { // 원데이면
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
					
					result = service.insertOneClassSchedule(episode, epsList, epCount);
				}
				
			}else {
				// 신규 등록 이구나~
				epCount = 1; // 원데이용 회차변수
				
				if(openClass.getClassType() > 0) { // 정규면
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
					
					result = service.insertClassSchedule(episode, epsList);
				}else { // 원데이면
					epCount = 1;
					
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
					
					result = service.insertOneClassSchedule(episode, epsList, epCount);
				}
				
			}
			
			if(result > 0) {
				Util.swalSetMessage("클래스 스케쥴 등록 완료", null, "success", ra);	
				session.removeAttribute("openClass");
				session.removeAttribute("openCount");
			}else {
				Util.swalSetMessage("클래스 스케줄 등록 실패", "관리자에게 문의해주세요", "error", ra);
				session.removeAttribute("openClass");
				session.removeAttribute("openCount");
			}
			
			return "redirect:/";
		}
		
		// 썸머노트 이미지 저장
		@RequestMapping("uploadFile")
		@ResponseBody()
		public String summernote(@RequestParam(value="file", required=false) List<MultipartFile> file,
								HttpSession session) {
			
			//int classNo = (Integer)session.getAttribute("classNo");
			//System.out.println(classNo);
			//System.out.println(file);
			/*
			 * int classNo = (int)session.getAttribute("classNo");
			 * System.out.println(classNo);
			 */
			System.out.println(file);
			
			String webPath = "/resources/images/class/"; // (DB에 저장되는 경로)
		      
		    String serverPath = session.getServletContext().getRealPath(webPath);
		     
		    String fileName = Util.fileRename(file.get(0).getOriginalFilename());
		    
		    try {
				file.get(0)
				.transferTo(new File(serverPath + "/" + fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}

		    return fileName;
			
		}
		

}
