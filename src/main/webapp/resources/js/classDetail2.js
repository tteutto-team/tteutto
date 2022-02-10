function reviewList(pageNum){
	$.ajax({
		url: "reviewList",
		data: {
			"classNo" : classNo,
			"pageNum" : pageNum
		},
		type: "GET",
		dataType: "JSON",
		success: function(result){
			$(".review_box").empty();
			if(result.data.length > 0){
				for(let re of result.data){
					const reviewList = $("<div class='review_List'>");
					const profileImg = $("<img src='"+ contextPath +"/resources/images/profile/"+ re.memberImg +"'>");
					const reviewId = $("<div class='review_id'>"+ re.memberName +"**</div>");
					const reviewDate = $("<div class='review_date'>"+ re.reviewDt +"</div>");
					const reviewStar = $("<div class='review_star'>");
					for(let i=0; i<re.reviewStar; i++){
						reviewStar.append("<img src='"+ contextPath +"/resources/images/class-detail/star.png'>");
					}
					for(let i=0; i<(5-re.reviewStar); i++){
						reviewStar.append("<img src='"+ contextPath +"/resources/images/class-detail/star2.png'>");
					}
	
					const reviewContent = $("<div class='review_content'>");
					const review_hide = $("<p class='review_hide on'>"+ re.reviewContent +"</p>");
					const moreBtn = $("<span class='moreBtn'>더읽기</span>");
					const foldBtn = $("<span class='foldBtn' style='display: none;'>접기</span>");
					reviewContent.append(review_hide, moreBtn, foldBtn);
	
	
					reviewList.append(profileImg, reviewId, reviewDate, reviewStar, reviewContent);
	
					if(re.memberNo = loginMemberNo){
						const editBtn = $("<div class='editBtn'>");
						editBtn.append("<button type='button' class='modifyBtn'>수정</button>");
						editBtn.append("<button type='button' class='deleteBtn'>삭제</button>");
	
						reviewList.append(editBtn);
					}
	
					if(teacherNo == loginMemberNo){
						const reviewDeclare = $("<div class='review_declare'>");
						reviewDeclare.append("<button type='button' class='reviewDeclareBtn'>신고하기</button>");
						
						reviewList.append(reviewDeclare);
					}
	
					$(".review_box").append(reviewList);
				}

				const pageNumber = $("<div class='page-number'>");
				const pageUl = $("<ul class='page-ul'>");
				if(result.pagination.startPage != 1){
					const li1 = $("<li>");
					li1.append("<a onclick='reviewList(1);'><i class='fas fa-angle-double-left'></i></a>");
					const li2 = $("<li>");
					li2.append('<a onclick="reviewList('+ result.pagination.prevPage +');"><i class="fas fa-angle-left"></i></a>');
					pageUl.append(li1, li2);
				}

				for(let i=result.pagination.startPage; i<=result.pagination.endPage; i++){
					if(i == result.pagination.currentPage){
						const li = $('<li style="border: 1px solid #FFDF3E; border-radius: 50%; background-color: #FFDF3E; cursor:text;">');
						li.append('<a style="color: white;">'+ i +'</a>');
						pageUl.append(li);
					}else{
						const li = $("<li>");
						li.append('<a onclick="reviewList('+ i +');">'+ i +'</a>');
						pageUl.append(li);
					}
				}

				if(result.pagination.endPage != result.pagination.maxPage){
					const li1 = $("<li>");
					li1.append("<a onclick='reviewList("+ result.pagination.nextPage +");'><i class='fas fa-angle-right'></i></a>");
					const li2 = $("<li>");
					li2.append('<a onclick="reviewList('+ result.pagination.maxPage +');"><i class="fas fa-angle-double-right"></i></a>');
					pageUl.append(li1, li2);
				}
				pageNumber.append(pageUl);
				$(".review_box").append(pageNumber);

			}else{
				console.log("작성된 후기가 존재하지 않습니다.");
	
			}
			// <div class="page-number">
				// 	<ul class="page-ul">
				// 		<c:if test="${pagination.startPage != 1}">
				// 			<li>
				// 				<a href="notice?cd=110&cp=1"><i class="fas fa-angle-double-left"></i></a>
				// 			</li>
				// 			<li>
				// 				<a href="notice?cd=110&cp=${pagination.prevPage}"><i class="fas fa-angle-left"></i></a>
				// 			</li>
				// 		</c:if>
						
				// 		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1" var="i">
				// 			<c:choose>
				// 				<c:when test="${i == pagination.currentPage}">
				// 					<li style="border: 1px solid #4facfe; border-radius: 50%; background-color: #4facfe;">
				// 						<a style="color: white;">${i}</a>
				// 					</li>
				// 				</c:when>
				// 				<c:otherwise>
				// 					<li>
				// 						<a href="${contextPath}/board/notice?cd=110&cp=${i}">${i}</a>
				// 					</li>
				// 				</c:otherwise>
				// 			</c:choose>
				// 		</c:forEach>
						
						
				// 		<c:if test="${pagination.endPage != pagination.maxPage}">
				// 			<li>
				// 				<a href="${contextPath}/board/notice?cd=110&cp=${pagination.nextPage}"><i class="fas fa-angle-right"></i></a>
				// 			</li>
				// 			<li>
				// 				<a href="${contextPath}/board/notice?cd=110&cp=${pagination.maxPage}"><i class="fas fa-angle-double-right"></i></a>
				// 			</li>
				// 		</c:if>
				// 	</ul>
			// </div>

		}
	})
}

reviewList(1);
