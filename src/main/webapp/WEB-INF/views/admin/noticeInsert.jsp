<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/noticeInsert.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<div class="title-wrap">
			<h2>공지사항 등록</h2>
		</div>
		<form action="noticeInsert" method="POST" enctype="multipart/form-data">
		    <div class="notice-title">
		    	<p>제목</p>
		    	<input type="text" name="noticeTitle">
		    </div>
		    <div class="notice-content">
		    	<p>내용</p>
		    	<textarea name="noticeContent"></textarea>
		    </div>
		    <div>
		    	<p>첨부파일</p>
		    	<div>
			    	<input type="file" name="images"> <button type="button" id="addImage">추가</button>
		    	</div>
		    </div>
		    <button>등록하기</button>
		</form>
	</div>
</div>
   
<script type="text/javascript">
	$("#addImage").on("click", function(){
		const input = $("<br><input type='file' name='images'>");
		const button = $("<button type='button' class='remove'>삭제</button>");
		
		const div = $("form > div:nth-of-type(3) > div");
		
		div.append(input, button);
	});
	
	$(document).on("click", ".remove", function(){
		$(this).prev().prev().remove();
		$(this).prev().remove();
		$(this).remove();
	});
		
	
</script>
