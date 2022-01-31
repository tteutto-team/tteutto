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
  var naver_id_login = new naver_id_login("d_q2NGPsQeZpTrvq0_S0", "http://localhost:8080/tteutto/");
  // 접근 토큰 값 출력
  
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
 
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    const user_email = naver_id_login.getProfileData('email');
    const name = naver_id_login.getProfileData('name');
    const gender = naver_id_login.getProfileData('gender');
    const birthday = naver_id_login.getProfileData('birthday');
    const birthyear = naver_id_login.getProfileData('birthyear');
    const mobile = naver_id_login.getProfileData('mobile');
    const profile_image = naver_id_login.getProfileData('profile_image');
    
    window.location.href='/tteutto/member/naverLogin?user_email='+user_email;
  }
</script>
</body>
</html>
