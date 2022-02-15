$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "refundList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				displayStart: (sessionStorage.getItem("page")-1)*10,
				order: [[3, "asc"]],
				columns: [
					{ data: "refundNo" },
					{ data: "studentName" },
					{ 
						data: null,
						render: function (data, type, row) {
							return data.className + '-' + data.episodeCount + '회차';
						}
					},
					{ data: "refundRequestDate" },
					{ data: "classProgress" },
					{ data: "refundMoney" },
					{
						data: null,
						render: function (data, type, row) {
							return '<button onclick="agree(' + data.refundNo + ', \'' + data.className + '-' + data.episodeCount + '\', ' + data.memberNo + ')">승인</button>';
						},
						orderable: false
					}
				]
			})
		}
	})
}

function agree(refundNo, className, memberNo) {
	Swal.fire({
		title: '환불 승인하시겠습니까?',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '확인',
		cancelButtonText: '취소'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				url: "refundAgree",
				dataType: "json",
				data: {
					"refundNo": refundNo
				},
				success: function (result) {
					if (result > 0) {

						const obj = {}
						obj.noteContent = "'" + className + "회차' 환불신청이 승인되었습니다.";
						obj.memberNo = memberNo;
						obj.flag = 0;

						noteSock.send(JSON.stringify(obj));

						Swal.fire({
							title: '신청 승인 완료',
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
function deny(refundNo, className, memberNo) {
	Swal.fire({
		title: '환불 거절 하시겠습니까?',
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