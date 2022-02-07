$(function () {
	createTable();
})

function createTable() {
	$.ajax({
		url: "userList",
		type: "GET",
		dataType: "JSON",
		success: function (data) {
			$('#table_id').DataTable({
				language: lang_kor,
				data: data,
				order: [[0, "asc"]],
				columns: [
					{ data: "memberNo" },
					{ data: "memberName" },
					{
						data: null,
						render: function (data, type, row) {
							if (data.memberGrade == 0) {
								return "유저";
							} else {
								return "관리자";
							}
						}
					},
					{
						data: null,
						render: function (data, type, row) {
							if (data.teacherEnroll == 'Y') {
								return "강사";
							} else {
								return "학생";
							}
						}
					},
					{
						data: null,
						render: function (data, type, row) {
							if (data.teacherStatus == 0) {
								return "신청완료";
							}else if(data.teacherStatus == 1) {
								return "검토중";
							}else if(data.teacherStatus == 2){
								return "승인완료";
							}else if(data.teacherStatus == 3){
								return "반려";
							}else if(data.teacherStatus == 4){
								return "정지";
							}else if(data.teacherStatus == 100){
								return "미신청";
							}
						}
					},
					{
						data: null,
						render: function (data, type, row) {
							if (data.memberStatus == 0) {
								return "정상";
							} else if (data.memberStatus == 1) {
								return "탈퇴";
							} else {
								return "정지";
							}
						}
					},
					{ data: "memberBirth" },
					{
						data: null,
						render: function (data, type, row) {
							if (data.memberGender == 'M') {
								return "남자";
							} else {
								return "여자";
							}
						}
					},
					{ data: "memberPhone" },
					{
						data: null,
						render: function (data, type, row) {
							return '<button onclick="update(this, ' + data.memberNo + ', \'' + data.memberName + '\', '
								+ data.memberGrade + ', \'' + data.teacherEnroll + '\', ' + data.teacherStatus +', '+ data.memberStatus + ', \'' + data.memberBirth + '\', \'' + data.memberGender + '\', \'' + data.memberPhone + '\');">수정</button>'
								+ '<button onclick="note(this,' + data.memberNo + ');">쪽지</button>';
						},
						orderable: false
					}
				]
			})
		}
	})
}


function update(el, memberNo, memberName, memberGrade, teacherEnroll, teacherStatus, memberStatus, memberBirth, memberGender, memberPhone) {
	if ($(".cancel").length != 0) {
		Swal.fire({
			title: '수정중인 작업을 취소하시겠습니까?',
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
		}).then((result) => {
			if (result.value) {
				$(".cancel").click();
				update2(el, memberNo, memberName, memberGrade, teacherEnroll, teacherStatus, memberStatus, memberBirth, memberGender, memberPhone);
			} else {
				return false;
			}
		})
	} else {
		update2(el, memberNo, memberName, memberGrade, teacherEnroll, teacherStatus, memberStatus, memberBirth, memberGender, memberPhone);
	}
}

