$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "receiptList",
		type: "GET",
		dataType: "JSON",
		data: {calNo : paramCalNo},
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				columns: [
					{ data: "studentName" },
					{ 
						data: null,
						render: function (data, type, row) {
							if(data.classProgress == 0){
								return "100%";
							}else{
								return data.classProgress + "%";
							}
						}	
					},
					{ 
						data: null,
						render: function (data, type, row) {
							return data.calPrice.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") + "원";
						}	
					},
				]
			})
		}
	})
}
function a(){
	let price = 0;
	
	const td = $("table tbody td:last-of-type");
	
	for(let i=0; i< td.length; i++){
		price += parseInt($(td[i]).text().replaceAll(",", "").replaceAll("원", ""));
	}
	
	Swal.fire({
		title: '정산하시겠습니까?',
		text: '합계 : '+ price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") + '원',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '확인',
		cancelButtonText: '취소'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				url: "../receiptUpdate",
				data: {calNo: paramCalNo},
				type: "POST",
				success: function(result){
					if(result > 0){
						
						const obj = {}
						obj.noteContent = "'" + teacherName + "'님 "+ className +" 정산이 완료되었습니다.";
						obj.memberNo = memberNo;
						obj.flag = 0;

						noteSock.send(JSON.stringify(obj));
						
						Swal.fire({
							title: '정산이 완료되었습니다.',
							icon: 'success',
							confirmButtonColor: '#3085d6',
							confirmButtonText: '확인',
						}).then((result) => {
							
							location.href = "../calculateManage";
						})
					}
				}
				
			})
		}
	})
	
}