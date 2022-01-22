<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/search.css"/>
<main class="test">
	<div class="search">
		<!-- 검색 결과가 없을 때 노출되는 화면 -->
		<div class="no">
			<div class="announce">
				<h1 class="title">'뚱이'에 대한 클래스 검색 결과가 없습니다.</h1>
				<span>찾고자하는 클래스가 없으신가요? 아래애 추천드리는 다른 클래스들도 구경해보세요.</span>
			</div>
			
			<div class="list">
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
			</div>
		</div>
		
		<!-- 검색 결과가 있을 때 노출되는 화면 -->
		<%-- <div class="yes">
			<h1 class="title">'캔들'에 대한 클래스 검색 결과</h1>
			
			<div class="select">
				<select id="sort" class="box">
					<option value="all">전체 클래스</option>
					<option value="oneday">원데이 클래스</option>
					<option value="several">다회차 클래스</option>
				</select>
				
				<select id="line-up" class="box">
					<option value="popular">인기순</option>
					<option value="accuracy">정확도순</option>
					<option value="latest">최신순</option>
					<option value="rating">평점순</option>
				</select>
			</div>
			
			<div class="list">
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
			</div>
		</div>
		
		<div class="search pagination prevent-dragging">
			<a href="#" class="arrow"><i class="icon-left"></i></a>
			<span class="num">1</span>
			<a href="#" class="num">2</a>
			<a href="#" class="num">3</a>
			<a href="#" class="num">4</a>
			<a href="#" class="num">5</a>
			<a href="#" class="arrow"><i class="icon-right"></i></a>
		</div> --%>
	</div>
</main>

<jsp:include page="../common/footer.jsp"/>