const signUpCheckObj = {
	"name" : false,
	"birth" : false,
	"gender" : false,
	"phone3" : false
}

function validate() {
	for (key in signUpCheckObj) {
		if (!signUpCheckObj[key]) {
			let message;
			switch (key) {
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
