<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="apple-touch-icon" sizes="57x57" href="${contextPath}/resources/images/favicon/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="${contextPath}/resources/images/favicon/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="${contextPath}/resources/images/favicon/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="${contextPath}/resources/images/favicon/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="${contextPath}/resources/images/favicon/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="${contextPath}/resources/images/favicon/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="${contextPath}/resources/images/favicon/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="${contextPath}/resources/images/favicon/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="${contextPath}/resources/images/favicon/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="${contextPath}/resources/images/favicon/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="${contextPath}/resources/images/favicon/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="${contextPath}/resources/images/favicon/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="${contextPath}/resources/images/favicon/favicon-16x16.png">
		<link rel="manifest" href="${contextPath}/resources/images/favicon/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="${contextPath}/resources/images/favicon/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
		<title>뜨또 | 뜨겁게 또 시작해보자! 전국의 모든 오프라인 클래스, 뜨또에서 찾아보세요.</title>
		<link rel="stylesheet" href="${contextPath}/resources/css/common.css">
		<link rel="stylesheet" href="${contextPath}/resources/fontello/css/tteutto.css">
	</head>
	
	<body>
		<header>
			<div class="content">
				<div class="main">
					<div class="logo prevent-dragging">
						<a href="#">
						<img src="${contextPath}/resources/images/common/TTEUTTO ver.2.png" alt="뜨또 로고 이미지">
					</a></div>
					
					<div class="search">
						<form action="#" method="get">
							<input type="text" placeholder="듣고 싶은 클래스를 찾아보세요." name="search">
						</form>
					</div>
				</div>
				
				<div class="login">
					<ul>
						<li><a href="#">강사 신청하기</a></li>
						<li><a href="#">로그인</a></li>
					</ul>
				</div>
			</div>
		</header>
	</body>
</html>