reviewList(1);

let reviewText;
let pageNum = 1;
let i = 0;
let star;

function reviewList(pageNum) {
	$.ajax({
		url: "reviewList",
		data: {
			"classNo": classNo,
			"pageNum": pageNum
		},
		type: "GET",
		dataType: "JSON",
		success: function (result) {
			$(".review_box").empty();
			$("#reviewCtn").html(result.count);
			if (result.data.length > 0) {
				for (let re of result.data) {
					const reviewList = $("<div class='review_List'>");
					const profileImg = $("<img src='" + contextPath + "/resources/images/profile/" + re.memberImg + "'>");
					const reviewId = $("<div class='review_id'>" + re.memberName + "**</div>");
					const reviewDate = $("<div class='review_date'>" + re.reviewDt + "</div>");
					const reviewStar = $("<div class='review_star'>");
					for (let i = 0; i < re.reviewStar; i++) {
						reviewStar.append("<img class='star' src='" + contextPath + "/resources/images/class-detail/star.png'>");
					}
					for (let i = 0; i < (5 - re.reviewStar); i++) {
						reviewStar.append("<img class='emptyStar' src='" + contextPath + "/resources/images/class-detail/star2.png'>");
					}

					const reviewContent = $("<div class='review_content'>");
					const review_hide = $("<p class='review_hide on'>" + re.reviewContent + "</p>");
					const moreBtn = $("<span class='moreBtn'>더읽기</span>");
					const foldBtn = $("<span class='foldBtn' style='display: none;'>접기</span>");

					reviewContent.append(review_hide);


					reviewList.append(profileImg, reviewId, reviewDate, reviewStar, reviewContent);
					if (re.memberNo == loginMemberNo) {
						const editBtn = $("<div class='editBtn'>");
						editBtn.append("<button type='button' class='modifyBtn' onclick='updateShow(this, " + re.reviewNo + ")'>수정</button>");
						editBtn.append("<button type='button' class='deleteBtn' onclick='remove(this, " + re.reviewNo + ")'>삭제</button>");

						reviewList.append(editBtn);
					}

					if (teacherNo == loginMemberNo) {
						const reviewDeclare = $("<div class='review_declare'>");
						reviewDeclare.append("<button type='button' class='reviewDeclareBtn' onclick='report("+ re.memberNo +")'>신고하기</button>");

						reviewList.append(reviewDeclare);
					}

					$(".review_box").append(reviewList);
					if($(".review_hide.on").eq(i).outerHeight() == 72){
						reviewContent.append(moreBtn, foldBtn);
					}
					i++;
				}

				const pageNumber = $("<div class='page-number'>");
				const pageUl = $("<ul class='page-ul'>");
				console.log(result.pagination.startPage);
				console.log(result.pagination.endPage);
				console.log(result.pagination.prevPage);
				if (result.pagination.startPage != 1) {
					const li1 = $("<li>");
					li1.append("<a onclick='reviewList(1);'>&lt;&lt;</a>");
					const li2 = $("<li>");
					li2.append('<a onclick="reviewList(' + result.pagination.prevPage + ');">&lt;</a>');
					pageUl.append(li1, li2);
				}

				for (let i = result.pagination.startPage; i <= result.pagination.endPage; i++) {
					if (i == result.pagination.currentPage) {
						const li = $('<li style="border: 1px solid #FFDF3E; border-radius: 50%; background-color: #FFDF3E; cursor:text;">');
						li.append('<a style="color: white;">' + i + '</a>');
						pageUl.append(li);
					} else {
						const li = $("<li>");
						li.append('<a onclick="reviewList(' + i + ');">' + i + '</a>');
						pageUl.append(li);
					}
				}

				if (result.pagination.endPage != result.pagination.maxPage) {
					const li1 = $("<li>");
					li1.append("<a onclick='reviewList(" + result.pagination.nextPage + ");'>&gt;</a>");
					const li2 = $("<li>");
					li2.append('<a onclick="reviewList(' + result.pagination.maxPage + ');">&gt;&gt;</a>');
					pageUl.append(li1, li2);
				}
				pageNumber.append(pageUl);
				$(".review_box").append(pageNumber);

				i = 0;
			} else {
				$(".review_area").css("margin", "0 20px");
				$(".review_box").append("작성된 후기가 존재하지 않습니다.");

			}
		}
	})
}


