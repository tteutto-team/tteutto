<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/notice_list.css"/>
<div id ="container">
    <main>
        <div id="container_header">
            <h1>공지사항</h1>
        </div>
        <ul id="notice_list">
	        <%-- 공지사항 목록 출력 --%>
	        <c:choose>
	        	<c:when test="${empty notice}">
		        	<li class="notice_list_item">
		                <a href="#" class="notice_list_link">공지사항이 존재하지 않습니다.</a>
		            </li>
	            </c:when>
	            <c:otherwise>
	            	<c:forEach items="${notice}" var="notice">
	            		<li class="notice_list_item">
			                <a href="${contextPath}/notice/noticeView/${notice.noticeNo}" class="notice_list_link">${notice.noticeTitle}</a>
			            </li>
	            	</c:forEach>
	            </c:otherwise>
	        </c:choose>
        </ul>
    </main>
</div>
<jsp:include page="../common/footer.jsp"/>