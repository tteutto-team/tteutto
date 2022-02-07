<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/userManage.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css"/>

<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<h2>유저 관리</h2>
	    <table id="table_id" class="display">
	        <thead>
	            <tr>
	                <th>번호</th>
	                <th>회원명</th>
	                <th>회원구분</th>
	                <th>강사등록여부</th>
	                <th>강사신청상태</th>
	                <th>회원상태</th>
	                <th>생년월일</th>
	                <th>성별</th>
	                <th>전화번호</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
	    </table>
	</div>
</div>
   
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="${contextPath}/resources/js/admin/jquery-ui.min.js"></script>

<script>
	let noteSock = new SockJS("<c:url value='/note' />");
	
	$.datepicker.setDefaults({
		  dateFormat: 'yy-mm-dd',
		  prevText: '이전 달',
		  nextText: '다음 달',
		  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		  showMonthAfterYear: true,
		  yearSuffix: '년'
		});
</script>
<script src="${contextPath}/resources/js/admin/userManage.js"></script>
