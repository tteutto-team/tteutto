<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/profile.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/studentWishList.css" />
    
<div id="container">
    <main>
        <jsp:include page="../common/studentMypageSidebar.jsp"></jsp:include>
        
        <form id ="signUp">
            <div id="profile_header">
                <span>김사과</span>님의 학생 프로필
                <div id="secession" class="profile_btn btn_shadow">탈퇴하기</div>
                <div id="save" class="profile_btn btn_shadow">저장하기</div>
            </div>
            <div class="profile_content">
                <div class="profile_area">
                    <div class="profile_img" id="img_cover" style="background-image:url(//img.taling.me/Content/Images/placeholders/profile-default.thumb.jpg)">
                        <img class="camera" src="https://front-img.taling.me/Content/Images/Tutor/Images/btn_pfimg.png">
                        <input type="file" id="picture" name="picture">
                    </div>
                </div>
                <div class="profile_area">
                    <div class="label_title">ID</div>
                    <div class="label_content">user01@naver.com</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">비밀번호</div>
                    <div class="label_content"><a href="#" class="pw_change btn_shadow">비밀번호 변경하기</a></div>
                </div>
                <div class="profile_area">
                    <div class="label_title">전화번호</div>
                    <div class="label_content">010-1234-5678</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">이름</div>
                    <div class="label_content">김케이</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">생년월일</div>
                    <div class="label_content">000111</div>
                </div>
            </div>
           
        </form>
    </main>
</div>
<jsp:include page="../common/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	$(".left > .list > div:nth-of-type(1)").addClass("selected");
</script>