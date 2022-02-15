<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
                <div class="share_kakao" onclick="sendLinkCustom();">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                        <path fill="#1B1C1D" fill-rule="evenodd" d="M12 4c-4.971 0-9 3.185-9 7.115 0 2.558 1.707 4.8 4.27 6.054l-.78 2.94c-.122.489.179.483.377.351l3.463-2.353a11.39 11.39 0 001.67.123c4.971 0 9-3.185 9-7.115S16.971 4 12 4"></path>
                    </svg>
                </div>
                <div class="share_twiter" onclick="shareTwitter();">
                    <svg viewBox="0 0 64 64" width="36" height="36">
                        <g>
                            <path fill="#FFF" d="M48,22.1c-1.2,0.5-2.4,0.9-3.8,1c1.4-0.8,2.4-2.1,2.9-3.6c-1.3,0.8-2.7,1.3-4.2,1.6 C41.7,19.8,40,19,38.2,19c-3.6,0-6.6,2.9-6.6,6.6c0,0.5,0.1,1,0.2,1.5c-5.5-0.3-10.3-2.9-13.5-6.9c-0.6,1-0.9,2.1-0.9,3.3 c0,2.3,1.2,4.3,2.9,5.5c-1.1,0-2.1-0.3-3-0.8c0,0,0,0.1,0,0.1c0,3.2,2.3,5.8,5.3,6.4c-0.6,0.1-1.1,0.2-1.7,0.2c-0.4,0-0.8,0-1.2-0.1 c0.8,2.6,3.3,4.5,6.1,4.6c-2.2,1.8-5.1,2.8-8.2,2.8c-0.5,0-1.1,0-1.6-0.1c2.9,1.9,6.4,2.9,10.1,2.9c12.1,0,18.7-10,18.7-18.7 c0-0.3,0-0.6,0-0.8C46,24.5,47.1,23.4,48,22.1z"></path>
                        </g>
                    </svg>
                </div>
                <div class="share_facebook" onclick="shareFacebook();">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                        <path fill="#FFF" fill-rule="evenodd" d="M20.007 3H3.993A.992.992 0 003 3.993v16.013c0 .549.444.993.993.993h8.621v-6.97h-2.347v-2.716h2.347V9.308c0-2.324 1.42-3.589 3.494-3.589.993 0 1.847.072 2.096.106v2.43h-1.44c-1.125 0-1.344.54-1.344 1.328v1.733h2.689l-.349 2.723h-2.34V21h4.587a.992.992 0 00.993-.993V3.993A.992.992 0 0020.007 3"></path>
                    </svg>
                </div>
                <!-- http://115.90.212.22:8080
                	http://kh-aclass.xyz:8080 -->
                <div class="linkCopy" onclick="copy('http://localhost:8080/${contextPath}/class/classDetail?classNo=${cdtr.cdt.classNo}&epNo=${param.epCount}');">
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
                            [<span id="buyEp">${param.epCount}회차</span>] ${cdtr.cdt.className}
                        </p> 
                        <span>${cdtr.member.memberNm} 강사</span> 
                       	<span style="display:none" id="epNoSpan">${cdtr.epSchedule[0].epNo}</span>
                        <c:choose>
                        	<c:when test="${cdtr.cdt.classType == 0}">
	                        	<span id="buyClassDate"></span>
	                        </c:when>
	                        <c:otherwise>
	                        	<span id="buyClassDate">${cdtr.epSchedule[0].schdlDt}  (${cdtr.epSchedule[0].schdlWeek})  <br> ~ ${cdtr.epSchedule[ fn:length(cdtr.epSchedule)-1].schdlDt}  (${cdtr.epSchedule[fn:length(cdtr.epSchedule)-1].schdlWeek})</span>
	                        </c:otherwise>
                        </c:choose>
                </div> 
            </div>
            <div class="paymentList">

                <div class="payment">
                    결제 금액
                </div>
                <div class="paymentAmount">
                	<span id="epAmount">
	             	    <c:set var="payAmount" value="${cdtr.ep.epPrice}"/> 
                    	<fmt:formatNumber value="${payAmount}" groupingUsed="true" />
                	</span>
                    원
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
                                <strong id="naviClassName">[
                                <c:choose>
                                	<c:when test="${cdtr.cdt.classType == 1}">
	                                	<span>${param.epCount}회차</span>
                                	</c:when>
									<c:otherwise>
										<span>원데이</span>
									</c:otherwise>                                	
                                </c:choose>
                                
                                ] ${cdtr.cdt.className} </strong>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" id="classPrice">
                                	<c:set var="payAmount" value="${cdtr.ep.epPrice}"/> 
                    				<span id="epPrice"> <fmt:formatNumber value="${payAmount}" groupingUsed="true" /> </span> 원
                            </td>
                            <td id="classStar">
                            	<c:if test="${empty crev.reviewAvg}">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
                            	</c:if>
                            	<c:if test="${crev.reviewAvg == 1}">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
                            	</c:if>
                            	<c:if test="${crev.reviewAvg == 2}">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
                            	</c:if>
                            	<c:if test="${crev.reviewAvg == 3}">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
                            	</c:if>
                            	<c:if test="${crev.reviewAvg == 4}">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star2.png">
                            	</c:if>
                            	<c:if test="${crev.reviewAvg == 5}">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
	                                <img src="${contextPath}/resources/images/class-detail/star.png">
                            	</c:if> 
                            </td>
                        </tr>
                    </tbody>
                </table>
               
               <div class="boxContent">
                   <div class="threeBox">
                       <p>난이도</p>
                       <div>
                           <span>${cdtr.cdt.classLevel}</span>
                        </div>
                   </div>
                   <div class="threeBox">
                    <p>소요시간</p>
                    <div>
                        <span>${cdtr.epSchedule[0].schdlTime}</span>시간
                    </div>
                    </div>
                    <div class="threeBox">
                        <p>수업인원</p>
                        <div>
                        <c:if test="${cdtr.cdt.classPerson == 0}">
                            최대<span>${cdtr.cdt.classMaxPerson}</span>명
                        </c:if>
                        <c:if test="${cdtr.cdt.classPerson == 1}">
                        	1:1수업
                        </c:if>
                        </div>
                    </div>
               </div>

               <!-- 정규 클래스 날짜 area (CLASS_TYPE = 1) --> 
              <div class="lesson-area">
                   <div class="multiClassDate">
                      <strong>클래스 일정</strong>
                      <div class="lessonCnt">
                          <c:choose>
                          	<c:when test="${cdtr.cdt.classType == 1}"><c:set var="sign" value="일차"/></c:when>
							<c:otherwise><c:set var="sign" value="회차"/> </c:otherwise>
                          </c:choose>
                          <c:forEach var="eps" items="${cdtr.epSchedule}" varStatus="vs">
	                           
	                          <c:choose>
								<c:when test="${cdtr.cdt.classType == 0}">
									<c:if test="${eps.possibleFl == 1}">
				                          <strong class="lessonCntList">
				                          	<span> ${eps.epCount} </span>
				                           ${sign} </strong>  
			                          	<span class="lessonDate">  ${eps.schdlDt} </span> (<span>${eps.schdlWeek}</span>) <span> ${eps.schdlStartTime}</span> ~ <span> ${eps.schdlEndTime}</span> <br>
									</c:if>
								</c:when>
								<c:otherwise>
										<strong class="lessonCntList">
					                       <span> ${vs.count} </span>
					                     	${sign} </strong>  
		                          		<span class="lessonDate">  ${eps.schdlDt} </span> (<span>${eps.schdlWeek}</span>) <span> ${eps.schdlStartTime}</span> ~ <span> ${eps.schdlEndTime}</span> <br>
								</c:otherwise>
	                          </c:choose>
	                          
	                          
                         </c:forEach>
                    </div>
                    <div class="lesson-bottom-opacity"> </div>
                    <!-- 옵션 선택 -->
                    <!-- 원데이 클래스 날짜 선택 -->
                    <c:if test="${cdtr.cdt.classType == 0}">
	                    <div class="onedayClassDate">
	                        <strong> 클래스 회차 선택 </strong>
	                        <article class="onedaySelect">
	                            <button class="btn-select">회차를 선택해주세요.</button>
	                            <ul class="list-date">
	                            	<c:forEach var="eps" items="${cdtr.epSchedule}" varStatus="vs">
	                            		<c:if test="${eps.possibleFl == 1}">
		                                	<li data-class_text="${eps.epCount}회차 - ${eps.epPrice} 원 ( ${eps.registerStudentCnt} / ${cdtr.cdt.classMaxPerson} )">
		                                		<button type="button">
		                                			<span>${eps.epCount}회차</span> - <span><fmt:formatNumber value="${eps.epPrice}" groupingUsed="true" /></span>원
		                                			<span style="display:none">${eps.schdlDt} (${eps.schdlWeek}) ${eps.schdlStartTime} ~ ${eps.schdlEndTime}</span>
		                                			<span style="display:none">${eps.epNo}</span>
		                                			<span>( ${eps.registerStudentCnt} / ${cdtr.cdt.classMaxPerson} )</span>
		                                		</button>
	                                		</li>
	                            		</c:if>
	                            		
	                            		<c:if test="${vs.first && eps.registerStudentCnt == cdtr.cdt.classMaxPerson}">
	                            			<c:set var="soldout" value="1"/>
	                            		</c:if>
	                            	</c:forEach>
	                            </ul>
	                        </article>
	                       
	                    </div>
              	    </c:if>  
 			
                    
                </div>
                <!-- 찜하기, 공유하기 -->
               <div class="wishShareBtn">
                    <button type="button" class="wsBtn" id="wishBtn"> 
                        <div class="wsIcon">
                        
                        	<%-- 클래스 찜하기 버튼 > 찜 X --%> <%-- 테스트 --%>
							<c:if test="${heartFlag == 0}">
								<c:set var="emptyHeart" value="iconFlag"/>
                         	</c:if>
	                         
							<%-- 클래스 찜하기 버튼 > 찜 O --%>
							<c:if test="${heartFlag == 1}">
								<c:set var="fillHeart" value="iconFlag"/>
	                        </c:if>
                        
                        
                            <svg id="emptyHeart" class="wishIcon ${emptyHeart}" width="18" height="18" fill="none" viewBox="0 0 24 24">
                                <path fill-rule="evenodd" d="M20.5 9c0-2-1.5-3.9-3.7-3.9-2.3 0-3.8 1.63-4.8 3.33-1-1.7-2.5-3.33-4.8-3.33C5 5.1 3.5 6.867 3.5 9c0 4.62 4.949 7.667 8.5 9.623 3.551-1.956 8.5-5.003 8.5-9.623zm-19-.176C1.5 5.607 3.962 3 7 3c2.7 0 4 1 5 2.2C13 4 14.3 3 17 3c3.038 0 5.5 2.607 5.5 5.824C22.5 14.827 16.684 18.52 12 21 7.316 18.52 1.5 14.827 1.5 8.824z" fill="#1a1a1a"></path>
                            </svg>
                            
                            <!-- 로그인한 회원이 이 상품을 찜했을시 -->
                            <svg id="fillHeart" class="wishIcon ${fillHeart}" xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="none" viewBox="0 0 24 24">
                                <path fill-rule="evenodd" d="M1.5 8.824C1.5 5.607 3.962 3 7 3c2.5 0 4 1.5 5 3 1-1.5 2.5-3 5-3 3.038 0 5.5 2.607 5.5 5.824C22.5 14.827 16.684 18.52 12 21 7.316 18.52 1.5 14.827 1.5 8.824z" fill="rgb(253, 48, 73)"></path>
                            </svg>
	                            
	                        
                        </div>
                        <div>
                            찜하기 
                        </div>
                        
                        
                    </button>
                    <button type="button" class="wsBtn" id="shareBtn"> 
                        <div class="wsIcon">
                            <svg class="shareIcon" xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="none" viewBox="0 0 24 24">
                                <path fill-rule="evenodd" d="M20 19v-7h2v8a1 1 0 01-1 1H3a1 1 0 01-1-1v-8h2v7h16zM13 5.829l3.586 3.587L18 8.001 12 2 6 8.001l1.414 1.414L11 5.829v10.173h2V5.829z" fill="#1a1a1a"></path>
                            </svg>
                        </div>
                        
                        <div>
                            공유하기
                        </div> 
                        
                    </button>
                </div> 
                <div class="buyBtn" id="buyBtnId">
                
                		<c:if test="${cdtr.cdt.classType == 1}">
                			<c:if test="${cdtr.cdt.classMaxPerson == cdtr.epSchedule[0].registerStudentCnt }">
	                		 	<div id="registerBtn">신청마감</div>
	                		 </c:if>
	                		 <c:if test="${cdtr.cdt.classMaxPerson != cdtr.epSchedule[0].registerStudentCnt }">
                				<div id="registerBtn">신청하기</div>
                			</c:if> 
                		</c:if>
                		<c:if test="${cdtr.cdt.classType == 0}">
                			<div id="registerBtn">신청하기</div>
                		</c:if>
               
                <%-- <c:if test="${cdtr.cdt.classMaxPerson == cdtr.epSchedule[0].registerStudentCnt }">
		                    <div id="registerBtn">신청마감</div>
                </c:if>
                <c:if test="${cdtr.cdt.classMaxPerson != cdtr.epSchedule[0].registerStudentCnt }">
                			<div id="registerBtn">신청하기</div>
                </c:if> --%>
		                    <!-- <div><span>남은 시간 : </span>2022-02-12 10:00 </div> -->
                </div>

            </div> <!-- sticky nav end -->

        </aside>

        <!-- 클래스 내용 -->
        <div class="classContainer" >
            
            <div class="classDetailContainer">
            <div class="wrapperImg">
                <img class="classMainImage" src="${contextPath}/resources/images/class-detail/${thumImgList[0].thImgNm}" id="mainImg">
            </div>
                <div class="sideImg">
                	<img class="sideImgStyle" src="${contextPath}/resources/images/class-detail/${thumImgList[0].thImgNm}" id="sideImg1">
                <c:forEach var="imgList" items="${thumImgList}" varStatus="vs" begin="1" >
                    <img class="sideImgStyle blind" src="${contextPath}/resources/images/class-detail/${imgList.thImgNm}" id="sideImg2">
                </c:forEach>
                </div> 

            </div>
            <!-- 네비바 -->
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
            <div class="section1"  data-aos="fade-up">
                <!-- <div class="introClass" style="margin-top: 100px;">  -->
                <div style="margin-top: 100px;"> 
                   <!--  <p  >간단한 클래스 소개</p>  -->
                   <c:if test="${!empty cdt.classIntro}">
                   		<div id="summernote"></div>
                   		${cdt.classIntro }
                   </c:if>
                </div>
                   
 <%--                <div> 
                    <p class="subTitle">입문자분들을 위한 꿀조합 클래스입니다 :)</p>
                </div>
                <div>
                    <img src="${contextPath}/resources/images/class-detail/temp7.jpg"> 
                </div>
                <div class="classDescription">
                    <p>
                        오일파스텔을 쓰기위해서는 어떻게 명암이 들어가는지 아는 것이 중요해요. 기본적인 명암법을 배우고, 오일파스텔을 쓰기 전 특성을 알아볼 거예요. 또 기초를 바탕으로 어떻게 얼굴을 채워넣으면 좋은지 이야기 해볼게요. 그렇게 채색을 시작하면서 서서히 각자의 색으로 완성할 수 있도록 도와드리겠습니다.<br><br>
                    </p>
                    
                    <img src="${contextPath}/resources/images/class-detail/temp9.JPG">
                    <p>
                        감정이나 경험, 무언가 오래 기억하고 싶은게 있을 때, 기록하는 방법은 여러가지가 있습니다. 다양한 소재들을 이용해 손이 가는 대로 슥슥 그리다 보면 기분이 좋아지곤 합니다. 제가 사용하는 여러 가지 재료들 중에 오일파스텔 이라는 재료로 그림 그리는 재미를 나누고자 해요. 오일파스텔은 생소한 재료일 수 있는데, 사용하다 보면 오일파스텔만의 질감에 매력을 느끼고 쉽고 친숙한 재료라고 느껴질 거예요.
                    </p>
                </div>

                <!-- 수업대상 추천 -->
                <div class="classRecommend">
                    <div class="recommend-title">
                        <p>이런분들께 추천합니다</p>
                        <div>
                            <ul>
                                <li>UX디자이너가 되기위해 취업준비중인 취준생</li>
                                <li>타 전공자분들을 위한 UX입문과정</li>
                                <li>UX팀으로 이직을 위한 이직 준비 과정(경력 기술서 만들기!!)</li>
                                <li>UX 디자인 포트폴리오 준비 및 취업 컨설팅이 필요한 대학생</li>
                                <li>프로토파이/인비전/XD 등 다양한 프로토 타이핑 툴 학습이 필요하신분</li>
                                <li>UX디자인 분석/휴리스틱 분석에 대한 학습이 필요하신분</li>
                                <li>스타트업을 시작하기 위해 반응형 APP Design이 필요한 분</li>
                            </ul>
                        </div>
                    </div>
                </div> --%>

                <!-- 지도부분 -->
                    
                <div class="introClass" style="margin-top: 80px;"> 
                    <p data-aos="fade-up">클래스 장소</p> 
                </div>
                <div data-aos="fade-up"> 
                    <p class="subTitle" id="classAddress">${cdtr.ep.epPlace}</p>
                    <button type="button" onclick="window.open(loadSearch())" class="searchAddress">길찾기 ></button>
                </div>
                <div id="place_map" data-aos="fade-up"><div id="map" style="width:100%;height:100%;"></div></div>
                
            </div>

            <!-- 내용2 : 강사소개 -->
            <div id="section2"  class="scroll"></div>
            <div class="section2" >
                <div class="teacherProfile" data-aos="flip-up">
                    <img src="${contextPath}/resources/images/teacher/${tIntro.teacherImg}">
                    <p >
                        클래스 강사 <br> '
                        <span id="teacherNickname">${tIntro.memberNm}</span>
                        ' 입니다. <br>
                        <c:forEach items="${snsList}" var="sns">
	                        <c:if test="${sns.snsDiv == 0}">
		                        <img src="${contextPath}/resources/images/class-detail/instaIcon.png">
		                        <span id="instaId" data-aos="fade-up">
		                            <a href="#">${sns.snsLink}</a>
		                        </span>
	                        </c:if>
	                        
	                        <c:if test="${sns.snsDiv == 1}">
		                        <img src="${contextPath}/resources/images/class-detail/blogIcon.png">
		                        <span id="instaId" data-aos="fade-up">
		                            <a href="#">${sns.snsLink}</a>
		                        </span>
	                        </c:if>
	                        
	                        <c:if test="${sns.snsDiv == 2}">
		                        <img src="${contextPath}/resources/images/class-detail/youtubeIcon.png">
		                        <span id="instaId" data-aos="fade-up">
		                            <a href="#">${sns.snsLink}</a>
		                        </span>
	                        </c:if>
                        </c:forEach>
                    </p>
                </div>
                <div class="profileText" data-aos="flip-up" >
                    <p>${tIntro.teacherIntro}
                        </p>
                </div>
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
            </div>

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
                        수강 후기 <span id="reviewCtn">  </span> 　
                    </p> 
                </div>
                <div class="review_area">
                    <div class="review_box">
                        <%-- <div class="review_List">
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

                        <div class="review_List">
                            <div class="enroll_review_title"> 후기 남기기 </div>
                            <img src="${contextPath}/resources/images/class-detail/none_profile_img.png" id="enroll_review_profile">
                            <form>
                                <div class="enroll_star">
                                    <article class="enroll_review_star">
                                        <button class="review-btn-select">
                                            <img src="${contextPath}/resources/images/class-detail/star.png">
                                            <img src="${contextPath}/resources/images/class-detail/star.png">
                                            <img src="${contextPath}/resources/images/class-detail/star.png">
                                            <img src="${contextPath}/resources/images/class-detail/star.png">
                                            <img src="${contextPath}/resources/images/class-detail/star.png">
                                        </button>
                                        <ul class="review-list-date">
                                            <li>
                                                <button type="button">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                </button>
                                            </li>
                                            <li>
                                                <button type="button">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                </button>
                                            </li>
                                            <li>
                                                <button type="button">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                </button>
                                            </li>
                                            <li>
                                                <button type="button">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                </button>
                                            </li>
                                            <li>
                                                <button type="button">
                                                    <img src="${contextPath}/resources/images/class-detail/star.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                    <img src="${contextPath}/resources/images/class-detail/star2.png">
                                                </button>
                                            </li>
                                        </ul>
                                    </article>
                                </div>

                                <!-- 수업을 들은 학생만 남길 수 있도록 -->
                                <div class="review_enroll">
                                    <input type="text" placeholder="수강 후 작성이 가능합니다.">
                                </div>
                                <div class="enrollBtn">
                                    <button>
                                        등록
                                    </button>
                                </div>
                            </form>
                        </div> --%>

                    </div>
                </div>
            </div>
            
        </div>
        
        
        <c:if test="${cdtr.cdt.memberNo != loginMember.memberNo}">
	        <div class="btnLiveChat">
	            <button type="button" style="bottom: 20px;" id="livetalk">
	                실시간 톡
	            </button>
	        </div>
        </c:if>
        
    </div>
    
