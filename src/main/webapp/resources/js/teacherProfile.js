$(".record_add").on("click", function(){
	const html1 = "<div id='record_area'>";
    const html2 = "<input type='text' class='profile_input' placeholder='재능과 관련된 이력을 입력해 주세요.' name='profileInput'>";
    const html3 = "<div class='upload_area'>";
    const html4 = "<div class='upload_img'>";
    const html5 = "<img class='preview' src='https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png'>"
    const html6 = "<input type='file' class='profile_file' name='profileImg'>"
    const html7 = "</div> <div class='close_record' onclick='close_record_function(this)'>닫기</div>";
    const html8 = "</div></div>";
	$(this).prev().after(html1+html2+html3+html4+html5+html6+html7+html8);
});

// 이력 추가 닫기
function close_record_function(el) {
    $(el).parent().parent().remove();
};

// 저장하기
$("#save").on("click", function(){

    if(confirm("수정한 정보를 저장하시겠습니까?")){
        if(teacherProfileValidate()){
            $("#signUp").submit();
        }
    }else{
        alert("수정이 취소되었습니다.");
    }
});

// 강사 정보 수정 유효성 검사 
function teacherProfileValidate() {
    if ($("#phone").val().trim().length == 0) {
        alert("전화번호를 입력해 주세요.");
        $("#phone").focus();
        return false;
    }

    else if ($("#introduce").val().trim().length == 0) {
        alert("강사 소개를 입력해 주세요.");
        $("#introduce").focus();
        return false;
    }

    else{
        return true;
    }
}
