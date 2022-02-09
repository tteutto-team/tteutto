package edu.kh.tteutto.classRoom.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import edu.kh.tteutto.classRoom.model.service.TeacherService;
import edu.kh.tteutto.classRoom.model.vo.ClassDetail;
import edu.kh.tteutto.classRoom.model.vo.EpisodeClass;
import edu.kh.tteutto.classRoom.model.vo.OngingClass;
import edu.kh.tteutto.classRoom.model.vo.Receipt;
import edu.kh.tteutto.member.model.vo.Member;

@Controller
@RequestMapping("/teacher/*")
public class ClassRoomController {
	
	@Autowired
	private TeacherService service;
	
	// 클래스 목록
	@RequestMapping(value = "classList/{memNo}", method = RequestMethod.GET)
	public String classList(@ModelAttribute("loginMember") Member loginMember, Model model, @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo, @PathVariable("memNo") int memNo) {
		
//		int memberNo = loginMember.getMemberNo();
		int memberNo = 3;

		// 클래스 목록 조회
		List<ClassDetail> classList = service.selectClassList(memberNo);
		// 에피소드 조회(클래스 회차 조회)
		List<EpisodeClass> episodeList = service.selectClassEpisode(memberNo);
		
		for(int i=0; i < episodeList.size(); i++) {
			
			// 날짜
			String getStartDate = episodeList.get(i).getStartDate().substring(2);
			String getEndDate = episodeList.get(i).getEndDate().substring(2);
			getStartDate = getStartDate.substring(0,2) + "/" + getStartDate.substring(2,4) + "/" + getStartDate.substring(4);
			getEndDate = getEndDate.substring(0,2) + "/" + getEndDate.substring(2,4) + "/" + getEndDate.substring(4);
			String date1 = getStartDate + " ~ " + getEndDate;
			
			episodeList.get(i).setDate(date1);
			
			// 정산 여부 설정
			
			// 오늘날짜 yyyyMMdd로 생성
			String todayfm = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
			 
			// yyyyMMdd 포맷 설정
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			 
			// 비교할 date와 today를데이터 포맷으로 변경
			Date startDate;
			Date endDate;
			Date today;
			
			try {
				startDate = new Date(dateFormat.parse(episodeList.get(i).getStartDate()).getTime());
				endDate = new Date(dateFormat.parse(episodeList.get(i).getEndDate()).getTime());
				today = new Date(dateFormat.parse(todayfm).getTime());

				// compareTo메서드를 통한 날짜비교 (비교 날짜 - 오늘)
				int startCompare = startDate.compareTo(today); 
				int endCompare = endDate.compareTo(today); 
				
				if(endCompare > 0) {	// 수업이 아직 안끝났을 경우 (현재 날짜 < 끝 날짜)
					episodeList.get(i).setCalStatus(-2);	// 정산 신청 버튼 X
					
				}
				
				// 수업이 끝났을 경우 && 미정산인 경우
				else if(endCompare <= 0 && episodeList.get(i).getCalStatus() == -1 ) {
					// 현재 날짜 > 끝 날짜 
					episodeList.get(i).setCalStatus(-1);	// 정산 신청 버튼 나오게 해야함
				} 
				
				else if(episodeList.get(i).getCalStatus() == 1) {	
					episodeList.get(i).setCalStatus(1);
				}
				
				else if(episodeList.get(i).getCalStatus() == 0) {
					episodeList.get(i).setCalStatus(0);
				}
				
				// 진행 중인 경우 => start - 오늘 ; startCompare <= 0 && end - 오늘; endCompare >= 0
				if(startCompare <= 0 && endCompare >= 0) {
					episodeList.get(i).setStudyStatus("0");
				} 
				
				// 진행 예정인 경우 => start - 오늘;  startCompare > 0 &&  end - 오늘; endCompare >= 0
				else if(startCompare > 0 && endCompare > 0) {
					episodeList.get(i).setStudyStatus("1");
				}
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			} 
		}
		
		model.addAttribute("loginMember", loginMember);
		model.addAttribute("classList", classList);
		model.addAttribute("episodeList", episodeList);
		
		return "class/teacherClassList";
	}
	
	
	// 영수증 ajax
	@ResponseBody
	@RequestMapping(value = "receipt", method=RequestMethod.POST)
	public String receipt(String epNo) {
		
		List<Receipt> receiptList = service.selectReceipt(epNo);
		
		Gson gson = new Gson();
		String result = gson.toJson(receiptList);
		
		return result;
	}
	
	// 클래스 삭제 가능 여부 조회 ajax
	@ResponseBody
	@RequestMapping(value = "selectDeletClass", method = RequestMethod.POST)
	public int selectDeletClass(String epNo) {
		
		int result = service.selectDeleteClass(epNo);
		
		return result;
	}
	
	// 클래스 삭제 ajax
	@ResponseBody
	@RequestMapping(value = "deletClass", method = RequestMethod.POST)
	public int deletClass(String epNo) {
		
		int result = service.deletClass(epNo);
		
		return result;
	}
	
	
	// 학생 관리(수강 예정)
	@RequestMapping(value="studentListExpect", method=RequestMethod.POST)
	public String studentListExpect(String epNo, Model model,RedirectAttributes ra) {
		
		
		return "class/teacherStudentListExpect";
	}
	
	// 학생 관리(진행 중)
	@RequestMapping(value="studentListOngoing", method=RequestMethod.POST)
	public String studentListOngoing(int epNo, Model model) {

		List<OngingClass> ongoingClassList = service.selectOngoingClass(epNo);
		
		for(OngingClass c : ongoingClassList) {
			
			if(c.getMemberGender() != null && c.getMemberGender().equals("M") ) {
				c.setMemberGender("남자");
			} else if(c.getMemberGender() != null && c.getMemberGender().equals("W")) {
				c.setMemberGender("여자");
			}
			
		}
		model.addAttribute("epNo", epNo);
		model.addAttribute("ongoingClassList", ongoingClassList);
		
		return "class/teacherStudentListOngoing";
	}
	
	
	// 학생 관리(진행 중) - 신고
	@ResponseBody
	@RequestMapping(value="reportStudent", method=RequestMethod.POST)
	public int reportStudent(String epNo, String memberNo, String reportText) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("epNo", epNo);
		map.put("memberNo", memberNo);
		map.put("reportText", reportText);
		
		int result = service.reportStudent(map);
		
		return result;
	}
	
	// 정산 신청
	@ResponseBody
	@RequestMapping(value="calculate", method=RequestMethod.POST)
	public int calculate(String epNo) {
		
		int result = service.calculate(epNo);
		
		System.out.println("result " + result);
		return result;
	}
	
	// 클래스 신청 - 기존 클래스 목록 조회
	@ResponseBody
	@RequestMapping(value="ExistingClassList", method=RequestMethod.POST)
	public String ExistingClassList(@ModelAttribute("loginMember") Member loginMember ) {
		
		
		
//		List<ClassDetail> classList= service.existingClassList(loginMember.getMemberNo());
		List<ClassDetail> classList= service.existingClassList(4);
		
		Gson gson = new Gson();
		String rList = gson.toJson(classList);
		
		System.out.println("rList " + rList);
		return rList;
	}
	
	

	
}