<jsp:include page="../common/footer.jsp"/>
    
    
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 차트 라이브러리 js -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    
    <!-- Step 1) Load D3.js -->
    <script src="https://d3js.org/d3.v5.min.js"></script>
    
    <!-- Step 2) Load billboard.js with style -->
    <script src="${contextPath}/resources/js/billboard.js"></script>
    
    <script>
    	const contextPath = '${contextPath}';
    
    	// 신청여부 조회용 변수 선언
    	const loginMemberNo = '${loginMember.memberNo}';
    	const classNo = '${param.classNo}';
    	
    	// 결제내역 삽입용 변수 선언
    	const loginMemberName = '${loginMember.memberNm}';
    	const loginMemberPno = '${loginMember.memberPno}';
    	
    	const epNo = "${param.epNo}";
    	
    	// 최대인원 변수선언
    	const classMaxPerson = '${cdtr.cdt.classMaxPerson}';
    	
    	let heartFlag = '${heartFlag}';
    	
    	const teacherNo = "${cdtr.cdt.memberNo}";
    </script>
    
    <script src="${contextPath}/resources/js/classDetail.js"></script>
    <script src="${contextPath}/resources/js/classDetail2.js"></script>
	
	<!-- 지도 API/JS -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c2fadae20e5509a211c93e833342aa29&libraries=services,clusterer,drawing"></script>
    <script src="${contextPath}/resources/js/map.js"></script>
    
    <!-- 결제 api -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    
    <script>
    // 구매하기 모달창
    $(document).ready(function(){

        $("#buyBtnId").click(function(){

        	if(${!empty sessionScope.loginMember}){
        	
        		
        		if($(".btn-select").text() == '회차를 선택해주세요.'){
        			swal({'icon' : 'info',
			       		  'title' : '회차 선택 후 신청해주세요.'
			       		  });
        		}else{
        			
        			// 해당클래스의 강사번호와 로그인번호가 같을 경우
        			// 본인 클래스이므로 신청 못함
        			if(${cdtr.cdt.memberNo== loginMember.memberNo}){
        				swal({'icon' : 'info',
        		       		  'title' : '본인이 개설한 클래스는 신청할 수 없습니다.'
        		       		  });
        			}else{
        				
	          		  $(".buyModal").fadeIn();
        			}
        		
        		 
        		}
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
	    	
		        if(heartFlag == 1){
			            /* swal({'icon' : 'info',
				    		 'title' : '찜목록에서 삭제되었습니다.'
		    				       		  	}); */
			            $.ajax({
			                url: "deletetWish",
			                data: {
			                	'memberNo' : loginMemberNo,
			                	'classNo' : classNo
			                },
			                type: "POST",
			                success : function(data){
			                  console.log("삭제성공")
			                  $("#fillHeart").removeClass("iconFlag");
			                  $("#emptyHeart").addClass("iconFlag");
			                  heartFlag = 0;
			                },
			                error : function(){
			                  console.log("삭제에러")		
			                }
		              });
		           
		            
		        }else{
		        	 // console.log("1111");
		            /* swal({'icon' : 'success',
			    		 'title' : '찜목록에 추가되었습니다.'
	    				       		  	}); */
		            $.ajax({
		                url: "insertWish",
		                data: {
		                	'memberNo' : loginMemberNo,
		                	'classNo' : classNo
		                },
		                type: "POST",
		                success : function(data){
		                  console.log("추가성공")
		                  heartFlag = 1;
		                  $("#emptyHeart").removeClass("iconFlag");
		                  $("#fillHeart").addClass("iconFlag");
		                },
		                error : function(){
		                  console.log("추가에러")		
		                }
		              });
		        }
		}else{
		    alert("로그인 후 진행해주세요.");
		    $(location).attr("href", "${contextPath}/member/login");
	   	}
		        
	});
 
 	// 결제금액 변수선언
 	var payAmount = '<c:out value="${payAmount}"/>';
 	
 	
 	  // 실시간톡 버튼
 	  $('#livetalk').on('click', function(){
	 	  	if(${!empty sessionScope.loginMember}){
			 	    var url="../chat/chatRoom?teacherNo=${cdtr.cdt.memberNo}&mode=0";
			 	    var option="width=482, height=700, top=200"
			 	    window.open(url, "_blank", option);
			 	  
		 	  }else{
		 		 alert("로그인 후 진행해주세요.");
				 $(location).attr("href", "${contextPath}/member/login");
		 	  }
 	  });
 	  
 	  
 	  //카카오 공유하기
 	  function sendLinkCustom() {
 		 try{
	        Kakao.init("78e4a93e20f860122fd8a26c9c05dbe7");
 			 
 		 }catch(e){};

 		 Kakao.Link.sendCustom({
            templateId: 70472
        });
      }
 	  
 /* 	 Kakao.init("78e4a93e20f860122fd8a26c9c05dbe7"); //어플의 Javascript Key 값 
 	 function sendLinkCustom() { 
 		 debugger; Kakao.Link.sendCustom({ templateId : 53911 //숫자값 
 		 }); } try { function sendLinkDefault() { 
 			 Kakao.Link.sendDefault({ 
 				 objectType : 'feed', 
 				 content : { 
 					 title : 'Test Homepage Title', 
 					 description : '#Test #Homepage #Kakao Link Description', 
 					 imageUrl : 'http://k.kakaocdn.net/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png', 
 					 link : { 
 						 mobileWebUrl : 
 							 'https://developers.kakao.com', 
 							 webUrl : 'https://developers.kakao.com', 
 							 }, 
 						}, social : { 
 							likeCount : 100, 
 							commentCount : 200, 
 							sharedCount : 300, 
 						}, buttons : [ { 
 							title : '웹으로 보기', 
 							link : { mobileWebUrl : 
 								'https://developers.kakao.com', 
 								webUrl : 'https://developers.kakao.com', 
 								}, 
 						}, { title : '앱으로 보기', 
 							link : { 
 								mobileWebUrl : 'https://developers.kakao.com', 
 								webUrl : 'https://developers.kakao.com', 
 								}, 
 							},
 							],
 						}) } ; 
 						window.kakaoDemoCallback && window.kakaoDemoCallback() 
 				
 		 	} catch (e) { window.kakaoDemoException && window.kakaoDemoException(e) } */

 	  
 	  //트위터 공유하기
 	  function shareTwitter() {
	    var sendText = "뜨또"; // 전달할 텍스트
	    var sendUrl = "http://kh-aclass.xyz:8080/tteutto/class/classDetail?classNo=${cdtr.cdt.classNo}"; // 전달할 URL
	    window.open("https://twitter.com/intent/tweet?text=" + sendText + "&url=" + sendUrl);
	  }
 	  
 	  //페이스북 공유하기
 	  function shareFacebook() {
		    var sendUrl = "http://kh-aclass.xyz:8080/tteutto/class/classDetail?classNo=${cdtr.cdt.classNo}"; // 전달할 URL
		    window.open("http://www.facebook.com/sharer/sharer.php?u=" + sendUrl);
		}
 	  
 	  //링크 복사하기
 	  function copy(val) {
		  var dummy = document.createElement("textarea");
		  document.body.appendChild(dummy);
		  dummy.value = val;
		  dummy.select();
		  document.execCommand("copy");
		  document.body.removeChild(dummy);
		}
 	  
 	  
 	  // 썸머노트 불러오기
 	  //$('#summernote').html(opener.document.getElementById('summernote').value);
 
    </script>
