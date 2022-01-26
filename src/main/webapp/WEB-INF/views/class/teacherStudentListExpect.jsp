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
                    <img src="${contextPath}/resources/images/profile/temp.png">
                </div>
                <div class="name">홍길동</div>
                <div class="introduce">안녕하세요. 만나서 반갑습니다.</div>

                <div class="list">
                    <div onclick="location.href='${contextPath}/member/teacherProfile'">강사 프로필</div>
                    <div class="selected" onclick="location.href='${contextPath}/teacher/classList'">클래스 목록</div>
                </div>
                <button onclick="location.href='${contextPath}/teacher/classList'">목록으로</button>
            </div>

            <div class="right">
            	<div class="right-top">
	                <p><span>'클래스1'</span> 학생 목록 <span id="class-status">(교육 예정)</span></p>
            	</div>

                <div class="table">
                    <div class="row">
                        <div class="column">번호</div>
                        <div class="column">학생 이름</div>
                        <div class="column">채팅</div>
                        <div class="column">수강 거절</div>
                        <div class="column">신고</div>
                    </div>

                    <div class="row">
                        <div class="column">1</div>
                        <div class="column">학생1</div>
                        <div class="column"><button class="modal-open-btn">채팅</button></div>
                        <div class="column"><button class="reject modal-open-btn">수강 거절</div>
                        <div class="column"><button class="report modal-open-btn">신고</div>
                    </div>

                    <div class="row">
                        <div class="column">2</div>
                        <div class="column">학생2</div>
                        <div class="column"><button class="modal-open-btn">채팅</button></div>
                        <div class="column"><button class="reject modal-open-btn">수강 거절</div>
                        <div class="column"><button class="report modal-open-btn">신고</div>
                    </div>

                    <div class="row">
                        <div class="column">3</div>
                        <div class="column">학생3</div>
                        <div class="column"><button class="modal-open-btn">채팅</button></div>
                        <div class="column"><button class="reject modal-open-btn">수강 거절</div>
                        <div class="column"><button class="report modal-open-btn">신고</div>
                    </div>
                    
                </div>

                <!-- 페이지 네이션 -->
                <div class="page-number">
                    <ul class="page-ul">
                        <li>
                            <a href="#"><i class="fas fa-angle-double-left"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fas fa-angle-left"></i></a>
                        </li>
                        
                        <li style="border: 1px solid #FFDF3E; border-radius: 50%; background-color: #FFDF3E;">
                            <a style="color: white;">1</a>
                        </li>
                        <li>
                            <a href="#">2</a>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fas fa-angle-right"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fas fa-angle-double-right"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </main>


        <!-- 신고 모달 -->
        <div id="modal" class="report-request modal">
            <div class="modal-content">
                <form action="#" method="post">
                    <div class="modal-title">
                        <h2>신고 요청</h2>
                    </div>
    
                    <div class="modal-classname">
                        <p>'클래스명1 - 학생1'</p>
                    </div>
                    
                    <textarea name="" id="modal-report" placeholder="신고 사유를 입력해주세요."></textarea>

                    <input type="hidden">

                    <div id="modal-btn">
                        <button>보내기</button>
                        <button type="button" id="modal-close-btn" class="modal-close-btn">취소</button>
                    </div>
                </form>
            </div>

            <div class="modal-layer"></div>
        </div>

        <!-- 수강 거절 모달 -->
        <div id="modal" class="reject-request modal" >
            <div class="modal-content">
                <div class="modal-title">
                    <h2>수강 거절</h2>
                </div>

                <div class="modal-classname">
                    <p>'클래스명1 - 동길홍'</p>
                </div>

                <!-- 옵션 선택 -->
                <article class="cont-select">
                    <button class="btn-select">수강 거절 사유</button>
                    <ul class="list-member">
                        <li><button type="button">자리 부족</button></li>
                        <li><button type="button">행동 부적절</button></li>
                    </ul>
                </article>

                <input type="hidden">

                <div id="modal-btn">
                    <button>보내기</button>
                    <button type="button" id="modal-close-btn" class="modal-close-btn">취소</button>
                </div>
            </div>

            <div class="modal-layer"></div>
        </div>
    
    
    </div>
    
    <jsp:include page="../common/footer.jsp"/>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<script>

	    // 모달 열기
	    $(".modal-open-btn").click(function () {
	        // 신고
	        if($(this).hasClass("report")){
	            $(".report-request").fadeIn(100);
	            $(".report-request").css("display", "flex");
	        }
	        // 거절
	        if($(this).hasClass("reject")){
	            $(".reject-request").fadeIn(100);
	            $(".reject-request").css("display", "flex");
	        }
	    });
	
	    // 모달 닫기 버튼
	    $(".modal-close-btn").click(function () {
	        $(".modal").fadeOut(100);
	    });
	
	    // 모달 밖에 클릭시 모달 닫기
	    $(".modal").click(function (e) {
	        if($(e.target).hasClass('modal-layer')) {
	            $(".modal").fadeOut(100);
	        }
	
	    });
	
	    // 슬라이드
	    $(".slide").on("click", function () {
	        if ($(this).parent().next().css("display") == "none") {
	            $(".invisible").slideUp(100);
	            $(".slide").html('<i class="fas fa-angle-down"></i>');
	            $(this).parent().next().slideDown(100);
	            $(this).html('<i class="fas fa-angle-up"></i>');
	
	        } else {
	            $(this).parent().next().slideUp(100);
	            $(this).html('<i class="fas fa-angle-down"></i>');
	
	        }
	    });
	
		/* select-option */
	    const btn = document.querySelector('.btn-select');
	    const list = document.querySelector('.list-member');
	    btn.addEventListener('click', () => {
	        btn.classList.toggle('on');
	    });
	    list.addEventListener('click', (event) => {
	        if (event.target.nodeName === "BUTTON") {
	            btn.innerText = event.target.innerText;
	            btn.classList.remove('on');
	        }
	    });

	</script>