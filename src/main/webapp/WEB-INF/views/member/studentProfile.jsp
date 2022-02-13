<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/profile.css"/>
<link rel="stylesheet" href="${contextPath}/resources/css/studentWishList.css" />
    
<div id="container">
    <main>
        <jsp:include page="../common/studentMypageSidebar.jsp"></jsp:include>
        
        <form id ="signUp" action="studentProfileUpdate" method="post"  name="studentProfileUpdate"
				  enctype="multipart/form-data" role="form" onsubmit="return studentProfileValidate();">
            <div id="profile_header">
                <span>${loginMember.memberNm}</span>님의 학생 프로필
                <div id="secession" class="profile_btn btn_shadow modal-open-btn resign">탈퇴하기</div>
                <div id="save" class="profile_btn btn_shadow">저장하기</div>
            </div>
            <div class="profile_content">
                <div class="profile_area">
                	<c:if test="${empty loginMember.memberImg}">
	                    <div class="profile_img" id="img_cover" 
    	                	style="background-image:url(${contextPath}/resources/images/profile/temp.png)">
                	</c:if>
                	<c:if test="${!empty loginMember.memberImg}">
	                    <div class="profile_img" id="img_cover" 
    	                	style="background-image:url(${contextPath}/resources/images/profile/${loginMember.memberImg})">
                	</c:if>
                        <img class="camera" src="https://front-img.taling.me/Content/Images/Tutor/Images/btn_pfimg.png">
                        <input type="file" name="profileImg" id="picture" name="picture" onchange='loadImg(this)'>
                    </div>
                </div>
                <div class="profile_area">
                    <div class="label_title">ID</div>
                    <div class="label_content">${loginMember.memberEmail}</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">비밀번호</div>
                    <div class="label_content"><a href="${contextPath}/member/changePw2" class="pw_change btn_shadow">비밀번호 변경하기</a></div>
                </div>
                <div class="profile_area">
                    <div class="label_title">전화번호</div>
                    <div class="label_content"><input type="text" class="profile_input" name="phone" placeholder="010-1234-5678" value="${loginMember.memberPno}"></div>
                </div>
                <div class="profile_area">
                    <div class="label_title">이름</div>
                    <div class="label_content"><input type="text" class="profile_input" name="name" placeholder="김케이" value="${loginMember.memberNm}"></div>
                </div>
                <div class="profile_area">
                    <div class="label_title">생년월일</div>
                    <div class="label_content">${brithArray[0]}년 ${brithArray[1]}월 ${brithArray[2]}일</div>
                </div>
            </div>
           
        </form>
    </main>

	<!-- 탈퇴하기 모달 -->
	<div id="modal" class="resign-request modal">
	    <div class="modal-content" style="position: relative;">
	        <!-- <form action="#" method="post"> -->
	            <div class="modal-title">
	                <h2>정말로 회원 탈퇴를 하시겠습니까?</h2>
	            </div>
	            
	            <div id="modal-btn">
	                <button id="new" style="height: 50px;" onclick="location.href='${contextPath}/member/resign'">네</button>
	                <button type="button" id="existing" style="height: 50px;" onclick="resign_cancle()">아니요</button>
	            </div>
	
	        <!-- </form> -->
	        <button type="button" id="modal-close-btn" class="modal-close-btn new-class-modal-close" style="background: none;" >X</button>
	    </div>
	
	    <div class="modal-layer"></div>
	</div>
</div>


<jsp:include page="../common/footer.jsp"/>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	$(".left > .list > div:nth-of-type(1)").addClass("selected");
</script>

<script src="${contextPath}/resources/js/studentProfile.js"></script>
