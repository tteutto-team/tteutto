// 탈퇴하기 모달
 // 모달 열기
 $(".modal-open-btn").click(function () {

    console.log("click");
    $(".resign-request").fadeIn(100);
    $(".resign-request").css("display", "flex");
});

// 모달 닫기 버튼
$(".modal-close-btn").click(function () {
    $(".modal").fadeOut(100);
});

// 모달 밖에 클릭시 모달 닫기
$(".modal").click(function (e) {
    if($(e.target).hasClass('modal-layer')) {
        $(".modal").fadeOut(100);
    }
});

function resign_cancle(){
    swal({
        title: "취소되었습니다.",
        text: "",
        icon: "error"
      });

    $(".modal").fadeOut(100);
}



// 이미지 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
function loadImg(input) {

	// 매개변수 input == 클릭된 input 요소
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            var image = e.target.result;

            $(input).parent().css({"background-image": "url("+image+")"});
        }
        reader.readAsDataURL(input.files[0]);
	} 
}


// 저장하기
$("#save").on("click", function(){

    if(confirm("수정한 정보를 저장하시겠습니까?")){
        if(studentProfileValidate()){
            $("#signUp").submit();
        }
    }else{
        alert("수정이 취소되었습니다.");
    }
});

// 학생 정보 수정 유효성 검사 
function studentProfileValidate() {
    if(nameValidate() && phoneValidate()){
        return true;    
    }
    else{
        return false;
    }
}

// 이름 유효성 검사
function nameValidate(){

    const inputName = $("[name='name']"); 
    const regExp = /^[가-힣]{2,5}$/;

    if( inputName.val().length == 0 ){ 
        alert("이름을 입력해 주세요.");
        inputName.focus();
        return false;

    }else if(regExp.test(inputName.val())){
        return true;

    }else{ 
        alert("이름의 형식에 맞게 입력해 주세요.");
        inputName.focus();
        return false;
    }
};

// 전화번호 글자수 제한 + 유효성 검사
function phoneValidate(){

    const phone = $("[name='phone']");

    if( phone.val().length == 0 ){
        alert("전화번호를 입력해 주세요.");
        phone.focus();
        return false;
    }
    
    if (/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/.test(phone.val())) {
        return true;
    }

    else{ 
        alert("형식에 맞는 전화번호를 입력해 주세요.");
        phone.focus();
        return false;
    }
};