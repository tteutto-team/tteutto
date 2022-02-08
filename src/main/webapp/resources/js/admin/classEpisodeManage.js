$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "classEpisodeList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[4, "asc"]],
				columns: [
					{ data: "episodeNo" },
					{
						data: null,
						render: function (data, type, row) {
							return '<a href="classEpisode/'+ data.episodeNo +'?no='+ data.classNo +'">' + data.className + '-' + data.episodeCount + '회차</a>';
						}
					},
					{ data: "memberName" },
					{
						data: null,
						render: function (data, type, row) {
							if(data.episodeStatus == 0){
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
							return '<button onclick="agree(' + data.episodeNo + ', ' + data.memberNo + ', \'' + data.className + '-' + data.episodeCount + '\')">승인</button>'
							+ '<button onclick="deny(' + data.episodeNo + ', ' + data.memberNo + ', \'' + data.className + '-' + data.episodeCount + '\')">거절</button>';
						},
						orderable: false
					}
				]
			})
		}
	})
}

function agree(episodeNo, memberNo, className) {
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
				url: "episodeAgree",
				dataType: "json",
				data: {
					"episodeNo": episodeNo,
					"memberNo": memberNo,
					"className": className,
				},
				success: function (result) {
					if (result > 0) {

						const obj = {}
						obj.noteContent = "'" + className + "회차' 신청이 승인되었습니다.";
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
function deny(episodeNo, memberNo, className) {
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
				url: "episodeDeny",
				dataType: "json",
				data: {
					"episodeNo": episodeNo,
				},
				success: function (result) {
					if (result > 0) {

						const obj = {}
						obj.noteContent = "'" + className + "회차' " + message + "로/으로 신청 거절되었습니다.";
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