<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/faqInsert.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<div class="title-wrap">
			<h2>FAQ 등록</h2>
		</div>
		<form action="faqInsert" method="POST">
			<div>
		    	<p>구분</p>
		    	<div>
			    	<select name="faqDiv">
			    		<option value="0">학생</option>
			    		<option value="1">강사</option>
			    	</select>
		    	</div>
		    </div>
		    <div class="notice-title">
		    	<p>질문</p>
		    	<input type="text" name="faqQuestion">
		    </div>
		    <div class="notice-content">
		    	<p>답변</p>
		    	<textarea name="faqAnswer"></textarea>
		    </div>
		    <button>등록하기</button>
		</form>
	</div>
</div>
