<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/profile.css"/>
    
    
<div id="container">
    <main>
        <div class="left">
            <div class="box">
                <img src="images/KakaoTalk_20220112_153307445.png">
            </div>
            <div class="name">홍길동</div>
        
            <div class="list">
                <div class="selected">학생 프로필</div>
                <div>클래스 목록</div>
            </div>
        </div>
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
                    <div class="label_title">성별</div>
                    <div class="label_content">남</div>
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