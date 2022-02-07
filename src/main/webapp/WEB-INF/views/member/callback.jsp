<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<c:if test="${flag==1}">
	<script>
	location.href="${contextPath}/"
	</script>
</c:if>
<c:if test="${flag==0}">
	<script>
		swal({
			title : "처음 방문하셨습니다",
			text : "추가 정보를 입력해주세요",
			icon : "info"
		}).then(function(){
			window.location.href="signup2";
		});
	</script>
</c:if>
<c:if test="${flag==2}">
	<script>
		swal({
			title : "이미 회원 가입 상태입니다",
			text : "홈페이지 로그인을 이용해주세요",
			icon : "error"
		}).then(function(){
			window.location.href="login"
		});
	</script>
</c:if>
</body>
</html>