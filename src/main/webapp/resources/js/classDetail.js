/* 원데이클래스 날짜(,시간) 옵션 선택 */
const btn = document.querySelectorAll('.btn-select');
const list = document.querySelectorAll('.list-date');

for (let i = 0; i < btn.length; i++) {
   btn[i].addEventListener('click', () => {
       btn[i].classList.toggle('on');
   });
}

for (let j = 0; j < list.length; j++) {
   list[j].addEventListener('click', (event) => {
       if (event.target.nodeName === "BUTTON") {
           btn[j].innerText = event.target.innerText;
           btn[j].classList.remove('on');
        }
        

        
   });
}





/* 별점 선택 */
const rBtn = document.querySelectorAll('.review-btn-select');
const rList = document.querySelectorAll('.review-list-date');

for (let i = 0; i < rBtn.length; i++) {
  rBtn[i].addEventListener('click', () => {
    rBtn[i].classList.toggle('on');
   });
}

for (let j = 0; j < rList.length; j++) {
   rList[j].addEventListener('click', (event) => {
       if (event.target.nodeName === "BUTTON") {
          rBtn[j].innerHtml ="";
          rBtn[j].innerHtml = event.target.innerHtml;
          rBtn[j].classList.remove('on');
        }
        

        
   });
}


// 모달 밖에 클릭시 모달 닫기
$(".modal").click(function (e) {
  console.log(e.target);
  if($(e.target).hasClass('modal-layer')) {
      $(".modal").css("display","none");
  }

});



// 결제하기 체크된 경우만 결제하기 버튼 누를수 있도록
// + 체크 안되어있으면 얼럿창

$("#payCheckBox").on("click",function(){

  if($('#payCheckBox').is(":checked") == false){
    console.log('체크 안 된 상태');
    
    $("#payBtnId").on("click",function(){
      alert("주문내용 확인에 동의해주세요.")
      
    });
  }

});



// 

