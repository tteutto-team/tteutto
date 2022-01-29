<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/classManage.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<h2>회차별 클래스 신청 관리</h2>
	    <table id="table_id" class="display">
	        <thead>
	            <tr>
	                <th>번호</th>
	                <th>클래스명-회차</th>
	                <th>강사명</th>
	                <th>신청날짜</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
	    </table>
	</div>
</div>
   
           <!-- 후기 작성 모달창 -->
<div id="modal1">
    <div class="modal-content">
       <h1>거절 사유</h1>
   	<div>
      <select name="cancel-reason">
        <option>설명 부족</option>
        <option>부적절한내용</option>
        <option>가격 부적합</option>
      </select>
    </div>
       <input type="hidden">

        <div class="modal-btn">
            <button class="sendDeny">보내기</button>
            <button type="button" class="modal-close-btn">취소</button>
        </div>
    </div>

    <div class="modal-layer"></div>
</div>

<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<script>
	let noteSock = new SockJS("<c:url value='/note' />");
 
</script>
<script src="${contextPath}/resources/js/admin/classManage.js"></script>
