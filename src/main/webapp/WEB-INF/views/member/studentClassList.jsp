<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />

<link rel="stylesheet" href="${contextPath}/resources/css/studentClassList.css" />
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />



<div class="container">
        <main>
            <jsp:include page="../common/studentMypageSidebar.jsp"></jsp:include>

            <div class="right">
                <div class="title">
                    <p><span>000</span>님의 클래스 목록</p>
                </div>

                <div class="table">
                    <div class="row">
                        <div class="column table-column">번호</div>
                        <div class="column table-column">클래스명</div>
                        <div class="column table-column">클래스 상태</div>
                        <div class="column table-column">수강 기간</div>
                        <div class="column table-column">환불 여부</div>
                        <div class="column table-column">환불 금액</div>
                        <div class="column table-column"></div>
                    </div>
                    <%-- 
                    <div class="row">
                        <div class="column">1</div>
                        <div class="column">클래스명1</div>
                        <div class="column">수강 예정</div>
                        <div class="column">22/03/01 ~ 22/04/01</div>
                        <div class="column">-</div>
                        <div class="column">-</div>
                        <div class="column slide">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </div>
                    <div class="invisible">
                        <div class="invisible-btn">
                            <button><i class="far fa-comment"></i> 채팅</button>
                            <button class="review-modal-btn"><i class="fas fa-pen"></i> 후기</button>
                            <button class="report-modal-btn"><i class="fas fa-exclamation-triangle"></i> 신고</button>
                            <button><i class="fas fa-wallet"></i> 환불</button>
                        </div>
                    </div>
                    --%>
                    
                    <c:choose>
                    	<c:when test="${empty register}">
                    		<div>응 공부안하면 그만이야~</div>
                    	</c:when>
                    	<c:otherwise>
		                    <c:forEach items="${register}" var="rg">
			                    <div class="row">
			                        <div class="column">${rg.regNo}</div>
			                        <div class="column">${rg.className}</div>
			                        <div class="column">${rg.classStatus}</div>
			                        <div class="column">${rg.dtTerm}</div>
			                        <div class="column">
			                        	<c:if test="${empty rg.refundStatus}">-</c:if>
			                        	<c:if test="${rg.refundStatus == 0}">접수완료</c:if>
			                        	<c:if test="${rg.refundStatus == 1}">승인</c:if>
			                        	<c:if test="${rg.refundStatus == 2}">거절</c:if>
			                        </div>
			                        <div class="column">
			                        	<c:if test="${empty refundMoney}">-</c:if>
			                        	<c:if test="${!empty refundMoney}">${rg.refundMoney}</c:if>
			                        </div>
			                        <div class="column slide">
			                            <i class="fas fa-angle-down"></i>
			                        </div>
			                    </div>
			                    <div class="invisible">
			                        <div class="invisible-btn">
			                        	
				                        <button class="chat-btn" type="button"><i class="far fa-comment"></i> 채팅</button>
				                        <div style="display:none;">${rg.memberNo}</div>
				                        
			                            <button class="review-modal-btn"><i class="fas fa-pen"></i> 후기</button>
			                            <button class="report-modal-btn"><i class="fas fa-exclamation-triangle"></i> 신고</button>
			                            <form action="${contextPath}/member/refundClass" class="refundCheck" method="POST" onsubmit="return refundCheck();">
			                            	<button class="refund-btn"><i class="fas fa-wallet"></i> 환불</button>
			                            	<input type="hidden" name="regNo" value="${rg.regNo}">
			                            	<input type="hidden" name="epNo" value="${rg.epNo}">
										</form>			                            	
			                            <div style="display:none;">${rg.memberNm}</div>
			                            <div style="display:none;">${rg.epNo}</div>
			                        </div>
			                    </div>
		                    </c:forEach>	
                    	</c:otherwise>
                    </c:choose>
                    

                </div>
                
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
						                <li><a href="studentClassList?cp=${i}">${i}</a></li>
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
		        
            </div>
        </main>


        <!-- 신고하기 모달창 -->
        <div id="report-modal">
            <div class="modal-content">
                <form action="${contextPath}/member/insertReport" method="POST">
                    <div class="modal-title">
                        <h2>신고하기</h2>
                    </div>
    
                    <div class="modal-classname">
                        <p id=report-class-Nm>'클래스명1'</p>
                        <input id="report-regNo" type="hidden" name="regNo"/>
                    </div>
                    
                    <textarea name="reportContent" class="modal-textarea" placeholder="신고사유를 입력해주세요." required></textarea>

                    <input type="hidden">

                    <div class="modal-btn">
                        <button type="submit">보내기</button>
                        <button type="button" class="modal-close-btn">취소</button>
                    </div>
                </form>
            </div>

            <div class="modal-layer"></div>
        </div>


        <!-- 후기 작성 모달창 -->
        <div id="review-modal">
            <div class="modal-content">
                <form action="${contextPath}/member/insertComment" method="POST" onsubmit="return starClick();">
                    <div class="modal-title">
                        <h2>후기 작성</h2>
                    </div>
    
                    <div class="modal-classname">
                        <p id="review-class-name">'클래스명1' - 강사명</p>
                        <input id="review-regNo" type="hidden" name="regNo"/>
                    </div>
                    
                    <div class="score">
                        평점 : 
                        <!-- <i class="fas fa-star"></i> -->
                        <i class="far fa-star"><span>1</span></i>
                        <i class="far fa-star"><span>2</span></i> 
                        <i class="far fa-star"><span>3</span></i>
                        <i class="far fa-star"><span>4</span></i>
                        <i class="far fa-star"><span>5</span></i>
                    </div>
                    
                    <textarea name="reviewContent" class="modal-textarea" placeholder="후기를 작성해주세요." required></textarea>

                    <input id="reviewStar" type="hidden" name="reviewStar"/>

                    <div class="modal-btn">
                        <button type="submit">작성완료</button>
                        <button type="button" class="modal-close-btn">취소</button>
                    </div>
                </form>
            </div>

            <div class="modal-layer"></div>
        </div>

    </div>