AOS.init();

    $(window).scroll(function(){ 
        var height = $(document).scrollTop(); //실시간으로 스크롤의 높이를 측정
       // console.log($(document).scrollTop());
        if(height > 751){ 
            $('.classNav').addClass('navFix'); 

        }else{ 
            $('.classNav').removeClass('navFix'); 
        } 
    });


    //스크롤
    (function (global, $) {

        var $menu     = $('.floating-menu li.m'),
            $contents = $('.scroll'),
            $doc      = $('html, body');
        $(function () {

            $menu.on('click','li', function(e){
                var $target = $(this),
                    idx     = $target.index(),
                    section = $contents.eq(idx),
                    offsetTop = section.offset().top;
                $doc.stop()
                        .animate({
                            scrollTop :offsetTop
                        }, 800);
                return false;
            });
        });

        $(window).scroll(function(){

            var scltop = $(window).scrollTop();

            $.each($contents, function(idx, item){
                var $target   = $contents.eq(idx),
                i         = $target.index(),
                targetTop = $target.offset().top;
                
                if (targetTop <= scltop+50) {
                    $menu.removeClass('selected');
                    $menu.eq(idx).addClass('selected');
                }
                if (!(200 <= scltop)) {
                    // $menu.removeClass('selected');
                }
            })

        });




        }(window, window.jQuery));

    // 날짜 셀렉트박스 영역밖 클릭시 닫힘 - 안돼
    $(document).mouseup(function(e){
        var listDate = $("list-date");
        if(listDate.has(e.target).length ===0)
            listDate.hide();
    
    });

    // // 사이드 이미지 마우스 호버시 이벤트 (css로..)
    // $('.sideImgStyle').hover(function(){

    //     $(this).css("opacity", 1).css("transition-duration", "0.7s");

    // });

    // $('.sideImgStyle').mouseleave(function(){

    //     $(this).css("opacity", 0.5).css("transition-duration", "0.7s");

    // });

    // 사이드 이미지 클릭시 
    $('.sideImgStyle').click(function(){

        // 만약 원래 클릭된 이미지가 있다면 기존 것은 불투명도 0.3
        
        // 선택한 이미지 불투명도 1
        //$(this).css("opacity", 1);
        
        $(this).siblings().addClass("blind");
        $(this).removeClass("blind");
        
        // 메인이미지에 띄우기
        $('#mainImg').attr("src",  $(this).attr("src") ).addClass("imgFadeInEffect");
    });

    
    // 네비바 메뉴 클릭시 selected 스타일속성
    // $('.navList').click(function(){
        
    //     $(this).siblings().removeClass("selected");
    //     $(this).addClass("selected");
    // });

    // 연령대, 성별 클릭시
    $('.stats_ageGender').click(function(){

        $(this).siblings().removeClass("stats_selected");
        $(this).addClass("stats_selected");

        if($(this).attr("id") === "classAge"){

            // $(".graphAge").css("display", "block");
            // $(".graphGender").css("display", "none");
            // $("#ageGenderTxt1").text("연령대는");
            // $("#ageGenderTxt2").text("ㅇㅇ대");
            
            $("#ageChart").css("display", "block");
            $("#genderChart").css("display", "none");
            $("#ageGenderTxt1").text("연령대는");
            $("#ageGenderTxt2").text("30대");


        }else if($(this).attr("id") === "classGender"){
            // $(".graphGender").css("display", "block");
            // $(".graphAge").css("display", "none");
            // $("#ageGenderTxt1").text("성별은");
            // $("#ageGenderTxt2").text("남성/여성");

            $("#genderChart").css("display", "block");
            $("#ageChart").css("display", "none");
            $("#ageGenderTxt1").text("성별은");
            $("#ageGenderTxt2").text("남성/여성");

        }
    });


    // 찜하기 - 빈하트 클릭시 
    $('#wishBtn').on('click', function(){

        if($('#emptyHeart').css('display')!="none"){
            console.log("1111");
            $('#fillHeart').css('display','block');
            $('#emptyHeart').css('display','none');
            alert("찜목록에 추가되었습니다.")
            
        }else{
            $('#emptyHeart').css('display','block');
            $('#fillHeart').css('display','none');
        }
    });


    // 공유하기 모달창
    $(document).ready(function(){ 

            $("#shareBtn").click(function(){
                $(".shareModal").fadeIn();
        });

            $(".share_modal_content").click(function(){
               $(".shareModal").fadeOut();
        });

    });

    // 구매하기 모달창
    $(document).ready(function(){

        $("#buyBtnId").click(function(){
            $(".buyModal").fadeIn();
        });

        $(".buy_modal_closeBtn").click(function(){
            $(".buyModal").fadeOut();
        });

    });


    //댓글 더읽기버튼 클릭 이벤트

    $('.moreBtn').click(function(){
        $(this).prev().removeClass("on");
        $(this).next().show();
        $(this).hide();


    });

    $('.foldBtn').click(function(){
        $(this).prev().prev().addClass("on");
        $(this).prev().show();
        $(this).hide();
    });


    // 환불정책 아코디언 메뉴
    $(".acodian_title").click(function() {
        $(this).next(".acodian_content").stop().slideToggle(300);
        $(this).toggleClass('on');
    });
  

    /* 셀렉트 바 닫힘-열림 중복 방지*/
    $(".btn-select").on("click",function(){
        if($(this).hasClass("on") && $(this).parent().next().find(".btn-select").hasClass("on")){
            console.log($(this).parent().next().find(".btn-select"));
            $(this).parent().next().find(".btn-select").removeClass("on");
        }
    });


    //차트
    var chart = bb.generate({
      bindto: "#ageChart",
      data: {
          type: "bar",
          x : "x",
          columns: [
              ["x","10대","20대","30대","40대","50대이상"],
              ["연령대", 30, 40, 70, 30, 10]
          ],
          groups: [
              [
                  "연령대"
              ]
          ],
          colors: {
              "연령대": "#ffd500"
          },
      }, 
      axis: {
          x: {
            type: "category"
          }
      },
      bar: {
          radius: {
          ratio: 0.1
          },
          width: {
              ratio: 0.9,
              max: 50
          }
      },
  });

  var chart = bb.generate({
      bindto: "#genderChart",
      data: {
          type: "donut",
          columns: [
              ["남성", 60],
              ["여성", 40]
          ],
          colors: {
              "남성": "#ffd500",
              "여성": "#acc43d"
          },
      }
  });






