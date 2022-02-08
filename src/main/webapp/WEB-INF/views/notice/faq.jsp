<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/notice_list.css"/>
<div id ="container">
    <main>
        <div id="container_header">
            <h1>자주 묻는 질문</h1>
        </div>
        <div class="select_tab">
            <div class="tab_on" id="student" value="0">학생</div>
            <div class="tab" id="teacher" value="1">강사</div>
        </div>
        <div id ="faq_list"></div>
    </main>
</div>

<jsp:include page="../common/footer.jsp"/>
<script src="${contextPath}/resources/js/faq.js"></script>