$(function() {
	createTable();
})

function createTable() {
	$.ajax({
		url: "classEpisodeList",
		type: "GET",
		dataType: "JSON",
		success: function(data) {
			console.log(data);
			$('#table_id').DataTable({
				data: data,
				columns: [
					{ data: "classNo" },
					{ data: null },
					{ data: "memberName" },
					{ data: "classRequestDate" }
				],
				columnDefs: [
					{
						"targets": 4,
						"data": null,
						"render": function(data, type, row) {
							console.log(data);
							return '<button onclick="agree(' + data.classNo + ', ' + data.memberNo + ', \'' + data.className + '-' + data.episodeCount + '\')">승인</button><button onclick="deny(' + data.classNo + ', ' + data.memberNo + ', \'' + data.className + '-' + data.episodeCount + '\')">거절</button>';
						},
						"orderable": false
					},
					{
						"targets": 1,
						"data": null,
						"render": function(data, type, row) {
							return '<a href="#">' + data.className + '-' + data.episodeCount + '회차</a>';
						},
						"orderable": false
					}
				]
			})
		}
	})
}

function agree(classNo, memberNo, className) {
	if (confirm("클래스 회차 등록을 승인하겠습니까?")) {
		$.ajax({
			url: "episodeAgree",
			dataType: "json",
			data: {
				"classNo": classNo,
				"memberNo": memberNo,
				"className": className,
			},
			success: function(result) {
				if (result > 0) {

					const obj = {}
					obj.noteContent = className;
					obj.memberNo = memberNo;
					obj.flag = 0;

					// console.log(obj);

					// 만들어진 JS 객체를 JSON으로 변환하여 웹소켓 객체 handleTextMessage() 로 전달

					// JSON.stringify : JS 객체 -> JSON 문자열
					// JSON.parse : JSON 문자열 -> JS 객체
					noteSock.send(JSON.stringify(obj));

					alert("승인 완료");

					$('#table_id').DataTable().destroy();
					createTable();

				}
			}
		})
	}
}

// 모달 열기
function deny(classNo, memberNo, className){
	$("#modal1").fadeIn(100);
	$("#modal1").css("display", "flex");
	$(".sendDeny").attr("onclick", "sendDeny2(" + classNo + ", " + memberNo + ", \'" + className + "\')");
}

// 거절 쪽지 보내기
function sendDeny2(classNo, memberNo, className){
	$.ajax({
			url: "episodeDeny",
			dataType: "json",
			data: {
				"classNo": classNo,
			},
			success: function(result) {
				if (result > 0) {

					const obj = {}
					obj.noteContent = className+'회차 ' + $("select[name=cancel-reason]").val();
					obj.memberNo = memberNo;
					obj.flag = 1;

					// console.log(obj);

					// 만들어진 JS 객체를 JSON으로 변환하여 웹소켓 객체 handleTextMessage() 로 전달

					// JSON.stringify : JS 객체 -> JSON 문자열
					// JSON.parse : JSON 문자열 -> JS 객체
					noteSock.send(JSON.stringify(obj));

					alert("승인 거절");
					
					$("#modal1").fadeOut(100);

					$('#table_id').DataTable().destroy();
					createTable();

				}
			}
		})
}

// 모달 닫기 버튼
$(".modal-close-btn").click(function() {
	$("#modal1").fadeOut(100);
	$("#modal1").fadeOut(100);
	$(".sendDeny").removeAttr("onclick");
});

// 모달 밖에 클릭시 모달 닫기
$("#modal1").click(function(e) {
	if ($(e.target).hasClass('modal-layer')) {
		$("#modal1").fadeOut(100);
		$(".sendDeny").removeAttr("onclick");
	}

});