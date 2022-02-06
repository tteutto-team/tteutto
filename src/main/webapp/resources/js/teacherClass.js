 // 모달 열기
 $(".modal-open-btn").click(function () {
	
    if($(this).hasClass("receipt")){
        $(".receipt-request").fadeIn(100);
        $(".receipt-request").css("display", "flex");
    }

    if($(this).hasClass("delete")){
        console.log("삭제");
        $(".delete-request").fadeIn(100);
        $(".delete-request").css("display", "flex");
    }

    if($(this).hasClass("new-class")){
        $(".class-open").fadeIn(100);
        $(".class-open").css("display", "flex");
    }
    
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

// 슬라이드
$(".slide").on("click", function () {

    // console.log($(this).attr("id"));
    let classId = $(this).attr("id").split("_")[1];

    if ($(this).parent().next().hasClass("invisible-a")){
        
        if($(this).parent().next().css("display") == "none") {
            $(".invisible-a").slideUp(100);	// 모든 슬라이드를 다 올리고
            $(".slide").html('<i class="fas fa-angle-down"></i>');	// 모든 슬라이드 아이콘을 바꾸고
            $(this).parent().next().slideDown(100);	// 숨겨진 슬라이드를 내린다.
            $(this).html('<i class="fas fa-angle-up"></i>');	// 내린 슬라이드의 아이콘을 바꾼다.

            $.ajax({
                url : contextPath + "/teacher/classEpisode",
                type: "POST",
                data: {"classId" : classId},
                dataType: "JSON",
                success : function(result){
                    if(result == null){
                        console.log("null");
                    } else{
                        console.log("else");
                    }
                }


            });
            

        
        } else {	// 펼쳐져 있는 경우
            $(this).parent().next().slideUp(100);	// 버튼을 누른 슬라이드를 닫고
            $(this).html('<i class="fas fa-angle-down"></i>');	// 아이콘을 바꾼다.
        } 

    } else{
        console.log("안가짐")
    }
    
});

/* 기존 강좌 이어열기 클릭시 */
$("#existing").on("click", function(){
    if($(".class-list").css('display') === 'none'){
        $(".class-list").css("display","flex");
    }
    else{
        $(".class-list").css("display","none");
    }
});

/* 기존 강좌 이어열기 - 열기 클릭시 */
$(".existing-class-select").on("click", function(){
    if($(".btn-select").text() != "강의 목록"){
        location.href="${contextPath}/register/schedule";
    }
});

/* select-option */
const btn = document.querySelector('.btn-select');
const list = document.querySelector('.list-member');
btn.addEventListener('click', () => {
    btn.classList.toggle('on');
});
list.addEventListener('click', (event) => {
    if (event.target.nodeName === "BUTTON") {
        btn.innerText = event.target.innerText;
        btn.classList.remove('on');
    }
});
