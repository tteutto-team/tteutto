<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" href="${contextPath}/resources/css/changePw.css" />
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

<div class="container">
    <main>
        <h1>비밀번호 변경</h1>
		<form action="changePw" method="POST" name="changePwForm" onsubmit="return validate();">
			<input type="hidden" name="memberEmail" value="${param.memberEmail}">
			<input type="hidden" name="certCd" value="${param.certCd}">
	        <div>
	            <label for="pw1">새 비밀번호</label>
	        </div>
	        <div>
	            <input type="password" id="pw1" name="memberPw"> <br>
	            <span id="checkPw1"></span>
	        </div>
	
	        <div>
	            <label for="pw2">비밀번호 확인</label>
	        </div>
	        <div>
	            <input type="password" id="pw2"> <br>
	            <span id="checkPw2"></span>
	        </div>
	        <button id="changePw">비밀번호 변경하기</button>
        </form>
    </main>
</div>

<jsp:include page="../common/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/findPw.js"></script>