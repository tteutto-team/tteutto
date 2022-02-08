$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "classUpdateList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[4, "asc"]],
				columns: [
					{ data: "classNo" },
					{
						data: null,
						render: function (data, type, row) {
							return '<a href="classUpdate/'+ data.classNo +'">' + data.className + '</a>';
						}
					},
					{ data: "memberName" },
					{
						data: null,
						render: function (data, type, row) {
							if(data.classStatus == 0){
								return "신청완료";
							}else{
								return "검토중";
							}
						}
					},
					{ data: "classRequestDate" },
					{
						data: null,
						render: function (data, type, row) {
							return '<button onclick="agree(' + data.classNo + ', ' + data.memberNo + ', \'' + data.className + '\')">승인</button>'
								+ '<button onclick="deny(' + data.classNo + ', ' + data.memberNo + ', \'' + data.className + '\')">거절</button>';
						},
						orderable: false
					}
				]
			})
		}
	})
}

function agree(classNo, memberNo, className) {
	Swal.fire({
		title: '승인 하시겠습니까?',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '승인 쪽지 보내기',
		cancelButtonText: '취소'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				url: "classUpdateAgree",
				dataType: "json",
				data: {
					"classNo": classNo,
				},
				success: function (result) {
					if (result > 0) {

						const obj = {}
						obj.noteContent = "'" + className + "' 수정 신청이 승인되었습니다.";
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
function deny(classNo, memberNo, className) {
	Swal.fire({
		title: '거절 하시겠습니까?',
		input: "select",
		inputOptions: {
			'설명 부족': '설명 부족',
			'부적절한내용': '부적절한내용'
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
				url: "classUpdateDeny",
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