<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>


<jsp:include page="../common/header.jsp"/>

    <link href="${contextPath}/resources/css/classDetail.css" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" >
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">


    <!-- Load with base style -->
    <link rel="stylesheet" href="${contextPath}/resources/css/billboard.css">
    
    <!-- 클래스 번호 -->
    <input type="hidden" id="class_detail_no" value="${cdtr.cdt.classNo}">
    
    <!-- 공유하기 모달창 -->
    <div class="shareModal modal" style="display: none;">
        <div class="share_modal_content">
            <div class="modalTitle">
                <h3>공유하기</h3>
                <button type="button" class="share_modal_closeBtn">
                    <span class="share_modal_closeBtn_span">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                            <path d="M18.5 4L12 10.5 5.5 4 4 5.5l6.5 6.5L4 18.5 5.5 20l6.5-6.5 6.5 6.5 1.5-1.5-6.5-6.5L20 5.5 18.5 4z" fill="#1a1a1a"></path>
                        </svg>
                    </span>
                </button>
            </div>
            <div class="modalContent">
                <div class="share_kakao">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                        <path fill="#1B1C1D" fill-rule="evenodd" d="M12 4c-4.971 0-9 3.185-9 7.115 0 2.558 1.707 4.8 4.27 6.054l-.78 2.94c-.122.489.179.483.377.351l3.463-2.353a11.39 11.39 0 001.67.123c4.971 0 9-3.185 9-7.115S16.971 4 12 4"></path>
                    </svg>
                </div>
                <div class="share_twiter">
                    <svg viewBox="0 0 64 64" width="36" height="36">
                        <g>
                            <path fill="#FFF" d="M48,22.1c-1.2,0.5-2.4,0.9-3.8,1c1.4-0.8,2.4-2.1,2.9-3.6c-1.3,0.8-2.7,1.3-4.2,1.6 C41.7,19.8,40,19,38.2,19c-3.6,0-6.6,2.9-6.6,6.6c0,0.5,0.1,1,0.2,1.5c-5.5-0.3-10.3-2.9-13.5-6.9c-0.6,1-0.9,2.1-0.9,3.3 c0,2.3,1.2,4.3,2.9,5.5c-1.1,0-2.1-0.3-3-0.8c0,0,0,0.1,0,0.1c0,3.2,2.3,5.8,5.3,6.4c-0.6,0.1-1.1,0.2-1.7,0.2c-0.4,0-0.8,0-1.2-0.1 c0.8,2.6,3.3,4.5,6.1,4.6c-2.2,1.8-5.1,2.8-8.2,2.8c-0.5,0-1.1,0-1.6-0.1c2.9,1.9,6.4,2.9,10.1,2.9c12.1,0,18.7-10,18.7-18.7 c0-0.3,0-0.6,0-0.8C46,24.5,47.1,23.4,48,22.1z"></path>
                        </g>
                    </svg>
                </div>
                <div class="share_facebook">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                        <path fill="#FFF" fill-rule="evenodd" d="M20.007 3H3.993A.992.992 0 003 3.993v16.013c0 .549.444.993.993.993h8.621v-6.97h-2.347v-2.716h2.347V9.308c0-2.324 1.42-3.589 3.494-3.589.993 0 1.847.072 2.096.106v2.43h-1.44c-1.125 0-1.344.54-1.344 1.328v1.733h2.689l-.349 2.723h-2.34V21h4.587a.992.992 0 00.993-.993V3.993A.992.992 0 0020.007 3"></path>
                    </svg>
                </div>
                <div class="linkCopy">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" viewBox="0 0 24 24">
                        <path fill-rule="evenodd" d="M14 8a1 1 0 011-1h3a5 5 0 110 10h-3a1 1 0 110-2h3a3 3 0 100-6h-3a1 1 0 01-1-1zm-4 8a1 1 0 01-1 1H6A5 5 0 116 7h3a1 1 0 110 2H6a3 3 0 100 6h3a1 1 0 011 1zm-3-4a1 1 0 011-1h8a1 1 0 110 2H8a1 1 0 01-1-1z" fill="#1B1C1D"></path>
                    </svg>
                    <span >링크 복사하기</span>
                </div>
            </div>
        </div>
        <div class="modal-layer"></div>
    </div>

    <!-- 구매하기 모달창 -->
    <div class="buyModal modal" style="display: none;">
        <div class="buy_modal_content">
            <div class="modalTitle">
                <h3>신청내역</h3>
                <button type="button" class="buy_modal_closeBtn">
                    <span class="buy_modal_closeBtn_span">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                            <path d="M18.5 4L12 10.5 5.5 4 4 5.5l6.5 6.5L4 18.5 5.5 20l6.5-6.5 6.5 6.5 1.5-1.5-6.5-6.5L20 5.5 18.5 4z" fill="#1a1a1a"></path>
                        </svg>
                    </span>
                </button>
            </div>
            <div class="modalContent lineStyle">
                <div class="buyClassImg flexStyle1">
                    <img src="${contextPath}/resources/images/class-detail/temp3.jpg">
                </div>
                <div class="buyClassName flexStyle2">
                        <p class="buyClassTitle">
                            콰야의 오일파스텔 드로잉
                        </p> 
                        <span>강사명</span>
                        <span id="buyClassDate">2022년 1월 15일 (토) 11:00 ~12:00</span>
                </div>
            </div>
            <div class="paymentList">

                <div class="payment">
                    결제 금액
                </div>
                <div class="paymentAmount">
             	    <c:set var="payAmount" value="${cdtr.ep.epPrice}"/> 
                    <fmt:formatNumber value="${payAmount}" groupingUsed="true" />원
                </div>
            </div>
            <form id="paymentCheck">
                <input type="checkbox" id="payCheckBox">
                   <label for="payCheckBox">주문 내용을 확인하였으며, 결제에 동의합니다. (필수)</label>
                </input>
            </form>
            <div class="payBtn" id="payBtnId">
                <div>결제하기</div>
            </div>
            <div class="payInfo1">
                <p>서비스 제공이 완료된 이후에 전문가에게 결제 대금이 전달됩니다.</p>
            </div>

        </div>
        <div class="modal-layer"></div>
    </div>
    
    <!-- 클래스 상세 내용 -->
    <div class="classContent">
    

        <!-- 오른쪽 결제 박스 -->
        <aside class="sticky_area sticky">
            <div class="sticky_navi">
                <table>
                    <colgroup>
                        <col style="width: 190px;">
                        <col style="width: 20px;">
                        <col style="width: 140px;">
                    </colgroup>
                    <thead>
                        <tr>
                            <td scope="col">
                                <a href="#" class="aStyle" id="n_classCategory"> ${cdtr.cdt.categoryNm} </a> <br>
                            </td>
                            <td scope="col"></td>
                            <td scope="col" id="teacherName">${cdtr.member.memberNm}</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td colspan="3">
                                <strong id="naviClassName">[<span>1</span>회차] <span id="className"></span> </strong>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" id="classPrice">
                                <span>월</span> 
                                	<c:set var="payAmount" value="${cdtr.ep.epPrice}"/> 
                    				<fmt:formatNumber value="${payAmount}" groupingUsed="true" />10,000 원
                            </td>
                            <td id="classStar">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                            </td>
                        </tr>
                    </tbody>
                </table>
                
               <div class="boxContent">
                   <div class="threeBox">
                       <p>난이도</p>
                       <div>
                           <span id="classLevel"></span>
                        </div>
                   </div>
                   <div class="threeBox">
                    <p>소요시간</p>
                    <div>
                        
                    </div>
                    </div>
                    <div class="threeBox">
                        <p>수업인원</p>
                        <div>
                            최대<span id="maxPerson"></span>명
                        </div>
                    </div>
               </div>

               <!-- 다회차 클래스 날짜 area --> 
              <div class="lesson-area">
                   <div class="multiClassDate">
                      <strong>클래스 일정</strong>
                      <div class="lessonCnt">
                          <strong class="lessonCntList"> <span> 1 </span> 일차 </strong>  
                          <span class="lessonDate">  2022년 01월 07일</span> (<span>금</span>) <span> 10:00 </span> ~ <span> 11:00 </span> <br>
                          <strong class="lessonCntList"> <span> 2 </span> 일차 </strong>  
                          <span class="lessonDate">  2022년 01월 07일</span> (<span>금</span>) <span> 10:00 </span> ~ <span> 11:00 </span> <br>
                          <strong class="lessonCntList"> <span> 3 </span> 일차 </strong>  
                          <span class="lessonDate">  2022년 01월 07일</span> (<span>금</span>) <span> 10:00 </span> ~ <span> 11:00 </span> <br>
                          <strong class="lessonCntList"> <span> 4 </span> 일차 </strong>  
                          <span class="lessonDate">  2022년 01월 07일</span> (<span>금</span>) <span> 10:00 </span> ~ <span> 11:00 </span> <br>
                          <strong class="lessonCntList"> <span> 5 </span> 일차 </strong>  
                          <span class="lessonDate">  2022년 01월 07일</span> (<span>금</span>) <span> 10:00 </span> ~ <span> 11:00 </span> <br>
                        </div>
                        <div class="lesson-bottom-opacity"> </div>
                    </div>
                    
                    <!-- 원데이 클래스 날짜 선택 -->
                    <!-- <div>
                        <div class="onedayDateSelect">
                            <select class="selectBox">
                                <option> 2022년 01월 07일 (금) </option>
                                <option> 2022년 01월 07일 (금) </option>
                                <option> 2022년 01월 07일 (금) </option>
                            </select>
                        </div>
                        <div class="onedayTimeSelect ">
                            <select class="selectBox">
                                <option> 10:00 ~ 11:00 </option>
                                <option> 10:00 ~ 11:00 </option>
                                <option> 10:00 ~ 11:00 </option>
                            </select>
                        </div>
                    </div> -->
                    
                

                
               
                <div class="buyBtn" id="buyBtnId">
                    <div>신청하기</div>
                </div>

            </div> <!-- sticky nav end -->

        </aside>

        
        <!-- 클래스 내용 -->
        <div class="classContainer" >
            
            <!-- 네비바 -->
            <div class="classDetailContainer">
                <img id="mainImage" class="classMainImage" src="${contextPath}/resources/images/class-detail/temp3.jpg" id="mainImg" style="float:left; width:85%;">
                <div id="sideImage" class="sideImg">
                    <img class="sideImgStyle" src="${contextPath}/resources/images/class-detail/temp3.jpg" id="sideImg1">
                    <img class="sideImgStyle blind" src="" id="sideImg2" style="display:none;">
                    <img class="sideImgStyle blind" src="" id="sideImg3" style="display:none;">
                    <img class="sideImgStyle blind" src="" id="sideImg4" style="display:none;">
                    <img class="sideImgStyle blind" src="" id="sideImg5" style="display:none;">
                </div> 

            </div>
            <div class="classNav floating-menu">
               <ul>
                    <li class="navList selected m"> <a href="#section1"> 강의소개 </a></li>
                    <li class="navList m"> <a href="#section2">강사소개 </a></li>
                    <li class="navList m"> <a href="#section3">수강생 통계</a></li>
                    <li class="navList m"> <a href="#section4">환불정책</a></li>
                    <li class="navList m"> <a href="#section5">후기</a></li>
                </ul> 
            </div>
            
            <!-- 내용1 : 강의소개 -->
            <div id="section1" class="scroll"></div>
            <div class="section1">
                <div class="introClass" style="margin-top: 100px;"> 
                </div>
                   	<div id="summernote"></div>
			
                <!-- 지도부분 -->
                    
				<!--
                <div class="introClass"> 
                    <p data-aos="fade-up">클래스 장소</p> 
                </div>
                <div data-aos="fade-up"> 
                    <p class="subTitle" id="classAddress">서울특별시 강남구 강남구 테헤란로14길 6</p>
                    <button type="button" onclick="window.open(loadSearch())" class="searchAddress">길찾기 ></button>
                </div>
                <div id="place_map" data-aos="fade-up"><div id="map" style="width:100%;height:100%;"></div></div>
                
            </div>-->

            <!-- 내용2 : 강사소개 -->
            <!--
            <div id="section2"  class="scroll"></div>
            <div class="section2" >
                <div class="teacherProfile" data-aos="flip-up">
                    <img src="${contextPath}/resources/images/class-detail/teacherProfileImg.png" >
                    <p >
                        클래스 강사 <br> '
                        <span id="teacherNickname">ㅇㅇㅇ</span>
                        ' 입니다. <br>
                        <img src="${contextPath}/resources/images/class-detail/instaIcon.png">
                        <span id="instaId" data-aos="fade-up">
                            @teacher_Id
                        </span>
                    </p>
                </div>
                <div class="profileText" data-aos="flip-up" >
                    <p>안녕하세요. ㅇㅇ클래스 강사 ㅇㅇㅇ입니다. <br> 
                        목숨을 사는가 싶이 살았으며 그들의 그림자는 천고에 사라지지 않는 것이다 이것은 현저하게 일월과 같은 예가 되려니와 그와 같지 못하다 할지라도 창공에 반짝이는 뭇 별과 같이 산야에 피어나는 군영과 같이 이상은 실로 인간의</p>
                </div>-->
                
                <!-- <div class="profileText2">
                    <p>
                        <span id="qa1">
                            <strong>1. 브이로그로 공부하는 영어 학습법이 왜 좋다고 생각하시나요? </strong><br><br>
                        </span>
                        제가 처음 미국에 갔을 때, 친구들의 행동을 보면서 어떤 상황에서 어떻게 말을 하는지 계속 들었어요. 
                        그래야 비슷한 순간이 왔을 때 내 감정을 정확하게 표현할 수 있었으니까요. 
                        그래서 저는 일상에서의 영어를 보며 상황에 맞는 표현을 학습하는 것이 가장 효율적이라고 생각하고, 또 이번에 촬영한 부분은 아무래도 배경이 한국이다 보디 공감대도 있을 것 같아요. 
                        그래서 아마 도움이 많이 될 것이라 생각해요.
                    </p>
                    <p>
                        <sapn id="qa2">
                            <strong>2. 수강생들이 헤일리님의 브이로그와 인강으로 영어를 배우면 어떤 장점이 있을까요? </strong><br><br>
                        </sapn>

                        제가 처음 미국에 갔을 때, 친구들의 행동을 보면서 어떤 상황에서 어떻게 말을 하는지 계속 들었어요. 
                        그래야 비슷한 순간이 왔을 때 내 감정을 정확하게 표현할 수 있었으니까요. 
                        그래서 저는 일상에서의 영어를 보며 상황에 맞는 표현을 학습하는 것이 가장 효율적이라고 생각하고, 또 이번에 촬영한 부분은 아무래도 배경이 한국이다 보디 공감대도 있을 것 같아요. 
                        그래서 아마 도움이 많이 될 것이라 생각해요.
                            
                    </p>
                </div> -->
            </div>
            
            <%-- 
            <!-- 내용3 : 수강생통계 -->
            <div id="section3"  class="scroll"></div>
            <div class="section3" >
                <div class="introClass" > 
                    <div data-aos="fade-up"> 
                        <p id="stats_title" class="sectionLine" >어떤분들이 많이 수강할까요?</p>
                    </div>
                    <p style="float: left; margin-bottom: 45px;" data-aos="fade-up">해당 클래스를 <br>
                        가장 많이 수강한 <span id="ageGenderTxt1">연령대는</span> <br>
                        <span id="ageGenderTxt2">30대</span> 입니다.
                    </p> 
                </div>
                <div class="ageGender" data-aos="fade-up">
                    <button type="button" class="stats_ageGender stats_selected" id="classAge">연령대</button>
                    <button type="button" class="stats_ageGender" id="classGender">성별</button>
                </div>
                <div class="stats_area" data-aos="fade-up" >
                    <!-- 연령 -->
                    <!-- <div class="graphAge">
                        <div id="minwon-bar" class="progress-bar" >
                            
                            <div class="progress"> </div>
                        </div>
                        <div class="progress-bar2"></div>
                        <div class="progress-bar3"></div>
                    </div> -->
                    <!-- 성별 -->
                    <!-- <div class="graphGender" style="display: none;">
                        <div class="donut-container">
                            <div class="donut"> </div>
                        </div> -->
                        <!-- <div class="donut-container">
                            <div class="donut"> </div>
                        </div> -->
                    <!-- </div> -->

                    <!-- 연령대 차트 -->
                    <div id="ageChart"  data-aos="fade-up"></div>
                    <!-- 성별차트 -->
                    <div id="genderChart"  data-aos="fade-up" style="display: none;"></div>
                </div>
            </div>--%>

            <!-- 내용4 : 환불정책 -->
            <div id="section4"  class="scroll"></div>
            <div class="section4" >
                <div class="introClass"> 
                    <p class="sectionLine">환불 정책</p> 
                </div>
                <div class="acodian_wrap">
                    <div class="acodian_title on">
                        환불 정책 상세 내용
                    </div>
                    <div class="refund acodian_content">
                        <table >
                            <thead>
                                <tr>
                                    <td></td>
                                    <td>상세 내용</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td style="font-weight: 400;">클래스 수강전</td>
                                    <td>수강료 전액 100% 환불 가능</td>
                                </tr>
                                <tr>
                                    <td style="font-weight: 400;">클래스 수강중</td>
                                    <td>클래스 기간 환불금액 = 결제금액 ÷ 30일 × 남은 클래스 일수 만큼 지급</td>
                                </tr>
                                <tr>
                                    <td style="font-weight: 400;">클래스 종료</td>
                                    <td>클래스가 종료된 후에는 환불이 불가능합니다.</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="acodian_title">
                        관리자에게 문의하기
                    </div>
                    <div class="qaBtn acodian_content" style="display: none;">
                        <div>
                            <p> 기타 문의사항이 있을 경우 관리자에게 연락 바랍니다.</p>
                            <span><br>(T: 1544-9970 / F: 02-722-0858)</span>
                        </div>
                    </div>
                </div>
            </div>
                
            <!-- 내용5 : 수강 후기 -->
            <div id="section5"  class="scroll"></div>
            <div class="section5" >
                <div class="introClass"> 
                    <p class="sectionLine">
                        수강 후기 <span id="reviewCtn"> 47 </span> 　
                    </p> 
                </div>
                <div class="review_area">
                    <div class="review_box">
                        <div class="review_List">
                            <img src="${contextPath}/resources/images/class-detail/none_profile_img.png">
                            <div class="review_id">use**</div>
                            <div class="review_date">2021-12-31 22:28:41</div>
                            <div class="review_star">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star2.png">
                            </div>
                            <div class="review_content">
                                <p class="review_hide on">
                                    풀이 돋고 이상의 꽃이 피고 희망의 놀이 뜨고 열락의 새가 운다사랑의 풀이 없으면 인간은 사막이다 오아이스도 없는 사막이다 보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 이상의 꽃이풀이 돋고 이상의 꽃이 피고 희망의 놀이 뜨고 열락의 새가 운다사랑의 풀이 없으면 인간은 사막이다 오아이스도 없는 사막이다 보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 이상의 꽃이
                                </p>
                                 <span class="moreBtn" >
                                     더읽기
                                </span>
                                <span class="foldBtn" style="display: none;" >
                                    접기
                               </span>
                            </div>
                            <!-- 수정, 삭제 : 로그인한 회원번호와 댓글을 작성한 회원번호가 일치할 경우만 보이게-->
                            <div class="editBtn">
                                <button type="button" class="modifyBtn">수정</button>
                                <button type="button" class="deleteBtn">삭제</button>
                            </div>
                            <!-- 신고하기: 로그인한 회원이 해당 클래스 담당 강사일 경우에만 보이도록 -->
                            <!-- <div class="review_declare">
                                <button type="button" class="reviewDeclareBtn">신고하기</button>
                            </div> -->
                        </div>
                        <div class="review_List">
                            <img src="${contextPath}/resources/images/class-detail/none_profile_img.png">
                            <div class="review_id">use**</div>
                            <div class="review_date">2021-12-31 22:28:41</div>
                            <div class="review_star">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star2.png">
                            </div>
                            <div class="review_content">
                                <p class="review_hide on">풀이 돋고 이상의 꽃이 피고 희망의 놀이 뜨고 열락의 새가 운다사랑의 풀이 없으면 인간은 사막이다 오아이스도 없는 사막이다 보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 이상의 꽃이</p>
                                 <!-- 글자수 넘어가면 이 부분 생기면서  br이 ...으로 변함 -->
                                 <span class="moreBtn" >
                                    <br> 더읽기
                                </span>
                                <span class="foldBtn" style="display: none;" >
                                    접기
                               </span>
                            </div>
                            <!-- <div class="editBtn">
                                <button type="button" class="modifyBtn">수정</button>
                                <button type="button" class="deleteBtn">삭제</button>
                            </div> -->
                            <!-- <div class="review_declare">
                                <button type="button" class="reviewDeclareBtn">신고하기</button>
                            </div> -->
                        </div>
                        <div class="review_List">
                            <img src="${contextPath}/resources/images/class-detail/none_profile_img.png">
                            <div class="review_id">use**</div>
                            <div class="review_date">2021-12-31 22:28:41</div>
                            <div class="review_star">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star.png">
                                <img src="${contextPath}/resources/images/class-detail/star2.png">
                            </div>
                            <div class="review_content">
                                <p class="review_hide on">풀이 돋고 이상의 꽃이 피고 희망의 놀이 뜨고 열락의 새가 운다사랑의 풀이 없으면 인간은 사막이다 오아이스도 없는 사막이다 보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 이상의 꽃이</p>
                                 <!-- 글자수 넘어가면 이 부분 생기면서  br이 ...으로 변함 -->
                                 <span class="moreBtn" >
                                    <br> 더읽기
                                </span>
                                <span class="foldBtn" style="display: none;" >
                                    접기
                               </span>
                            </div>
                            <!-- <div class="editBtn">
                                <button type="button" class="modifyBtn">수정</button>
                                <button type="button" class="deleteBtn">삭제</button>
                            </div> -->
                            <!-- <div class="review_declare">
                                <button type="button" class="reviewDeclareBtn">신고하기</button>
                            </div> -->
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
                </div>
            </div>
            
        </div>
        
        <div class="btnLiveChat">
            <button type="button" style="bottom: 20px;" onclick="liveTalk();">
                실시간 톡
            </button>
        </div>
        
    </div>
    
