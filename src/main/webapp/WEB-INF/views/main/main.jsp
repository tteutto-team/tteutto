<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<jsp:include page="../common/header.jsp"/>

<!-- 부트스트랩 - 케러셀 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- 아이콘 -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
<link href="${contextPath}/resources/icon/css/uicons-regular-rounded.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/resources/css/main.css"/>

<!-- 캐러셀 -->
<div class="carosel">
    <div id="myCarousel" class="carousel slide product-img">
        <div class="carousel-inner">
            
            <div class="carousel-item active" style="background: #DBDBDB;">
                <img src="${contextPath}/resources/images/main/theme_1.png">
            </div>
            <div class="carousel-item" style="background: #65A4D6;">
                <img src="${contextPath}/resources/images/main/theme_2.png">
            </div>
            <div class="carousel-item">
                <img src="${contextPath}/resources/images/main/main_3.jpg">
            </div>
            <div class="carousel-item">
                <img src="${contextPath}/resources/images/main/main_4.jpg">
            </div>
        </div>

        <a class="carousel-control-prev" href="#myCarousel" data-slide="prev" style="left: 30px;">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" data-slide="next" style="right: 30px;">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
</div>

<main>
    <!-- 카테고리 -->
    <table class="category">
        <tr>
            <!-- 
            <td> <a class="category-div"><i class="fi-rr-camera"></i><p>공예/디자인</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-computer"></i><p>요리</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-cupcake"></i><p>뷰티/헬스</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-scissors"></i><p>사진/영상</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-brush"></i><p>커리어</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-flower-bouquet"></i><p>음악</p></a></td>
             -->
             
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/design.png')"><p>공예/디자인</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/cooking.png')"><p>요리</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/beauty.png')"><p>뷰티/헬스</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/video.png')"><p>사진/영상</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/career.png')"><p>커리어</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/music.png')"><p>음악</p></a></td>
        </tr>
    </table>

    <!-- 주변 클래스 추천 -->
    <div class="hot-class">
        <div class="hot-class-top">
            <span class="detail">
                주변 클래스 추천<i class="fas fa-angle-right"></i>
            </span>
            <span class="location modal-open-btn" style="cursor: pointer;">
                <i class=" fi-rr-marker"></i> <p id="location">서울 종로구</p>
            </span>
        </div>

        <div class="hot-class-bottom">
        	<div class="hot-class-bottom-view">
        	
	        	<c:forEach items="${locationList}" var="classList" varStatus="vs">
	        		<c:if test="${vs.index % 4 == 0 }">
	        			<div class="hot-class-content <c:if test="${vs.first}">active</c:if>">
	        		</c:if>
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
								<button type="button" class="btn_like" id="${classList.classNo}">
									<span class="img_emoti">좋아요</span>
									<span class="ani_heart_m"></span>
								</button>
							</c:if>
							
							<%-- 클래스 찜하기 버튼 > 찜 O --%>
							<c:if test="${classList.heartFlag == 1}">
								<button type="button" class="btn_like btn_unlike" id="${classList.classNo}">
									<span class="img_emoti">좋아요</span>
									<span class="ani_heart_m hi"></span>
								</button>
							</c:if>
				
							<div class="detail-info">
								<span class="category-name">${classList.categoryName}</span> <%-- 카테고리명 --%>
								
								<%-- 클래스명 --%>
								<div class="class-name">
									<c:choose>
										<c:when test="${classList.classType == 0}">[원데이] </c:when>
										<c:otherwise>[${classList.episodeNo}회차] </c:otherwise>
									</c:choose>
									${classList.className}
								</div>
								
								<div class="grade">
		                            <i class="fi-rr-star"></i> <span>${classList.starAverage}</span> <%-- 평점 --%>
		                            <i class="fi-rr-heart"></i> <span>${classList.heartCount}</span> <%-- 찜 개수 --%>
		                       	</div>
								
								<div class="detail-info-bottom">
									<img src="${contextPath}/resources/images/teacher/${classList.teacherImage}"> <%-- 강사 프로필 이미지 --%>
									<span class="teacher-name">${classList.memberName}</span> <%-- 강사명 --%>
									<span class="class-price"><fmt:formatNumber value="${classList.episodePrice}" pattern="#,###"/>원</span> <%-- 수업료 --%>
								</div>
							</div>
						</div>
		            <c:if test="${vs.index % 4 == 3 }">
			            </div>
	        		</c:if>
		        </c:forEach>
		        
		        <c:if test="${fn:length(locationList) % 4 != 0 }">
		            </div>
        		</c:if>
		    </div>
        </div>
        
        <div class="arrow left"><i class="icon-left prev"></i></div>
        <div class="arrow right"><i class="icon-right next"></i></div>

    </div>

    <!-- 인기 클래스 추천 -->
    <div class="hot-class">
        <div class="hot-class-top">
            <span class="detail">
                인기 클래스 추천<i class="fas fa-angle-right"></i>
            </span>
        </div>

        <div class="hot-class-bottom">
        	<div class="hot-class-bottom-view">
        	
	        	<c:forEach items="${hotList}" var="classList" varStatus="vs">
	        		<c:if test="${vs.index % 4 == 0 }">
	        			<div class="hot-class-content <c:if test="${vs.first}">active</c:if>">
	        		</c:if>
	        			<%-- 클래스 카드 --%>
			        	<div class="class">
							<div class="image">
								<%-- 클래스 이미지 --%>
								<img src="${contextPath}/resources/images/class-detail/${classList.thumbnailImageName}" 
									onclick="location.href='/tteutto/class/classDetail?classNo=${classList.classNo}'">
								
								<%-- 수업 등록 지역 --%>
								<p class="location-p">${classList.classArea}</p>
							</div>
							
							<%-- 클래스 찜하기 버튼 > 찜 X --%>
							<c:if test="${classList.heartFlag == 0}">
								<button type="button" class="btn_like" id="${classList.classNo}">
									<span class="img_emoti">좋아요</span>
									<span class="ani_heart_m"></span>
								</button>
							</c:if>
							
							<%-- 클래스 찜하기 버튼 > 찜 O --%>
							<c:if test="${classList.heartFlag == 1}">
								<button type="button" class="btn_like btn_unlike" id="${classList.classNo}">
									<span class="img_emoti">좋아요</span>
									<span class="ani_heart_m hi"></span>
								</button>
							</c:if>
				
							<div class="detail-info">
								<span class="category-name">${classList.categoryName}</span> <%-- 카테고리명 --%>
								
								<%-- 클래스명 --%>
								<div class="class-name">
									<c:choose>
										<c:when test="${classList.classType == 0}">[원데이] </c:when>
										<c:otherwise>[${classList.episodeNo}회차] </c:otherwise>
									</c:choose>
									${classList.className}
								</div>
								
								<div class="grade">
		                            <i class="fi-rr-star"></i> <span>${classList.starAverage}</span> <%-- 평점 --%>
		                            <i class="fi-rr-heart"></i> <span>${classList.heartCount}</span> <%-- 찜 개수 --%>
		                       	</div>
								
								<div class="detail-info-bottom">
									<img src="${contextPath}/resources/images/teacher/${classList.teacherImage}"> <%-- 강사 프로필 이미지 --%>
									<span class="teacher-name">${classList.memberName}</span> <%-- 강사명 --%>
									<span class="class-price"><fmt:formatNumber value="${classList.episodePrice}" pattern="#,###"/>원</span> <%-- 수업료 --%>
								</div>
							</div>
						</div>
		            <c:if test="${vs.index % 4 == 3 }">
			            </div>
	        		</c:if>
		        </c:forEach>
		        
		        <c:if test="${fn:length(hotList) % 4 != 0 }">
		            </div>
        		</c:if>
		    </div>
        </div>
        <div class="arrow left"><i class="icon-left prev"></i></div>
        <div class="arrow right"><i class="icon-right next"></i></div>

    </div>

    <!-- 신규 클래스 추천 -->
    <div class="hot-class">
        <div class="hot-class-top">
            <span class="detail">
                신규 클래스 추천<i class="fas fa-angle-right"></i>
            </span>
        </div>

        <div class="hot-class-bottom">
        	<div class="hot-class-bottom-view">
        	
	        	<c:forEach items="${newList}" var="classList" varStatus="vs">
	        		<c:if test="${vs.index % 4 == 0 }">
	        			<div class="hot-class-content <c:if test="${vs.first}">active</c:if>">
	        		</c:if>
	        			<%-- 클래스 카드 --%>
			        	<div class="class">
							<div class="image">
								<%-- 클래스 이미지 --%>
								<img src="${contextPath}/resources/images/class-detail/${classList.thumbnailImageName}" 
									onclick="location.href='/tteutto/class/classDetail?classNo=${classList.classNo}'">
								
								<%-- 수업 등록 지역 --%>
								<p class="location-p">${classList.classArea}</p>
							</div>
							
							<%-- 클래스 찜하기 버튼 > 찜 X --%>
							<c:if test="${classList.heartFlag == 0}">
								<button type="button" class="btn_like" id="${classList.classNo}">
									<span class="img_emoti">좋아요</span>
									<span class="ani_heart_m"></span>
								</button>
							</c:if>
							
							<%-- 클래스 찜하기 버튼 > 찜 O --%>
							<c:if test="${classList.heartFlag == 1}">
								<button type="button" class="btn_like btn_unlike" id="${classList.classNo}">
									<span class="img_emoti">좋아요</span>
									<span class="ani_heart_m hi"></span>
								</button>
							</c:if>
				
							<div class="detail-info">
								<span class="category-name">${classList.categoryName}</span> <%-- 카테고리명 --%>
								
								<%-- 클래스명 --%>
								<div class="class-name">
									<c:choose>
										<c:when test="${classList.classType == 0}">[원데이] </c:when>
										<c:otherwise>[${classList.episodeNo}회차] </c:otherwise>
									</c:choose>
									${classList.className}
								</div>
								
								<div class="grade">
		                            <i class="fi-rr-star"></i> <span>${classList.starAverage}</span> <%-- 평점 --%>
		                            <i class="fi-rr-heart"></i> <span>${classList.heartCount}</span> <%-- 찜 개수 --%>
		                       	</div>
								
								<div class="detail-info-bottom">
									<img src="${contextPath}/resources/images/teacher/${classList.teacherImage}"> <%-- 강사 프로필 이미지 --%>
									<span class="teacher-name">${classList.memberName}</span> <%-- 강사명 --%>
									<span class="class-price"><fmt:formatNumber value="${classList.episodePrice}" pattern="#,###"/>원</span> <%-- 수업료 --%>
								</div>
							</div>
						</div>
		            <c:if test="${vs.index % 4 == 3 }">
			            </div>
	        		</c:if>
	        		
		        </c:forEach>
		        <c:if test="${fn:length(newList) % 4 != 0 }">
		            </div>
        		</c:if>
		    </div>
        </div>
        <div class="arrow left"><i class="icon-left prev"></i></div>
        <div class="arrow right"><i class="icon-right next"></i></div>

    </div>

