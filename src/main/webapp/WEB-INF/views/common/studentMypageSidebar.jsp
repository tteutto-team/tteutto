<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${contextPath}/resources/css/studentMypageSidebar.css" />


<div class="left">
    <div class="box">
    	<c:if test="${empty loginMember.memberImg}">
	        <img src="${contextPath}/resources/images/profile/temp.png">
    	</c:if>
    	<c:if test="${!empty loginMember.memberImg}">
	        <img src="${contextPath}/resources/images/profile/${loginMember.memberImg}">
    	</c:if>
    </div>
    <div class="name">${loginMember.memberNm}</div>
    <div class="introduce">뜨또에 오신걸 환영합니다.</div>

    <div class="list">
        <div onclick="location.href='studentProfile'">학생 프로필</div>
        <div onclick="location.href='studentClassList'">클래스 목록</div>
        <div onclick="location.href='studentCommentList'">후기 목록</div>
        <div onclick="location.href='studentWishList'">찜한 클래스</div>
    </div>
</div>