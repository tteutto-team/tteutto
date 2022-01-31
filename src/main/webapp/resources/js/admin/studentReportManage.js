$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "studentReportList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			console.log(data);
			$('#table_id').DataTable({
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
							return '<button onclick="agree(' + data.reportNo + ', \'' + data.reportContent + '\', ' + data.reportTargetNo + ', ' + data.reportCount + ')">신고 내용</button>';
						},
						orderable: false
					}
				]
			})
		}
	})
}

function agree(reportNo,  reportContent, reportTargetNo, reportCount) {
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
					"reportStatus": reportStatus
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
						obj.flag = 1;

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