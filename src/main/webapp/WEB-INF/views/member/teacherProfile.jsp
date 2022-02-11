<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/profile.css"/>
<div id="container">
    <main>
        <div class="left">
            <div class="box">
                <img src="${contextPath}/resources/images/teacher/profile/${loginMember.teacherImg}">
            </div>
            <div class="name">${teacher.memberNm}</div>
            <div class="introduce">${teacher.teacherIntro}</div>

            <div class="list">
                <div class="selected" onclick="location.href='${contextPath}/member/teacherProfile'">강사 프로필</div>
                <div onclick="location.href='${contextPath}/teacher/classList/${loginMember.memberNo}'">클래스 목록</div>
            </div>
        </div>
        <form id ="signUp" action="teacherProfileUpdate" method="post"  name="teacherProfileUpdate"
				  enctype="multipart/form-data" role="form" onsubmit="return teacherProfileValidate();">
            <div id="profile_header">
                <span>${teacher.memberNm}</span>님의 강사 프로필
                <div id="save" class="profile_btn btn_shadow">저장하기</div>
            </div>
            <div class="profile_content">
                <div class="profile_area">
                    <div class="profile_img" id="img__cover" style="background-image:url('${contextPath}/resources/images/teacher/profile/${loginMember.teacherImg}')">
                        <!-- <img class="camera" src="https://front-img.taling.me/Content/Images/Tutor/Images/btn_pfimg.png">
                        <input type="file" id="picture" name="picture"> -->
                    </div>
                </div>
                <div class="profile_area">
                    <div class="label_title">ID</div>
                    <div class="label_content">${teacher.memberEmail}</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">전화번호</div>
                    <div class="label_content"><input type="text" name="phone" id="phone" class="profile_input" value="${teacher.memberPno}"></div>
                </div>
                <div class="profile_area">
                    <div class="label_title">이름</div>
                    <div class="label_content">${teacher.memberNm}</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">생년월일</div>
                    <div class="label_content">${teacher.memberBirth}</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">강사소개</div>
                    <div class="label_content">
                        <textarea placeholder="-경력&#13;&#10;-재능 및 경험담" id="introduce" name="introduce" maxlength="1000">${teacher.teacherIntro}</textarea>
                    </div>
                </div>
                <div class="profile_area">
                    <div class="label_title" id="check">이력(권장사항)</div>
                    <div class="label_content">
                    
                       	<c:forEach items="${careerList}" var="career" varStatus="status">
	                        <div id="record_area">
	                            <input type="text" class="profile_input" value="${career.careerContent}" disabled>
	                            <div class="upload_area" id="career_${career.careerNo}">
	                                <div class="upload_img">
	                                    <img class="preview img_img_not_update" src="${contextPath}${career.imgPath}${career.imgName}">
	                                    <input type="file" class="profile_file talent_img" disabled>
	                                </div>
	                                <div class='close_record' onclick='close_record_function(this,0)'>삭제</div>
	                            </div>
                        	</div>
                        </c:forEach>
                        
                        <button type="button" class="record_add">+ 이력 추가</button>

                        <div id="input_sns">
                            <p>소셜 미디어<em>(권장사항, 링크는 https:// 로 시작해야 합니다)</em></p>

							<c:forEach items="${snsList}" var="sns">
								<c:if test="${sns.snsDiv == 1}">
		                            <div class="instagram_area sns_area">
		                                <input type="url" name="instagram" id ="instagram"class="sns_link" placeholder="인스타그램" value="${sns.snsLink}">
		                            </div>
	                            </c:if>	
							
								<c:if test="${sns.snsDiv == 2}">
		                            <div class="blog_area sns_area">
		                                <input type="url" name="blog" id ="blog"class="sns_link" placeholder="블로그(네이버, 브런치, 티스토리 등) 주소를 입력해 주세요." value="${sns.snsLink}">
		                            </div>
	                            </c:if>	
							
								<c:if test="${sns.snsDiv == 3}">
		                            <div class="youtube_area sns_area">
										<input type="url" name="youtube" id ="youtube"class="sns_link" placeholder="유튜브 주소를 입력해 주세요." value="${sns.snsLink}">
		                            </div>
	                            </c:if>	
							</c:forEach>  
	                            
	                        <c:if test="${empty snsList}">
	                        	<div class="instagram_area sns_area">
                                	<input type="url" name="instagram" id ="instagram"class="sns_link" placeholder="인스타그램">
	                            </div>
	                            <div class="blog_area sns_area">
	                                <input type="url" name="blog" id ="blog"class="sns_link" placeholder="블로그(네이버, 브런치, 티스토리 등) 주소를 입력해 주세요.">
	                            </div>
	                            <div class="youtube_area sns_area">
	                                <input type="url" name="youtube" id ="youtube"class="sns_link" placeholder="유튜브 주소를 입력해 주세요.">
	                            </div>
	                        </c:if>
	                        
	                        <!-- 1개 || 2개만 sns가 등록되어 있을 경우; 입력안된 sns 보여주기 -->
	                        <c:forEach items="${snsDivList}" var="snsDiv">
	                        	<c:if test="${snsDiv == 1}">
	                        		<div class="instagram_area sns_area">
                                		<input type="url" name="instagram" id ="instagram"class="sns_link" placeholder="인스타그램">
	                            	</div>
	                        	</c:if>
	                        	
	                        	<c:if test="${snsDiv == 2}">
	                        		<div class="blog_area sns_area">
	                                	<input type="url" name="blog" id ="blog"class="sns_link" placeholder="블로그(네이버, 브런치, 티스토리 등) 주소를 입력해 주세요.">
	                            	</div>
	                        	</c:if>
	                        	
	                        	<c:if test="${snsDiv == 3}">
		                            <div class="youtube_area sns_area">
		                                <input type="url" name="youtube" id ="youtube"class="sns_link" placeholder="유튜브 주소를 입력해 주세요.">
		                            </div>
	                        	</c:if>
	                        </c:forEach>
								                        
                        </div>
                    </div>
                    
                </div>
            </div>
           
        </form>
    </main>
    
</div>

<script>
	const contextPath = "${contextPath}";
</script>

<jsp:include page="../common/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/teacherProfile.js"></script>


