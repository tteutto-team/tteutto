<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/calculate.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<div class="title-wrap">
			<h2>${cal.className}-${cal.episodeCount}회차 ${cal.teacherName}강사</h2>
			<button onclick="a();">정산하기</button>
		</div>
	    <table id="table_id" class="display">
	        <thead>
	            <tr>
	                <th>학생명</th>
	                <th>출석률</th>
	                <th>정산금액</th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
	    </table>
	</div>
	<form action="#" name="updateRequest">
		<input type="hidden" name="calNo" value="${paramCalNo}">
	</form>
</div>
   
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<script>
	let noteSock = new SockJS("<c:url value='/note' />");
 	
	const contextPath = "${contextPath}";
	
	const teacherName = "${cal.teacherName}";
	const className = "${cal.className}-${cal.episodeCount}회차"	
	const memberNo = "${cal.calNo}";
	console.log(memberNo);
	const paramCalNo = "${paramCalNo}";
</script>
<script src="${contextPath}/resources/js/admin/calculate.js"></script>
