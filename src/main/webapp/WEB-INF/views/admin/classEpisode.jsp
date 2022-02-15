<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/classEpisode.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<div class="wrap">
			<div>클래스 이름</div>
			<div>${classOne.className}</div>
		</div>
		<div class="wrap">
			<div>지역</div>
			<div>${classOne.classArea}</div>
		</div>
		<div class="wrap">
			<div>수업 형태</div>
			<div>
				<c:if test="${classOne.classType == 0}">원데이</c:if>
				<c:if test="${classOne.classType == 1 }">정규</c:if>
			</div>
		</div>
		<div class="wrap">
			<div>수업 참여 인원</div>
			<div>${classOne.classPerson}</div>
		</div>
		<div class="wrap">
			<div>수업 최소 인원</div>
			<div>${classOne.classMinPerson}</div>
		</div>
		<div class="wrap">
			<div>수업 최대 인원</div>
			<div>${classOne.classMaxPerson}</div>
		</div>
		<div class="wrap">
			<div>수업 소개</div>
			<div>${classOne.classIntro}</div>
		</div>
		<div class="wrap">
			<div>난이도</div>
			<div>${classOne.classLevel}</div>
		</div>
		<div class="wrap">
			<div>카테고리</div>
			<div>${classOne.categoryName} - ${classOne.categoryDetailName}</div>
		</div>
		<div class="wrap">
			<div>썸네일 사진</div>
			<div>
				<c:if test="${!empty classOne.thumbnailImg}">
					<c:forEach var="img" items="${classOne.thumbnailImg}">
						<img class='img' src="${contextPath}/resources/images/class/${img.thumbnailImgName}"> <br>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<div class="wrap">
			<div>가격</div>
			<div>${episodeOne.episodePrice}</div>
		</div>
		<div class="wrap">
			<div>장소</div>
			<div>${episodeOne.episodePlace}</div>
		</div>
		<div class="wrap">
			<div>수업 날짜</div>
			<div>
				<c:if test="${!empty episodeOne.scheduleList}">
					<c:forEach var="schedule" items="${episodeOne.scheduleList}">
						${schedule.scheduleDate} / ${schedule.scheduleWeek}요일 / ${schedule.scheduleStartTime} ~ ${schedule.scheduleEndTime} / ${schedule.scheduleTime}시간 <br>
					</c:forEach>
				</c:if>	
			</div>
		</div>
	</div>
</div>
   
<script type="text/javascript">
	const img = $("img");
	
	for(let i=0; i<img.length; i++){
		if($(img[i]).outerWidth() > "697"){
			$(img[i]).css("width", "697px");
		}
	}
</script>
   
<script src="${contextPath}/resources/js/admin/classManage.js"></script>
