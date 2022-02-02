// 이력 추가
$(".record_add").on("click", function(){
	const html1 = "<div id='record_area'>";
    const html2 = "<input type='text' class='profile_input talent' placeholder='재능과 관련된 이력을 입력해 주세요.' name='profileInput'>";
    const html3 = "<div class='upload_area'>";
    const html4 = "<div class='upload_img'>";
    const html5 = "<img class='preview img_img' src='https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png'>"
    const html6 = "<input type='file' class='profile_file talent_img' name='profileImg' onchange='loadImg(this)'>"
    const html7 = "</div> <div class='close_record' onclick='close_record_function(this,1)'>닫기</div>";
    const html8 = "</div></div>";
	$(this).before(html1+html2+html3+html4+html5+html6+html7+html8);
});

// 이력 추가 닫기
function close_record_function(el,num) {
    if(num == 0){
        if(confirm("이력을 삭제하시겠습니까?")){
            $(el).parent().parent().remove();
        }
    }
    else{
        if(confirm("이력칸을 닫으시겠습니까?"))
        $(el).parent().parent().remove();
    }
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

    const input = $(".talent");  // 설명
    const img = $(".img_img"); // 파일 업로드
    
    const offset = $('#check').offset();

    for(let i=0; i < input.length; i++){
        if(input.eq(i).val().trim() == "" && img.eq(i).val()== ""){
            input.eq(i).remove();
            img.eq(i).remove();
            img.eq(i).prev().remove();
        }
    }

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

    else if(input.val().trim() == ""){
        alert("이력 설명 칸을 입력해주세요.");
        
        $('html').animate({scrollTop : offset.top}, 400);

        return false;
    }

    else if(img.attr("src").charAt(0)=="h" ){
        alert("이력 칸의 이미지를 첨부해주세요.");
        $('html').animate({scrollTop : offset.top}, 400);
        return false;
    }

    else{
        return true;
    }
}


// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
function loadImg(input) {

	// 매개변수 input == 클릭된 input 요소
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            var image = e.target.result;
            $(input).prev().attr("src", image);
        }
        reader.readAsDataURL(input.files[0]);
	} 
}