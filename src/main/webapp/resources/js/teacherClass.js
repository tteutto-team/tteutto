 // 모달 열기
 $(".modal-open-btn").click(function () {
	
    // 영수증
    if($(this).hasClass("receipt")){
        chageReceipt($(this).parent());
        $(".receipt-request").fadeIn(100);
        $(".receipt-request").css("display", "flex");
    }

    // 삭제 요청
    if($(this).hasClass("delete")){

        let possibleDelete = possibleDeleteClass($(this).parent().parent().attr("id").split("_")[1]);

        if(possibleDelete > 0){
            $(".delete-request").fadeIn(100);
            $(".delete-request").css("display", "flex");
        } else{
            swal({
                title: "클래스를 삭제할 수 없습니다.",
                text: "진행중이거나 수강 학생이 있는 진행 예정인 강좌입니다. 관리자에게 문의해주세요!",
                icon: "error"
              });
        }
    }

    // 학생 관리 버튼
    if($(this).hasClass("student-management")){
        
        let epNo = $(this).parent().parent().attr("id").split("_")[1];

        if($(this).hasClass("0")){  // 진행중인 클래스
            sendPost(contextPath+"/teacher/studentListOngoing", "epNo", epNo);
            
        } else{ // 진행 예정 클래스
            sendPost(contextPath+"/teacher/studentListExpect", "epNo", epNo);
        }
    }

    // 새로운 클래스 열기
    if($(this).hasClass("new-class")){
        $(".class-open").fadeIn(100);
        $(".class-open").css("display", "flex");
    }
    
});

// 모달 닫기 버튼
$(".modal-close-btn").click(function () {
    $(".modal").fadeOut(100);
    $(".cont-select").fadeOut(100);
});

// 모달 밖에 클릭시 모달 닫기
$(".modal").click(function (e) {
    if($(e.target).hasClass('modal-layer')) {
        $(".cont-select").fadeOut(100);
        $(".modal").fadeOut(100);
    }
});

