<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/refundManage.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<h2>환불 신청 관리</h2>
	    <table id="table_id" class="display">
	        <thead>
	            <tr>
	                <th>번호</th>
	                <th>학생명</th>
	                <th>클래스명-회차</th>
	                <th>신청일자</th>
	                <th>수업진행률</th>
	                <th>환불금액</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
	    </table>
	</div>
</div>
   
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<script>
	let noteSock = new SockJS("<c:url value='/note' />");
 	
	const contextPath = "${contextPath}";
</script>
<script src="${contextPath}/resources/js/admin/refundManage.js"></script>
