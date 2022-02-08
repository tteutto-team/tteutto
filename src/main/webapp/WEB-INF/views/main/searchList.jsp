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
	<div class="searchList">
		<c:choose>
			<c:when test="${empty searchList}">
				<%-- 검색 결과가 없을 때의 화면 --%>
				<div class="no">
					<div class="announce">
						<h1 class="title"><span>'${param.search}'</span>에 대한 클래스 검색 결과가 없습니다.</h1>
						<span>찾고자하는 클래스가 없으신가요? 아래에 추천드리는 다른 클래스들도 구경해보세요.</span>
					</div>
				</div>
				
				<c:forEach items="${recommendList}" var="classList">					
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
				</c:forEach>
			</c:when>
			 
			<c:otherwise>
				<%-- 검색 결과가 있을 때의 화면 --%>
				<div class="yes">
					<h1 class="title"><span>'${param.search}'</span>에 대한 클래스 검색 결과</h1> <%-- 검색 키워드 --%>
					
					<%-- 옵션 선택 --%>
					<form action="" method="get" name="optionForm">
						<div class="select">
				            <article class="cont-select">
				                <input type="hidden" name="classType">
				                <button class="btn-select" type="button">클래스 종류</button>
				                <ul class="list-member">
				                    <li><button type="button">전체 클래스</button></li>
				                    <li><button type="button">원데이 클래스</button></li>
				                    <li><button type="button">정규 클래스</button></li>
				                </ul>
				            </article>
				            
				            <article class="cont-select">
				                <input type="hidden" name="classSort">
				                <button class="btn-select" type="button">정렬</button>
				                <ul class="list-member">
				                    <li><button type="button">인기순</button></li>
				                    <li><button type="button">최신순</button></li>
				                    <li><button type="button">평점 높은 순</button></li>
				                    <li><button type="button">찜 많은 순</button></li>
				                </ul>
				            </article>
						</div>
			            
			            <article class="cont-select">
			                <input type="hidden" name="classProgress">
			                <button class="btn-select" type="button">진행 여부</button>
			                <ul class="list-member">
			                    <li><button type="button">진행 예정</button></li>
			                    <li><button type="button">진행 중</button></li>
			                </ul>
			            </article>
			             
			            <div>
				            <input type="checkbox" name="classDay" value="월">월
				            <input type="checkbox" name="classDay" value="화">화
				            <input type="checkbox" name="classDay" value="수">수
				            <input type="checkbox" name="classDay" value="목">목
				            <input type="checkbox" name="classDay" value="금">금
				            <input type="checkbox" name="classDay" value="토">토
				            <input type="checkbox" name="classDay" value="일">일
			            </div>
			            
			            <div>
				            <input type="checkbox" name="classPrice" value="1">1만원대
				            <input type="checkbox" name="classPrice" value="2">2만원대
				            <input type="checkbox" name="classPrice" value="3">3만원대
				            <input type="checkbox" name="classPrice" value="4">4만원대
				            <input type="checkbox" name="classPrice" value="5">5만원대
			            </div>
			            
			            <div class="bottomLine" style="clear: both;">
			                <div class="line1 h4-height"><h4>수업등록지역 <span class="redText">*</span></h4></div>
			                <div class="line2">
			                    <!-- 브이월드 행정구역도를 이용한 셀렉트 박스 구현... 공간정보를 기반으로 하고 있어서 국가공간정보포털보다 느림 -->
			                    <!-- <form id="nsdiSearchForm" action="#" class="form_data" onsubmit="return false;search();"> -->
			                        <select id="sido_code" name="area1" class="select-style btn-select" required>
			                            <option class="list-member">선택</option>
			                        </select>
			                        <select id="sigoon_code" name="area2" class="select-style btn-select" required>
			                            <option class="list-member">선택</option>
			                        </select>
			                        <input type="hidden" id="classArea1" name="classArea1" value=""/>
			                        <input type="hidden" id="classArea2" name="classArea2" value=""/>
			                    <!-- </form> -->
			                </div>        
           				</div>
					</form>
			            
		            <%-- 클래스 목록 --%>
		            <div class="new-class">
						<div class="new-class-bottom">
		
							<c:forEach items="${searchList}" var="classList">					
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
							</c:forEach>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		
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
				                <li><a href="searchList?search=${param.search}&page=${i}">${i}</a></li>
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