function update2(el, memberNo, memberName, memberGrade, teacherEnroll, teacherStatus, memberStatus, memberBirth, memberGender, memberPhone) {
	const button = $('<button class="cancel" onclick="cancel(this, ' + memberNo + ', \'' + memberName + '\', '
		+ memberGrade + ', \'' + teacherEnroll + '\', ' + teacherStatus + ', ' + memberStatus + ', \'' + memberBirth + '\', \'' + memberGender + '\', \'' + memberPhone + '\');">취소</button>')
	const button2 = $('<button onclick="save(this, ' + memberNo + ')">저장</button>')

	// 이름 수정 input
	const name = $('<input>').val(memberName).css("width", "50px");
	$(el).parent().parent().children("td:nth-of-type(2)").html(name);

	// 회원 구분 selectbox
	const select1 = $("<select>");
	for (let i = 0; i < 2; i++) {
		let option = $("<option>");
		option.val(i);
		if (i == 0) {
			option.text("유저");
		} else if (i == 1) {
			option.text("관리자");
		}

		if (i == memberGrade) {
			option.attr("selected", "selected");
		}
		select1.append(option);
	}
	$(el).parent().parent().children("td:nth-of-type(3)").html(select1);

	// 강사 등록 여부 selectbox
	const select2 = $("<select>");
	for (let i = 0; i < 2; i++) {
		let option = $("<option>");
		if (i == 0) {
			option.text("학생");
			option.val('N');
		} else if (i == 1) {
			option.text("강사");
			option.val('Y');
		}

		if ('Y' == teacherEnroll) {
			option.attr("selected", "selected");
		}
		select2.append(option);
	}
	$(el).parent().parent().children("td:nth-of-type(4)").html(select2);

	// 강사 신청 상태 selectbox
	const select5 = $("<select>");
	for (let i = 0; i < 5; i++) {
		let option = $("<option>");
		if (i == 0) {
			option.text("신청완료");
			option.val(0);
		} else if (i == 1) {
			option.text("검토중");
			option.val(1);
		}else if(i == 2){
			option.text("승인완료")
			option.val(2);
			
		}else if(i == 3){
			option.text("반려")
			option.val(3);
		}else if(i == 4){
			option.text("정지")
			option.val(4);

		}

		if (i == teacherStatus) {
			option.attr("selected", "selected");
		}
		select5.append(option);
	}
	if(teacherStatus != 100){
		$(el).parent().parent().children("td:nth-of-type(5)").html(select5);
	}

	const select3 = $("<select>");
	for (let i = 0; i < 3; i++) {
		let option = $("<option>");
		option.val(i);
		if (i == 0) {
			option.text("정상");
		} else if (i == 1) {
			option.text("탈퇴");
		} else if (i == 2) {
			option.text("정지");
		}

		if (i == memberStatus) {
			option.attr("selected", "selected");
		}

		select3.append(option);
	}

	$(el).parent().parent().children("td:nth-of-type(6)").html(select3);

	// 생년월일 수정 input
	const birth = $('<input>').val(memberBirth).css("width", "80px").attr("class", "datePicker");
	$(el).parent().parent().children("td:nth-of-type(7)").html(birth);
	$(".datePicker").datepicker();

	// 성별 수정 select
	const select4 = $("<select>");
	for (let i = 0; i < 2; i++) {
		let option = $("<option>");
		if (i == 0) {
			option.text("여자");
			option.val('F');
		} else {
			option.text("남자");
			option.val('M');
		}

		if ('M' == memberGender) {
			option.attr("selected", "selected");
		}

		select4.append(option);
	}
	$(el).parent().parent().children("td:nth-of-type(8)").html(select4);

	// 전화번호 수정 input
	const phone = $('<input>').val(memberPhone).css("width", "110px");
	$(el).parent().parent().children("td:nth-of-type(9)").html(phone);


	// 취소 버튼
	$(el).parent().html(button2).append(button);

}



function cancel(el, memberNo, memberName, memberGrade, teacherEnroll, teacherStatus, memberStatus, memberBirth, memberGender, memberPhone) {

	const button = $('<button onclick="update(this, ' + memberNo + ', \'' + memberName + '\', '
		+ memberGrade + ', \'' + teacherEnroll + '\', ' + teacherStatus + ', ' + memberStatus + ', \'' + memberBirth + '\', \'' + memberGender + '\', \'' + memberPhone + '\');">수정</button>')

	const button2 = $('<button onclick="note(this,' + memberNo + ');">쪽지</button>');

	$(el).parent().parent().children("td:nth-of-type(2)").html(memberName);

	if (memberGrade == 0) {
		$(el).parent().parent().children("td:nth-of-type(3)").html("유저");
	} else {
		$(el).parent().parent().children("td:nth-of-type(3)").html("관리자");
	}

	if (teacherEnroll == 'Y') {
		$(el).parent().parent().children("td:nth-of-type(4)").html("강사");
	} else {
		$(el).parent().parent().children("td:nth-of-type(4)").html("학생");
	}

	if(teacherStatus == 0){
		$(el).parent().parent().children("td:nth-of-type(5)").html("신청완료");
	}else if(teacherStatus == 1){
		$(el).parent().parent().children("td:nth-of-type(5)").html("검토중");
	}else if(teacherStatus == 2){
		$(el).parent().parent().children("td:nth-of-type(5)").html("승인완료");
	}else if(teacherStatus == 3){
		$(el).parent().parent().children("td:nth-of-type(5)").html("반려");
	}else if(teacherStatus == 4){
		$(el).parent().parent().children("td:nth-of-type(5)").html("정지");
	}else if(teacherStatus == 100){
		$(el).parent().parent().children("td:nth-of-type(5)").html("미신청");
	}

	if (memberStatus == 0) {
		$(el).parent().parent().children("td:nth-of-type(6)").html("정상");
	} else if (memberStatus == 1) {
		$(el).parent().parent().children("td:nth-of-type(6)").html("탈퇴");
	} else {
		$(el).parent().parent().children("td:nth-of-type(6)").html("정지");
	}

	$(el).parent().parent().children("td:nth-of-type(7)").html(memberBirth);

	if (memberGender == 'M') {
		$(el).parent().parent().children("td:nth-of-type(8)").html("남자");
	} else {
		$(el).parent().parent().children("td:nth-of-type(8)").html("여자");
	}
	$(el).parent().parent().children("td:nth-of-type(9)").html(memberPhone);

	$(el).parent().html(button).append(button2);

}


$(document).on("click", ".paginate_button", function () {
	$(".cancel").click();
});


