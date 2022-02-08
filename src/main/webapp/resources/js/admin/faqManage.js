$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "faqList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[0, "desc"]],
				columns: [
					{ data: "faqNo" },
					{
						data: null,
						render: function (data, type, row) {
							return '<a href="'+ contextPath +'/notice/faq" target="_blank">' + data.faqQuestion + '</a>';
						}
					},
					{
						data: null,
						render: function (data, type, row) {
							let div;

							if (data.faqDiv == 0) {
								div = "학생";
							} else {
								div = "강사";
							}

							return div;
						}

					},
					{
						data: null,
						render: function (data, type, row) {
							return '<button onclick="agree(' + data.faqNo + ')">삭제</button>'
						},
						orderable: false
					}
				],
			})
		}
	})
}

function agree(faqNo) {
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
				url: "faqDelete",
				dataType: "json",
				data: {
					"faqNo": faqNo
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