<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/profile.css"/>
    
<div id="container">
	<main>
		<form action="${contextPath}/member/teacherRegister" method="POST" id="register" enctype="multipart/form-data" role="form" onsubmit="return checkInput();">
			<div id="register_header">
                    <div>강사 신청</div>
                    <div><span>* </span>필수</div> 
            </div>
			<div class="register_content">
				<div class="register_area">
					<div class="label_title">프로필사진<span style="color: red">*</span></div>
					<div class="label_content">
						<div class="register_img" id="register_img_cover" style="margin-bottom: 10px;">
							<img class="ppap" src="//img.taling.me/Content/Images/placeholders/profile-default.thumb.jpg">
							<img class="camera" style="margin-top: -40px;"
								src="https://front-img.taling.me/Content/Images/Tutor/Images/btn_pfimg.png">
							<input type="file" id="picture" name="image" onchange="loadImg(this)">
						</div>
						<div class="register_img"
							style="background-image: url(https://front-img.taling.me/Content/app3/img/bg/bg-profile-example-01-64-px@2x.png)"></div>
						<div class="register_img"
							style="background-image: url(https://front-img.taling.me/Content/app3/img/bg/bg-profile-example-02-64-px@2x.png)"></div>
						<div class="register_img"
							style="background-image: url(https://front-img.taling.me/Content/app3/img/bg/bg-profile-example-03-64px@2x.png)"></div>

						<p>
							<span style="color: red">주의</span> 얼굴이 나오지 않은 동물/캐릭터/단순배경사진은 승인되지
							않습니다. 강사님의 사진으로 등록해 주세요.
						</p>
					</div>
				</div>
				<div class="register_area">
					<div class="label_title">
						강사소개<span style="color: red">*</span>
					</div>
					<div class="label_content">
						<textarea name="teacherIntro" placeholder="-경력&#13;&#10;-재능 및 경험담" maxlength="1000" required></textarea>
					</div>
				</div>
				<div class="register_area">
					<div class="label_title">이력(권장사항)</div>
					<div class="label_content">
						<div id="record-box">
							<%--
							<div id="record_area">
								<input type="text" class="profile_input" name="careerContent"
									placeholder="재능과 관련된 이력을 입력해 주세요.">
								<div class="upload_area">
									<div class="upload_img">
										<img class="preview"
											src="https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png">
										<input type="file" class="profile_file" name="images" onchange="loadCareerImg(this,0)">
									</div>
									<div class="close_record" onclick="close_record_function(this)">닫기</div>
								</div>
							</div>
							<div id="record_area">
								<input type="text" class="profile_input" name="careerContent"
									placeholder="재능과 관련된 이력을 입력해 주세요.">
								<div class="upload_area">
									<div class="upload_img">
										<img class="preview"
											src="https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png">
										<input type="file" class="profile_file" name="images" onchange="loadCareerImg(this,1)">
									</div>
									<div class="close_record" onclick="close_record_function(this)">닫기</div>
								</div>
							</div>
							 --%>
						</div>
						<button type="button" id="register_record_add" class="record_add">+
							이력 추가</button>

						<div id="input_sns">
							<p>
								소셜 미디어<em>(권장사항, 주소나 아이디를 입력해주세요.)</em>
							</p>
							<div class="instagram_area sns_area">
								<input type="text" id="instagram" class="sns_link" name="instagram"
									placeholder="인스타그램">
							</div>
							<div class="blog_area sns_area">
								<input type="text" id="blog" class="sns_link" name="blog"
									placeholder="블로그(네이버, 브런치, 티스토리 등) 주소를 입력해 주세요.">
							</div>
							<div class="youtube_area sns_area">
								<input type="text" id="youtube" class="sns_link" name="youtube"
									placeholder="유튜브 주소를 입력해 주세요.">
							</div>
						</div>
					</div>
				</div>
				<div id="register_btn_area">
					<button id="register_btn" class="btn_shadow">신청하기</button>
				</div>
			</div>
		</form>
	</main>
</div>
<script src="${contextPath}/resources/js/teacherRegister.js"></script>
<jsp:include page="../common/footer.jsp"/>