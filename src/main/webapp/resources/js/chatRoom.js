$(function(){
    $("input[type='text']").keypress(function(e){
        if(e.keyCode == 13 && $(this).val().length){ // 엔터를 칠경우 + 입력폼에 값이 있을경우
            var _val = $(this).val();  //입력폼 값 가져오기
            var _class = $(this).attr("class");
            $(this).val('');  // 입력폼 텍스트 없애기
            // alert(_val+"   "+_class);

            var _tar = $(".chat_wrap .inner").append('<div class="item '+_class+'"><div class="otherName">백동현</div><div class="box"><p class="msg">'+_val+'</p><span class="read-status"> 1 </span><span class="time">'+currentTime()+'</span></div></div>');
        }

        // if($(".sendBtn").click() && $("input[type='text']").val().length ){ // 입력버튼 클릭시
        //     var _val = $("input[type='text']").val();  //입력폼 값 가져오기
        //     var _class = $("input[type='text']").attr("class");
        //     $("input[type='text']").val('');  // 입력폼 텍스트 없애기
        //     // alert(_val+"   "+_class);

        //     var _tar = $(".chat_wrap .inner").append('<div class="item '+_class+'"><div class="box"><p class="msg">'+_val+'</p><span class="time">'+currentTime()+'</span></div></div>');
        // }


        setTimeout(function(){
            $(".chat_wrap .inner").find(".item:last").addClass("on");
        }, 10)

        // 스크롤 하단 고정
        $(".chat_wrap .inner").scrollTop($(".chat_wrap .inner")[0].scrollHeight);
    })

});

// 현재시간 함수
var currentTime = function(){
    var date = new Date();
    var hh = date.getHours();
    var mm = date.getMinutes();
    var apm = hh > 12 ? "오후":"오전";
    var ct = apm+" "+hh+":"+mm+"";
    return ct;
}

// 현재날짜 함수
var currentDate = function(){
    var date = new Date();
    
    var yy = date.getFullYear();
    var mm = date.getMonth() +1;
    var dd = date.getDate();
    var ctd = yy+"년 "+mm+"월 "+dd+"일";
    return ctd;
}

// 채팅창 닫기
$(function chatClose(){

    $(".chatClose").click(function(){
        if(confirm("채팅창을 닫으시겠습니까?")){
            window.close();
        }
        
    });
});

// 목록으로 돌아가기 버튼
$(".backBtn").click(function(){

    const obj = {};
    obj.memberNo = memberNo; /*전역변수 memberNo*/
    obj.chatRoomNo =  chatRoomNo;
    obj.memberName = memberName;

    // 웹소켓 처리 객체로 전달 (자바스크립트 객체를 문자열화 시켜서 내보낸다. (object -> JSON으로 전환))
    chattingSock.send( JSON.stringify(obj) );

    location.replace(contextPath +"/chat/chatRoomList");
});