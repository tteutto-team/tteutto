<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/classEpisode.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		지역 : ${classOne.classArea} <br>
		수업 형태 : <c:if test="${classOne.classType == 0}">원데이</c:if>
					<c:if test="${classOne.classType == 1 }">정규</c:if> <br>
		수업 참여 인원 : ${classOne.classPerson} <br>
		수업 최소 인원 : ${classOne.classMinPerson} <br>
		수업 최대 인원 : ${classOne.classMaxPerson} <br>
		클래스 이름 : ${classOne.className} - ${episodeOne.episodeCount}회차 <br>
		수업 소개 : ${classOne.classIntro} <br>
		난이도 : ${classOne.classLevel} <br>
		카테고리 : ${classOne.categoryName} - ${classOne.categoryDetailName} <br>
		
		<c:if test="${!empty classOne.thumbnailImg}">
			<c:forEach var="img" items="${classOne.thumbnailImg}">
				${img} <br>
			</c:forEach>
		</c:if>
		
		가격 : ${episodeOne.episodePrice} <br>
		장소 : ${episodeOne.episodePlace} <br>
		
		<c:if test="${!empty episodeOne.scheduleList}">
			<c:forEach var="schedule" items="${episodeOne.scheduleList}">
				수업 날짜 : ${schedule.scheduleDate} <br>
				수업 요일 : ${schedule.scheduleWeek}요일 <br>
				수업 시간 : ${schedule.scheduleStartTime} ~ ${schedule.scheduleEndTime} <br>
				소요 시간 : ${schedule.scheduleTime}시간 <br>
			</c:forEach>
		</c:if>		
	</div>
</div>
   

<script>
 
</script>
<script src="${contextPath}/resources/js/admin/classManage.js"></script>
