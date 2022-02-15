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

            <div class="right" style="border: none;">
                <div class="title classList" style="padding: 0px 17px 0px 17px; border: none;">
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
	                            onclick="location.href='/tteutto/class/classDetail?classNo=${classList.classNo}&epCount=${classList.episodeCount}'">
	                            
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
										<c:otherwise>[${classList.episodeCount}회차] </c:otherwise>
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${contextPath}/resources/js/vworld.js"></script>
<script>
	$(".left > .list > div:nth-of-type(4)").addClass("selected");

	const btn = document.querySelectorAll('.btn-select');
	const list = document.querySelectorAll('.list-member');
	
	<%-- 옵션 버튼 클릭 시 드롭다운 열고 닫기 --%>
	for (let i = 0; i < btn.length; i++) {
		btn[i].addEventListener('click', () => {
			
			if (btn[i].classList.contains('on')) { <%-- 열린 상태 --%>
			    btn[i].classList.remove('on');
				
			} else { <%-- 닫힌 상태 --%>
				for (b of btn)
					b.classList.remove("on");
	
			    btn[i].classList.add('on');
			}
		});
	}
	
	<%-- 옵션 버튼 + 옵션 리스트 외 나머지 클릭 시 드롭다운 닫기 --%>
	window.addEventListener("click", function(e) {
		let flag = true;
	
		const nodeList = document.querySelectorAll(".btn-select, .list-member, .list-member > li");
	
		for (node of nodeList) {
			if (e.target == node) {
				flag = false;
				break;
			}
		} 
	
		if (flag) {
			for (b of btn)
				b.classList.remove("on");
		}
	});	
	<%-- 옵션 리스트 클릭 시 버튼 텍스트 변경 및 드롭다운 닫기 --%>
	for (let j = 0; j < list.length; j++) {
		list[j].addEventListener('click', (event) => {
		    if (event.target.nodeName === "BUTTON") {
		        btn[j].innerText = event.target.innerText;
		        $(btn[j]).prev().val(event.target.innerText);
		        btn[j].classList.remove('on');
		        
		        <%-- input type='hidden'은 value가 변해도 change 이벤트가 발생하지 않기 때문에 강제 발생 --%>
		        $(btn[j]).prev().change();
		    }
		});
	}	
	
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
	
	<%-- 클래스 목록 옵션 변경 --%>
	$('[name=optionForm] input, [name=optionForm] select').on("change", function() {
		const formData = new FormData($('[name=optionForm]')[0]);
		formData.append("search", "${param.search}");
		formData.append("sido", $("#sido_code > option:selected").text());
		formData.append("sigoon", $("#sigoon_code > option:selected").text());
		formData.append("type", "${type}");
		formData.append("ctNo", "${param.ctNo}");
		formData.append("ctDetailNo", "${param.ctDetailNo}");
		
		
		$.ajax({
			url : "${contextPath}/main/changeOption", 
			data : formData, 
			type : "post",
			dataType : "json", 
		 	contentType: false,
		 	processData: false,
		 	success : function(result) {
		 		console.log(result)
		 		changeQueryString();
		 		
		 		$(".list-wrap > .class").remove(); <%-- 기존 클래스 카드 삭제 --%>
		 		
		 		for (let classList of result.classList) {
		 			<%-- 클래스 카드 --%>
			 		const classCard = $('<div class="class">');
			 		
			 		const imgDiv = $('<div class="image">');
			 		
			 		<%-- 클래스 이미지 --%>
			 		const img = $('<img>');
			 		img.attr("src", "${contextPath}/resources/images/class-detail/" + classList.thumbnailImageName);
			 		img.attr("onclick", "location.href='/tteutto/class/classDetail?classNo=" + classList.classNo 
			 							+ "&epCount=" + classList.episodeCount + "'");
			 		
			 		<%-- 수업 등록 지역 --%>
			 		const locationP = $('<p class="location-p">').text(classList.classArea);
			 		
					imgDiv.append(img, locationP);
					classCard.append(imgDiv);
			 		
					<%-- 클래스 찜하기 버튼 --%>
					let btnLike;
					let imgEmoti;
					let aniHeartM;
					
					<%-- 찜 X --%>
					if (classList.heartFlag == 0) {
						btnLike = $('<button type="button" class="btn_like">').attr('id',classList.classNo);
						imgEmoti = $('<span class="img_emoti">').text('좋아요');
						aniHeartM = $('<span class="ani_heart_m">');
					
					<%-- 찜 O --%>
					} else {
						btnLike = $('<button type="button" class="btn_like btn_unlike">').attr('id',classList.classNo);
						imgEmoti = $('<span class="img_emoti">').text('좋아요');
						aniHeartM = $('<span class="ani_heart_m hi">');
					}
					
					btnLike.append(imgEmoti, aniHeartM);
					
					<%-- 클래스 찜하기 버튼 이벤트 --%>
					$(btnLike).click(function() {
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
					
					classCard.append(btnLike);
					
					const detailInfo = $('<div class="detail-info">');
					
					<%-- 카테고리명 --%>
					const category = $('<span class="category-name">').text(classList.categoryName);
					detailInfo.append(category);
					
					<%-- 클래스명 --%>
					const className = $('<div class="class-name">')
					
					if (classList.classType == 0)
						className.text("[원데이] " + classList.className);
					else
						className.text("["+ classList.episodeCount + "회차] " + classList.className)
						
					detailInfo.append(className);
					
					<%-- 별점, 찜 개수 --%>
					const grade = $('<div class="grade">');
					const starI = $('<i class="fi-rr-star">');
					const star = $('<span>').text(classList.starAverage.toFixed(1));
					
					const heartI = $('<i class="fi-rr-heart">'); 
					const heart = $('<span>').text(classList.heartCount);
					
					grade.append(starI, star, heartI, heart);
					starI.after(" "); star.after(" "); heartI.after(" "); heart.after(" ");
					
					detailInfo.append(grade);
					
					const detailInfoBottom = $('<div class="detail-info-bottom">');
					
					<%-- 강사 프로필 이미지 --%>
					const teacherImg = $('<img src="${contextPath}/resources/images/teacher/profile/' + classList.teacherImage + '">');
					
					<%-- 강사명 --%>
					const teacherName = $('<span class="teacher-name">').text(classList.memberName);
					
					<%-- 수업료 --%>
					const classPrice = $('<span class="class-price">').text(classList.episodePrice.toLocaleString('ko-KR') + "원")
					
					detailInfoBottom.append(teacherImg,teacherName,classPrice);
					teacherImg.after(" "); teacherName.after(" "); classPrice.after(" ");
					detailInfo.append(detailInfoBottom);
					
					classCard.append(detailInfo);
					
					<%-- 화면에 클래스 카드 추가 --%>
					$(".list-wrap").append(classCard);
					classCard.after(" ");
		 		}
		 	}
		})
	});
	
	
	// 주소창에 쿼리스트링을 추가하는 함수
	function changeQueryString(){
		let queryString = location.pathname;
		
		const arr = [];
		
		$("[name=price]:checked").each(function(){ 
			arr.push("price="+$(this).val());
		});
		
		if($("#sido_code > option:selected").text() != "선택"){
			arr.push("sido="+$("#sido_code > option:selected").text());
		}
		
		if($("#sigoon_code > option:selected").text() != "선택"){
			arr.push("sigoon="+$("#sigoon_code > option:selected").text());
		}
		
		if($("[name=classType]").val() != "" && $("[name=classType]").val() != "전체"){
			arr.push("classType="+$("[name=classType]").val());
		}
		
		if($("[name=classSort]").val() != ""){
			arr.push("classSort="+$("[name=classSort]").val());
		}
		
		
		
		if(arr.length > 0){
			
			queryString += "?";
			
			for(let i=0 ; i<arr.length ; i++){
				if(i == 0) queryString += arr[i];
				else queryString += "&" + arr[i];
			}
			
		}
		
		console.log(queryString);
		
		history.pushState(null, null, queryString);
		
	}
</script>
