<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${contextPath}/resources/css/studentMypageSidebar.css" />


<div class="left">
    <div class="box">
        <img src="${contextPath}/resources/images/profile/temp.png">
    </div>
    <div class="name">홍길동</div>
    <div class="introduce">안녕하세요. 만나서 반갑습니다.</div>

    <div class="list">
        <div onclick="">학생 프로필</div>
        <div onclick="location.href='studentClassList'">클래스 목록</div>
        <div onclick="location.href='studentCommentList'">후기 목록</div>
        <div onclick="location.href='studentWishList'">찜 목록</div>
    </div>
</div>