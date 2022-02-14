/* $(function(){
    $("input[type='text']").keypress(function(e){
        if(e.keyCode == 13 && $(this).val().length){ // 엔터를 칠경우 + 입력폼에 값이 있을경우
            var _val = $(this).val();  //입력폼 값 가져오기
            var _class = $(this).attr("class");
            $(this).val('');  // 입력폼 텍스트 없애기
            // alert(_val+"   "+_class);

            var _tar = $(".chat_wrap .inner").append('<div class="item '+_class+'"><div class="otherName">백동현</div><div class="box"><p class="msg">'+_val+'</p><span class="read-status"> 1 </span><span class="time">'+currentTime()+'</span></div></div>');
        }


        
    })

}); */

// 스크롤 하단 고정
   $(".chat_wrap .inner").scrollTop($(".chat_wrap .inner")[0].scrollHeight);
        
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



// 채팅 보내기 함수
function sendMessage(){
   const msgContent = $("#inputChatting").val();
   
   if(msgContent.trim().length == 0){
      alert("내용을 입력해주세요")
   }else{
      
      //자바스크립트 객체 생성
      const obj={};
      obj.memberNo = memberNo;
      obj.teacherNo = teacherNo;
        obj.studentNo = studentNo;
      /*obj.memberEmail = memberEmail;*/
      obj.memberNm = memberNm;
      obj.msgContent = msgContent;
      obj.chatRoomNo = chatRoomNo;
        obj.mode = mode;
      
      //console.log(obj);
      
      // 만들어진 js 객체를 json으로 변환하여 웹소켓 객체 handleTextMessage()로 전달
      
      // JS 객체(obj)를 JSON 문자열로 바꿔서 보냄
      chattingSock.send(JSON.stringify(obj))
      
      $("#inputChatting").val(""); //전달된 메세지 지우기
   }
}

// 웹소켓 서버에서 전달된 메세지가 있을 경우
chattingSock.onmessage = function(e){
   // e.data : 전달받은 메세지
   
   const obj = JSON.parse(e.data);
    console.log(obj.cm.msgContent);
   
   ////////////
   const div = $("<div>");
   const divB = $("<div class='box'>");


   const p = $("<p class='msg'>");
   const span = $("<span class='time'>");
   span.html(obj.cm.msgDt);
   


   if(obj.cm.msgContent != undefined){ // 채팅 내용 입력시
       // XSS, 개행문자 처리
        let chat = XSS(obj.cm.msgContent);
        chat = chat.replaceAll("\n", "<br>");
        p.html(chat);

   }else{ // 나가기버튼 눌렀을때 (== obj.msgContent== undefined) == 메세지가 없는 경우

        p.html("<b>"+ obj.cm.memberNm+"님이 나가셨습니다.</b>");

   }
   


   if (obj.cm.memberNo == memberNo) {
      div.addClass("item mymsg");
      div.append(divB);
      divB.append(p);
      divB.append(span);
      $(".flex_wrap > .on").append(div);

   } else {
      
      div.addClass("otherName");
      div.html(obj.cm.memberNm);
      $(".flex_wrap > .on").append(div);
     
      div.after(divB);
      divB.append(p);
      divB.append(span);
   }

   

   
   ///////////////////////
   
   
   // 채팅 입력시 말풍선이 부드럽게 나타나는 효과
   setTimeout(function(){
       $(".chat_wrap .inner").find(".item:last").addClass("on");
   }, 10)
   
   // 스크롤 하단 고정
   $(".chat_wrap .inner").scrollTop($(".chat_wrap .inner")[0].scrollHeight);

}


// 보내기 버튼 클릭 시 채팅 전달
$("#sendBtn").on("click", sendMessage);

//엔터키 눌렀을 시 채팅 전달
function enterkey() {
   if (window.event.keyCode == 13) {
      sendMessage();
    }
}


// 엔터 쳤을 때 



// XSS 처리 함수 ( 위에서 쓰임 )
function XSS(msgContent){
    // 입력받은 메세지를 str에 저장
    let str = msgContent;

    // 입력받은 메세지중 &, < , >, " 이 있다면 "" 안에 있는 내용으로 바꿔주고 str에 다시 저장
    str = str.replace(/&/g, "&amp;");
    str = str.replace(/</g, "&lt;");
    str = str.replace(/>/g, "&gt;");
    str = str.replace(/"/g, "&quot;");

    return str;
}





// 나가기 버튼 동작
$("#exit-btn").on("click", function(){

    if(confirm("나가시겠습니까?")){

        const obj = {};
        obj.memberNo = memberNo; /*전역변수 memberNo*/
        obj.chatRoomNo =  chatRoomNo;
        obj.memberName = memberName;

        // object -> JSON으로 전환
        chattingSock.send( JSON.stringify(obj) );

        // 방 나가기
        // location.replace : 해당 주소 화면으로 화면을 변경(이전 화면이 히스토리에 남지 않음)
        location.replace(contextPath +"/chat/chatRoomList");

    }
})