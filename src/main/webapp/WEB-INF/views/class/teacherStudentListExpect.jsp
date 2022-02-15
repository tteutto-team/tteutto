<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<style>
	.row{
		height: 55px;
	}
	
 	.page-a{
		height : 28px;
		padding-top:5px;
	}
	
	.icon-search:before {
    	margin-top: 12.5px;
	}
	
	.icon-open:before,.icon-close:before {
    	margin-top: 39.5px;
	}
</style>

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
                <div class="introduce">뜨또에 오신걸 환영합니다.</div>

                <div class="list">
                    <div onclick="location.href='${contextPath}/member/teacherProfile'">강사 프로필</div>
                    <div class="selected" onclick="location.href='${contextPath}/teacher/classList/${loginMember.memberNo}'">클래스 목록</div>
                </div>
                <button onclick="location.href='${contextPath}/teacher/classList/${loginMember.memberNo}'">목록으로</button>
            </div>

            <div class="right">
            	<div class="right-top">
	                <p><span id="class-episode-name">${episodeInfo.classNm} - ${episodeInfo.epCount}</span> 학생 목록 <span id="class-status">(진행 예정)</span></p>
            	</div>

                <div class="table">
                    <div class="row">
                        <div class="column">번호</div>
                        <div class="column">학생 이름</div>
                        <div class="column">채팅</div>
                        <div class="column">수강 거절</div>
                    </div>

					<c:forEach items="${studentList}" var="student" varStatus="status">
	                    <div class="row">
	                        <div class="column">${status.count}</div>
	                        <div class="column">${student.memberNm}</div>
	                        <div class="column"><button class="modal-open-btn" onclick="window.open('${contextPath}/chat/chatRoom?classNo=${episodeInfo.classNo}&studentNo=${student.memberNo}&mode=1','채팅창 목록','width=482,height=700,location=no,status=no,scrollbars=yes');">채팅</button></div>
	                        <div class="column"><button class="reject modal-open-btn" onclick="reject(${student.memberNo}, this)">수강 거절</button></div>
	                    </div>
					</c:forEach>

                </div>

                <%-- 페이지네이션 --%>
				<c:if test="${pagination.maxPage > 1}">
			        <div class="page-number">
			            <ul class="page-ul">
			            	<c:if test="${pagination.currentPage != 1}">
				            	<%-- 이전 리스트로 이동 --%>
				                <li><a class="page-a" href="${contextPage}/tteutto/teacher/studentListExpect?epNo=${epNo}&page=1"><i class="fas fa-angle-double-left"></i></a></li>
				                <%-- 이전 페이지로 이동 --%>
				                <li><a class="page-a" href="${contextPage}/tteutto/teacher/studentListExpect?epNo=${epNo}&page=${pagination.prevPage}"><i class="fas fa-angle-left"></i></a></li>
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
						                <li><a href="?epNo=${epNo}&page=${i}">${i}</a></li>
					                </c:otherwise>
				                </c:choose>
			                </c:forEach>
			                
			                <c:if test="${pagination.currentPage != pagination.maxPage}">
				                <%-- 다음 페이지로 이동 --%>
				                <li><a class="page-a" href="${contextPage}/tteutto/teacher/studentListExpect?epNo=${epNo}&page=${pagination.nextPage}"><i class="fas fa-angle-right"></i></a></li>
				                <%-- 다음 리스트로 이동 --%>
				                <li><a class="page-a" href="${contextPage}/tteutto/teacher/studentListExpect?epNo=${epNo}&page=${pagination.maxPage}"><i class="fas fa-angle-double-right"></i></a></li>
			                </c:if>
			            </ul>
			        </div>
		        </c:if>
                
                
            </div>
        </main>
    </div>
    
    
    
    
    <script>
    	const contextPath = "${contextPath}";
    	const epNo = "${epNo}";
    </script>
    
    <jsp:include page="../common/footer.jsp"/>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="${contextPath}/resources/js/teacherClassExpect.js"></script>
