$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "studentReportList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[3, "asc"]],
				columns: [
					{ data: "reportNo" },
					{ data: "reportName"},
					{ data: "reportTarget" },
					{ data: "reportRequestDate"},
					{ data: "reportCount"},
					{
						data: null,
						render: function (data, type, row) {
							return '<button onclick="agree(' + data.reportNo + ', \'' + data.reportContent + '\', ' + data.reportTargetNo + ', ' + data.reportCount + ', '+ data.reportDiv +')">신고 내용</button>';
						},
						orderable: false
					}
				]
			})
		}
	})
}

function agree(reportNo,  reportContent, reportTargetNo, reportCount, reportDiv) {
	Swal.fire({
		title: '신고 내용',
		text: reportContent,
		icon: 'warning',
		showCancelButton: true,
		showDenyButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '신고 승인',
		denyButtonText: '신고 거절',
		cancelButtonText: '취소'
	}).then((result) => {
		if (result.value != undefined) {

			let reportStatus;

			if(result.value){
				reportStatus = 2;
				
			}else{
				reportStatus = 3;
			}

			$.ajax({
				url: "reportAgreeDeny",
				dataType: "json",
				data: {
					"reportNo": reportNo,
					"reportTargetNo": reportTargetNo,
					"reportCount": reportCount,
					"reportStatus": reportStatus,
					"reportDiv" : reportDiv
				},
				success: function (result) {
					console.log(result);
					if (result > 0) {

						if(reportStatus == 2){
							const obj = {}
							obj.noteContent = "회원님의 누적 신고횟수는 '" + (reportCount+1) + "'회 입니다.";
							obj.memberNo = reportTargetNo;
							obj.flag = 0;
	
							noteSock.send(JSON.stringify(obj));
	
							Swal.fire({
								title: '신고 승인 완료',
								icon: 'success',
								confirmButtonColor: '#3085d6',
								confirmButtonText: '확인',
							})

						}else{

							Swal.fire({
								title: '신고 승인 거절',
								icon: 'success',
								confirmButtonColor: '#3085d6',
								confirmButtonText: '확인',
							})

						}

						$('#table_id').DataTable().destroy();
						createTable();

					}
				}
			})
		}
	})

}
