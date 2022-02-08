package edu.kh.tteutto.member.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.tteutto.chat.model.vo.ChatRoom;
import edu.kh.tteutto.classRoom.model.vo.ClassRefund;
import edu.kh.tteutto.classRoom.model.vo.ClassRegister;
import edu.kh.tteutto.classRoom.model.vo.ClassReport;
import edu.kh.tteutto.classRoom.model.vo.ClassReview;
import edu.kh.tteutto.classRoom.model.vo.Teacher;
import edu.kh.tteutto.common.Util;
import edu.kh.tteutto.main.model.vo.ClassList;
import edu.kh.tteutto.main.model.vo.Pagination;
import edu.kh.tteutto.member.model.service.MemberService;
import edu.kh.tteutto.member.model.service.WishService;
import edu.kh.tteutto.member.model.vo.Career;
import edu.kh.tteutto.member.model.vo.Certified;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.member.model.vo.Sns;

@Controller
@SessionAttributes({ "loginMember" })

@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService service;

	@Autowired
	private JavaMailSender mailSender;
	
	
	// 회원가입 페이지 이동
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signUp() {
		return "member/signup";
	}
	

	// 이메일 중복 검사
	@RequestMapping("emailDupCheck")
	@ResponseBody
	public int emailDupCheck(String inputEmail) {
		return service.emailDupCheck(inputEmail);
	}

	// 이메일 인증 번호
	@RequestMapping("sendMail")
	@ResponseBody
	public void sendMailTest(String inputEmail) {

		String temp = "";

		// 인증 번호 생성기
		Random rnd = new Random();
		for (int i = 0; i < 8; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp += (char) ((int) (rnd.nextInt(26)) + 97);
				break;
			case 1:
				// A-Z
				temp += (char) ((int) (rnd.nextInt(26)) + 65);
				break;
			case 2:
				// 0-9
				temp += (rnd.nextInt(10));
				break;
			}
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("inputEmail", inputEmail);
		map.put("temp", temp);

		int result2 = service.emailDupCheck2(inputEmail);
		int result = 0;
		
		if (result2 == 0) {
			result = service.sendMailTest(map);
		}else {
			result =service.updateMailTest(map);
		}
		if (result == 1) {
			String subject = "뜨또 회원가입 인증 이메일 입니다.";
			String content = "뜨또 홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 "
					+ "<span style='color : #BF5846; font-weight:bold; font-size: 18px;'>" + temp + "</span>" + " 입니다." + "<br><br>"
					+ "해당 인증번호를 인증번호 입력칸에 입력해 주세요.";
			String from = "sseungjoon0319@gmail.com";
			String to = inputEmail;
			try {
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
				// true는 멀티파트 메세지를 사용하겠다는 의미

				/*
				 * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 MimeMessageHelper mailHelper = new
				 * MimeMessageHelper(mail,"UTF-8");
				 */

				// mailHelper.setFrom(from);
				// 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
				// 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
				mailHelper.setFrom("뜨또 <sseungjoon0319@gmail.com>");
				mailHelper.setTo(to);
				mailHelper.setSubject(subject);
				mailHelper.setText(content, true);
				// true는 html을 사용하겠다는 의미입니다.

				/*
				 * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
				 */

				mailSender.send(mail);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	// 이메일 인증번호 확인
	@ResponseBody
	@RequestMapping("checkCert")
	public int checkCert(String inputCertify, String inputEmail) {
		
		System.out.println(inputCertify + " / " +inputEmail);
		Map<String, String> map = new HashMap<String, String>();
		map.put("inputEmail", inputEmail);
		map.put("inputCertify", inputCertify);
		
		int result = service.checkCert(map);
		
		return result;
	}

	// 회원가입
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signUp(Member member, RedirectAttributes ra) {

		int result = service.signUp(member);

		String title;
		String text;
		String icon;

		if (result > 0) { // 성공
			title = "회원 가입 성공";
			text = member.getMemberNm() + "님의 회원 가입을 환영합니다.";
			icon = "success"; // success, error, info, warning
		} else { // 실패
			title = "회원 가입 실패";
			text = "관리자에 문의해주세요";
			icon = "error"; // success, error, info, warning
		}

		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("text", text);
		ra.addFlashAttribute("icon", icon);

		return "redirect:/";
	}

	// 로그인 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	// 로그인
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Member member, Model model, RedirectAttributes ra,
			@RequestParam(value = "save", required = false) String save, HttpServletRequest req,
			HttpServletResponse resp) {

		Member loginMember = service.login(member);

		if (loginMember != null) {
			model.addAttribute("loginMember", loginMember);

			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());

			if (save != null) {
				cookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				cookie.setMaxAge(0);
			}
			cookie.setPath(req.getContextPath());
			resp.addCookie(cookie);
			return "redirect:/";
		} else {
			String title = "로그인 실패";
			String text = "아이디, 비밀번호를 확인해주세요.";
			String icon = "error"; // success, error, info, warning
			
			ra.addFlashAttribute("title", title);
			ra.addFlashAttribute("text", text);
			ra.addFlashAttribute("icon", icon);
			return "redirect:/member/login";
		}
		
	}

	// 로그아웃
	@RequestMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete();

		return "redirect:/";
	}

	// 비밀번호 찾기 페이지 이동
	@RequestMapping(value = "findPw", method = RequestMethod.GET)
	public String findPw() {
		return "member/findPw";
	}

	// 비밀번호 찾기 링크 보내기
	@RequestMapping("sendEmail")
	@ResponseBody
	public int sendEmail(String inputEmail, RedirectAttributes ra) {
		String temp = "";
		// 인증 번호 생성기
		Random rnd = new Random();
		for (int i = 0; i < 8; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp += (char) ((int) (rnd.nextInt(26)) + 97);
				break;
			case 1:
				// A-Z
				temp += (char) ((int) (rnd.nextInt(26)) + 65);
				break;
			case 2:
				// 0-9
				temp += (rnd.nextInt(10));
				break;
			}
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("inputEmail", inputEmail);
		map.put("temp", temp);

		
		int result =service.updateMailTest(map);
		String url = "http://localhost:8080/tteutto/member/changePw?memberEmail=" +inputEmail+"&certCd="+ temp;
		if (result == 1) {
			String subject = "뜨또 비밀번호 찾기 입니다.";
			String content = 
				"<div style='width: 500px; border: 1px solid #ddd; border-radius: 5px; padding: 30px;\'>" +
				"<h1>뜨또</h1>"+
				"<div style='margin: 20px 0; display: flex;'>"+
				"<div>"+
				"<p>비밀번호 변경 안내</p>"+
				"<p style='color: #989696; font-size: 14px;'>안녕하세요 회원님!</p>"+
				"</div>"+
				"<div style='margin-left: 15px;'>"+
				"<img src='https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61eac6a1f7ea86892aac80df/download/TTEUTTO_ver.4_(favicon).png' style='height: 40px;'>"+
				"</div>"+
				"</div>"+
				"<div style='background-color: rgb(255, 250, 218); padding: 10px;'>"+
				"<h4>꼭 확인해주세요!</h4>"+
				"<p style='margin:5px 0; font-size: 13px;'>- 아래 링크를 통해 비밀번호를 변경해주세요.</p>"+
				"<p style='margin:5px 0; font-size: 13px;'>- 아래 링크는 비밀번호 찾기를 신청 한 후 6시간이 지나면 소멸됩니다.</p>"+
				"<p style='margin:5px 0; font-size: 13px;'>- 만일 본인이 신청하지 않았다면 help@tteutto.com으로 문의 해주세요</p>"+
				"</div>"+      
				"<a  href="+url+" style='margin-top: 20px; display:block; background-color: #FFDF3E; border:0; font-size: 16px; cursor: pointer; text-decoration:none; color:black; text-align:center; padding:10px'>비밀번호 변경</a>"+
				"</div>";
			String from = "sseungjoon0319@gmail.com";
			String to = inputEmail;
			try {
				MimeMessage mail = mailSender.createMimeMessage();
				MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
				// true는 멀티파트 메세지를 사용하겠다는 의미

				/*
				 * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 MimeMessageHelper mailHelper = new
				 * MimeMessageHelper(mail,"UTF-8");
				 */

				// mailHelper.setFrom(from);
				// 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
				// 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
				mailHelper.setFrom("뜨또 <sseungjoon0319@gmail.com>");
				mailHelper.setTo(to);
				mailHelper.setSubject(subject);
				mailHelper.setText(content, true);
				// true는 html을 사용하겠다는 의미입니다.

				/*
				 * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
				 */
				mailSender.send(mail);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 비밀번호 변경
	@RequestMapping(value= "changePw", method=RequestMethod.GET)
	public String changePw() {
		return "member/changePw";
	}
	
	// 비밀번호 변경
	@RequestMapping(value="changePw", method=RequestMethod.POST)
	public String changePw(Member member, Certified certified, RedirectAttributes ra) {
		
		int result = service.changeConfirm(certified);
		String title = "";
		String text = "";
		String icon = "";
		String path = "";
		
		String temp = "";
		// 인증 번호 생성기
		Random rnd = new Random();
		for (int i = 0; i < 8; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp += (char) ((int) (rnd.nextInt(26)) + 97);
				break;
			case 1:
				// A-Z
				temp += (char) ((int) (rnd.nextInt(26)) + 65);
				break;
			case 2:
				// 0-9
				temp += (rnd.nextInt(10));
				break;
			}
		}

		
		if(result == 1) {
			int result2 = service.changePw(member);
			
			if(result2 == 1) { // 성공
				title = "비밀번호 변경 성공";
				text = "다시 로그인 해주세요.";
				icon = "success"; 
				path = "redirect:/member/login";
				
				certified.setCertCd(temp);
				int result3 = service.updateCert(certified);
				
			} else { // 실패
				title = "비밀번호 변경 실패";
				text = "관리자에 문의해주세요";
				icon = "error";
				path = "redirect:/";
			}
		
		}else {
			title = "비밀번호 변경 실패";
			text = "관리자에 문의해주세요";
			icon = "error";
			path = "redirect:/";
		}
		
		
		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("icon", icon);
		
		return path;
	}
	
	
	// 학생 마이페이지 클래스 목록 이동
	@RequestMapping(value = "studentClassList", method = RequestMethod.GET)
	public String studentClassList(@RequestParam(value="cp", required=false, defaultValue="1") int cp,
								   @ModelAttribute("loginMember") Member loginMember, Model model) {
		
		int memberNo = loginMember.getMemberNo();
		
		//Pagination pagination = null;
		
		//pagination = service.getPagination(cp);
		
		List<ClassRegister> register = service.studentClassList(memberNo);
		
		model.addAttribute("register", register);
		
		return "member/studentClassList";
	}

	// 학생 마이페이지 후기 목록 이동
	@RequestMapping(value = "studentCommentList", method = RequestMethod.GET)
	public String studentCommentList(@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			   						 @ModelAttribute("loginMember") Member loginMember,
			   						 Model model) {
		//Pagination pagination = null;
		
		int memberNo = loginMember.getMemberNo();
		
		List<ClassReview> review = service.studentCommentList(memberNo);
		
		model.addAttribute("review", review);
		
		return "member/studentCommentList";
	}

	// 찜한 클래스
	@RequestMapping("studentWishList")
	public String studentWishList(Model model, 
			@ModelAttribute("loginMember") Member loginMember, 
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		 
		int memberNo = loginMember.getMemberNo();
		
		Pagination pagination = null;
		List<ClassList> wishList = null;
		
		pagination = service.getPagination(memberNo, page);
		pagination.setLimit(9);
		pagination.setPageSize(5);
		
		wishList = service.selectWishList(pagination, memberNo);
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("wishList", wishList);
		
		return "member/studentWishList";
	}

	// 학생 프로필 페이지 이동
	@RequestMapping(value = "studentProfile", method = RequestMethod.GET)
	public String studentProfile(@ModelAttribute("loginMember") Member loginMember, Model model) {
		
		System.out.println("로그인 한 회원정보 : "+ loginMember.getMemberImg());
		
		String brith = loginMember.getMemberBirth().substring(0, 10);
		String[] brithArray = brith.split("-");
		
		model.addAttribute("brithArray", brithArray);
		model.addAttribute("loginMember", loginMember);
		
		return "member/studentProfile";
	}
	
	// 학생 프로필 수정
	@RequestMapping(value = "studentProfileUpdate", method = RequestMethod.POST)
	public String studentProfileUpdate(@ModelAttribute("loginMember") Member loginMember, String name, String phone,
										HttpSession session, RedirectAttributes ra, Model model, 
										@RequestParam(value="profileImg", required=false, defaultValue="0") MultipartFile image/*업로드 파일*/) {
		
		Member member = new Member();
		member.setMemberNo(loginMember.getMemberNo());
		member.setMemberNm(name);
		member.setMemberPno(phone);
		
		if(image.getSize() != 0) {
			// 웹 접근 경로(webPath), 서버 저장 경로(serverPath)
			String webPath = "/resources/images/profile/"; // (DB에 저장되는 경로)
			String serverPath = session.getServletContext().getRealPath(webPath);
			member.setMemberImg(Util.fileRename( image.getOriginalFilename() )); // 변경된 파일명
			
			try {
				image.transferTo(new File(serverPath + "/" + member.getMemberImg()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int result = service.studentProfileUpdate(member);
		
		if(result > 0 ) {	// 성공
			loginMember.setMemberNm(name);
			loginMember.setMemberPno(phone);
			loginMember.setMemberImg(member.getMemberImg());
			return "redirect:studentProfile";
		} else { // 실패
			return "redirect:studentProfile";
		}
	}
	
	// 회원 탈퇴
	@RequestMapping(value = "resign", method = RequestMethod.GET)
	public String memberResign( @ModelAttribute("loginMember") Member loginMember, RedirectAttributes ra, SessionStatus status) {
		
		int memberNo = loginMember.getMemberNo();
//		int memberNo = 3;

		String path = null;
		
		int result = service.memberResign(memberNo);
		
		if(result > 0) {
			status.setComplete();	// 세션 만료
			Util.swalSetMessage("탈퇴가 되었습니다.", "그동안 뜨또를 사랑해주셔서 감사합니다.", "success", ra);
			path="/";
		} else if(result == -1) {
			Util.swalSetMessage("탈퇴 실패", "수강 중이거나 수강예정인 강의가 있습니다. 관리자에게 문의해주세요.", "error", ra);
			path = "resign";
		} else {
		Util.swalSetMessage("탈퇴 실패", "관리자에게 문의해주세요.", "error", ra);
		path = "resign";
		}
		
		return "redirect:" + path;
	}

	// 강사 프로필 페이지 이동
	@RequestMapping(value = "teacherProfile", method = RequestMethod.GET)
	public String teacherProfile(/* @ModelAttribute("loginMember") Member loginMember, */ Model model) {

//		int memberNo = loginMember.getMemberNo();
		int memberNo = 3;

		Teacher teacher = service.selectTeacherProfile(memberNo);
		List<Career> careerList = service.selectTeacherCareer(memberNo);
		List<Sns> snsList = service.selectTeacherSns(memberNo);
		
		System.out.println("careerList : "+ careerList);
		
		List<Integer> snsDivList = new ArrayList<Integer>();
		snsDivList.add(1);
		snsDivList.add(2);
		snsDivList.add(3);
		
		for(int i=0; i < snsList.size(); i++) {
			
			if(snsList.get(i).getSnsDiv() == (Integer)1) {
				snsDivList.remove(snsDivList.indexOf(1));
			}
			
			if(snsList.get(i).getSnsDiv() == (Integer)2) {
				snsDivList.remove(snsDivList.indexOf(2));
			}
			
			if(snsList.get(i).getSnsDiv() == (Integer)3) {
				snsDivList.remove(snsDivList.indexOf(3));
			}
		}
		
		model.addAttribute("snsDivList", snsDivList);
		model.addAttribute("snsList", snsList);
		model.addAttribute("careerList", careerList);
		model.addAttribute("teacher", teacher);

		return "member/teacherProfile";
	}
	
	// 강사 프로필 업데이트
	@RequestMapping(value = "teacherProfileUpdate", method = RequestMethod.POST)
	public String teacherProfileUpdate( @ModelAttribute("loginMember") Member loginMember,
										String phone, String introduce, @RequestParam(value = "profileInput", required=false, defaultValue="0") List<String> profileInput,
										String instagram, String blog, String youtube, HttpSession session,
										@RequestParam(value="profileImg", required=false, defaultValue="0") List<MultipartFile> images/*업로드 파일*/,
										RedirectAttributes ra) {
		
		int memberNo = loginMember.getMemberNo();
//		int memberNo = 3;
		
		List<Sns> snsList = new ArrayList<Sns>();
		
		if(!instagram.equals("")) {
			Sns sns = new Sns();
			sns.setMemberNo(memberNo);
			sns.setSnsLink(instagram);
			sns.setSnsDiv(1);
			snsList.add(sns);
		}
		if(!blog.equals("")) {
			Sns sns = new Sns();
			sns.setMemberNo(memberNo);
			sns.setSnsLink(blog);
			sns.setSnsDiv(2);
			snsList.add(sns);
		}
		if(!youtube.equals("")) {
			Sns sns = new Sns();
			sns.setMemberNo(memberNo);
			sns.setSnsLink(youtube);
			sns.setSnsDiv(3);
			snsList.add(sns);
		}
		
		Teacher teacher = new Teacher();
		teacher.setMemberNo(memberNo);
		teacher.setTeacherIntro(introduce);
		
		
		// 이력을 수정하지 않았을 경우
		for(int i = 0; i < profileInput.size(); i++) {
			if(profileInput.get(0).equals("0")) {
				profileInput.remove(i);
			}
		}
		
		// 웹 접근 경로(webPath), 서버 저장 경로(serverPath)
		String webPath = "/resources/images/teacher/profile/"; // (DB에 저장되는 경로)
		String serverPath = session.getServletContext().getRealPath(webPath);
		
		int result = 0;
		
		// 이력을 수정하지 않았을 경우
		if(profileInput.size() == 0) {
			result = service.teacherProfileUpdate2(teacher, phone, snsList);
		} else {	// 이력을 수정했을 경우
			result = service.teacherProfileUpdate(teacher, phone, snsList, profileInput, images, webPath, serverPath);
		}
		
		if(result > 0) {
			return "redirect:teacherProfile";
		} else {	// 에러일 경우
			return "redirect:teacherProfile";
		}
	}
	
	// 강사 이력 삭제
	@RequestMapping(value = "teacherProfiledelete", method = RequestMethod.POST)
	@ResponseBody
	public int teacherProfiledelete(HttpSession session, String id) {
		
		// 웹 접근 경로(webPath), 서버 저장 경로(serverPath)
		String webPath = "/resources/images/teacher/profile/"; // (DB에 저장되는 경로)
		String serverPath = session.getServletContext().getRealPath(webPath);
		
		int result = service.teacherProfiledelete(id, webPath, serverPath);
		
		if(result > 0) {
			
		}
		
		return result;
	}
	
	
	// 강사 신청 페이지 이동
	@RequestMapping(value = "teacherRegister", method = RequestMethod.GET)
	public String teacherRegister(HttpSession session) {
		if(session.getAttribute("loginMember") != null) {
			return "member/teacherRegister";			
		}else {
			return "member/login";
		}
	}
	
	// 강사 신청
	@RequestMapping(value = "teacherRegister", method=RequestMethod.POST)
	public String teacherRegisterInsert(RedirectAttributes ra, @ModelAttribute("loginMember") Member loginMember, 
										Teacher teacher, String instagram, String blog, String youtube, String careerContent,
										MultipartFile image, List<MultipartFile> images, HttpSession session) {
		
		// 로그인 맴버 가져오기
		teacher.setMemberNo(loginMember.getMemberNo());
		
		// 웹 접근 경로(webPath), 서버 저장 경로(serverPath)
		// 프로필 이미지 저장 경로
		String webPath = "/resources/images/teacher/profile/"; // DB에 저장되는 경로
		String serverPath = session.getServletContext().getRealPath(webPath);
		
		// 캐리어 이미지 저장 경로
		String webPath2 = "/resources/images/teacher/career/";
		String serverPath2 = session.getServletContext().getRealPath(webPath2);
		
		// SNS 리스트 생성 
		List<Sns> snsList = new ArrayList<Sns>();
		
		if(instagram.length() != 0) {
			Sns sns = new Sns();
			sns.setSnsLink(instagram);
			sns.setSnsDiv(0);
			snsList.add(sns);
		}
		if(blog.length() != 0) {
			Sns sns = new Sns();
			sns.setSnsLink(blog);
			sns.setSnsDiv(1);
			snsList.add(sns);
		}
		if(youtube.length() != 0) {
			Sns sns = new Sns();
			sns.setSnsLink(youtube);
			sns.setSnsDiv(2);
			snsList.add(sns);
		}
		

		
		int result = service.teacherRegisterInsert(teacher, images, image, careerContent, snsList, serverPath, serverPath2 );
		
		if(result > 0) {
			Util.swalSetMessage("강사 신청 완료", "관리자 승인을 기다려주세요.", "success", ra);			
			return "redirect:/";
		}else {
			Util.swalSetMessage("강사 신청 실패", "관리자에게 문의해주세요.", "error", ra);			
			return "redirect:/";
		}
		
		
	}
	
	// 지도 지역 불러오기 
	@GetMapping("classLocation")
	@ResponseBody()
	public String classLocation() {
		
		return null;
	}
	
	// 내 클래스 목록에서 후기 작성
	@RequestMapping("insertComment")
	public String insertComment(ClassReview classReview, RedirectAttributes ra) {
		
		int result = service.insertComment(classReview);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "후기 작성이 완료되었습니다.");			
		}
		
		return "redirect:/member/studentClassList";
	}
	
	// 내 클래스 목록에서 신고 작성
	@RequestMapping("insertReport")
	public String insertReport(ClassReport classReport, RedirectAttributes ra) {
		
		int result = service.insertReport(classReport);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "신고가 정상적으로 접수되었습니다.");			
		}
		
		return "redirect:/member/studentClassList";
	}
	
	// 학생 후기 수정
	@RequestMapping("updateComment")
	public String updateComment(ClassReview classReview, RedirectAttributes ra) { 
		
		int result = service.updateReport(classReview);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "후기 수정이 완료되었습니다.");			
		}
		
		return "redirect:/member/studentCommentList";
	}
	
	// 학생 - 강사 채팅방 생성
	@RequestMapping("insertChatRoom")
	public String insertChatRoom(@ModelAttribute("loginMember") Member loginMember, ChatRoom chatRoom) {
		
		chatRoom.setMemberNo(loginMember.getMemberNo());
	
		int check = service.checkChatRoom(chatRoom);
		
		if(check == 0) {
			int result = service.insertChatRoom(chatRoom);			
		}
		
		return "redirect:/member/studentClassList";
	}
	
	// 클래스 환불 신청
	@RequestMapping("refundClass")
	public String refundClass(ClassRefund refund, RedirectAttributes ra) {

		int result = service.refundClass(refund);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "환불 신청이 완료되었습니다.");			
		}
		
		return "redirect:/member/studentClassList";
	}
	
	// 학생 후기 삭제
	@RequestMapping("deleteReview")
	public String deleteReview(int reviewNo, RedirectAttributes ra) {

		int result = service.deleteReview(reviewNo);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "후기가 삭제되었습니다.");			
		}
		
		return "redirect:/member/studentClassList";
	}
	
	
}
