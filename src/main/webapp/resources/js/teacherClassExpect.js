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

// 수강 거절
function rejectStudent(el){
    const className = $("#class-episode-name").text();
    const stduentName = $(el).text();

    $("#modal-class-student").text(className + " / " + stduentName);
}

function reject(memberNo, el){
    const className = $("#class-episode-name").text();
    swal({
        title: "수강 거절을 하시겠습니까?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((willDelete) => {
        if (willDelete) {
            
            $.ajax({
                url : contextPath + "/teacher/studentReject",
                data : {"epNo" : epNo, "studentNo" : memberNo, "className" : className},
                dataType : "JSON",
                type : "GET",
                success : function (result){
                    if(result > 0){
                        swal({"title" : "거절되었습니다.", "icon" : "success"});
                        $(el).parent().parent().remove();
                    
                    } else{
                        swal({"title" : "문제 발생", "text" : "관리자에게 문의바랍니다.", "icon" : "error"});
                    }
                },
                error : function(req, status, error){
                    console.log("삭제 가능 여부 조회 실패");
                    console.log(req.responseText);
                }
            });

        } else {
          swal("취소되었습니다.");
        }
      });
}