function updateShow(el, reviewNo) {
	reviewText = $(el).parent().prev().children("p").html().replaceAll("<br>", "\r\n");
	star = $(el).parent().parent().children(".review_star").html();

	$(el).parent().prev().remove();
	$(el).parent().before("<textarea class='review_content'>" + reviewText + "</textarea>");
	$(el).parent().prev().css({ "display": "block", "width": "600px", "resize": "none", "min-height": "22px" });

	$(el).parent().parent().children(".review_star").children().addClass("starUpdate");

	$(el).parent().html("<button type='button' onclick='update(this," + reviewNo + ")'>수정</button><button type='button' onclick='cancel(this, " + reviewNo + ")'>취소</button>")
}


function cancel(el, reviewNo) {
	$(".editBtn").append("<button type='button' class='modifyBtn' onclick='updateShow(this, " + reviewNo + ")'>수정</button>");
	$(".editBtn").append("<button type='button' class='deleteBtn' onclick='remove(this, " + reviewNo + ")'>삭제</button>");
	const moreBtn = $("<span class='moreBtn'>더읽기</span>");
	const foldBtn = $("<span class='foldBtn' style='display: none;'>접기</span>");

	const reviewContent = $("<div class='review_content'>");
	const review_hide = $("<p class='review_hide on'>" + reviewText.replaceAll("\r\n", "<br>") + "</p>");

	$(el).parent().prev().remove();

	$(el).parent().before(reviewContent);
	$(el).parent().prev().append(review_hide);

	if($(el).parent().prev().children("p").outerHeight() == 72){
		$(el).parent().prev().append(moreBtn, foldBtn);
	}

	$(el).parent().parent().children(".review_star").children().removeClass("starUpdate");
	$(el).parent().parent().children(".review_star").html(star);

	$(el).prev().remove();
	$(el).remove();

	
}

function update(el, reviewNo) {
	swal({
		title: '후기를 수정하시겠습니까?',
		icon: 'warning',
		buttons: {
			cancel: {
				text: "취소",
				visible: true,
				value: false
			},
			confirm: {
				text: "수정",
				value: true
			}
		}
	}).then((result) => {
		if (result) {
			$.ajax({
				url: "reviewUpdate",
				data: {
					"reviewNo": reviewNo,
					"reviewContent": $(el).parent().prev().val(),
					"reviewStar": $(el).parent().parent().children(".review_star").children(".star").length
				},
				success: function (result) {
					if (result > 0) {
						swal({
							title: '수정 완료되었습니다.',
							icon: 'success',
							buttons: {
								confirm: {
									text: "확인",
									value: true
								}
							}
						})
						reviewList(pageNum);
					}
				}
			})
		}
	});
}

function remove(el, reviewNo) {
	swal({
		title: '후기를 삭제하시겠습니까?',
		icon: 'warning',
		dangerMode: true,
		buttons: {
			cancel: {
				text: "취소",
				visible: true,
				value: false
			},
			confirm: {
				text: "삭제",
				value: true
			}
		}
	}).then((result) => {
		if (result) {
			$.ajax({
				url: "reviewDelete",
				data: { "reviewNo": reviewNo },
				success: function (result) {
					if (result > 0) {
						swal({
							title: '삭제 완료되었습니다.',
							icon: 'success',
							buttons: {
								confirm: {
									text: "확인",
									value: true
								}
							}
						})
						reviewList(pageNum);
					}
				}
			})
		}
	});
}


$(document).on("click", ".starUpdate", function () {
	$(this).prevAll().removeClass("star");
	$(this).prevAll().removeClass("emptyStar");
	$(this).removeClass("star");
	$(this).removeClass("emptyStar");
	$(this).prevAll().addClass("star");
	$(this).addClass("star");
	$(this).prevAll().attr("src", "" + contextPath + "/resources/images/class-detail/star.png");
	$(this).attr("src", "" + contextPath + "/resources/images/class-detail/star.png");

	$(this).nextAll().removeClass("star");
	$(this).nextAll().addClass("emptyStar");
	$(this).nextAll().attr("src", "" + contextPath + "/resources/images/class-detail/star2.png");

})

function report(memberNo){
	swal({
		title: '신고하시겠습니까?',
		icon: 'warning',
		dangerMode: true,
		buttons: {
			cancel: {
				text: "취소",
				visible: true,
				value: false
			},
			confirm: {
				text: "신고",
			}
		},
		content: {
			element: "textarea",
			style: {"resize":"none"}
		}
	}).then((result) => {
		if(result){
			$.ajax({
				url: "report",
				data: {
					"memberNo": memberNo,
					"reportContent": $(".swal-content__textarea").val(),
					"episodeNo": epNo
				},
				success: function(result){
					if(result > 0){
						swal({
							title: '신고 완료되었습니다.',
							icon: 'success',
							buttons: {
								confirm: {
									text: "확인",
									value: true
								}
							}
						})
					}
				}
			})
		}
	})
}