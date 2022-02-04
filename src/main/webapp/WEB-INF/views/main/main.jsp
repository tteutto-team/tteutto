<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<jsp:include page="../common/header.jsp"/>

<!-- 부트스트랩 - 케러셀 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- 아이콘 -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
<link href="${contextPath}/resources/icon/css/uicons-regular-rounded.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/resources/css/main.css"/>

<!-- 캐러셀 -->
<div class="carosel">
    <div id="myCarousel" class="carousel slide product-img">
        <div class="carousel-inner">
            
            <div class="carousel-item active">
                <img src="${contextPath}/resources/images/main/main_1.jpg">
            </div>
            <div class="carousel-item">
                <img src="${contextPath}/resources/images/main/main_2.jpg">
            </div>
            <div class="carousel-item">
                <img src="${contextPath}/resources/images/main/main_3.jpg">
            </div>
            <div class="carousel-item">
                <img src="${contextPath}/resources/images/main/main_4.jpg">
            </div>
        </div>

        <a class="carousel-control-prev" href="#myCarousel" data-slide="prev" style="left: 30px;">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" data-slide="next" style="right: 30px;">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
</div>

<main>
    <!-- 카테고리 -->
    <table class="category">
        <tr>
            <!-- 
            <td> <a class="category-div"><i class="fi-rr-camera"></i><p>공예/디자인</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-computer"></i><p>요리</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-cupcake"></i><p>뷰티/헬스</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-scissors"></i><p>사진/영상</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-brush"></i><p>커리어</p></a></td>
            <td> <a class="category-div"><i class="fi-rr-flower-bouquet"></i><p>음악</p></a></td>
             -->
             
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/design.png')"><p>공예/디자인</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/cooking.png')"><p>요리</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/beauty.png')"><p>뷰티/헬스</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/video.png')"><p>사진/영상</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/career.png')"><p>커리어</p></a></td>
            <td> <a class="category-div" style="background-image:url('${contextPath}/resources/images/main/music.png')"><p>음악</p></a></td>
        </tr>
    </table>

    <!-- 주변 클래스 추천 -->
    <div class="location-class">
        <div class="location-class-top">
            <span class="detail">
                주변 클래스 추천<i class="fas fa-angle-right"></i>
            </span>
            <span class="location modal-open-btn" style="cursor: pointer;">
                <i class=" fi-rr-marker"></i> <p>서울 종로구</p>
            </span>
        </div>

        <div class="location-class-bottom">

            <div class="class" onclick="location.href='/tteutto/class/classDetail'">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <!-- 인기 클래스 추천 -->
    <div class="hot-class">
        <div class="hot-class-top">
            <span class="detail">
                인기 클래스 추천<i class="fas fa-angle-right"></i>
            </span>
        </div>

        <div class="hot-class-bottom">

            <div class="class">
                <div class="image">
                   	<img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <!-- 신규 클래스 추천 -->
    <div class="new-class">
        <div class="new-class-top">
            <span class="detail">
                신규 클래스 추천<i class="fas fa-angle-right"></i>
            </span>
        </div>

        <div class="new-class-bottom">

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

            <div class="class">
                <div class="image">
                    <img src="${contextPath}/resources/images/class/temp.jpg">
                    <p class="location-p">서울 강남</p>
                </div>
                <button type="button" class="btn_like">
                    <span class="img_emoti">좋아요</span>
                    <span class="ani_heart_m"></span>
                </button>
                <div class="detail-info">
                    <span class="category-name">카테고리</span>
                    <div class="class-name">[🏆BEST] 이봄의 타로 클래스 ❥ 고민으로 잠 못드는 당신을 위해</div>
                    <div class="grade">
                        <i class="fi-rr-star"></i> <span>95%</span>
                        <i class="fi-rr-heart"></i> <span>120</span>
                    </div>
                    
                    <div class="detail-info-bottom">
                        <img src="${contextPath}/resources/images/teacher/temp.jpg">
                        <span class="teacher-name">홍길동</span> 
                        <span class="class-price">월 15,000</span>
                    </div>
                </div>
            </div>

        </div>

    </div>

</main>

	<!-- 위치 모달 -->
        <div id="modal" class="location-setting modal">
            <div class="modal-content">
                <form action="#" method="post">
                    <div class="modal-title">
                        <h2>위치 설정</h2>
                    </div>
    
                    <div class="modal-location">
                        <p>'서울 종로구'</p>
                    </div>
                    <div class="modal_location_search">
                    	<input type=text" id="locationSearch" name="locationSearch">
                    	<button type="button" id="locationSearchBtn">찾기</button>	
                    </div>
                    <div style="border: 1px solid #ccc; height: 300px;"><div id="map" style="width:100%;height:100%;"></div></div>

                    

                    <div id="modal-btn">
                        <button id="locationClick" type="button">설정</button>
                        <button type="button" id="modal-close-btn" class="modal-close-btn">취소</button>
                    </div>
                </form>
            </div>

            <div class="modal-layer"></div>
        </div>
        
<jsp:include page="../common/footer.jsp"/>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- 부트스트랩 케러셀 -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- 지도 API/JS -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c2fadae20e5509a211c93e833342aa29&libraries=services,clusterer,drawing"></script>
<script src="${contextPath}/resources/js/mapList.js"></script>

<script>
    $('.btn_like').click(function(){
        if($(this).hasClass('btn_unlike')){
            $(this).removeClass('btn_unlike');
            $(this).children('span:eq(1)').removeClass('hi');
            $(this).children('span:eq(1)').addClass('bye');
        }
        else{
            $(this).addClass('btn_unlike');
            $(this).children('span:eq(1)').removeClass('bye');
            $(this).children('span:eq(1)').addClass('hi');
        }
    });
    
    /* 위치 모달 */
    // 모달 열기
	    $(".modal-open-btn").click(function () {
	    	
	    	// 위치
	        if($(this).hasClass("location")){
	            $(".location-setting").fadeIn(100);
	            $(".location-setting").css("display", "flex");
	        }
	    	
	        relayout();
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
</script>