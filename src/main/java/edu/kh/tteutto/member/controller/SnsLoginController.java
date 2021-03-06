package edu.kh.tteutto.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.github.scribejava.core.model.OAuth2AccessToken;

import edu.kh.tteutto.member.google.GoogleOAuthRequest;
import edu.kh.tteutto.member.google.GoogleOAuthResponse;
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
	
	@Autowired
    private GoogleConnectionFactory googleConnectionFactory;
    @Autowired
    private OAuth2Parameters googleOAuth2Parameters;
	
	
	// ????????? ??????
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
		}else{
			 /* ??????code ?????? */
	        OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	        String googleAuthUrl = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
	        // System.out.println("??????:" + googleAuthUrl);
	        model.addAttribute("google_url", googleAuthUrl);

	        /* ????????? ?????? URL??? View??? ?????? */
	        return googleAuthUrl;
		}
	}

	// ????????? ????????? ????????? callback
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
        // System.out.println(loginMember);
        if(loginMember != null) {
        	// ????????? ??????
        	model.addAttribute("loginMember", loginMember);
            flag = 1;
        }else {
        	
        	int result2 = service.emailCheck(email);
        	// System.out.println(result2);
        	if(result2 != 0) {
        		flag = 2;
        	}else {
        		session.setAttribute("email", email);
        		flag = 0;
        	}
        }
        model.addAttribute("flag", flag);
        return "member/callback";
    }
	
	// ?????? ?????? ??????
	@RequestMapping(value="signup2", method = RequestMethod.GET)
	public String signUp() {
		return "member/signup2";
	}
	
	 // ????????? ????????? ????????? callback
    @RequestMapping(value = "kakaoCallback", method = { RequestMethod.GET, RequestMethod.POST })
    public String callback(HttpServletRequest request, HttpServletResponse response, Model model,
                                            @RequestParam(value = "code", required = false) String code,
                                            @RequestParam(value = "state", required = false) String state, RedirectAttributes ra, HttpSession session) throws Exception {

        String serverUrl = request.getScheme() + "://" + request.getServerName();
        if (request.getServerPort() != 80) {
            serverUrl = serverUrl + ":" + request.getServerPort();
        }

        OAuth2AccessToken oauthToken;
        oauthToken = kakaoLoginVO.getAccessToken(session, code, state, serverUrl);
        if (oauthToken == null) {
            model.addAttribute("msg", "????????? ????????? access ?????? ?????? ?????? ?????????.");
            model.addAttribute("url", "/");
            return "/common/redirect";
        }

        //System.out.println("AccessToken : " + oauthToken.getAccessToken());
        //System.out.println("RefreshToken : " + oauthToken.getRefreshToken());

        // ????????? ????????? ????????? ????????????
        String apiResult = kakaoLoginVO.getUserProfile(oauthToken, serverUrl);
        //System.out.println("apiResult : " + apiResult.toString());

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(apiResult);
        JSONObject jsonObj = (JSONObject) obj;
        //System.out.println("jsonObj : " + jsonObj);

        JSONObject response_obj = (JSONObject) jsonObj.get("kakao_account");
        //System.out.println("response_obj : " + response_obj);

        // ????????? ??????
        String email = (String) response_obj.get("email");
        
        Member loginMember = service.snsLogin(email);
        int flag;
        if(loginMember != null) {
        	// ????????? ??????
        	model.addAttribute("loginMember", loginMember);
            flag = 1;
        }else {
        	
        	int result2 = service.emailCheck(email);
        	// System.out.println(result2);
        	if(result2 != 0) {
        		flag = 2;
        	}else {
        		session.setAttribute("email", email);
        		flag = 0;
        	}
        }
        model.addAttribute("flag", flag);
        return "member/callback";
    }
    
    // ?????? ????????? ?????????
    @RequestMapping(value = "googleCallback", method = { RequestMethod.GET, RequestMethod.POST })
    public String googleAuth(Model model, @RequestParam(value = "code") String authCode, RedirectAttributes ra, HttpServletRequest request, HttpSession session)
            throws Exception {

    	//HTTP Request??? ?????? RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        //Google OAuth Access Token ????????? ?????? ???????????? ??????
        GoogleOAuthRequest googleOAuthRequestParam =  new GoogleOAuthRequest();
        googleOAuthRequestParam.setCode(authCode);
        googleOAuthRequestParam.setClientId("1043401104218-qa40fc4knjg7ru12mje6t95bl4p94vmc.apps.googleusercontent.com");
        googleOAuthRequestParam.setClientSecret("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");
        googleOAuthRequestParam.setRedirectUri("http://localhost:8080/tteutto/member/googleCallback");
        googleOAuthRequestParam.setGrantType("authorization_code");

        //JSON ????????? ?????? ????????? ??????
        //????????? ??????????????? ???????????? ???????????? ??????????????? Object mapper??? ?????? ???????????????.
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //AccessToken ?????? ??????
        ResponseEntity<String> resultEntity = restTemplate.postForEntity("https://www.googleapis.com/oauth2/v4/token", googleOAuthRequestParam, String.class);
        // System.out.println("resultEntity : " + resultEntity);
        //https://oauth2.googleapis.com/token
        // https://accounts.google.com/o/oauth2/token
        // https://www.googleapis.com/oauth2/v4/token

        //Token Request
        GoogleOAuthResponse result = mapper.readValue(resultEntity.getBody(), new TypeReference<GoogleOAuthResponse>() {
        });

        //ID Token??? ?????? (???????????? ????????? jwt??? ????????? ????????????)
        String jwtToken = result.getIdToken();
        String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo").queryParam("id_token", jwtToken).toUriString();

        String resultJson = restTemplate.getForObject(requestUrl, String.class);

        Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
        model.addAllAttributes(userInfo);
        model.addAttribute("token", result.getAccessToken());

        // System.out.println("userInfo : " + userInfo);
        // System.out.println("AccessToken : " + result.getAccessToken());
        // System.out.println("code : " + googleOAuthRequestParam.getCode());
        // System.out.println("AccessType : " + googleOAuthRequestParam.getAccessType());
        // System.out.println("GrantType : " + googleOAuthRequestParam.getGrantType());
        // System.out.println("refreshToken : " + result.getRefreshToken());
        // refreshToken ????????? ????????? access?????? ???????????????
        // https://developers.google.com/identity/gsi/web/guides/revoke
        
        String email = userInfo.get("email");
        // System.out.println(email);
        Member loginMember = service.snsLogin(email);
        int flag;
        if(loginMember != null) {
        	// ????????? ??????
        	model.addAttribute("loginMember", loginMember);
            flag = 1;
        }else {
        	
        	int result2 = service.emailCheck(email);
        	// System.out.println(result2);
        	if(result2 != 0) {
        		flag = 2;
        	}else {
        		session.setAttribute("email", email);
        		flag = 0;
        	}
        }
        model.addAttribute("flag", flag);
        return "member/callback";
    }
    
	
	// ????????????
	@RequestMapping(value = "signup2", method = RequestMethod.POST)
	public String signUp(Member member, RedirectAttributes ra,
			HttpSession session) {
		
		String email = (String) session.getAttribute("email");
		member.setMemberEmail(email);
		int result = service.signUp2(member);

		String title;
		String text;
		String icon;

		if (result > 0) { // ??????
			title = "?????? ?????? ??????";
			text = member.getMemberNm() + "?????? ?????? ????????? ???????????????.";
			icon = "success"; // success, error, info, warning
		} else { // ??????
			title = "?????? ?????? ??????";
			text = "???????????? ??????????????????";
			icon = "error"; // success, error, info, warning
		}

		ra.addFlashAttribute("title", title);
		ra.addFlashAttribute("text", text);
		ra.addFlashAttribute("icon", icon);

		return "redirect:/";
	}
}
