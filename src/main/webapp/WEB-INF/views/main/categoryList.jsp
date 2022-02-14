<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />

<link rel="stylesheet" href="${contextPath}/resources/css/studentWishList.css" />
<link rel="stylesheet" href="${contextPath}/resources/css/classList.css"/>
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
<link href="${contextPath}/resources/icon/css/uicons-regular-rounded.css" rel="stylesheet">

<div class="container">
        <main>
            <jsp:include page="categorySidebar.jsp"></jsp:include>

            <div class="right">
                <div class="title classList">
 					<%-- 옵션 선택 --%>
					<form action="" method="get" name="optionForm">
						<div class="price">
							<div class="price-chk">
		                    	<input type="checkbox" name="price" value="1" id="price1">
		                    	<label for="price1"></label>
		                    	<label for="price1" class="label prevent-dragging">1만 원 미만</label>
							</div>
							
							<div class="price-chk">
		                    	<input type="checkbox" name="price" value="2" id="price2">
		                    	<label for="price2"></label>
				            	<label for="price2" class="label prevent-dragging">1만 원 ~ 3만 원</label>
							</div>
							
							<div class="price-chk">
		                    	<input type="checkbox" name="price" value="3" id="price3">
		                    	<label for="price3"></label>
				            	<label for="price3" class="label prevent-dragging">3만 원 ~ 5만 원</label>
							</div>
							
							<div class="price-chk">
		                    	<input type="checkbox" name="price" value="4" id="price4">
		                    	<label for="price4"></label>
				            	<label for="price4" class="label prevent-dragging">5만 원 ~ 10만 원</label>
							</div>
							
							<div class="price-chk">
					            <input type="checkbox" name="price" value="5" id="price5">
					            <label for="price5"></label>
					            <label for="price5" class="label prevent-dragging">10만 원 초과</label>
							</div>
	                    </div>
						
						<div class="select">
				            <!-- 브이월드 행정구역도를 이용한 셀렉트 박스 구현... 공간정보를 기반으로 하고 있어서 국가공간정보포털보다 느림 -->
	                        <article class="cont-select">
	                        	<select id="sido_code" name="area1" class="select-style btn-select" style="appearance:none; font-size:15px; font-family: 'IBM Plex Sans KR', sans-serif;">
	                            	<option class="list-member">선택</option>
	                        	</select>
	                        </article>
	                        
	                        <article class="cont-select">	
	                        	<select id="sigoon_code" name="area2" class="select-style btn-select" style="appearance:none; font-size:15px; font-family: 'IBM Plex Sans KR', sans-serif;">
	                            	<option class="list-member">선택</option>
	                        	</select>
	                        </article>
	                        
				            <article class="cont-select">
				                <input type="hidden" name="classType">
				                <button class="btn-select" type="button">수업 형태</button>
				                <ul class="list-member">
				                    <li><button type="button">전체</button></li>
				                    <li><button type="button">원데이</button></li>
				                    <li><button type="button">정규</button></li>
				                </ul>
				            </article>
				            
				            <%-- 인기, 신규 클래스 목록일 때 정렬 조건 미노출 --%>
				            <c:if test="${type != 'hot' && type != 'new'}">
					            <article class="cont-select">
					                <input type="hidden" name="classSort">
					                <button class="btn-select" type="button">정렬</button>
					                <ul class="list-member">
					                    <li><button type="button">인기순</button></li>
					                    <li><button type="button">별점 높은 순</button></li>
					                    <li><button type="button">찜 많은 순</button></li>
					                    <li><button type="button">후기 많은 순</button></li>
					                </ul>
					            </article>
				            </c:if>
						</div>
					</form>
                </div>

                <div class="list-wrap">
            		
            		<c:forEach items="${classList}" var="classList">
            			<%-- 클래스 카드 --%>
	                    <div class="class">
	                        <div class="image">
	                        	<%-- 클래스 이미지 --%>
	                            <img src="${contextPath}/resources/images/class-detail/${classList.thumbnailImageName}" 
	                            onclick="location.href='/tteutto/class/classDetail?classNo=${classList.classNo}&epCount=${classList.episodeNo}'">
	                            
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
	                        
	                        <%-- 클래스 찜하기 버튼 > 찜 X --%>
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
	                                <i class="fi-rr-star"></i> <span>${classList.starAverage}</span> <%-- 별점 --%>
	                                <i class="fi-rr-heart"></i> <span>${classList.heartCount}</span> <%-- 찜 개수 --%>
	                            </div>
	                            
	                            <div class="detail-info-bottom">
	                            	<img src="${contextPath}/resources/images/teacher/profile/${classList.teacherImage}"> <%-- 강사 프로필 이미지 --%>
	                                <span class="teacher-name">${classList.memberName}</span> <%-- 강사명 --%>
	                                <span class="class-price"><fmt:formatNumber value="${classList.episodePrice}" pattern="#,###"/>원</span> <%-- 수업료 --%>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
                
                <%-- 페이지네이션 --%>
				<c:if test="${pagination.maxPage > 1}">
			        <div class="page-number">
			            <ul class="page-ul">
			            	<c:if test="${pagination.startPage != 1}">
				            	<%-- 이전 리스트로 이동 --%>
				                <li><a href="#"><i class="fas fa-angle-double-left"></i></a></li>
				                <%-- 이전 페이지로 이동 --%>
				                <li><a href="#"><i class="fas fa-angle-left"></i></a></li>
			                </c:if>
			                
			                <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1"  var="i">
			                	<c:choose>
			                		<c:when test="${i == pagination.currentPage}">
						                <%-- 선택된 페이지 --%>
						                <li style="border-radius: 50%; background-color: #FFDF3E;">
						                    <a style="color: white;">${i}</a></li>
					                </c:when>
					                
					                <c:otherwise>
						                <%-- 선택되지 않은 페이지 --%>
						                <li><a href="studentWishList?page=${i}">${i}</a></li>
					                </c:otherwise>
				                </c:choose>
			                </c:forEach>
			                
			                <c:if test="${pagination.endPage != pagination.maxPage}">
				                <%-- 다음 페이지로 이동 --%>
				                <li><a href="#"><i class="fas fa-angle-right"></i></a></li>
				                <%-- 다음 리스트로 이동 --%>
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
	
	<%-- 클래스 카드 찜하기 버튼 기능 및 색상 변경 --%>
	$('.btn_like').click(function() {
		const classNo = this.getAttribute('id');
		
		if ('${loginMember}' != "") {
			const heartBtn = this;
			
			$.ajax({
				url : "${contextPath}/member/changeHeart", 
				data : {"classNo" : classNo}, 
				success : function(result) {
					
					const temp = $(heartBtn).next().find('.fi-rr-heart').next();
					
					if (result > 0) {
					    if ($(heartBtn).hasClass('btn_unlike')) {
					        $(heartBtn).removeClass('btn_unlike');
					        $(heartBtn).children('span:eq(1)').removeClass('hi');
					        $(heartBtn).children('span:eq(1)').addClass('bye');
					        temp.text( Number(temp.text()) - 1 );
					        
					    } else {
					        $(heartBtn).addClass('btn_unlike');
					        $(heartBtn).children('span:eq(1)').removeClass('bye');
					        $(heartBtn).children('span:eq(1)').addClass('hi');
					        temp.text( Number(temp.text()) + 1 );
					    }
					}
				}
			}) 
		
		} else alert("로그인 후 이용 가능합니다.");
	});
</script>
