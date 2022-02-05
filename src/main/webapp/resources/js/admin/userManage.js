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
								+ data.memberGrade + ', \'' + data.teacherEnroll + '\', ' + data.memberStatus + ', \'' + data.memberBirth + '\', \'' + data.memberGender + '\', \'' + data.memberPhone + '\');">수정</button>';
						},
						orderable: false
					}
				]
			})
		}
	})
}

function update(el, memberNo, memberName, memberGrade, teacherEnroll, memberStatus, memberBirth, memberGender, memberPhone) {

	if ($(".cancel").length != 0) {
		if (confirm("수정중인 작업을 취소하시겠습니까?")) {
			$(".cancel").click();
		} else {
			return false;
		}
	}


	const button = $('<button class="cancel" onclick="cancel(this, ' + memberNo + ', \'' + memberName + '\', '
		+ memberGrade + ', \'' + teacherEnroll + '\', ' + memberStatus + ', \'' + memberBirth + '\', \'' + memberGender + '\', \'' + memberPhone + '\');">취소</button>')

	// 이름 수정 input
	const name = $('<input>').val(memberName).css("width", "50px");
	$(el).parent().parent().children("td:nth-of-type(2)").html(name);

	// 회원 구분 selectbox
	const select1 = $("<select>");
	for (let i = 0; i < 2; i++) {
		let option = $("<option>");
		option.val(memberGrade);
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
		option.val(teacherEnroll);
		if (i == 0) {
			option.text("학생");
		} else if (i == 1) {
			option.text("강사");
		}

		if ('Y' == teacherEnroll) {
			option.attr("selected", "selected");
		}
		select2.append(option);
	}
	$(el).parent().parent().children("td:nth-of-type(4)").html(select2);

	const select3 = $("<select>");
	for (let i = 0; i < 3; i++) {
		let option = $("<option>");
		option.val(memberStatus);
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

	$(el).parent().parent().children("td:nth-of-type(5)").html(select3);

	// 생년월일 수정 input
	const birth = $('<input>').val(memberBirth).css("width", "80px").attr("class", "datePicker");
	$(el).parent().parent().children("td:nth-of-type(6)").html(birth);
	$(".datePicker").datepicker();

	// 성별 수정 select
	const select4 = $("<select>");
	for (let i = 0; i < 2; i++) {
		let option = $("<option>");
		option.val(memberGender);
		if (i == 0) {
			option.text("여자");
		} else{
			option.text("남자");
		}

		if ('M' == memberGender) {
			option.attr("selected", "selected");
		}

		select4.append(option);
	}
	$(el).parent().parent().children("td:nth-of-type(7)").html(select4);

	// 전화번호 수정 input
	const phone = $('<input>').val(memberPhone).css("width", "110px");
	$(el).parent().parent().children("td:nth-of-type(8)").html(phone);


	// 취소 버튼
	$(el).parent().html(button);

}





function cancel(el, memberNo, memberName, memberGrade, teacherEnroll, memberStatus, memberBirth, memberGender, memberPhone) {

	const button = $('<button onclick="update(this, ' + memberNo + ', \'' + memberName + '\', '
		+ memberGrade + ', \'' + teacherEnroll + '\', ' + memberStatus + ', \'' + memberBirth + '\', \'' + memberGender + '\', \'' + memberPhone + '\');">수정</button>')

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

	if (memberStatus == 0) {
		$(el).parent().parent().children("td:nth-of-type(5)").html("정상");
	} else if (memberStatus == 1) {
		$(el).parent().parent().children("td:nth-of-type(5)").html("탈퇴");
	} else {
		$(el).parent().parent().children("td:nth-of-type(5)").html("정지");
	}

	$(el).parent().parent().children("td:nth-of-type(6)").html(memberBirth);

	if (memberGender == 'M') {
		$(el).parent().parent().children("td:nth-of-type(7)").html("남자");
	} else {
		$(el).parent().parent().children("td:nth-of-type(7)").html("여자");
	}
	$(el).parent().parent().children("td:nth-of-type(8)").html(memberPhone);

	$(el).parent().html(button);

}



$(document).on("click", ".paginate_button", function(){
	$(".cancel").click();
});