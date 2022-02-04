<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<body>
<script type="text/javascript">
  var naver_id_login = new naver_id_login("d_q2NGPsQeZpTrvq0_S0", "http://localhost:8080/tteutto/member/callback");
  
  // 접근 토큰 값 출력
  alert(naver_id_login.oauthParams.access_token);
  
  
  const path2 = "https://nid.naver.com/oauth2.0/token?client_id=d_q2NGPsQeZpTrvq0_S0&client_secret=299N6qv0P8&grant_type=authorization_code&state="+naver_id_login.oauthParams.state+"&code="+naver_id_login.oauthParams.access_token;
  
  // 접근 토큰 삭제
  const path3 = "https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=d_q2NGPsQeZpTrvq0_S0&client_secret=299N6qv0P8&access_token="+naver_id_login.oauthParams.access_token+"&service_provider=NAVER";
  
  // authentication request생성 url
  const path4 = "https://nid.naver.com/oauth2.0/authorize?client_id=d_q2NGPsQeZpTrvq0_S0&response_type=code&redirect_uri=http://localhost:8080/tteutto/member/callback&state="+naver_id_login.oauthParams.state;
 
  
  const code = path4.getParameterByName('code');
  console.log(code);
  // authentication request을 생성 -> code
  //if(code != null){
  	// 접근 토큰 요청
  	//const path5 = "https://nid.naver.com/oauth2.0/token?client_id=d_q2NGPsQeZpTrvq0_S0&client_secret=299N6qv0P8&grant_type=authorization_code&state="+naver_id_login.oauthParams.state+"&code="+code;
  	//location.href = path5;
  //}
  
  
  // 네이버 사용자 프로필 조회
  // naver_id_login.get_naver_userprofile("naverSignInCallback()");
 
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  // function naverSignInCallback() {

  // }
</script>
</body>
</html>
