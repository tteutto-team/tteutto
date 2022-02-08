$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "noticeList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[2, "desc"]],
				columns: [
					{ data: "noticeNo" },
					{
						data: null,
						render: function (data, type, row) {
							return '<a href="'+ contextPath +'/notice/noticeView/'+ data.noticeNo +'" target="_blank">' + data.noticeTitle + '</a>';
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
