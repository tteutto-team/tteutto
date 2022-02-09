$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "reviewList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[5, "desc"]],
				columns: [
					{ data: "reviewNo" },
					{
						data: null,
						render: function (data, type, row) {
							return data.className + '-' + data.episodeCount + '회차';
						}
					},
					{ data: "memberName" },
					{ data: "reviewContent" },
					{
						data: null,
						render: function (data, type, row) {
							if(data.reviewStatus == 0){
								return "정상";
							}else{
								return "삭제";
							}
						}
					},
					{
						data: "reviewDate"
					},
					{
						data: null,
						render: function (data, type, row) {
							if(data.reviewStatus == 0){
								return '<button onclick="deny(' + data.reviewNo + ', ' + data.memberNo + ', \'' + data.reviewContent + '\')">삭제</button>';
							}else{
								return "-";
							}
						},
						orderable: false
					}
				]
			})
		}
	})
}

// 거절 쪽지 보내기
function deny(reviewNo, memberNo, reviewContent) {
	Swal.fire({
		title: '후기를 삭제 하시겠습니까?',
		input: "select",
		inputOptions: {
			'부적절한내용': '부적절한내용',
			'욕설': '욕설'
		},
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '거절 쪽지 보내기',
		cancelButtonText: '취소'
	}).then((result) => {
		const message = result.value;

		if (result.value) {
			$.ajax({
				url: "reviewDeny",
				dataType: "json",
				data: {
					"reviewNo": reviewNo,
				},
				success: function (result) {
					if (result > 0) {

						const obj = {}
						obj.noteContent = "회원님이 작성한 '" + reviewContent + "' 후기가 " + message + "로/으로 삭제되었습니다.";
						obj.memberNo = memberNo;
						obj.flag = 0;

						noteSock.send(JSON.stringify(obj));

						Swal.fire({
							title: '후기 삭제 완료',
							icon: 'success',
							confirmButtonColor: '#3085d6',
							confirmButtonText: '확인',
						})

						$('#table_id').DataTable().destroy();
						createTable();

					}
				}
			})
		}
	})
}