<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/class.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
	${classOne}
		지역 : ${classOne.classArea} <br>
		수업 형태 : <c:if test="${classOne.classType == 0}">원데이</c:if>
					<c:if test="${classOne.classType == 1 }">정규</c:if> <br>
		수업 참여 인원 : ${classOne.classPerson} <br>
		수업 최소 인원 : ${classOne.classMinPerson} <br>
		수업 최대 인원 : ${classOne.classMaxPerson} <br>
		클래스 이름 : ${classOne.className} <br>
		수업 소개 : ${classOne.classIntro} <br>
		난이도 : ${classOne.classLevel} <br>
		카테고리 : ${classOne.categoryName} - ${classOne.categoryDetailName} <br>
		
		<c:if test="${!empty classOne.thumbnailImg}">
			<c:forEach var="img" items="${classOne.thumbnailImg}">
				${img} <br>
			</c:forEach>
		</c:if>
		
			
	</div>
</div>
   

<script>
 
</script>
<script src="${contextPath}/resources/js/admin/classManage.js"></script>
