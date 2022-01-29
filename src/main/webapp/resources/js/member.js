const signUpCheckObj = {
	"email" : false,
	"pw1" : false,
	"pw2" : false,
	"name" : false,
	"birth" : false,
	"gender" : false,
	"phone3" : false
}

function validate() {
	for (key in signUpCheckObj) {
		if (!signUpCheckObj[key]) {
			let message;
			console.log(key);
			switch (key) {
				case "email": message = "이메일이 유효하지 않습니다."; break;
				case "pw1": message = "비밀번호가 유효하지 않습니다."; break;
				case "pw2": message = "비밀번호가 일치하지 않습니다."; break;
				case "name": message = "이름이 유효하지 않습니다."; break;
				case "birth": message = "생일이 유효하지 않습니다."; break;
				case "gender": message = "성별을 선택해 선택해 주세요."; break;
				case "phone3": message = "전화번호가 유효하지 않습니다."; break;
			}
			alert(message);

			return false;
		}
	}
	const phone = document.getElementsByName("phone");

	const input1 = document.createElement("input");
	input1.setAttribute("type", "hidden");
	input1.setAttribute("name", "memberPno");
	input1.value = phone[0].value + "-" + phone[1].value + "-" + phone[2].value;
	document.signUpForm.append(input1)
	console.log(input1);
}


// 이메일 유효성 검사
document.getElementById("email").addEventListener("input", function() {

	const inputEmail = this.value;
	const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
	const checkEmail = document.getElementById("checkEmail");

	if(inputEmail.length == 0){
        checkEmail.innerText = "";
        signUpCheckObj.email = false;
    }else if(regExp.test(inputEmail)){
		$.ajax({
			url : "emailDupCheck",
			type : "GET",
			data : {"inputEmail": inputEmail},
			success : function(result){
				if(result == 0){
					checkEmail.innerText = "사용 가능한 아이디 입니다.";
			        checkEmail.style.color = "green";
			        signUpCheckObj.email = true;
				}else{
					checkEmail.innerHTML = "<i class='fas fa-exclamation-triangle'></i> 이미 사용중인 이메일 입니다.";
			        checkEmail.style.color = "red";
			        signUpCheckObj.email = false;
				}
			},
			error : function(request, status, error){
                if( request.status == 404 ){
                    console.log("ajax 요청 주소가 올바르지 않습니다.");
                } else if( request.status == 500){
                    console.log("서버 내부 에러 발생");
                }
            },
            complete : function(){}
		});
	}else{
		checkEmail.innerHTML = "<i class='fas fa-exclamation-triangle'></i> 유효하지 않은 이메일 입니다.";
        checkEmail.style.color = "red";
        signUpCheckObj.email = false;
	}
});

// 비밀번호 유효성 검사
// 문자, 숫자, 특수문자 각 최소 1개, 8~16자리
document.getElementById("pw1").addEventListener("input", function(){

    const inputPw = this.value; // 입력 받은 이메일

    const regExp = /^(?=.*[a-zA-Z])((?=.*\d)(?=.*\W)).{8,16}$/


    const checkPw1 = document.getElementById("checkPw1"); // 출력용

    if(inputPw.length == 0){ // 빈칸
        checkPw1.innerText = "";
        signUpCheckObj.pw1 = false;
    
    }else if(regExp.test(inputPw)){ // 유효할 때
        checkPw1.innerText = "유효한 비밀번호 입니다.";
        checkPw1.style.color = "green";
        signUpCheckObj.pw1 = true;

    }else{
        checkPw1.innerHTML = "<i class='fas fa-exclamation-triangle'></i> 유효하지 않은 비밀번호 입니다.";
        checkPw1.style.color = "red";
        signUpCheckObj.pw1 = false;
    }

});

// 비밀번호 확인 유효성 검사  == > pwd1이랑 같은 값이면 유효
$("#pw2, #pw1").on("input", function(){

    const pw1 = document.getElementById("pw1").value;
    const pw2 = document.getElementById("pw2").value;
    const checkPw2 = document.getElementById("checkPw2"); // 출력용

    if( pw2.trim().length == 0 ){ // 비밀번호 확인이 빈칸일 경우
        checkPw2.innerText = "";
        signUpCheckObj.pw2 = false;

    }else if(pw1 == pw2){ // 유효한 경우
        checkPw2.innerText = "비밀번호가 일치합니다.";
        checkPw2.style.color = "green";
        signUpCheckObj.pw2 = true;
        
    }else { // 유효하지 않은 경우
        checkPw2.innerHTML = "<i class='fas fa-exclamation-triangle'></i> 비밀번호가 일치하지 않습니다.";
        checkPw2.style.color = "red";
        signUpCheckObj.pw2 = false;
    }
});

