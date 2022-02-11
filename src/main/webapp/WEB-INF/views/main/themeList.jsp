<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<jsp:include page="../common/header.jsp"/>

<link rel="stylesheet" href="${contextPath}/resources/css/classList.css"/>

<!-- icon -->
<link href="${contextPath}/resources/icon/css/uicons-regular-rounded.css" rel="stylesheet">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" 
crossorigin="anonymous"/>

<main>
	<div class="classList">
		<%-- 클래스 테마 이미지 --%>
		<div class="themeImage"><img src="${contextPath}/resources/images/main/${themeList[0].themeImage}"></div>
		
		<%-- 클래스 테마 목록 --%>
		<c:forEach items="${themeList}" var="classList">					
			<%-- 클래스 카드 --%>
			<div class="class">
				<div class="image">
					<%-- 클래스 이미지 --%>
					<img src="${contextPath}/resources/images/class-detail/${classList.thumbnailImageName}" 
					onclick="location.href='/tteutto/class/classDetail?classNo=${classList.classNo}&epNo=${classList.episodeNo}'">
					
					<%-- 수업 등록 지역 --%>
					<p class="location-p">${classList.classArea}</p>
				</div>
				
				<%-- 클래스 찜하기 버튼 > 찜 X --%>
				<c:if test="${classList.heartFlag == 0}">
					<button type="button" class="btn_like">
						<span class="img_emoti">좋아요</span>
						<span class="ani_heart_m"></span>
					</button>
				</c:if>
				
				<%-- 클래스 찜하기 버튼 > 찜 O --%>
				<c:if test="${classList.heartFlag == 1}">
					<button type="button" class="btn_like btn_unlike">
						<span class="img_emoti">좋아요</span>
						<span class="ani_heart_m hi"></span>
					</button>
				</c:if>
	
				<div class="detail-info">
					<span class="category-name">${classList.categoryName}</span> <%-- 카테고리명 --%>
					<div class="class-name">${classList.className}</div> <%-- 클래스명 --%>
					<div class="grade">
	                          <i class="fi-rr-star"></i> <span>${classList.starAverage}</span> <%-- 별점 --%>
	                          <i class="fi-rr-heart"></i> <span>${classList.heartCount}</span> <%-- 찜 개수 --%>
	                     	</div>
					
					<div class="detail-info-bottom">
						<img src="${contextPath}/resources/images/teacher/${classList.teacherImage}"> <%-- 강사 프로필 이미지 --%>
						<span class="teacher-name">${classList.memberName}</span> <%-- 강사명 --%>
						<span class="class-price"><fmt:formatNumber value="${classList.episodePrice}" pattern="#,###"/>원</span> <%-- 수업료 --%>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</main>

<jsp:include page="../common/footer.jsp"/>

<script>
	<%-- 클래스 카드 찜하기 버튼 기능 및 색상 변경 --%>
	$('.btn_like').click(function() {
		const classNo = this.getAttribute("id");
		
		if ("${loginMember}" != "") {
			const heartBtn = this;
			
			$.ajax({
				url : "${contextPath}/member/changeHeart", 
				data : {"classNo" : classNo}, 
				success : function(result) {
					if (result > 0) {
					    if ($(heartBtn).hasClass('btn_unlike')) {
					        $(heartBtn).removeClass('btn_unlike');
					        $(heartBtn).children('span:eq(1)').removeClass('hi');
					        $(heartBtn).children('span:eq(1)').addClass('bye');
					        
					    } else {
					        $(heartBtn).addClass('btn_unlike');
					        $(heartBtn).children('span:eq(1)').removeClass('bye');
					        $(heartBtn).children('span:eq(1)').addClass('hi');
					    }
					}
				}
			}) 
		
		} else alert("로그인 후 이용 가능합니다.");
	});
</script>