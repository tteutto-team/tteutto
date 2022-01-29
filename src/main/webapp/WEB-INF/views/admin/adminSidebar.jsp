<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>뜨또 어드민 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/adminSidebar.css">
	
</head>
<body>
	<aside id="left">
		<div class="logo">
			<img src="${contextPath}/resources/images/favicon/android-icon-144x144.png">
			<span>뜨또 관리자 페이지</span>
		</div>
		<div class="admin-list">
			<div>
				<a href="classManage"><i class="far fa-circle"></i> 회차별 신청 관리</a>
				<a href="#"><i class="far fa-circle"></i> 클래스 신청 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="#"><i class="far fa-circle"></i> 유저 관리</a>
				<a href="#"><i class="far fa-circle"></i> 강사 신청 관리</a>
			</div>
		</div>
	</aside>
</body>
</html>