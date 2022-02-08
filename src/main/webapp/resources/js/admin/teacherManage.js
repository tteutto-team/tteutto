$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "teacherList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[3, "asc"]],
				columns: [
					{ data: "memberNo" },
					{
						data: null,
						render: function (data, type, row) {
							return '<a href="teacher/' + data.memberNo + '">' + data.memberName + '</a>';
						}
					},
					{
						data: null,
						render: function (data, type, row) {
							if(data.teacherStatus == 0){
								return "신청완료";
							}else{
								return "검토중";
							}
						}
					},
					{ data: "teacherRequestDate" },
					{
						data: null,
						render: function (data, type, row) {
							return '<button onclick="agree(' + data.memberNo + ', \'' + data.memberName + '\')">승인</button>'
							+ '<button onclick="deny(' + data.memberNo + ', \'' + data.memberName + '\')">거절</button>';
						},
						orderable: false
					}
				]
			})
		}
	})
}

function agree(memberNo, memberName) {
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
				url: "teacherAgree",
				dataType: "json",
				data: {
					"memberNo": memberNo,
				},
				success: function (result) {
					if (result > 0) {

						const obj = {}
						obj.noteContent = "'" + memberName + "'님 강사 신청이 승인되었습니다.";
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
function deny(memberNo, memberName) {
	Swal.fire({
		title: '거절 하시겠습니까?',
		input: "select",
		inputOptions: {
			'설명 부족': '설명 부족',
			'이력서 미첨부': '이력서 미첨부',
			'자격 미달': '자격 미달'
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
				url: "teacherDeny",
				dataType: "json",
				data: {
					"memberNo": memberNo,
				},
				success: function (result) {
					if (result > 0) {

						const obj = {}
						obj.noteContent = "'" + memberName + "'님 " + message + "로/으로 강사 신청이 거절되었습니다.";
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