// 이름 유효성 검사
$("#name").on("input", function(){

    const inputName = $(this).val(); 
    const regExp = /^[가-힣]{2,5}$/;

    if( inputName.length == 0 ){ 
        $("#checkName").text("");
        signUpCheckObj.name = false;

    }else if(regExp.test(inputName)){
        $("#checkName").text("유효한 이름 입니다.").css("color", "green");
        signUpCheckObj.name = true;

    }else{ 
        $("#checkName").html("<i class='fas fa-exclamation-triangle'></i> 유효하지 않은 이름 입니다.").css("color", "red");
        signUpCheckObj.name = false;
    }
});

// 생일 유효성 검사
$("#birth").on("input", function(){
	const inputBirth = $(this).val();
	const regExp = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/
	
	if(inputBirth.length == 0){
		$("#checkBirth").text("");
		signUpCheckObj.birth = false;
	}else if(regExp.test(inputBirth)){
		$("#checkBirth").text("유효한 생일 입니다.").css("color", "green");
		signUpCheckObj.birth = true;
	}else{
		$("#checkBirth").html("<i class='fas fa-exclamation-triangle'></i> 유효하지 않은 생일 입니다.").css("color", "red");
		signUpCheckObj.birth = false;
	}
});

// 성별 유효성 검사
$('input[name=MemberGender]').on("change", function(){
	const checkGender = $('input[name="MemberGender"]:checked').val();
	if(checkGender.length > 0){
		signUpCheckObj.gender = true;
		
	}else{
		signUpCheckObj.gender = false;
	}
});

// 전화번호 글자수 제한 + 유효성 검사
$(".phone").on("input", function(){

    if(  $(this).val().length > 4  ){

        const num = $(this).val().slice(0,4); 

        $(this).val(num);
    }

    const inputPhone2 = document.getElementById("phone2").value;
    const inputPhone3 = document.getElementById("phone3").value;

    const regExp2 = /^\d{3,4}$/;
    const regExp3 = /^\d{4}$/;

    const checkPhone = document.getElementById("checkPhone");

    if( inputPhone2.length == 0  && inputPhone3.length == 0){ 
        checkPhone.innerText = "";
        signUpCheckObj.phone3 = false;

    }else if(regExp2.test(inputPhone2) && regExp3.test(inputPhone3) ){ 

        checkPhone.innerText = "유효한 전화번호 입니다.";
        checkPhone.style.color = "green";
        signUpCheckObj.phone3 = true;

    }else{ 

        checkPhone.innerHTML = "<i class='fas fa-exclamation-triangle'></i> 유효하지 않은 전화번호 입니다.";
        checkPhone.style.color = "red";
        signUpCheckObj.phone3 = false;

    }
});

let clickCount = 0;
$("#check_btn").on("click", function(){
	const inputEmail = $("#email").val();
	// console.log(inputEmail);
	// console.log(clickCount);
	if(clickCount == 0 && signUpCheckObj.email == true){
		let html = "<div>";
		html +=	"<label for='email'>이메일 인증번호</label> <br>";
		html +=	"<div id='email-div'>";
		html +=	"<input type='number' id='certify' name='certify' placeholder='인증번호를 입력하세요.'>";
		html += "<button type='button' id='certify_btn'>확인하기</button>";
		html +=	"</div>";
		html +=	"<span id='checkCertify'></span>";
		html +=	"</div>";
		$(html).insertAfter(".first");
		clickCount = clickCount + 1;
		$.ajax({
			url : "sendMail",
			type : "GET",
			data : {"inputEmail": inputEmail},
			success : function(result){
				if(result == 0){
					console.log("성공");
				}
			},
			error : function(request, status, error){
                if( request.status == 404 ){
                    console.log("ajax 요청 주소가 올바르지 않습니다.");
                } else if( request.status == 500){
                    console.log("서버 내부 에러 발생");
                }
            },
            complete : function(){}
		});
	}
	
});
