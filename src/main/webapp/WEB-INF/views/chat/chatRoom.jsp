<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>채팅창</title>

<link href="${contextPath}/resources/css/chatRoom.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" />
<link
	href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap"
	rel="stylesheet">

</head>
<body>
	<div class="chat_info">
		<div class="backBtn"
			onclick="location.href='/tteutto/chat/chatRoomList'">
			<svg width="25" height="25" viewBox="0 0 13 20" fill="none"
				xmlns="http://www.w3.org/2000/svg"
				class="InnerIconstyled__Icon-sc-197h5bb-0 cYxoKX CompactHeaderstyled__BackButton-sc-1rdzle3-7 hQfOPQ"
				defaultOpacity="1" hoveredOpacity="1" margintop="0" marginright="0"
				marginbottom="0" marginleft="0">
                <path fill="currentColor" fill-rule="evenodd"
					clip-rule="evenodd"
					d="M9.17255 16.4226C8.84711 16.748 8.31947 16.748 7.99404 16.4226L2.1607 10.5893C1.83527 10.2638 1.83527 9.73619 2.1607 9.41075L7.99404 3.57742C8.31947 3.25198 8.84711 3.25198 9.17255 3.57742C9.49799 3.90285 9.49799 4.43049 9.17255 4.75593L3.92847 10L9.17255 15.2441C9.49799 15.5695 9.49799 16.0972 9.17255 16.4226Z"></path>
            </svg>
		</div>
		<img
			src="https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61ea6885cbefd43cdfd1638e/previews/61ea6886cbefd43cdfd163b7/download/TTEUTTO_ver.1.png">
		<span>실시간으로 간편하게 문의하세요. <span>
				<div class="chatClose" onclick="chatClose();">×</div>
		</span>
		</span>
	</div>
	<!-- <div class="chat_title">
        <img src="https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61eac69be448bf64cd927411/previews/61eac69ce448bf64cd927465/download/TTEUTTO_ver.3_%28favicon%29.png">
        <div class="chat_title1">뜨또에 문의하기</div>
        <div class="chat_title2">뜨겁게 또시작, 뜨또!</div> -->
	
