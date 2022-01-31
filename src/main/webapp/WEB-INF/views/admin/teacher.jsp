<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/classManage.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		이름 : ${teacher.memberName} <br>
		프로필 : ${teacher.teacherImg} <br>
		소개 : ${teacher.teacherIntro} <br>
		
		<c:if test="${!empty teacher.careerList}">
			<c:forEach var="career" items="${teacher.careerList}">
				${career.careerContent } <br>
			</c:forEach>
		</c:if>
		
		<c:if test="${!empty teacher.snsList}">
			<c:forEach var="sns" items="${teacher.snsList}">
				${sns.snsLink} <br>
			</c:forEach>
		</c:if>		
	</div>
</div>
   
<script>
 
</script>
<script src="${contextPath}/resources/js/admin/classManage.js"></script>