</main>

	<!-- 위치 모달 -->
        <div id="modal" class="location-setting modal">
            <div class="modal-content">
                <form action="#" method="post">
                    <div class="modal-title">
                        <h2>위치 설정</h2>
                    </div>
    
                    <div class="modal-location">
                        <p>'서울 종로구'</p>
                    </div>
                    <div class="modal_location_search">
                    	<input type=text id="locationSearch" name="locationSearch">
                    	<button type="button" id="locationSearchBtn">찾기</button>	
                    </div>
                    <div style="border: 1px solid #ccc; height: 300px;"><div id="map" style="width:100%;height:100%;"></div></div>

                    

                    <div id="modal-btn">
                        <button id="locationClick" type="button">설정</button>
                        <button type="button" id="modal-close-btn" class="modal-close-btn">취소</button>
                    </div>
                </form>
            </div>

            <div class="modal-layer"></div>
        </div>
        
<jsp:include page="../common/footer.jsp"/>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- 부트스트랩 케러셀 -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- 지도 API/JS -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c2fadae20e5509a211c93e833342aa29&libraries=services,clusterer,drawing"></script>
<script src="${contextPath}/resources/js/mapList.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	<%-- 클래스 카드 찜하기 버튼 색상 변경 --%>
	$('.btn_like').click(function() {
		const classNo = this.getAttribute("id");
		
		if ("${loginMember}" != "") {
			const heartBtn = this;
			
			$.ajax({
				url : "${contextPath}/member/changeHeart", 
				data : {"classNo" : classNo}, 
				success : function(result) {
					console.log(result);
					
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
    
    /* 위치 모달 */
    // 모달 열기
    $(".modal-open-btn").click(function () {
    	
    	// 위치
        if($(this).hasClass("location")){
            $(".location-setting").fadeIn(100);
            $(".location-setting").css("display", "flex");
        }
    	
        relayout();
    });

    // 모달 닫기 버튼
    $(".modal-close-btn").click(function () {
        $(".modal").fadeOut(100);
    });

    // 모달 밖에 클릭시 모달 닫기
    $(".modal").click(function (e) {
        if($(e.target).hasClass('modal-layer')) {
            $(".modal").fadeOut(100);
        }

    });
	    
    <%-- 클래스 카드 캐러셀 --%>
    $('.prev').click(function(){
       
       // 캐러셀 고정부분
       const view = $(this).parent().parent().children().eq(1).children();
       
       // 캐러셀이 순환하는 내용물의 개수 (클래스 4개당 1개)
       const contentLength = $(view).children().length;
       
       let temp;
       if(contentLength == 0)    temp = 0;
       else               temp = contentLength-1;
       
       const content = $(view).children().eq(temp).clone();
       
       
       // 현재 active 클래스가 포함된 class-content의 인덱스
       let cuurentIndex = $(view).children().index($(view).find(".active"));
       
       // active 클래스를 우선 삭제
       $(view).children().removeClass("active");
       
       // active 클래스를 이전 요소에 추가
       if(cuurentIndex > 0){
          $(view).children().eq(cuurentIndex - 1).addClass("active");
       }else{
          $(view).children().eq(temp).addClass("active");
          $(view).prepend(content);
          $(view).css("margin-left", "-1200px")
       }
       
       const offset = cuurentIndex != 0 ? (-1200 * (cuurentIndex-1)) : 0;
       
       $(view).stop().animate({'margin-left': offset + "px"},function(){
          
            if(cuurentIndex == 0){
               $(view).stop().animate({'margin-left': (-1200 * (contentLength-1)) + "px"}, 0);
               $(view).children().eq(0).remove()
            }
        });
        
        
    });    
    
    $('.next').click(function(){
       // 캐러샐 고정부분
       const view = $(this).parent().parent().children().eq(1).children();
       
       
       // 캐러셀이 순환하는 내용물의 개수 (클래스 4개당 1개)
       const contentLength = $(view).children().length;
       
       const content = $(view).children().eq(0).clone();
       
       // 현재 active 클래스가 포함된 class-content의 인덱스
       const cuurentIndex = $(view).children().index($(view).find(".active"));
       
       // active 클래스를 우선 삭제
       $(view).children().removeClass("active");
       
       // active 클래스를 다음 요소에 추가
       if(cuurentIndex < contentLength-1){
          $(view).children().eq(cuurentIndex + 1).addClass("active");
       }else{
          $(view).children().eq(0).addClass("active");
          $(view).append(content);
       }
       
       $(view).stop().animate({'margin-left': (-1200 * (cuurentIndex+1)) + "px"},function(){
          
            if(cuurentIndex >= contentLength-1){
               $(view).stop().animate({'margin-left': "0px"}, 0);
               $(view).children().eq(contentLength).remove()
            }
        });
    });     
	    
</script>
<c:if test="${!empty sessionScope.email}">
	<c:remove var="email" scope="session"/>
</c:if>