<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/faqManage.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<div class="title-wrap">
			<h2>FAQ</h2>
			<button onclick="location.href='${contextPath}/admin/faqInsert'">글쓰기</button>
		</div>
	    <table id="table_id" class="display">
	        <thead>
	            <tr>
	                <th>번호</th>
	                <th>질문내용</th>
	                <th>구분</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        </tbody>
	    </table>
	</div>
</div>
   
<script src="${contextPath}/resources/js/admin/faqManage.js"></script>
<script type="text/javascript">
	const contextPath = "${contextPath}";
</script>