// 슬라이드
$(".slide").on("click", function () {

    let classId = $(this).attr("id").split("_")[1];

    if ($(this).parent().next().hasClass("invisible-a")){
        
        if($(this).parent().next().css("display") == "none") {
            $(".invisible-a").slideUp(100);	// 모든 슬라이드를 다 올리고
            $(".slide").html('<i class="fas fa-angle-down"></i>');	// 모든 슬라이드 아이콘을 바꾸고
            $(this).parent().next().slideDown(100);	// 숨겨진 슬라이드를 내린다.
            $(this).html('<i class="fas fa-angle-up"></i>');	// 내린 슬라이드의 아이콘을 바꾼다.
        
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

        $.ajax({
            url : contextPath + "/teacher/ExistingClassList",
            dataType : "JSON",
            type : "POST",
            success : function(rList){
                if(rList != null){
                    let ul = $(".list-member")
                    ul.empty();
                    
                    $.each(rList, function(index, classOne){
                        let li = "<li><button class = 'class-no-open' id=" + classOne.classNo + " type='button'>"+ classOne.className +"</button></li>";
                        ul.append(li);
                    });
                    $(".class-list").css("display","flex");
                } 
            }

        })
    }
    else{
        $(".class-list").css("display","none");
    }
});

/* 기존 강좌 열기 클릭시 */
$(".existing-class-select").on("click", function(){
    const liList = $(".class-no-open");
    const select = $(".btn-select").text().trim();

    for(let name of liList){
        if($(name).text().trim() == select){
            let id = $(name).attr("id");
            location.href = contextPath + "/register/schedule/"+id;
        }
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


// 영수증 클릭시
function chageReceipt(parentDiv){

    let epNo = parentDiv.parent().attr("id").split("_")[1];
    
    let classDate = parentDiv.prev().prev().prev().text();

    let className = $(".modal-receipt-class-name");
    let tbody = $(".modal-receipt-tbody");
    let calDate = $(".modal-receipt-calDate");
    let date = $(".modal-receipt-date");
    let price = $(".modal-receipt-price");
    let sum = 0;

    let table;

    $.ajax({
        url: contextPath + "/teacher/receipt",
        type : "POST",
        data : {"epNo" : epNo},
        dataType : "JSON",
        success : function(rList){
            tbody.html("");
            if(rList != null){
                $.each(rList, function(index, receipt){
                    className.text(receipt.classNm +" - " + receipt.teacherNm);
                    let html = "<tr> <td>"+ (index+1) +"</td> <td>"+ receipt.studentNm +"</td> <td>" + receipt.price + "</td> </tr>";
                    table += html;
                    sum += receipt.price;
                    calDate.text(receipt.calDate);
                })
                tbody.html(table);
                date.text(classDate);
                price.text(sum);
            }
        },
        error : function(req, status, error){
            console.log("영수증 조회 실패");
            console.log(req.responseText);
        }
    }); // end ajax
}

// 삭제 클릭 시
function possibleDeleteClass(epNo){

    $.ajax({
        url : contextPath + "/teacher/selectDeletClass",
        data : {"epNo" : epNo},
        type : "POST",
        success : function(result){

            if(result > 0){
                // $(".delete-request").fadeIn(100);
                // $(".delete-request").css("display", "flex");
                
                swal({
                    title: "정말로 삭제하시겠습니까?",
                    text: "모든 클래스의 정보가 사라집니다. 정말 삭제하시겠습니까? ",
                    icon: "warning",
                    buttons: true,
                    dangerMode: true,
                  })
                  .then((willDelete) => {
                    if (willDelete) {

                      let deleteResult = deleteClass(epNo);

                      if(deleteResult > 0){
                          swal("강의가 삭제되었습니다.", {
                            icon: "success",
                          });
                      } else{
                          swal({
                            title: "강의를 삭제하는데 실패하였습니다..",
                            text: "관리자에게 문의해주세요!",
                            icon: "error"
                        });
                      }

                    } else {
                      swal("취소되었습니다.");
                    }
                  });

            } else{
                swal({
                    title: "클래스를 삭제할 수 없습니다.",
                    text: "진행중이거나 수강 학생이 있는 진행 예정인 강좌입니다. 관리자에게 문의해주세요!",
                    icon: "error"
                });
            }

        },  // end success
        error : function(req, status, error){
            console.log("삭제 가능 여부 조회 실패");
            console.log(req.responseText);
        }
    }); // end ajax
}

// 클래스 삭제
function deleteClass(epNo){
    $.ajax({
        url: contextPath + "/teacher/deleteClass",
        data : {"epNo" : epNo},
        type : "POST",
        success : function(result){
            if(result > 0){
                return 1;
            } else{
                return 0;
            }
        },
        error : function(req, status, error){
            console.log("삭제 실패");
            console.log(req.responseText);
        }
    })
}


// post 방식 데이터 전송
function sendPost(url, name, params) { 

    var form = document.createElement('form'); 
    form.setAttribute('method', 'get'); 
    form.setAttribute('action', url); 
    
    for (var key in params) { 
        var hiddenField = document.createElement('input'); 
        hiddenField.setAttribute('type', 'hidden');
        hiddenField.setAttribute('name', name); 
        hiddenField.setAttribute('value', params[key]); 
        // hiddenField.setAttribute('value', 1); 
        form.appendChild(hiddenField); 
    } 
    document.body.appendChild(form); 
    form.submit(); 
}


// 정산하기
function calculate(epNo, el){
    
   $.ajax({
       url: contextPath + "/teacher/calculate",
       data : {"epNo" : epNo},
       type : "POST",
       success : function(result) {
            
            if(result > 0){

                let div = $(el).parent();
                $(el).remove();
                div.append("<div class='column'>요청 완료</div>");

                swal("정산 신청이 되었습니다.", {
                    icon: "success",
                  });

            } else{
                swal({
                    title: "클래스를 삭제할 수 없습니다.",
                    text: "진행중이거나 수강 학생이 있는 진행 예정인 강좌입니다. 관리자에게 문의해주세요!",
                    icon: "error"
                });
            }
       }
   })

}