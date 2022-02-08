<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/noticeManage.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<div class="title-wrap">
			<h2>공지사항</h2>
			<button onclick="location.href='${contextPath}/admin/noticeInsert'">글쓰기</button>
		</div>
	    <table id="table_id" class="display">
	        <thead>
	            <tr>
	                <th>번호</th>
	                <th>제목</th>
	                <th>등록일자</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
	    </table>
	</div>
</div>
   
<script src="${contextPath}/resources/js/admin/noticeManage.js"></script>
<script type="text/javascript">
	const contextPath = "${contextPath}";
</script>