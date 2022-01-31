const signUpCheckObj = {
	"pw1" : false,
	"pw2" : false
}

function validate() {
	for (key in signUpCheckObj) {
		if (!signUpCheckObj[key]) {
			let message;
			switch (key) {
				case "pw1": message = "비밀번호가 유효하지 않습니다."; break;
				case "pw2": message = "비밀번호가 일치하지 않습니다."; break;
			}
			alert(message);

			return false;
		}
	}
}


$("#sendEmail").on("click", function(){
	const inputEmail = $("#email").val();
	$.ajax({
		url : "emailDupCheck",
		type : "GET",
		data : {"inputEmail" : inputEmail},
		success : function(result){
						console.log(result);
			if(result == 1){
				$.ajax({
					url : "sendEmail",
					type : "POST",
					data : {"inputEmail" : inputEmail},
					success : function(result){
						if(result == 1){
							swal({
								title : "이메일 링크 전송 성공",
								text : "이메일을 확인해 주세요.",
								icon : "success"
							}).then(function(){
								window.location.href = "../"
							});
							
						}else{
							swal({
								title : "비밀번호 찾기 문제 발생",
								text : "관리자에게 문의해주세요.",
								icon : "error"
							});
						}
					}
				});
			}else{
				swal({
					text : "이메일을 다시 확인해 주세요.",
					icon : "warning"
				});
			}
		}		
	});
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