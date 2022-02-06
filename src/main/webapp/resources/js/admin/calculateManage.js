$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "calculateList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[3, "asc"]],
				columns: [
					{ data: "calNo" },
					{
						data: null,
						render: function (data, type, row) {
							if(data.calStatus == 0){
								return '' + data.className + '-' + data.episodeCount + '회차';
							}else if(data.calStatus == 2){
								return '<a href="calculate/' + data.calNo + '">' + data.className + '-' + data.episodeCount + '회차</a>';
								
							}
						}
					},
					{ data: "teacherName" },
					{ data: "calRequestNo" },
					{
						data: null,
						render: function (data, type, row) {
							if(data.calStatus == 0){
								return '<button onclick="agree(' + data.calNo + ')">영수증 생성</button>';
							}else if(data.calStatus == 2){
								return '영수증 출력 완료';
							}
						},
						orderable: false
					}
				]
			})
		}
	})
}

function agree(calNo) {
	Swal.fire({
		title: '영수증을 생성하시겠습니까?',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '확인',
		cancelButtonText: '취소'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				url: "createReceipt",
				dataType: "json",
				data: {
					"calNo": calNo
				},
				success: function (result) {
					if (result > 0) {

						Swal.fire({
							title: '신청 승인 완료',
							icon: 'success',
							confirmButtonColor: '#3085d6',
							confirmButtonText: '확인',
						}).then((result) => {
							location.href = "calculate/" + calNo;
						})

					}
				}
			})
		}
	})

}