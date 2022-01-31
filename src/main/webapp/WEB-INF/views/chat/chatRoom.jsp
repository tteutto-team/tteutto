<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅창</title>

    <link href="${contextPath}/resources/css/chatRoom.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"  />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
        
</head>
<body>
    <div class="chat_info">
        <div class="backBtn">
            <svg width="25" height="25" viewBox="0 0 13 20" fill="none" xmlns="http://www.w3.org/2000/svg" class="InnerIconstyled__Icon-sc-197h5bb-0 cYxoKX CompactHeaderstyled__BackButton-sc-1rdzle3-7 hQfOPQ" defaultOpacity="1" hoveredOpacity="1" margintop="0" marginright="0" marginbottom="0" marginleft="0">
                <path fill="currentColor" fill-rule="evenodd" clip-rule="evenodd" d="M9.17255 16.4226C8.84711 16.748 8.31947 16.748 7.99404 16.4226L2.1607 10.5893C1.83527 10.2638 1.83527 9.73619 2.1607 9.41075L7.99404 3.57742C8.31947 3.25198 8.84711 3.25198 9.17255 3.57742C9.49799 3.90285 9.49799 4.43049 9.17255 4.75593L3.92847 10L9.17255 15.2441C9.49799 15.5695 9.49799 16.0972 9.17255 16.4226Z"></path>
            </svg>
        </div>
        <img src="https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61ea6885cbefd43cdfd1638e/previews/61ea6886cbefd43cdfd163b7/download/TTEUTTO_ver.1.png">
        <span>실시간으로 간편하게 문의하세요.
            <span>
                <div class="chatClose" onclick="chatClose();">×</div>
            </span>    
        </span>
    </div>
    <!-- <div class="chat_title">
        <img src="https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61eac69be448bf64cd927411/previews/61eac69ce448bf64cd927465/download/TTEUTTO_ver.3_%28favicon%29.png">
        <div class="chat_title1">뜨또에 문의하기</div>
        <div class="chat_title2">뜨겁게 또시작, 뜨또!</div> -->
        

    <div class="chat_title">
        <img src="https://trello-members.s3.amazonaws.com/5f6847b648dcd038f65b8551/6798ec30c2f40b27b3656649306bd860/original.png">
        <div class="chat_title1"><span>백동현</span>강사님께 문의하기</div>
        <div class="chat_title2">뜨겁게 또시작, 뜨또!</div>
        
    </div>
    <div>
        <div class="chatSubTitle">
            수업 일정과 강의 내용에 대해 문의해보세요.
            <br>(연락처 문의 또는 직접 알려주는 것은 불가)				
        </div>
    </div>
    <!-- FAQ 페이지로 이동 -->
    <!-- 
    <div class="linkFaq">
        <a href="#" target="_blank">뜨또 자주 묻는 질문</a> 
    </div> -->

    <div class="chat_wrap">
        <div class="inner">
            <div class="flex_wrap">
                <!-- <div class="tteuttoProfile">

                    <img src="https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61eac69be448bf64cd927411/previews/61eac69ce448bf64cd927465/download/TTEUTTO_ver.3_%28favicon%29.png" style="width: 25px; border-radius: 5px;">
                </div> -->
                
                <div class="item on">
                    <div class="otherName">백동현</div>
                    <div class="box">
                        <p class="msg">안녕하세요😊 
                            <!-- <span style="font-weight: bold;">뜨또</span>입니다!<br>
                            이용중 궁금한 사항이 있으시면 문의 바랍니다.🙇‍♀️<br><br>
                            탈잉센터 운영시간 안내 <br>
                            평일 10:00 ~ 17:00<br>
                            (점심 13:00 ~ 14:00)<br>
                            ※ 주말 및 공휴일 휴무 -->
                            <!-- <div> <a href=""> 뜨또 자주묻는 질문 </a></div> -->
                        </p>
                            <span class="time">오전 10:05</span>
                        </div>
                    </div>
                    
                    <!-- <div class="item mymsg">
                        <div class="box">
                            <p class="msg">안녕하세요</p>
                            <span class="time">오전 10:05</span>
                        </div>
                    </div> -->
                    
                </div>
            </div>
            

        </div>


        <div class="inputBtn">

            <input type="text" class="mymsg" placeholder="메시지 입력(개인 연락처 입력 불가 : 전화번호, 카톡, 페이스북등)">
            <button type="button" class="sendBtn">전송</button>
        </div>
        <input type="text" class="yourmsg" placeholder="상대방 내용 입력">
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/chatRoom.js"></script>



</body>
</html>