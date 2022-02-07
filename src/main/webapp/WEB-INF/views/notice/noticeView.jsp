<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/notice_list.css"/>
<div id ="container">
    <main>
        <div id="container_header">
            <h1>공지사항</h1>
        </div>
        <div id="notice_content_">
            <div id="notice_content_header">
                <h3>${notice.noticeTitle}</h3>
            </div>
            <div id="notice_content_view">
                ${notice.noticeContent}
            </div>
        </div>
        <div id="notice-footer">
            <div id="list_btn">
                <a href="#">목록으로</a>
            </div>
        </div>
    </main>
</div>
<jsp:include page="../common/footer.jsp"/>