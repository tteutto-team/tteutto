<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" />

<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" href="${contextPath}/resources/css/signup.css" />
<!-- icon -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />



<div class="container">
	<main class="signup">
		<h1>회원가입</h1>

		<form action="#" method="POST">
			<div>
				<label for="email">이메일</label> <br>
				<div id="email-div">
					<input type="email" id="email" name="memberEmail">
					<button>인증하기</button>
				</div>
				<span id="checkEmail"><i class="fas fa-exclamation-triangle"></i>
					유효하지 않는 E-mail입니다.</span>
			</div>

			<div>
				<label for="pw1">비밀번호</label> <br> <input type="password"
					id="pw1" name="memberPw"> <br> <span id="checkPw1"><i
					class="fas fa-exclamation-triangle"></i> 유효하지 않는 비밀번호입니다.</span>
			</div>

			<div>
				<label for="pw2">비밀번호 확인</label> <br> <input type="password"
					id="pw2"> <br> <span id="checkPw2"><i
					class="fas fa-exclamation-triangle"></i> 비밀번호가 일치하지 않습니다.</span>
			</div>

			<div>
				<label for="name">이름</label> <br> <input type="text" id="name"
					name="memberName"> <br> <span id="checkName"><i
					class="fas fa-exclamation-triangle"></i> 형식에 맞지 않는 이름입니다.</span>
			</div>

			<div>
				<label for="birth">생년월일</label> <br>
				<div id="birth-gender">
					<input type="number" id="birth"> <input id="male"
						type="radio" name="gender" value="male"> <label
						class="gender" for="male">남</label> <input id="female"
						type="radio" name="gender" value="female"> <label
						class="gender" for="female">여</label> <br>
				</div>

				<span id="checkBirth"><i class="fas fa-exclamation-triangle"></i>
					형식에 맞지 않는 생년월일입니다.</span>
			</div>

			<div>
				<label for="phone1">전화번호</label> <br>
				<div id="phone-div">
					<select id="phone1" name="phone">
						<option>010</option>
						<option>011</option>
						<option>016</option>
						<option>017</option>
						<option>019</option>
					</select> <input id="phone2" type="number" name="phone"> <input
						id="phone3" type="number" name="phone">
				</div>

				<span id="checkPhone"><i class="fas fa-exclamation-triangle"></i>
					형식에 맞지 않는 전화번호입니다.</span>

			</div>

			<button id="signup-btn">동의하고 회원가입</button>
		</form>

		<p>
			<span>이용약관, 개인정보 처리방침</span> 내용을 확인하였고 이에 동의합니다.
		</p>

		<a href="#" class="sns">
			<div>
				<img style="background-color: #20c702;"
					src="https://d2v80xjmx68n4w.cloudfront.net/assets/icon/naver_logo.png">
				<span>네이버로 시작하기</span>
			</div>
		</a> <a href="#" class="sns">
			<div>
				<img style="background-color: #f9e000;"
					src="https://d2v80xjmx68n4w.cloudfront.net/assets/icon/kakao_logo.png">
				<span>카카오로 시작하기</span>
			</div>
		</a> <a href="#" class="sns">
			<div>
				<img style="background-color: #f8f9fd;"
					src="https://d2v80xjmx68n4w.cloudfront.net/assets/icon/google_logo.png">
				<span>구글로 시작하기</span>
			</div>
		</a>

	</main>
</div>

<jsp:include page="../common/footer.jsp"/>