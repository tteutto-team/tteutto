// 모달 열기
$(".modal-open-btn").click(function () {
    // 신고
    if($(this).hasClass("report")){
        reportReq($(this));
        $(".report-request").fadeIn(100);
        $(".report-request").css("display", "flex");
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
    if ($(this).parent().next().css("display") == "none") {
        $(".invisible").slideUp(100);
        $(".slide").html('<i class="fas fa-angle-down"></i>');
        $(this).parent().next().slideDown(100);
        $(this).html('<i class="fas fa-angle-up"></i>');

    } else {
        $(this).parent().next().slideUp(100);
        $(this).html('<i class="fas fa-angle-down"></i>');

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


// 신고 버튼 클릭 시
function reportReq(btn){
    let className = $("#class-episode-name").text();
    let studentName = btn.parent().parent().prev().children().eq(1).text();
    $(".modal-classname-student").text(className + " / " + studentName);
}

function reportSubmit(){

    let reportText = $(".detail-reason");
    let memberNo = $(".studentName").attr("id");

    if(reportText.val().trim().length == 0){
        swal({"title" : "신고 내용을 입력해주세요.", "icon" : "error"});
    } else{

        $.ajax({
            url : contextPath + "/teacher/reportStudent",
            data : {"epNo" : epNo, "memberNo" : memberNo, "reportText" : reportText.val()},
            type : "POST",
            dataType : "JSON",
            success : function(result){
                if(result > 0){
                    $(".modal").fadeOut(100);
                    swal({"title" : "신고가 접수되었습니다.", "icon" : "success"});

                } else{
                    swal({
                        title: "신고에 문제가 생겼습니다.",
                        text: "관리자에게 문의하세요.",
                        icon: "warning"
                      })
                    $(".modal").fadeOut(100);
                }

            }

        });

    }

};





