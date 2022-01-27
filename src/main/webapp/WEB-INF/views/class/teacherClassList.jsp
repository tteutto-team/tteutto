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
            </div>

            <div class="right">
                <div class="right-top">
                    <p><span>'홍길동'</span>님의 클래스 목록</p>
                    <button class="new-class modal-open-btn" id="new-class">새 클래스 열기</button>
                </div>

                <div class="table">
                    <!-- <div class="row">
                        <div class="column table-colunm">번호</div>
                        <div class="column table-colunm">클래스명</div>
                        <div class="column table-colunm">클래스 상태</div>
                        <div class="column table-colunm">수강 기간</div>
                        <div class="column table-colunm">학생 관리</div>
                        <div class="column table-colunm">삭제 여부</div>
                        <div class="column table-colunm">정산</div>
                    </div> -->
                    <div class="row">
                        <div class="column table-colunm">번호</div>
                        <div class="column table-colunm">클래스명</div>
                        <div class="column table-colunm"></div>
                    </div>

                    <div class="row">
                        <div class="column">1</div>
                        <div class="column">클래스1</div>
                        <div class="column slide">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </div>
                    <div class="invisible-a">
                        <div class="invisible-btn">
	                        <div class="column">1</div>
	                        <div class="column">클래스명1</div>
	                        <div class="column">교육 예정</div>
	                        <div class="column">22/03/01 ~ 22/04/01</div>
	                        <div class="column"><button class="modal-open-btn" onclick="location.href = 'studentListOngoing.html';">관리</button></div>
	                        <div class="column">삭제 요청됨</div>
	                        <div class="column">정산 예정</div>
                        </div>
                        <div class="invisible-btn">
	                        <div class="column">1</div>
	                        <div class="column">클래스명1</div>
	                        <div class="column">교육 예정</div>
	                        <div class="column">22/03/01 ~ 22/04/01</div>
	                        <div class="column"><button class="modal-open-btn" onclick="location.href = 'studentListOngoing.html';">관리</button></div>
	                        <div class="column">삭제 요청됨</div>
	                        <div class="column">정산 예정</div>
                        </div>
                        <div class="invisible-btn">
	                        <div class="column">1</div>
	                        <div class="column">클래스명1</div>
	                        <div class="column">교육 예정</div>
	                        <div class="column">22/03/01 ~ 22/04/01</div>
	                        <div class="column"><button class="modal-open-btn" onclick="location.href = 'studentListOngoing.html';">관리</button></div>
	                        <div class="column">삭제 요청됨</div>
	                        <div class="column">정산 예정</div>
                        </div>
                    </div>
					
					<div class="row">
                        <div class="column">2</div>
                        <div class="column">클래스2</div>
                        <div class="column slide">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="column">3</div>
                        <div class="column">클래스3</div>
                        <div class="column slide">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="column">4</div>
                        <div class="column">클래스4</div>
                        <div class="column slide">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </div>
					
			



                    <!-- <div class="row">
                        <div class="column">1</div>
                        <div class="column">클래스명1</div>
                        <div class="column">교육 예정</div>
                        <div class="column">22/03/01 ~ 22/04/01</div>
                        <div class="column"><button class="modal-open-btn" onclick="location.href = 'studentListOngoing.html';">관리</button></div>
                        <div class="column">삭제 요청됨</div>
                        <div class="column">정산 예정</div>
                    </div>

                    <div class="row">
                        <div class="column">2</div>
                        <div class="column">클래스명2</div>
                        <div class="column">교육 예정</div>
                        <div class="column">22/03/01 ~ 22/04/01</div>
                        <div class="column"><button class="modal-open-btn" onclick="location.href = 'studentListExpect.html';">관리</button></div>
                        <div class="column"><button class="modal-open-btn delete">삭제 요청</button></div>
                        <div class="column">정산 예정</div>
                    </div>

                    <div class="row">
                        <div class="column">3</div>
                        <div class="column">클래스명3</div>
                        <div class="column">교육중</div>
                        <div class="column">22/03/01 ~ 22/04/01</div>
                        <div class="column"><button class="modal-open-btn">관리</button></div>
                        <div class="column"><button class="modal-open-btn delete">삭제 요청</button></div>
                        <div class="column"><button class="modal-open-btn calculation">신청</button></div>
                    </div>

                    <div class="row">
                        <div class="column">4</div>
                        <div class="column">클래스명4</div>
                        <div class="column">교육중</div>
                        <div class="column">22/03/01 ~ 22/04/01</div>
                        <div class="column"><button class="modal-open-btn">관리</button></div>
                        <div class="column"><button class="modal-open-btn delete">삭제 요청</button></div>
                        <div class="column">요청됨</div>
                    </div>

                    <div class="row">
                        <div class="column">5</div>
                        <div class="column">클래스명5</div>
                        <div class="column">교육 완료</div>
                        <div class="column">22/03/01 ~ 22/04/01</div>
                        <div class="column"><button class="modal-open-btn">관리</button></div>
                        <div class="column"></div>
                        <div class="column"><button class="modal-open-btn receipt">영수증</button></div>
                    </div>
                    
                     -->
                    
                    
                </div>
                <div class="page-number">
                    <ul class="page-ul">
                        <li>
                            <a href="#"><i class="fas fa-angle-double-left"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fas fa-angle-left"></i></a>
                        </li>
                        
                        <li style="border-radius: 50%; background-color: #FFDF3E;">
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

        <!-- 삭제 모달 -->
        <div id="modal" class="delete-request modal">
            <div class="modal-content">
                <form action="#" method="post">
                    <div class="modal-title">
                        <h2>삭제 요청</h2>
                    </div>
    
                    <div class="modal-classname">
                        <p>'클래스명1 - 동길홍'</p>
                    </div>
                    
                    <textarea name="" id="modal-report" placeholder="삭제 사유를 입력해주세요."></textarea>

                    <input type="hidden">

                    <div id="modal-btn">
                        <button>보내기</button>
                        <button type="button" id="modal-close-btn" class="modal-close-btn">취소</button>
                    </div>
                </form>
            </div>

            <div class="modal-layer"></div>
        </div>

        <!-- 영수증 모달 -->
        <div id="modal" class="receipt-request modal">
            <div class="modal-content">
                <div class="modal-title">
                    <h2>영수증</h2>
                </div>

                <div class="modal-classname">
                    <p>'클래스명1 - 동길홍'</p>
                </div>
                
                <div class="modal-main" style="flex: none;">
                    
        
                    <table class="receipt-table">
                        <thead>
                            <th>No</th>
                            <th>학생 이름</th>
                            <th>가격</th>
                        </thead>
    
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>학생1</td>
                                <td>10000</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>학생2</td>
                                <td>10000</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>학생3</td>
                                <td>10000</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>학생4</td>
                                <td>40000</td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>학생5</td>
                                <td>40000</td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>학생66</td>
                                <td>40000</td>
                            </tr>
                            <tr>
                                <td>7</td>
                                <td>학생66</td>
                                <td>40000</td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td>학생66</td>
                                <td>40000</td>
                            </tr>
                            <tr>
                                <td>9</td>
                                <td>학생66</td>
                                <td>40000</td>
                            </tr>

                        </tbody>
                    </table>
                </div>
                
                <div>
                    <p><span style="font-weight:bold; margin-right: 12px;">교육 기간: </span> 21/04/02 ~ 21/04/02</p>
                    <p><span style="font-weight:bold; margin-right: 12px;">총 정산 금액: </span> 100,000</p>
                </div>
                
                <div id="modal-btn">
                    <button type="button" id="modal-close" class="modal-close-btn">닫기</button>
                </div>
            </div>

            <div class="modal-layer"></div>
        </div>
    
        <!-- 클래스 열기 모달 -->
        <div id="modal" class="class-open modal">
            <div class="modal-content" style="position: relative;">
                <!-- <form action="#" method="post"> -->
                    <div class="modal-title">
                        <h2>클래스 오픈</h2>
                    </div>
                    
                    <div id="modal-btn">
                        <button id="new" style="height: 50px;">클래스 새로 만들기</button>
                        <button type="button" id="existing" style="height: 50px;">기존 클래스 이어 열기</button>
                    </div>

                    <!-- 옵션 선택 -->
                    <article class="cont-select class-list">
                        <button class="btn-select">강의 목록</button>
                        <ul class="list-member">
                            <li><button type="button">수강1</button></li>
                            <li><button type="button">수강2</button></li>
                            <li><button type="button">수강3</button></li>
                            <li><button type="button">수강4</button></li>
                            <li><button type="button">수강5</button></li>
                        </ul>
                        <button class="existing-class-select">열기</button>
                    </article>
                <!-- </form> -->
                <button type="button" id="modal-close-btn" class="modal-close-btn new-class-modal-close" style="background: none;" >X</button>
            </div>

            <div class="modal-layer"></div>
        </div>


    </div>
    
    <jsp:include page="../common/footer.jsp"/>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    
	<script>
	
	    // 모달 열기
	    $(".modal-open-btn").click(function () {
	        /* $("#modal").fadeIn(100);
	        $("#modal").css("display", "flex"); */
	
	        if($(this).hasClass("receipt")){
	            $(".receipt-request").fadeIn(100);
	            $(".receipt-request").css("display", "flex");
	        }
	
	        if($(this).hasClass("delete")){
	        	console.log("삭제");
	            $(".delete-request").fadeIn(100);
	            $(".delete-request").css("display", "flex");
	        }
	
	        if($(this).hasClass("new-class")){
	            $(".class-open").fadeIn(100);
	            $(".class-open").css("display", "flex");
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
	
	    /* 기존 강좌 이어열기 클릭시 */
	    $("#existing").on("click", function(){
	        if($(".class-list").css('display') === 'none'){
	            $(".class-list").css("display","flex");
	        }
	        else{
	            $(".class-list").css("display","none");
	        }
	    })
	
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