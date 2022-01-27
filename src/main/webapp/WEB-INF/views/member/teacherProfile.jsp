<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/profile.css"/>
    
<div id="container">
    <main>
        <div class="left">
            <div class="box">
                <img src="images/KakaoTalk_20220112_153307445.png">
            </div>
            <div class="name">홍길동</div>
            <div class="introduce">안녕하세요. 만나서 반갑습니다.</div>

            <div class="list">
                <div class="selected" onclick="location.href='${contextPath}/member/teacherProfile'">강사 프로필</div>
                <div onclick="location.href='${contextPath}/teacher/classList'">클래스 목록</div>
            </div>
        </div>
        <form id ="signUp">
            <div id="profile_header">
                <span>김사과</span>님의 강사 프로필
                <div id="save" class="profile_btn btn_shadow">저장하기</div>
            </div>
            <div class="profile_content">
                <div class="profile_area">
                    <div class="profile_img" id="img__cover" style="background-image:url(//img.taling.me/Content/Images/placeholders/profile-default.thumb.jpg)">
                        <img class="camera" src="https://front-img.taling.me/Content/Images/Tutor/Images/btn_pfimg.png">
                        <input type="file" id="picture" name="picture">
                    </div>
                </div>
                <div class="profile_area">
                    <div class="label_title">ID</div>
                    <div class="label_content">user01@naver.com</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">비밀번호</div>
                    <div class="label_content"><a href="#" class="pw_change btn_shadow">비밀번호 변경하기</a></div>
                </div>
                <div class="profile_area">
                    <div class="label_title">전화번호</div>
                    <div class="label_content">010-1234-5678</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">이름</div>
                    <div class="label_content">김케이</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">생년월일</div>
                    <div class="label_content">000111</div>
                </div>
                <div class="profile_area">
                    <div class="label_title">강사소개</div>
                    <div class="label_content">
                        <textarea placeholder="-경력&#13;&#10;-재능 및 경험담" maxlength="1000"></textarea>
                    </div>
                </div>
                <div class="profile_area">
                    <div class="label_title">이력(권장사항)</div>
                    <div class="label_content">
                        <div id="record_area">
                            <input type="text" class="profile_input" placeholder="재능과 관련된 이력을 입력해 주세요.">
                            <div class="upload_area">
                                <div class="upload_img">
                                    <img class="preview" src="https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png">
                                    <input type="file" class="profile_file">
                                </div>
                            </div>
                        </div>
                        <div id="record_area">
                            <input type="text" class="profile_input" placeholder="재능과 관련된 이력을 입력해 주세요.">
                            <div class="upload_area">
                                <div class="upload_img">
                                    <img class="preview" src="https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png">
                                    <input type="file" class="profile_file">
                                </div>
                            </div>
                        </div>
                        <button type="button" class="record_add">+ 이력 추가</button>

                        <div id="input_sns">
                            <p>소셜 미디어<em>(권장사항, 링크는 https:// 로 시작해야 합니다)</em></p>
                            <div class="instagram_area sns_area">
                                <input type="url" id ="instagram"class="sns_link" placeholder="인스타그램">
                            </div>
                            <div class="blog_area sns_area">
                                <input type="url" id ="blog"class="sns_link" placeholder="블로그(네이버, 브런치, 티스토리 등) 주소를 입력해 주세요.">
                            </div>
                            <div class="youtube_area sns_area">
                                <input type="url" id ="youtube"class="sns_link" placeholder="유튜브 주소를 입력해 주세요.">
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
           
        </form>
    </main>
</div>
<jsp:include page="../common/footer.jsp"/>