<jsp:include page="../common/footer.jsp"/>
<%--     
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 차트 라이브러리 js -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <!-- Step 1) Load D3.js -->
    <script src="https://d3js.org/d3.v5.min.js"></script>
    
    <!-- Step 2) Load billboard.js with style -->
    <script src="${contextPath}/resources/js/billboard.js"></script>
    
    
    <script src="${contextPath}/resources/js/classDetail.js"></script>
	
	<!-- 지도 API/JS -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c2fadae20e5509a211c93e833342aa29&libraries=services,clusterer,drawing"></script>
    <script src="${contextPath}/resources/js/map.js"></script>
    
    <!-- 결제 api -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
     --%>
    
    <script>
	
    
    // 부모창에서 팝업창으로 데이터 가져오기
    //앞은 자식꺼 // 뒤는 부모꺼
    $('#summernote').html(opener.document.getElementById('summernote').value);
    $('#className').html(opener.document.getElementById('titleArea').value);
    $('#maxPerson').html(opener.document.getElementById('maxPerson').value);
    $('#classLevel').html(opener.$('input[name="classLevel"]:checked').val());
	
    window.onload = function(){
		if($("#maxPerson").html() == '0'){
			$("#maxPerson").parent().html("1:1수업");
		}else{
		};
	}
    
    
	//이미지 바꾸기
	$(".sideImgStyle").on("click", function(e){
		const src = e.target.src;
		$(".sideImgStyle").addClass("blind");
		e.target.classList.remove("blind");
		$("#mainImage").attr("src", src);
	});
    
    
	// 부모창에서 등록한 이미지 불러오기d
	$("#mainImage").attr("src", opener.document.getElementById("mini-img").childNodes[1].childNodes[1].src);
	$("#sideImg1").attr("src", opener.document.getElementById("mini-img").childNodes[1].childNodes[1].src);
	$("#sideImg2").attr("src", opener.document.getElementById("mini-img").childNodes[2].childNodes[1].src);
	$("#sideImg2").removeAttr("style");
	$("#sideImg3").attr("src", opener.document.getElementById("mini-img").childNodes[3].childNodes[1].src);
	$("#sideImg3").removeAttr("style");
	$("#sideImg4").attr("src", opener.document.getElementById("mini-img").childNodes[4].childNodes[1].src);
	$("#sideImg4").removeAttr("style");
	$("#sideImg5").attr("src", opener.document.getElementById("mini-img").childNodes[5].childNodes[1].src);
	$("#sideImg5").removeAttr("style");

	//
	


	
    // 구매하기 모달창
    $(document).ready(function(){

        $("#buyBtnId").click(function(){

        	if(${!empty sessionScope.loginMember}){
        		
          	  $(".buyModal").fadeIn();
        	}else{
        		alert("로그인 후 진행해주세요.");
        		$(location).attr("href", "${contextPath}/member/login");
        	}
        });

        $(".buy_modal_closeBtn").click(function(){
            $(".buyModal").fadeOut();
        });

    });
    
    
 // 찜하기 - 빈하트 클릭시 
	$('#wishBtn').on('click', function(){
	 	if(${!empty sessionScope.loginMember}){
	    	
		        if($('#emptyHeart').css('display')!="none"){
		            console.log("1111");
		            $('#fillHeart').css('display','block');
		            $('#emptyHeart').css('display','none');
		            alert("찜목록에 추가되었습니다.")
		            
		        }else{
		            $('#emptyHeart').css('display','block');
		            $('#fillHeart').css('display','none');
		        }
		}else{
		    alert("로그인 후 진행해주세요.");
		    $(location).attr("href", "${contextPath}/member/login");
	   	}
		        
	});
 
 // 결제금액 변수선언
 	var payAmount = '<c:out value="${payAmount}"/>';
 
    </script>