<jsp:include page="../common/footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	$(".left > .list > div:nth-of-type(2)").addClass("selected");


    // 후기 모달 열기
    $(".review-modal-btn").click(function (e) {
    	
    	const regNo = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[1].innerText;
    	
    	$.ajax({
            url : "searchReview",      
            data : {"regNo" : regNo},  
            type : "POST",               
            success : function(result){
        		if(result > 0){
        			alert("이미 이 클래스에 대한 후기를 작성했습니다.");
        			
        		}else{
        			
        			$("#review-modal").fadeIn(100);
        	        $("#review-modal").css("display", "flex");
        	        
        	        const teacherNm = e.target.parentNode.childNodes[9].innerText;
        	        const classNm = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[3].innerText;
        			const tc = classNm + ' - ' + teacherNm

        	        $("#review-class-name").html(tc);
        	        $("#review-regNo").val(regNo);
        		}
            },

            error : function(){}

        });
    	

    });

    // 모달 밖에 클릭시 모달 닫기
    $("#review-modal").click(function (e) {
        if($(e.target).hasClass('modal-layer')) {
            $("#review-modal").fadeOut(100);
        }

    });

    // 신고 모달 열기
    $(".report-modal-btn").click(function (e) {
    	
    	const regNo = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[1].innerText;
    	
    	$.ajax({
            url : "searchReport",      
            data : {"regNo" : regNo},  
            type : "POST",               
            success : function(result){
        		if(result > 0){
        			alert("이미 이 클래스에 대한 신고를 작성했습니다.");
        	        
        		}else{
        			
        			$("#report-modal").fadeIn(100);
        	        $("#report-modal").css("display", "flex");
        	       
        	        const regNo = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[1].innerText;
        	        const classNm = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[3].innerText;

        	        $("#report-class-Nm").html(classNm);
        	        $("#report-regNo").val(regNo);
        		}
            },

            error : function(){}

        });
    	
    });

    // 모달 닫기 버튼
    $(".modal-close-btn").click(function () {
        $("#report-modal").fadeOut(100);
        $("#review-modal").fadeOut(100);
    });

    // 모달 밖에 클릭시 모달 닫기
    $("#report-modal").click(function (e) {
        if($(e.target).hasClass('modal-layer')) {
            $("#report-modal").fadeOut(100);
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
    
    let checkStar = false;
    
    // 별점스
    $(document).on("click", ".score > i", function(e){
    	$(".score > i").removeClass();
    	$(this).nextAll("i").addClass("far fa-star");
    	$(this).addClass("fas fa-star");
    	$(this).prevAll("i").addClass("fas fa-star");
    	
    	const star = e.target.childNodes[0].innerText;
    	$("#reviewStar").val(star);
    	checkStar = true;
    });
    
    // 별점은 꼭 눌러라
    function starClick(){
    	if(checkStar != true){
    		alert("별점을 선택해주세요.");
    		return false;
    	}
    }
    
    /*
    //환불 눌렀을 때
    $(".refund-btn").on("click", function(e){
    		
    	const regNo = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[1].innerText;
    	const epNo = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[1].innerText;
    	
    		$.ajax({
                url : "refundClass",      
                data : {"regNo" : regNo, "epNo" : epNo},  
                type : "POST",               
                success : function(result){
					if(result > 0){
						
					}else{
						alert("이미 환불 신청이 요청되었습니다.");
						
					}
                },

                error : function(){}

            });
    	
    });*/
    
    function refundCheck(){
    	if(confirm("정말로 환불 신청을 하시겠습니까?")){
    		
    	}else{
    		return false;
    	}
    }
    
    //채팅 눌렀을 때
    $(".chat-btn").on("click", function(e){
    		
    	const teacherNo = e.target.parentNode.childNodes[3].innerText;
    	console.log(teacherNo);
    	
    		$.ajax({
                url : "insertChatRoom",      
                data : {"teacherNo" : teacherNo},  
                type : "POST",               
                success : function(result){
                	/*
					let chatUrl = 'tteutto/chat/chatRoomList';
					if(result > 0){
						console.log("ㅇㅇ")
						window.open(chatUrl, '_blank', 'width=482, height=700, top=200');
					}else{
						console.log("ㅇㅏ")
						window.open(chatUrl, '_blank', 'width=482, height=700, top=200');
						
					}*/
					let chatUrl = '/tteutto/chat/chatRoomList';
                	window.open(chatUrl, '_blank', 'width=482, height=700, top=200');
                },

                error : function(){}

            });
    	
    });
    

</script>