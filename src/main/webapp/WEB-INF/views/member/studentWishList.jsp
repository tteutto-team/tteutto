<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />

<link rel="stylesheet" href="${contextPath}/resources/css/studentWishList.css" />
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
<link href="${contextPath}/resources/icon/css/uicons-regular-rounded.css" rel="stylesheet">

<div class="container">
        <main>
            <jsp:include page="../common/studentMypageSidebar.jsp"></jsp:include>

            <div class="right">
                <div class="title">
                    <p><span>${sessionScope.loginMember.memberNm}</span> 님의 찜한 클래스</p>
                </div>

                <div class="list-wrap">
            		
            		<c:forEach items="${wishList}" var="classList">
            			<!-- 클래스 카드 -->
	                    <div class="class">
	                        <div class="image">
	                        	<!-- 클래스 이미지 -->
	                            <img src="${contextPath}/resources/images/class-detail/${classList.thumbnailImageName}" 
	                            onclick="location.href='/tteutto/class/classDetail?classNo=${classList.classNo}'">
	                            
	                            <!-- 수업 등록 지역 -->
	                            <p class="location-p">${classList.classArea}</p>
	                        </div>
	                        
	                        <!-- 클래스 찜하기 버튼 > 찜 X -->
	                        <c:if test="${classList.heartFlag == 0}">
		                        <button type="button" class="btn_like">
		                            <span class="img_emoti">좋아요</span>
		                            <span class="ani_heart_m"></span>
		                        </button>
	                        </c:if>
	                        
	                        <!-- 클래스 찜하기 버튼 > 찜 X -->
	                        <c:if test="${classList.heartFlag == 1}">
		                        <button type="button" class="btn_like btn_unlike">
		                            <span class="img_emoti">좋아요</span>
		                            <span class="ani_heart_m hi"></span>
		                        </button>
	                        </c:if>
	                        
	                        <div class="detail-info">
	                            <span class="category-name">${classList.categoryName}</span> <!-- 카테고리명 -->
	                            <div class="class-name">${classList.className}</div> <!-- 클래스명 -->
	                            <div class="grade">
	                                <i class="fi-rr-star"></i> <span>${classList.starAverage}</span> <!-- 평점 -->
	                                <i class="fi-rr-heart"></i> <span>${classList.heartCount}</span> <!-- 찜 개수 -->
	                            </div>
	                            
	                            <div class="detail-info-bottom">
	                            	<img src="${contextPath}/resources/images/teacher/${classList.teacherImage}"> <!-- 강사 프로필 이미지 -->
	                                <span class="teacher-name">${classList.memberName}</span> <!-- 강사명 -->
	                                <span class="class-price"><fmt:formatNumber value="${classList.episodePrice}" pattern="#,###"/>원</span> <!-- 수업료 -->
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
                
                <!-- 페이지네이션 -->
				<c:if test="${pagination.maxPage > 1}">
			        <div class="page-number">
			            <ul class="page-ul">
			            	<c:if test="${pagination.startPage != 1}">
				            	<!-- 이전 리스트로 이동 -->
				                <li><a href="#"><i class="fas fa-angle-double-left"></i></a></li>
				                <!-- 이전 페이지로 이동 -->
				                <li><a href="#"><i class="fas fa-angle-left"></i></a></li>
			                </c:if>
			                
			                <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1"  var="i">
			                	<c:choose>
			                		<c:when test="${i == pagination.currentPage}">
						                <!-- 선택된 페이지 -->
						                <li style="border-radius: 50%; background-color: #FFDF3E;">
						                    <a style="color: white;">${i}</a></li>
					                </c:when>
					                
					                <c:otherwise>
						                <!-- 선택되지 않은 페이지 -->
						                <li><a href="studentWishList?page=${i}">${i}</a></li>
					                </c:otherwise>
				                </c:choose>
			                </c:forEach>
			                
			                <c:if test="${pagination.endPage != pagination.maxPage}">
				                <!-- 다음 페이지로 이동 -->
				                <li><a href="#"><i class="fas fa-angle-right"></i></a></li>
				                <!-- 다음 리스트로 이동 -->
				                <li><a href="#"><i class="fas fa-angle-double-right"></i></a></li>
			                </c:if>
			            </ul>
			        </div>
		        </c:if>
            </div>
        </main>
    </div>

<jsp:include page="../common/footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	$(".left > .list > div:nth-of-type(4)").addClass("selected");
	
    $('.btn_like').click(function(){
        if($(this).hasClass('btn_unlike')){
            $(this).removeClass('btn_unlike');
            $(this).children('span:eq(1)').removeClass('hi');
            $(this).children('span:eq(1)').addClass('bye');
        }
        else{
            $(this).addClass('btn_unlike');
            $(this).children('span:eq(1)').removeClass('bye');
            $(this).children('span:eq(1)').addClass('hi');
        }
    });
</script>
