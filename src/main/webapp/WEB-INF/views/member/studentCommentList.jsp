<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />

<link rel="stylesheet" href="${contextPath}/resources/css/studentCommentList.css" />
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />



<div class="container">
        <main>
            <jsp:include page="../common/studentMypageSidebar.jsp"></jsp:include>

            <div class="right">
                <div class="title">
                    <p><span>000</span>님이 작성한 후기</p>
                </div>

                <div class="table">
                    <div class="row">
                        <div class="column table-column">번호</div>
                        <div class="column table-column">클래스명 - 회차</div>
                        <div class="column table-column">강사명</div>
                        <div class="column table-column">평점</div>
                        <div class="column table-column">후기 내용</div>
                        <div class="column table-column"></div>
                    </div>
                    <%--
                    <div class="row">
                        <div class="column">1</div>
                        <div class="column">클래스명1</div>
                        <div class="column">수강 예정</div>
                        <div class="column">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star-half-alt"></i>
                            <i class="far fa-star"></i>
                        </div>
                        <div class="column">선생님이 너무 친절하세요.  강의도 ...</div>
                        <div class="column slide">
                            <i class="fas fa-angle-down"></i>
                        </div>
                    </div>
                    <div class="invisible">
                        <div class="invisible-btn">
                            <button class="review-modal-btn"><i class="far fa-edit"></i> 수정</button>
                            <button><i class="far fa-trash-alt"></i> 삭제</button>
                        </div>
                    </div>
                    --%>

					<c:choose>
						<c:when test="${empty review}">
							<div>응 후기안쓰면 그만이야~</div>
						</c:when>
						<c:otherwise>
							<c:forEach items="${review}" var="rv">
			                    <div class="row">
			                        <div class="column">${rv.reviewNo}</div>
			                        <div class="column">${rv.className} (${rv.epCount}회차)</div>
			                        <div class="column">${rv.memberName}</div>
			                        <div class="column">
			                        	<c:if test="${rv.reviewStar == 5}">
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
			                        	</c:if>
			                        	<c:if test="${rv.reviewStar == 4}">
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="far fa-star"></i>
			                        	</c:if>
			                        	<c:if test="${rv.reviewStar == 3}">
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="far fa-star"></i>
				                            <i class="far fa-star"></i>
			                        	</c:if>
			                        	<c:if test="${rv.reviewStar == 2}">
				                            <i class="fas fa-star"></i>
				                            <i class="fas fa-star"></i>
				                            <i class="far fa-star"></i>
				                            <i class="far fa-star"></i>
				                            <i class="far fa-star"></i>
			                        	</c:if>
			                        	<c:if test="${rv.reviewStar == 1}">
				                            <i class="fas fa-star"></i>
				                            <i class="far fa-star"></i>
				                            <i class="far fa-star"></i>
				                            <i class="far fa-star"></i>
				                            <i class="far fa-star"></i>
			                        	</c:if>
			                        </div>
			                        <div class="column">${rv.reviewContent}</div>
			                        <div class="column slide">
			                            <i class="fas fa-angle-down"></i>
			                        </div>
			                    </div>
			                    <div class="invisible">
			                        <div class="invisible-btn">
			                        	<div style="display:none;">${rv.reviewStar}</div>
			                            <button class="review-modal-btn"><i class="far fa-edit"></i> 수정</button>
			                            <button class="review-delete-btn"><i class="far fa-trash-alt"></i> 삭제</button>
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
						                <li><a href="studentCommentList?cp=${i}">${i}</a></li>
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

        <div id="review-modal">
            <div class="modal-content">
                <form action="${contextPath}/member/updateComment" method="POST" onsubmit="return starClick();">
                    <div class="modal-title">
                        <h2>후기 수정</h2>
                    </div>
    
                    <div class="modal-classname">
                        <p id="className">'클래스명1' - 홍길동</p>
                        <input id="review-reviewNo" type="hidden" name="reviewNo"/>
                    </div>

                    <div id="changeStar" class="score">
                        평점 : 
                        <!-- <i class="fas fa-star"></i> -->
                        <i class="far fa-star"><span>1</span></i>
                        <i class="far fa-star"><span>2</span></i> 
                        <i class="far fa-star"><span>3</span></i>
                        <i class="far fa-star"><span>4</span></i>
                        <i class="far fa-star"><span>5</span></i>
                    </div>
                    
                    <textarea id="reviewContent" name="reviewContent" class="modal-comment" placeholder="댓글 내용 작성." required></textarea>

                    <input id="reviewStar" type="hidden" name="reviewStar"/>

                    <div class="modal-btn">
                        <button type="submit">수정하기</button>
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
	$(".left > .list > div:nth-of-type(3)").addClass("selected");
	
	
    // 모달 열기
    $(".review-modal-btn").click(function (e) {
        $("#review-modal").fadeIn(100);
        $("#review-modal").css("display", "flex");
        
        const star = e.target.parentNode.childNodes[1].innerText;
        
        // 별점
        if(star == 1){
        	$("#changeStar").html();
        	$("#changeStar").html('<i class="fas fa-star"><span>1</span></i><i class="far fa-star"><span>2</span></i><i class="far fa-star"><span>3</span></i><i class="far fa-star"><span>4</span></i><i class="far fa-star"><span>5</span></i>');
        	const star = e.target.childNodes[0].innerText;
        	$("#reviewStar").val(1);
        }else if(star == 2){
        	$("#changeStar").html();
        	$("#changeStar").html('<i class="fas fa-star"><span>1</span></i><i class="fas fa-star"><span>2</span></i><i class="far fa-star"><span>3</span></i><i class="far fa-star"><span>4</span></i><i class="far fa-star"><span>5</span></i>');
        	const star = e.target.childNodes[0].innerText;
        	$("#reviewStar").val(2);
        }else if(star == 3){
        	$("#changeStar").html();
        	$("#changeStar").html('<i class="fas fa-star"><span>1</span></i><i class="fas fa-star"><span>2</span></i><i class="fas fa-star"><span>3</span></i><i class="far fa-star"><span>4</span></i><i class="far fa-star"><span>5</span></i>');
        	const star = e.target.childNodes[0].innerText;
        	$("#reviewStar").val(3);
        }else if(star == 4){
        	$("#changeStar").html();
        	$("#changeStar").html('<i class="fas fa-star"><span>1</span></i><i class="fas fa-star"><span>2</span></i><i class="fas fa-star"><span>3</span></i><i class="fas fa-star"><span>4</span></i><i class="far fa-star"><span>5</span></i>');
        	const star = e.target.childNodes[0].innerText;
        	$("#reviewStar").val(4);
        }else if(star == 5){
        	$("#changeStar").html();
        	$("#changeStar").html('<i class="fas fa-star"><span>1</span></i><i class="fas fa-star"><span>2</span></i><i class="fas fa-star"><span>3</span></i><i class="fas fa-star"><span>4</span></i><i class="fas fa-star"><span>5</span></i>');
        	const star = e.target.childNodes[0].innerText;
        	$("#reviewStar").val(5);
        }else{
        	$("#changeStar").html();
        	$("#changeStar").html('<i class="fas fa-star"><span>1</span></i><i class="far fa-star"><span>2</span></i><i class="far fa-star"><span>3</span></i><i class="far fa-star"><span>4</span></i><i class="far fa-star"><span>5</span></i>');
        	const star = e.target.childNodes[0].innerText;
        	$("#reviewStar").val(1);
        }
        
        
        
        const reviewNo = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[1].innerText;
        const classNm = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[3].innerText;
        const teacher = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[5].innerText;
        const content = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[9].innerText;
        const sum = classNm + " - " + teacher;
        $("#className").html(sum);
        $("#reviewContent").val(content);
        $("#review-reviewNo").val(reviewNo);
    });

    // 모달 닫기 버튼
    $(".modal-close-btn").click(function () {
        $("#review-modal").fadeOut(100);
    });

    // 모달 밖에 클릭시 모달 닫기
    $("#review-modal").click(function (e) {
        if($(e.target).hasClass('modal-layer')) {
            $("#review-modal").fadeOut(100);
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
    	//checkStar = true;
    });

    /*
    // 별점은 꼭 눌러라
    function starClick(){
    	if(checkStar != true){
    		alert("별점을 선택해주세요.");
    		return false;
    	}
    }
    */
    
    // 후기 삭제
    $(".review-delete-btn").on("click", function(e){
    	if(confirm("정말로 후기를 삭제하시겠습니까?")){
    		
    		const reviewNo = e.target.parentNode.parentNode.previousSibling.previousSibling.childNodes[1].innerText;
    		
    		$.ajax({
                url : "deleteReview",      
                data : {"reviewNo" : reviewNo},  
                type : "POST",               
                success : function(result){
            		e.target.parentNode.parentNode.previousSibling.previousSibling.remove();
            		e.target.parentNode.parentNode.remove();
                	alert("후기가 삭제되었습니다.");
                	//console.log(e.target.parentNode.parentNode);
                	//console.log(e.target.parentNode.parentNode.previousSibling.previousSibling);

            		
                },

                error : function(){}

            });
    	}
    })
    
    

</script>
