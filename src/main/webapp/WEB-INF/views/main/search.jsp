<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/search.css"/>
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" 
        crossorigin="anonymous"/>

<main>
	<div class="search">
		<!-- 검색 결과가 없을 때의 화면 -->
		<!--  
		<div class="no">
			<div class="announce">
				<h1 class="title">'뚱이'에 대한 클래스 검색 결과가 없습니다.</h1>
				<span>찾고자하는 클래스가 없으신가요? 아래애 추천드리는 다른 클래스들도 구경해보세요.</span>
			</div>
		</div>
		 -->
		 
		<!-- 검색 결과가 있을 때의 화면 -->
		<div class="yes">
			<h1 class="title">'캔들'에 대한 클래스 검색 결과</h1> <!-- 검색 키워드 -->
			
			<div class="select">
				<!-- 옵션 선택 -->
	            <article class="cont-select">
	                <button class="btn-select">클래스 종류</button>
	                <ul class="list-member">
	                    <li><button type="button">전체 클래스</button></li>
	                    <li><button type="button">원데이 클래스</button></li>
	                    <li><button type="button">다회차 클래스</button></li>
	                </ul>
	            </article>
	            
	            <article class="cont-select">
	                <button class="btn-select">정렬</button>
	                <ul class="list-member">
	                    <li><button type="button">인기순</button></li>
	                    <li><button type="button">정확도순</button></li>
	                    <li><button type="button">최신순</button></li>
	                    <li><button type="button">평점순</button></li>
	                </ul>
	            </article>
	            
	            <!-- 클래스 카드 -->
			</div>
			
			
			
			<!-- <div class="list">
				<ul>
					<li class="item"><a href="#">
						<div class="image">
							<img src="${contextPath}/resources/images/class/temp.jpg">
						</div>
						
						<div class="detail">
							<div class="area-1">
								<div>공예</div>
								<div class="teacher">
									<img src="${contextPath}/resources/images/teacher/temp.jpg">
									<span>HARAMCO</span>
								</div>
							</div>
							
							<div class="area-2">반짝반짝, 크리스탈 캔들 & 섬유향수 클래스</div>
							
							<div class="area-3">
								<div class="rating">
									<i class="star icon-star"></i>
									<i class="star icon-star"></i>
									<i class="star icon-star"></i>
									<i class="star icon-star"></i>
									<i class="star icon-star"></i>
								</div>
								<div class="price">34,000원</div>
							</div>
						</div>
					</a></li>
				</ul>
			</div> -->
			
		</div>
		
		<!-- 페이지네이션 -->
        <div class="page-number">
            <ul class="page-ul">
            	<!-- 이전 리스트로 이동 -->
                <li><a href="#"><i class="fas fa-angle-double-left"></i></a></li>
                
                <!-- 이전 페이지로 이동 -->
                <li><a href="#"><i class="fas fa-angle-left"></i></a></li>
                
                <!-- 선택된 페이지 -->
                <li style="border-radius: 50%; background-color: #FFDF3E;">
                    <a style="color: white;">1</a></li>
                
                <!-- 선택되지 않은 페이지 -->
                <li><a href="#">2</a></li>
                
                <!-- 다음 페이지로 이동 -->
                <li><a href="#"><i class="fas fa-angle-right"></i></a></li>
                
                <!-- 다음 리스트로 이동 -->
                <li><a href="#"><i class="fas fa-angle-double-right"></i></a></li>
            </ul>
        </div>
	</div>
</main>

<jsp:include page="../common/footer.jsp"/>

<script>
/* select-option */
const btn = document.querySelectorAll('.btn-select');
const list = document.querySelectorAll('.list-member');

for (let i = 0; i < btn.length; i++) {
	btn[i].addEventListener('click', () => {
	    btn[i].classList.toggle('on');
	});
}

for (let j = 0; j < list.length; j++) {
	list[j].addEventListener('click', (event) => {
	    if (event.target.nodeName === "BUTTON") {
	        btn[j].innerText = event.target.innerText;
	        btn[j].classList.remove('on');
	    }
	});
}
</script>