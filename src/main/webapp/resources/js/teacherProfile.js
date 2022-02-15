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

// 이력 추가 삭제/닫기
function close_record_function(el,num) {
    if(num == 0){
        if(confirm("삭제하면 되돌릴 수 없습니다. 이력을 삭제하시겠습니까?")){
            
            let id = $(el).parent().attr('id').substr(7);

            $.ajax({
                url: contextPath + "/member/teacherProfiledelete",
                type : "POST",
                data: {"id": id},
                dataType : "json",
                success : function(result){
                    if(result > 0){
                        // alert("성공");
                    } else{
                        // alert("실패");
                    }
                },

                error : function(req, status, error){
                    console.log("삭제 실패");
                    console.log(req.responseText);
                }
            });
            
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

    swal({
        title: "수정한 정보를 저장하시겠습니까?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
        .then((willDelete) => {
            if (willDelete) {

                if(teacherProfileValidate()){
                    $("#signUp").submit()

                } else {
                swal("수정이 취소되었습니다.");
                }
            }
        });    
});

// 강사 정보 수정 유효성 검사 
function teacherProfileValidate() {

    const input = $(".talent");  // 이력 설명
    const img = $(".img_img"); // 파일 업로드
    
    const offset = $('#check').offset();

    let phonResult = phoneValidate();

    if (!phonResult) {
        return false;
    }
    
    if (!goEventPage()){
        alert("url 형식에 맞게 입력해주세요.");
        $('html').animate({scrollTop : offset.top}, 500);
        return false;
    }

    else if ($("#introduce").val().trim().length == 0) {
        alert("강사 소개를 입력해 주세요.");
        $("#introduce").focus();
        return false;
    }

    else if(input.length != 0 && input.val().trim() == ""){
        alert("이력 설명 칸을 입력해주세요.");
        
        $('html').animate({scrollTop : offset.top}, 400);

        return false;
    }

    else if(img.length != 0  && img.attr("src").charAt(0)=="h" ){
        alert("이력 칸의 이미지를 첨부해주세요.");
        $('html').animate({scrollTop : offset.top}, 400);
        return false;
    }

    else{
        // 빈 이력 칸은 없애기
        for(let i=0; i < input.length; i++){
            if(input.eq(i).val().trim().length == 0 && 
                img.eq(i).attr("src")== "https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png"){
                input.eq(i).parent().remove();
            }
        }
        return true;    
    }
}


// 전화번호 글자수 제한 + 유효성 검사
function phoneValidate(){

    const phone = $("#phone");

    if( phone.val().trim().length == 0 ){
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


// 이미지 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
function loadImg_Img(input) {

	// 매개변수 input == 클릭된 input 요소
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            var image = e.target.result;

            $("#img__cover").css({"background-image": "url("+image+")"});
        }
        reader.readAsDataURL(input.files[0]);
	} 
}


function goEventPage(){
    let flag = false;
    let snsList = $(".sns_link");
    
    //url 유효성 검사
    let regex = /(http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
    
    for(let sns of snsList){
        //올바른 url이 맞다면 해당 url로 이동
        if(regex.test($(sns).val())){
            flag = true;
        } else{
            flag = false;
            return flag;
        }
    }
    return flag;
  }