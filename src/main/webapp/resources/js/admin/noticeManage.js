$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "noticeList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			console.log(data);
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[2, "desc"]],
				columns: [
					{ data: "noticeNo" },
					{
						data: null,
						render: function (data, type, row) {
							return '<a href="#">' + data.noticeTitle + '</a>';
						}
					},
					{ data: "noticeDate" },
					{
						data: null,
						render: function (data, type, row) {
							return '<button onclick="agree(' + data.noticeNo + ')">삭제</button>'
						},
						orderable: false
					}
				],
			})
		}
	})
}

function agree(noticeNo) {
	Swal.fire({
		title: '삭제 하시겠습니까?',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '삭제하기',
		cancelButtonText: '취소'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				url: "noticeDelete",
				dataType: "json",
				data: {
					"noticeNo": noticeNo
				},
				success: function (result) {
					if (result > 0) {

						Swal.fire({
							title: '삭제 완료',
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

// 거절 쪽지 보내기
function deny(classNo, memberNo, className) {
	Swal.fire({
		title: '거절 하시겠습니까?',
		input: "select",
		inputOptions: {
			'설명 부족': '설명 부족',
			'부적절한내용': '부적절한내용',
			'가격 부적합': '가격 부적합'
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
				url: "classDeny",
				dataType: "json",
				data: {
					"classNo": classNo,
				},
				success: function (result) {
					if (result > 0) {

						const obj = {}
						obj.noteContent = "'" + className + "' " + message + "로/으로 신청 거절되었습니다.";
						obj.memberNo = memberNo;
						obj.flag = 0;

						noteSock.send(JSON.stringify(obj));

						Swal.fire({
							title: '신청 거절 완료',
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