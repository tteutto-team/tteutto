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
	
	<!-- icon -->
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
    
    <!-- font -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/adminSidebar.css">
	
</head>
<body>
	<%-- <c:if test="${loginMember.memberGrade != 1}">
		<script type="text/javascript">
			location.href="${contextPath}";
		</script>
	</c:if> --%>

	<aside id="left">
		<div class="logo">
			<img src="${contextPath}/resources/images/common/TTEUTTO ver.2.png">
			<p>뜨또 관리자 페이지</p>
		</div>
		<div class="admin-list">
			<div>
				<a href="${contextPath}/admin/classEpisodeManage"><i class="far fa-circle"></i> 회차별 신청 관리</a>
				<a href="${contextPath}/admin/classManage"><i class="far fa-circle"></i> 클래스 신청 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="${contextPath}/admin/userManage"><i class="far fa-circle"></i> 유저 관리</a>
				<a href="${contextPath}/admin/teacherManage"><i class="far fa-circle"></i> 강사 신청 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="${contextPath}/admin/studentReportManage"><i class="far fa-circle"></i> 학생 신고 관리</a>
				<a href="#"><i class="far fa-circle"></i> 클래스 신고 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="${contextPath}/admin/calculateManage"><i class="far fa-circle"></i> 정산 관리</a>
				<a href="${contextPath}/admin/refundManage"><i class="far fa-circle"></i> 환불 관리</a>
			</div>
		</div>
		<div class="admin-list">
			<div>
				<a href="${contextPath}/admin/noticeManage"><i class="far fa-circle"></i> 공지사항</a>
				<a href="${contextPath}/admin/faqManage"><i class="far fa-circle"></i> FAQ</a>
			</div>
		</div>
	</aside>
</body>
<script>
	var lang_kor = {
        "decimal" : "",
        "emptyTable" : "데이터가 없습니다.",
        "info" : "_START_ - _END_ (총 _TOTAL_ 개)",
        "infoEmpty" : "0개",
        "infoFiltered" : "(전체 _MAX_ 개 중 검색결과)",
        "infoPostFix" : "",
        "thousands" : ",",
        "lengthMenu" : "_MENU_ 개씩 보기",
        "loadingRecords" : "로딩중...",
        "processing" : "처리중...",
        "search" : "검색 : ",
        "zeroRecords" : "검색된 데이터가 없습니다.",
        "paginate" : {
            "first" : "첫 페이지",
            "last" : "마지막 페이지",
            "next" : "다음",
            "previous" : "이전"
        },
        "aria" : {
            "sortAscending" : " :  오름차순 정렬",
            "sortDescending" : " :  내림차순 정렬"
        }
    };
</script>

<c:if test="${!empty requestScope.title }">
	<script>
		Swal.fire({
			title : "${title}",
			text : "${text}",
			icon : "${icon}",
			confirmButtonColor: '#3085d6',
			confirmButtonText: '확인',
		})
	</script>
</c:if>
</html>