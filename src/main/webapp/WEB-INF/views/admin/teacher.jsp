<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin/teacher.css">
    
<jsp:include page="adminSidebar.jsp"></jsp:include>


<div id="right">
	<div>
		<div class="wrap">
			<div>이름</div>
			<div>${teacher.memberName}</div>
		</div>
		<div class="wrap">
			<div>프로필</div>
			<div><img src="${contextPath}/resources/images/teacher/profile/${teacher.teacherImg}"></div>
		</div>
		<div class="wrap">
			<div>소개</div>
			<div>${teacher.teacherIntro}</div>
		</div>
		<div class="wrap">
			<div>경력</div>
			<div>
				<c:if test="${!empty teacher.careerList}">
					<c:forEach var="career" items="${teacher.careerList}">
						<img src="${contextPath}/${career.imgPath}/${career.imgName}"> <br>
						${career.careerContent} <br> <br>
					</c:forEach>
				</c:if>	
			</div>
		</div>
		<div class="wrap">
			<div>SNS</div>
			<div>
				<c:if test="${!empty teacher.snsList}">
					<c:forEach var="sns" items="${teacher.snsList}">
						<a href="${sns.snsLink}" target="_blank">${sns.snsLink}</a> <br>
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
