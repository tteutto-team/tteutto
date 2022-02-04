package edu.kh.tteutto.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;

import edu.kh.tteutto.member.kakao.KakaoLoginVO;
import edu.kh.tteutto.member.model.service.LoginService;
import edu.kh.tteutto.member.model.vo.Member;
import edu.kh.tteutto.member.naver.NaverLoginVO;

@Controller
@SessionAttributes({ "loginMember" })
@RequestMapping("/member/*")
public class SnsLoginController {

	@Autowired
	NaverLoginVO naverLoginVO;
	
	@Autowired
	KakaoLoginVO kakaoLoginVO;
	
	@Autowired
	private LoginService service;
	
	@Autowired
    private void setNaverLoginVO(NaverLoginVO naverLoginVO) {
        this.naverLoginVO = naverLoginVO;
    }
	
	@Autowired
    private void setKakaoLoginVO(KakaoLoginVO kakaoLoginVO) {
        this.kakaoLoginVO = kakaoLoginVO;
    }
	
	private String apiResult = null;
	
	
	
	// 로그인 화면
	@RequestMapping(value = "snsLogin")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session
			,@RequestParam(value="sns", required = false) String sns) {

		String serverUrl = request.getScheme()+"://"+request.getServerName();
		if(request.getServerPort() != 80) {
			serverUrl = serverUrl + ":" + request.getServerPort();
		}
		if(sns.equals("naver")) {
			
			String naverAuthUrl = naverLoginVO.getAuthorizationUrl(session);
			model.addAttribute("naverAuthUrl", naverAuthUrl);
			// System.out.println(naverAuthUrl);
			return naverAuthUrl;
		}else if(sns.equals("kakao")) {
			String kakaoAuthUrl = kakaoLoginVO.getAuthorizationUrl(session, serverUrl);
			model.addAttribute("kakaoAuthUrl", kakaoAuthUrl);
			// System.out.println(kakaoAuthUrl);
			return kakaoAuthUrl;
		}
		return null;
	}

	// 네이버 로그인 성공시 callback
	@RequestMapping(value = "naverCallback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(Model model, @RequestParam(value = "code", required = false) String code,
                           @RequestParam String state, RedirectAttributes ra,
                           HttpSession session) throws Exception {
        // System.out.println("============== callback ==============");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginVO.getAccessToken(session, code, state);
        // System.out.println("[AccessToken : " + oauthToken.getAccessToken() + "]");
        // System.out.println("[RefreshToken : " + oauthToken.getRefreshToken() + "]");

        // naverLoginBO.getNaverAccessToken(session, code, state);

        apiResult = naverLoginVO.getUserProfile(oauthToken);
        
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(apiResult);
        
        JSONObject jsonObj = (JSONObject) obj;
        // System.out.println("jsonObj : " + jsonObj);

        JSONObject response_obj = (JSONObject) jsonObj.get("response");
        
        String email = (String) response_obj.get("email");
        // System.out.println("email : " + email);
        
        Member loginMember = service.snsLogin(email);
        int flag;
        if(loginMember != null) {
        	// 세션에 추가
        	model.addAttribute("loginMember", loginMember);
            flag = 1;
        }else {
        	ra.addFlashAttribute("message", "회원등록을 먼저 등록해주세요.");
        	session.setAttribute("email", email);
        	flag = 0;
        }
        model.addAttribute("flag", flag);
        return "member/callback";
    }
	
	@RequestMapping(value="signup2", method = RequestMethod.GET)
	public String signUp() {
		return "member/signup2";
	}
	
	// 회원가입
	@RequestMapping(value = "signup2", method = RequestMethod.POST)
	public String signUp(Member member, RedirectAttributes ra,
			HttpSession session) {
		
		String email = (String) session.getAttribute("email");
		//System.out.println(email);
		member.setMemberEmail(email);
		int result = service.signUp2(member);

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

	
	// 카카오 로그인 성공시 callback
	 // 카카오 로그인 성공시 callback
    @RequestMapping(value = "kakaoCallback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(HttpServletRequest request, HttpServletResponse response, Model model,
                                            @RequestParam(value = "code", required = false) String code,
                                            @RequestParam(value = "state", required = false) String state, HttpSession session) throws Exception {

        String serverUrl = request.getScheme() + "://" + request.getServerName();
        if (request.getServerPort() != 80) {
            serverUrl = serverUrl + ":" + request.getServerPort();
        }

        OAuth2AccessToken oauthToken;
        oauthToken = kakaoLoginVO.getAccessToken(session, code, state, serverUrl);
        if (oauthToken == null) {
            model.addAttribute("msg", "카카오 로그인 access 토큰 발급 오류 입니다.");
            model.addAttribute("url", "/");
            return "/common/redirect";
        }

        System.out.println("AccessToken : " + oauthToken.getAccessToken());
        System.out.println("RefreshToken : " + oauthToken.getRefreshToken());

        // 로그인 사용자 정보를 읽어온다
        String apiResult = kakaoLoginVO.getUserProfile(oauthToken, serverUrl);
        System.out.println("apiResult : " + apiResult.toString());

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(apiResult);
        JSONObject jsonObj = (JSONObject) obj;
        System.out.println("jsonObj : " + jsonObj);

        JSONObject response_obj = (JSONObject) jsonObj.get("kakao_account");
        System.out.println("response_obj : " + response_obj);

        // 프로필 조회
        String email = (String) response_obj.get("email");
        String gender = (String) response_obj.get("gender");
        
        System.out.println(email);
        System.out.println(gender);
        
        session.setAttribute("islogin_r", "Y");
        session.setAttribute("email", email);
        session.setAttribute("gender", gender);

        
        return "member/callback";
    }
}
