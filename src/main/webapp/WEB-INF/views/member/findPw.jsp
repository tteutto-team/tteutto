<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" href="${contextPath}/resources/css/findPw.css" />
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />



<div class="container">
    <main>
        <h1>비밀번호 찾기</h1>

        <div class="explain">
            <p>가입시 등록한 이메일 주소를 입력해주세요.</p>
            <p>비밀번호 재설정 링크를 보내드립니다.</p>
        </div>

        <div>
            <label for="email">이메일</label>
        </div>

        <div>
            <input type="email" id="email" name="memberEmail"> <br>
        </div>

        

        <button id="sendEmail">인증 메일 전송하기</button>
    </main>
</div>

<jsp:include page="../common/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/pwChange.js"></script>