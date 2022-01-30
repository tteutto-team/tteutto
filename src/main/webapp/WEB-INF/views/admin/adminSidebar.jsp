<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>뜨또 관리자 페이지</title>
	
	<!-- jQuery -->
    <script src="${contextPath}/resources/js/admin/jquery-3.6.0.min.js"></script>
    
    <!-- DataTables -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/datatables.min.css"/>
	<script type="text/javascript" src="${contextPath}/resources/js/admin/datatables.min.js"></script>
    
    <!-- sweetAlert -->
    <script src="${contextPath}/resources/js/admin/sweetalert2.min.js"></script>
	<link rel="stylesheet" href="${contextPath}/resources/css/admin/sweetalert2.min.css">
    
    <!-- font -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/adminSidebar.css">
	
</head>
<body>
	<aside id="left">
		<div class="logo">
			<img src="${contextPath}/resources/images/common/TTEUTTO ver.2.png">
			<p>뜨또 관리자 페이지</p>
		</div>
		<div class="admin-list">
			<div>
				<a href="classEpisodeManage"><i class="far fa-circle"></i> 회차별 신청 관리</a>
				<a href="classManage"><i class="far fa-circle"></i> 클래스 신청 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="#"><i class="far fa-circle"></i> 유저 관리</a>
				<a href="teacherManage"><i class="far fa-circle"></i> 강사 신청 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="#"><i class="far fa-circle"></i> 학생 신고 관리</a>
				<a href="#"><i class="far fa-circle"></i> 클래스 신고 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="#"><i class="far fa-circle"></i> 정산 관리</a>
				<a href="#"><i class="far fa-circle"></i> 환불 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="#"><i class="far fa-circle"></i> 공지사항</a>
				<a href="#"><i class="far fa-circle"></i> FAQ</a>
			</div>
		</div>
	</aside>
</body>
</html>