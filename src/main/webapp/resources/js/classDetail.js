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
          // console.log(event.target.childNodes[1].innerText); //4회차
          // console.log(event.target.childNodes[3].innerText); // 10,000
          //console.log(event.target.childNodes[5].innerText); // 2022년 02월 14일 (월) 15:00 ~ 19:00
          console.log(event.target.childNodes[7].innerText); // 70001

           btn[j].classList.remove('on');
           
           document.getElementById("epPrice").innerText = event.target.childNodes[3].innerText;
           document.getElementById("buyEp").innerText = event.target.childNodes[1].innerText;
           document.getElementById("epAmount").innerText = event.target.childNodes[3].innerText;
           document.getElementById("buyClassDate").innerText = event.target.childNodes[5].innerText;
           document.getElementById("epNoSpan").innerText = event.target.childNodes[7].innerText;
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

		
		$("#payBtnId").click(function(){
		
			if($('#payCheckBox').is(":checked") == false){
			    
			    //console.log("체크 안된 상태");
			    alert("주문내용 확인에 동의해주세요.");
			      
		  	}else{  //체크했을 경우 결제 api진행
			
			//결제 api 
    		
    	  	IMP.init('imp19537399');
    	  	//결제시 전달되는 정보
    		IMP.request_pay({
    				    pg : 'kakaopay', 
    				    pay_method : 'card',
    				    merchant_uid : 'merchant_' + new Date().getTime(),
    				    name : '주문명:결제테스트'/*클래스 제목*/,
    				    amount : payAmount/*상품 가격*/, 
    				    buyer_name : '구매자이름',
    				    buyer_tel : '010-1234-5678'/*구매자 연락처*/,
    				    
    				}, function(rsp) {
    					var result = '';
    				    if ( rsp.success ) {
							
							$.ajax({
					          type: 'post',
					          url: 'insertRegister',
					          data: {
					                    /*'imp_uid': rsp.imp_uid,
					                    'merchant_uid': rsp.merchant_uid,
					                    'paid_amount' : rsp.paid_amount,
					                    'apply_num' : rsp.apply_num,*/
					                   
					                    'regNm' : loginMemberName,
					                    "memberNo" : loginMemberNo,
					                    'regPhoneNo' : loginMemberPno,
					                    'epNo' : $("#epNoSpan").text()
					                    
					          },
					          success: function (result) {
						           if(result > 0){
										swal({'icon' : 'success',
			    				       		  'title' : '결제가 완료되었습니다.'
	    				       		  	}).then(function(){
				    				        // $(".modal").css("display","none")
											location.href = contextPath + "/member/studentClassList";
										  });
									}
						        }, error:function(request, status, error){

									console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

	}
					          
					      	})
    				       	
    				        
    				    } else {
    				        var msg = '결제에 실패하였습니다.';
    				        msg += '에러내용 : ' + rsp.error_msg;
    				        result ='1';
    				    }
    				    if(result=="0") {
    				    	location.href= $.getContextPath()+"/Cart/Success";
    				    }
    				});
 
				}
		});
		
	// 로그인한 회원의 클래스 신청 여부 조회
	function selectRegisterDt(){
		if(loginMemberNo != ''){
			$.ajax({
				
				url : "selectRegisterDt",
				data : {
					   "memberNo" : loginMemberNo,
					   'classNo' : classNo },
				type : "POST",
				success : function(registerDt){
					console.log(registerDt);
					
				},
				error : function(){
					console.log("에러");
				}
				
			});
				
		
		}
	}
	
	
	


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


    


    // 공유하기 모달창
    $(document).ready(function(){ 

            $("#shareBtn").click(function(){
                $(".shareModal").fadeIn();
        });

            $(".share_modal_content").click(function(){
               $(".shareModal").fadeOut();
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
  
  