<!-- 	<button id="exit-btn">나가기</button> -->

	<c:choose>
		<c:when test="${!empty teacherInfo || loginMember.memberNo == cr.memberNo}">
			<div class="chat_title">
				<img src="https://trello-members.s3.amazonaws.com/5f6847b648dcd038f65b8551/6798ec30c2f40b27b3656649306bd860/original.png">
				<div class="chat_title1">
					<c:if test="${!empty teacherInfo}"><span>${teacherInfo.MEMBER_NM}</span>강사님께 문의하기</c:if>
					<c:if test="${empty teacherInfo}"><span>${cr.teacherNm}</span>강사님께 문의하기</c:if>
				</div>
				<div class="chat_title2">뜨겁게 또시작, 뜨또!</div>
			</div>
			<div>
				<div class="chatSubTitle">
					수업 일정과 강의 내용에 대해 문의해보세요. <br>(연락처 문의 또는 직접 알려주는 것은 불가)
				</div>
			</div>
		</c:when>
		
		<c:otherwise>
			<div class="chat_title">
				<img src="https://trello-members.s3.amazonaws.com/5f6847b648dcd038f65b8551/6798ec30c2f40b27b3656649306bd860/original.png">
				<div class="chat_title1">
					<c:if test="${empty teacherInfo}"><span>${cr.memberNm}</span>수강생의 문의 내역</c:if>
				</div>
				<div class="chat_title2">뜨겁게 또시작, 뜨또!</div>
			</div>
			<div>
				<div class="chatSubTitle">
					수강생의 문의 내역에 답장부탁드립니다. <br>(연락처 문의 또는 직접 알려주는 것은 불가)
				</div>
			</div>
		</c:otherwise>
	</c:choose>

	

	<div class="chat_wrap">
		<div class="inner">
			<div class="flex_wrap">
				<!-- 
                <div class="tteuttoProfile">

                    <img src="https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61eac69be448bf64cd927411/previews/61eac69ce448bf64cd927465/download/TTEUTTO_ver.3_%28favicon%29.png" style="width: 25px; border-radius: 5px;">
                </div> 
                -->
                
                <c:if test="${!empty list}">
                
                	<div class="item on">
                	
                	<c:forEach items="${list}" var="msg">
	                		<%-- message가 null인 경우 / null이 아닌 경우를 구분하기 --%>
							<%-- choos문 안에 다른거(주석) 넣으면 오류남 --%>
							<c:choose>
								<c:when test="${!empty msg.msgContent}">
									<c:set var="msgContent" value="${msg.msgContent}" />
								</c:when>
								<c:otherwise>
									<c:set var="msgContent"
										value="<b>${msg.memberNm} 님이 나가셨습니다.</b>" />
								</c:otherwise>
							</c:choose>
							
							<c:if test="${msg.memberNo == loginMember.memberNo }">
								<div class="item mymsg">
									<div class="box">
										<p class="msg">${msgContent}</p>
										<!-- <span class="read-status"> 1 </span>  -->
										<span class="time">${msg.msgDt}</span>
									</div>
								</div>
							</c:if>
		
							<c:if test="${msg.memberNo != loginMember.memberNo }">
								<div class="otherName">${msg.memberNm}</div>
								<div class="box">
									<p class="msg">${msgContent}</p>
									<span class="time">${msg.msgDt}</span>
								</div>
							</c:if>
						</c:forEach>
                	</div>
                </c:if>
                
                <c:if test="${empty list}">
                
	                <div class="item">
	                
						<c:forEach items="${list}" var="msg">
		
							<%-- message가 null인 경우 / null이 아닌 경우를 구분하기 --%>
							<%-- choos문 안에 다른거(주석) 넣으면 오류남 --%>
							<c:choose>
								<c:when test="${!empty msg.msgContent}">
									<c:set var="msgContent" value="${msg.msgContent}" />
								</c:when>
								<c:otherwise>
									<c:set var="msgContent"
										value="<b>${msg.memberNm} 님이 나가셨습니다.</b>" />
								</c:otherwise>
							</c:choose>
		
							<c:if test="${msg.memberNo == loginMember.memberNo }">
								<div class="item mymsg">
									<div class="box">
										<p class="msg">${msgContent}</p>
										<span class="time">${msg.msgDt}</span>
									</div>
								</div>
							</c:if>
		
							<c:if test="${msg.memberNo != loginMember.memberNo }">
								<div class="box">
									<div class="otherName">${msg.memberNm}</div>
									<p class="msg">${msgContent}</p>
									<span class="time">${msg.msgDt}</span>
								</div>
							</c:if>
		
						</c:forEach>
	
	                </div>
                </c:if>
				<%-- 				
				<div class="item on">

					<c:forEach items="${list}" var="msg">

						<c:if test="${msg.memberNo == loginMember.memberNo}">
							<div class="item mymsg">
								<div class="box">
									<p class="msg">${msg.message}</p>
									<span class="time">${msg.msgDt}</span>
								</div>
							</div>
						</c:if>

						<c:if test="${msg.memberNo != loginMember.memberNo}">
							<div class="otherName">백동현</div>
							<div class="box">
								<p class="msg">안녕하세요😊</p>
								<!-- <span class="read-status"> 1 </span> -->
								<span class="time">오전 10:05</span>
							</div>
						</c:if>



					</c:forEach>
				</div> --%>


			</div>
		</div>
	</div>


	<div class="inputBtn">

		<input type="text" class="mymsg" id="inputChatting" onkeyup="enterkey()"
			placeholder="메시지 입력(개인 연락처 입력 불가 : 전화번호, 카톡, 페이스북등)">
		<button type="button" id="sendBtn">전송</button>
	</div>
	<!-- <input type="text" class="yourmsg" placeholder="상대방 내용 입력"> -->
	</div>

	<!-- 웹소켓 -->
	<script
		src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	<script>
		// /chat 이라는 요청 주소로 통신할 수 있는  WebSocket 객체 생성
		let chattingSock = new SockJS("<c:url value='/chat' />");
		// == contextPath + /chat

		// 세션에 있는 값 전역 변수 선언
		let memberNo = "${loginMember.memberNo}";
		let teacherNo = "${teacherNo}";
		let studentNo = "${studentNo}";
		let mode = -1;
		/* let otherMemberNo = ""; // 강사 번호
		otherMemberNo = "${teacherInfo.MEMBER_NO}"; // 강사 번호 */
		
		
		
		/* if(${param.studentNo !=0 }){
			otherMemberNo = "${param.studentNo}"; // 강사 번호
		} else{
			otherMemberNo = "${teacherInfo.MEMBER_NO}"; // 강사 번호
		} */
		
		
/* 		if(otherMemberNo == ""){
			
			if(memberNo == "${cr.memberNo}"){
				memberNo = "${cr.memberNo}"; // 로그인 학생 번호
				otherMemberNo = "${cr.teacherNo}"; // 상대 강사 번호
				
			}else{
				memberNo = "${cr.teacherNo}"; 
				otherMemberNo = "${cr.memberNo}"; 
				
			}
			
		}
 */		
		/* const memberEmail = "${loginMember.memberEmail}"; */
		const memberNm = "${loginMember.memberNm}";
		let chatRoomNo = "${chatRoomNo}"; // 세션에 있는거임! 

		const contextPath = "${contextPath}";
	</script>
	
	<c:if test="${!empty param.mode}">
		<script type="text/javascript">
			mode = "${param.mode}";
		</script>
	</c:if>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/chatRoom.js"></script>




</body>
</html>