function save(el, memberNo) {
	const memberName = $(el).parent().parent().children("td:nth-of-type(2)").children().val();
	const memberGrade = $(el).parent().parent().children("td:nth-of-type(3)").children().val();
	const teacherEnroll = $(el).parent().parent().children("td:nth-of-type(4)").children().val();
	let teacherStatus = $(el).parent().parent().children("td:nth-of-type(5)").children().val();
	const memberStatus = $(el).parent().parent().children("td:nth-of-type(6)").children().val();
	const memberBirth = $(el).parent().parent().children("td:nth-of-type(7)").children().val();
	const memberGender = $(el).parent().parent().children("td:nth-of-type(8)").children().val();
	const memberPhone = $(el).parent().parent().children("td:nth-of-type(9)").children().val();

	if(teacherStatus == undefined){
		teacherStatus = 100;
	}

	console.log(memberName, memberGrade, teacherEnroll, teacherStatus, memberStatus, memberBirth, memberGender, memberPhone);

	Swal.fire({
		title: '수정내용을 저장하시겠습니까?',
		icon: 'info',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '확인',
		cancelButtonText: '취소'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				url: "userSave",
				data: {
					"memberNo": memberNo,
					"memberName": memberName,
					"memberGrade": memberGrade,
					"teacherEnroll": teacherEnroll,
					"teacherStatus": teacherStatus,
					"memberStatus": memberStatus,
					"memberBirth": memberBirth,
					"memberGender": memberGender,
					"memberPhone": memberPhone
				},
				type: "POST",
				success: function (result) {
					if (result > 0) {
						console.log("성공");

						$(el).parent().parent().children("td:nth-of-type(2)").html(memberName);

						if (memberGrade == 0) {
							$(el).parent().parent().children("td:nth-of-type(3)").html("유저");
						} else {
							$(el).parent().parent().children("td:nth-of-type(3)").html("관리자");
						}

						if (teacherEnroll == 'Y') {
							$(el).parent().parent().children("td:nth-of-type(4)").html("강사");
						} else {
							$(el).parent().parent().children("td:nth-of-type(4)").html("학생");
						}

						if(teacherStatus == 0){
							$(el).parent().parent().children("td:nth-of-type(5)").html("신청완료");
						}else if(teacherStatus == 1){
							$(el).parent().parent().children("td:nth-of-type(5)").html("검토중");
						}else if(teacherStatus == 2){
							$(el).parent().parent().children("td:nth-of-type(5)").html("승인완료");
						}else if(teacherStatus == 3){
							$(el).parent().parent().children("td:nth-of-type(5)").html("반려");
						}else if(teacherStatus == 4){
							$(el).parent().parent().children("td:nth-of-type(5)").html("정지");
						}else if(teacherStatus == 100){
							$(el).parent().parent().children("td:nth-of-type(5)").html("미신청");
						}

						if (memberStatus == 0) {
							$(el).parent().parent().children("td:nth-of-type(6)").html("정상");
						} else if (memberStatus == 1) {
							$(el).parent().parent().children("td:nth-of-type(6)").html("탈퇴");
						} else {
							$(el).parent().parent().children("td:nth-of-type(6)").html("정지");
						}

						$(el).parent().parent().children("td:nth-of-type(7)").html(memberBirth);

						if (memberGender == 'M') {
							$(el).parent().parent().children("td:nth-of-type(8)").html("남자");
						} else {
							$(el).parent().parent().children("td:nth-of-type(8)").html("여자");
						}
						$(el).parent().parent().children("td:nth-of-type(9)").html(memberPhone);

						const button = $('<button onclick="update(this, ' + memberNo + ', \'' + memberName + '\', '
							+ memberGrade + ', \'' + teacherEnroll + '\', ' + teacherStatus + ', ' + memberStatus + ', \'' + memberBirth + '\', \'' + memberGender + '\', \'' + memberPhone + '\');">수정</button>');
						const button2 = $('<button onclick="note(this,' + memberNo + ');">쪽지</button>');

						$(el).parent().html(button).append(button2);
					}
				}

			})

		}
	})
}


function note(el, memberNo) {
	const memberName = $(el).parent().parent().children("td:nth-of-type(2)").text();
	Swal.fire({
		title: memberName + '님에게 쪽지 보내기',
		icon: 'info',
		input: 'textarea',
		inputPlaceholder: '내용을 입력해주세요',
		inputAttributes: {
			'aria-label': '내용을 입력해주세요',
			'style': 'resize: none;'
		},
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: '쪽지 보내기',
		cancelButtonText: '취소'
	}).then((result) => {
		if (result.value) {
			console.log(result.value);
			const obj = {}
			obj.noteContent = result.value;
			obj.memberNo = memberNo;
			obj.flag = 0;

			noteSock.send(JSON.stringify(obj));

			Swal.fire({
				title: '쪽지 보내기 완료',
				icon: 'success',
				confirmButtonColor: '#3085d6',
				confirmButtonText: '확인',
			})
		}
	})
}