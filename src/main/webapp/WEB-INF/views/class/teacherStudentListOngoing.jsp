<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<jsp:include page="../common/header.jsp"/>

<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
<link rel="stylesheet" href="${contextPath}/resources/css/teacherClassList.css"/>

<div class="container">
        <main>
            <div class="left">
                <div class="box">
                    <img src="${contextPath}/resources/images/teacher/profile/${loginMember.teacherImg}">
                </div>
                <div class="name">${loginMember.memberNm}</div>
                <div class="introduce">안녕하세요. 만나서 반갑습니다.</div>

                <div class="list">
                    <div onclick="location.href='${contextPath}/member/teacherProfile'">강사 프로필</div>
                    <div class="selected" onclick="location.href='${contextPath}/teacher/classList/${loginMember.memberNo}'">클래스 목록</div>
                </div>
                <button onclick="location.href='${contextPath}/teacher/classList/${loginMember.memberNo}'">목록으로</button>
            </div>

            <div class="right">
	            <div class="right-top">
	                <p><span id="class-episode-name">${ongoingClassList[0].className}-${ongoingClassList[0].epCount}</span> 학생 목록 <span id="class-status">(진행 중)</span></p>
				</div>
				
                <div class="table">
                    <div class="row">
                        <div class="column">번호</div>
                        <div class="column">학생 이름</div>
                        <div class="column">성별</div>
                        <div class="column">신고 횟수</div>
                        <div class="column"></div>
                    </div>
                    
					<c:forEach items="${ongoingClassList}" var="ongoingClass" varStatus="status">
						<c:if test="${!empty ongoingClass.studentName}">
	                    
	                    <div class="row">
	                        <div class="column">${status.count}</div>
	                        <div class="column studentName" id="${ongoingClass.studentNo}">${ongoingClass.studentName}</div>
	                        <div class="column">${ongoingClass.memberGender}</div>
	                        <div class="column">${ongoingClass.reportCount}회</div>
	                        <div class="column slide">
	                            <i class="fas fa-angle-down"></i>
	                        </div>
	                    </div>
	                    <div class="invisible">
	                        <div class="invisible-btn" id="student_${ongoingClass.studentNo}">
	                            <button><i class="far fa-comment"></i> 채팅</button>
	                            <button class="modal-open-btn report"><i class="fas fa-exclamation-triangle"></i> 신고</button>
	                        </div>
	                    </div>
	                    
						</c:if>
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
						                <li><a href="?page=${i}">${i}</a></li>
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


        <!-- 신고 모달 -->
        <div id="modal" class="report-request modal">
            <div class="modal-content">
	            <div class="modal-title">
	                <h2>신고 요청</h2>
	            </div>
	
	            <div class="modal-classname">
	                <p class="modal-classname-student"></p>
	            </div>
	            
	            <textarea class="detail-reason" id="modal-report" placeholder="신고 사유를 입력해주세요."></textarea>
	
	            <input type="hidden">
	
	            <div id="modal-btn">
	                <button class="report-submit" onclick="reportSubmit()">보내기</button>
	                <button type="button" id="modal-close-btn" class="modal-close-btn">취소</button>
	            </div>
            </div>

            <div class="modal-layer"></div>
        </div>

    </div>

	<script>
    	const contextPath = "${contextPath}";
    	const epNo = "${epNo}";
    </script>
	<jsp:include page="../common/footer.jsp"/>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="${contextPath}/resources/js/teacherClassOngoing.js"></script>