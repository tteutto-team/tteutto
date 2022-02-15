<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<footer>
	<div class="content">
		<div class="area-1 prevent-dragging">
			<img src="${contextPath}/resources/images/common/TTEUTTO ver.1.png" alt="뜨또 로고 이미지">
			<div class="list">
				<ul>
					<li><a href="${contextPath}/notice/noticeList">공지사항</a></li>
					<li><a href="${contextPath}/notice/faq">FAQ</a></li>
					<li><a href="${contextPath}/notice/terms">이용약관</a></li>
					<li><a href="${contextPath}"><strong>개인정보 처리방침</strong></a></li>
				</ul>
			</div>
		</div>
		
		<div class="area-2">
			<div class="detail-info">
				<ul>
					<li><strong>(주)뜨또</strong></li>
					<li>서울특별시 중구 남대문로 120 대일빌딩 2층</li>
					<li>대표 : 우혜진</li>
				</ul>
				
				<ul>
					<li>사업자등록번호 : 102-31-84912</li>
					<li>통신판매업신고 : 2022-서울중구-0323</li>
				</ul>
				
				<ul>
					<li>대표번호 : 1544-9970 (평일 오전 9시 ~ 오후 9시 30분)</li>
					<li>이메일 : help@tteutto.com</li>
				</ul>
			</div>
			
			<div class="announce">
				<div class="sns">
					<ul>
						<li>
							<a href="https://www.facebook.com/khacademy1998"
							 target="_blank" id="facebook">
							<i class="icon-facebook"></i>
						</a></li>
						
						<li>
							<a href="https://www.instagram.com/kh_iei/"
							 target="_blank" id="insta">
							<i class="icon-instagram"></i>
						</a></li>
						
						<li>
							<a href="https://www.youtube.com/channel/UC2_-vqaMlRwjdjeLADvndyQ/featured"
							 target="_blank" id="youtube">
							<i class="icon-youtube"></i>
						</a></li>
					</ul>
				</div>
				
				<span>Copyright © 2022 tteutto Inc. All rights reserved.</span>
			</div>
		</div>
	</div>
</footer>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<!-- sweetealert : 경고창 api -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- 네이버 api -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
 
<!-- 카카오 로그인 api -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

<c:if test="${ !empty requestScope.message }">
	<script>
		$(function(){ // ready() 함수로 페이지 로딩 완료 후 alert 출력
			alert("${message}");
		})
			// EL 작성 시 scope를 지정하지 않으면
			// page -> request -> session -> application 순서로 검색하여
			// 일치하는 속성이 있으면 출력
	</script>
	
	<%-- message 1회 출력 후 session에서 제거 --%>
	<c:remove var="message" scope="session"/>
</c:if>
<%-- requestScope에 "title"이라는 키값이 존재하는 경우 --%>
<c:if test="${!empty requestScope.title }">
	<script>
		swal({
			title : "${title}",
			text : "${text}",
			icon : "${icon}"
		});
	</script>
</c:if>

<script type="text/javascript">
	$.ajax({
		url: "${contextPath}/chatNote/alarm",
		type: "get",
		success: function (result) {
			if (result > 0) {
				$(".alert").html(result);
				$(".alert").css("display", "block");

			}else{
				$(".alert").html(0);
				$(".alert").css("display","none");
			}
		}
	})

	function clearAlarm() {
			$.ajax({
				url: "${contextPath}/chatNote/clearAlarm",
				type: "get",
				success: function (result) {
					console.log(result);
					$(".alert").html(0);
					$(".alert").css("display","none");
					window.open('${contextPath}/chat/chatRoomList', '_blank', 'width=482, height=700, top=200');
				}
			})
		}
</script>