<jsp:include page="../common/footer.jsp"/>

<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script> -->
<script>
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
	    }
	});
}

<%-- 클래스 카드 찜하기 버튼 색상 변경 --%>
$('.btn_like').click(function(){
    if ($(this).hasClass('btn_unlike')) {
        $(this).removeClass('btn_unlike');
        $(this).children('span:eq(1)').removeClass('hi');
        $(this).children('span:eq(1)').addClass('bye');
    } else {
        $(this).addClass('btn_unlike');
        $(this).children('span:eq(1)').removeClass('bye');
        $(this).children('span:eq(1)').addClass('hi');
    }
});

//브이월드 행정도 API
$.support.cors = true;
            
    $(function(){
        $.ajax({
            type: "get",
            url: "https://api.vworld.kr/req/data?key=CEB52025-E065-364C-9DBA-44880E3B02B8&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADSIDO_INFO",
            async: false,
            dataType: 'jsonp',
            success: function(data) {
                let html = "<option>선택</option>";

                data.response.result.featureCollection.features.forEach(function(f){
                    //console.log(f.properties.ctp_kor_nm);
                    let scode = f.properties.ctprvn_cd;
                    let sname = f.properties.ctp_kor_nm;
                    
                    if(sname == "충청북도"){
                        sname = "충북";
                    }else if(sname == "충청남도"){
                        sname = "충남";
                    }else if(sname == "경상남도"){
                        sname = "경남";
                    }else if(sname == "경상북도"){
                        sname = "경북";
                    }else if(sname == "전라남도"){
                        sname = "전남";
                    }else if(sname == "전라북도"){
                        sname = "전북";
                    }else{
                        sname = sname.substring(0,2);
                    }
                    


                    html +=`<option value="${scode}">${sname}</option>`
                    
                })
                
                $('#sido_code').html(html);
                
            },
            error: function(xhr, stat, err) {}
        });
        
        
        $(document).on("change","#sido_code",function(){
            let thisVal = $(this).val();		

            $.ajax({
                type: "get",
                url: "https://api.vworld.kr/req/data?key=CEB52025-E065-364C-9DBA-44880E3B02B8&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADSIGG_INFO",
                data : {attrfilter : 'sig_cd:like:'+thisVal},
                async: false,
                dataType: 'jsonp',
                success: function(data) {
                    let html = "<option>선택</option>";
					const arr = [];
                    data.response.result.featureCollection.features.forEach(function(f){
                        let scode = f.properties.sig_cd;
                        let sname = f.properties.sig_kor_nm;
                        
                        //let cut = sname.indexOf(' ');
                        if(sname == '세종특별자치시'){
	sname = '특별시'
}else{
                        	sname = sname.substr(0, 3);
}
                        
                        if(arr.indexOf(sname) == -1){
                         arr.push(sname);
                         html +=`<option value="${scode}">${sname}</option>`
}
                        
                    })
                    $('#sigoon_code').html(html);
                    
                },
                error: function(xhr, stat, err) {}
            });
        });
        
        $(document).on("change","#sigoon_code",function(){ 
            
            let thisVal = $(this).val();		

            $.ajax({
                type: "get",
                url: "https://api.vworld.kr/req/data?key=CEB52025-E065-364C-9DBA-44880E3B02B8&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADEMD_INFO",
                data : {attrfilter : 'emd_cd:like:'+thisVal},
                async: false,
                dataType: 'jsonp',
                success: function(data) {
                    let html = "<option>선택</option>";

                    data.response.result.featureCollection.features.forEach(function(f){
                        //console.log(f.properties)
                        let scode = f.properties.emd_cd;
                        let sname = f.properties.emd_kor_nm;
                        html +=`<option value="${scode}">${sname}</option>`
                        
                    })
                    $('#dong_code').html(html);
                    
                },
                error: function(xhr, stat, err) {}
            });

        });

    });
</script>