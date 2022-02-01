<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쪽지 목록</title>

    <link href="${contextPath}/resources/css/messageList.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"  />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="chat_info">
            <img src="https://trello.com/1/cards/61ea68649279785e229eb2dd/attachments/61ea6885cbefd43cdfd1638e/previews/61ea6886cbefd43cdfd163b7/download/TTEUTTO_ver.1.png">
            <span>실시간으로 간편하게 문의하세요.
                <span>
                    <div class="chatClose" onclick="chatClose();">×</div>
                </span>
            </span>
        </div>
        <div class="menuTap">
            <ul>
                <li><a href="${contextPath}/chat/chatRoomList">채팅</a></li>
                <li><a href="#" class="on">쪽지</a></li>
            </ul>
        </div>

    </div>
    <div class="modeChange">
        <select>
            <option>수강생모드</option>
            <option>강사모드</option>
        </select>
    </div>

    <!-- 채팅리스트 -->
    <main class="chat_romm_list">
        <ul>
            <li>
                <a href="#">
                    <img src="${contextPath}/resources/images/chat/messageicon.png" class="profile-img" alt="k페이프로필사진">
                    <div class="talk">
                        <p class="friend-name">뜨또</p>
                        <p class="chat-content">[뜨또] 오픈예정 클래스 결과 및 유보 안내 <br><br>
                            안녕하세요, <span>홍길동</span>님.<br>
                            개설해 주신 [<span> 일러스트레이터 1분만에 되기</span>] 클래스 유보에 대해 안내드립니다.<br>
                            
                            저희 뜨또는 준비물까지 챙겨주는 온라인 클래스 플랫폼으로, 수요조사 공개된 클래스에 대하여 뜨또 이용약관 및 커뮤니티 정책, 관련 법령에 위배되는 콘텐츠의 포함여부를 검토하고 있습니다. <br>
                            이번에 만들어주신 페이지 내용 중 일부가 위의 기준에 부적합하여 유보 처리를 진행하였습니다. <br><br>
                            
                            수요조사는 언제든 다시 도전이 가능하므로, 위의 링크를 참고하여 마음껏 재도전해주셔도 좋습니다.<br>
                            뜨또는 사랑하는 일을 하며 살고 있는 <span>홍길동</span>님을 항상 응원합니다!<br><br>
                            
                            감사합니다.<br>
                            뜨또 드림<br>
                        </p>
                    </div>
                    <div class="chat-status">
                        <time datetime="15:40:00+09:00">오후 3:40</time>
                        <span class="chat-balloon">N</sapn>
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${contextPath}/resources/images/chat/messageicon.png" class="profile-img" alt="뫄뫄프로필사진">
                    <div class="talk">
                        <p class="friend-name">뜨또</p>
                        <p class="chat-content">네 물어보세요</p>
                    </div>
                    <div class="chat-status">
                        <time datetime="15:39:00+09:00">오후 3:39</time>
                            <span class="chat-balloon">N</span>
                    </div>
                </a>
            </li>
            <li>
                <a href="#" target="_blank">
                    <img src="${contextPath}/resources/images/chat/messageicon.png" class="profile-img" alt="쀼프로필사진">
                    <div class="talk">
                        <p class="friend-name">뜨또</p>
                        <p class="chat-content">안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.</p>
                    </div>
                    <div class="chat-status">
                        <time datetime="10:15:00+09:00">오전 10:15</time>
                    </div>
                </a>
            </li>


            
        </ul>
    </main>




    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        // 채팅창 닫기
        $(function chatClose() {

            $(".chatClose").click(function () {
                if (confirm("채팅창을 닫으시겠습니까?")) {
                    window.close();
                }

            });
        });
    </script>
</body>

</html>