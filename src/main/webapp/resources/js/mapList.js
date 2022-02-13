$(function(){
	$(".detail").eq(0).attr("onclick", "location.href='main/locationClass?location=서울 강남구'")
 	$("#location").text("서울 강남구");	
});






$(".location").on("click", function(){
	var geocoder = new kakao.maps.services.Geocoder();
	let location ="";
	if (navigator.geolocation) {
	
		// GeoLocation을 이용해서 접속 위치를 얻어옵니다
		navigator.geolocation.getCurrentPosition(function(position) {
	
			var lat = position.coords.latitude; // 위도
			var lng = position.coords.longitude; // 경도
			
			
			getAddr(lat,lng);
			function getAddr(lat,lng){
			
			    let coord = new kakao.maps.LatLng(lat, lng);
			    let callback = function(result, status) {
			        if (status === kakao.maps.services.Status.OK) {
			            location =result[0].address.region_1depth_name + " " + result[0].address.region_2depth_name;
			            $("#location").text(location);

						$(".detail").eq(0).attr("onclick", "location.href='main/locationClass?location="+location+"'")

						$.ajax({
							url : contextPath + "/main/changeOption",
							data : {"sido" : result[0].address.region_1depth_name, 
									"sigoon" : result[0].address.region_2depth_name, 
									"type" : "location",
									"location" : location},
							dataType : "json", 
							success : function(result) {
								// 기존 클래스 카드 삭제
								$('.hot-class-bottom-view:eq(0)').empty();
		 		
						 		for (let classList of result.classList) {
						 			// 클래스 카드 
							 		const classCard = $('<div class="class">');
							 		
							 		const imgDiv = $('<div class="image">');
							 		
							 		// 클래스 이미지 
							 		const img = $('<img>');
							 		img.attr("src", contextPath + "/resources/images/class-detail/" + classList.thumbnailImageName);
							 		img.attr("onclick", "location.href='/tteutto/class/classDetail?classNo=" + classList.classNo 
							 							+ "&epNo=" + classList.episodeNo + "'");
							 		
							 		// 수업 등록 지역 
							 		const locationP = $('<p class="location-p">').text(classList.classArea);
							 		
									imgDiv.append(img, locationP);
									classCard.append(imgDiv);
							 		
									// 클래스 찜하기 버튼 
									let btnLike;
									let imgEmoti;
									let aniHeartM;
									
									// 찜 X 
									if (classList.heartFlag == 0) {
										btnLike = $('<button type="button" class="btn_like">').attr('id',classList.classNo);
										imgEmoti = $('<span class="img_emoti">').text('좋아요');
										aniHeartM = $('<span class="ani_heart_m">');
									
									// 찜 O 
									} else {
										btnLike = $('<button type="button" class="btn_like btn_unlike">').attr('id',classList.classNo);
										imgEmoti = $('<span class="img_emoti">').text('좋아요');
										aniHeartM = $('<span class="ani_heart_m hi">');
									}
									
									btnLike.append(imgEmoti, aniHeartM);
									
									// 클래스 찜하기 버튼 이벤트 
									$(btnLike).click(function() {
										const classNo = this.getAttribute("id");
										
										if ("${loginMember}" != "") {
											const heartBtn = this;
											
											$.ajax({
												url : "${contextPath}/member/changeHeart", 
												data : {"classNo" : classNo}, 
												success : function(result) {
													if (result > 0) {
													    if ($(heartBtn).hasClass('btn_unlike')) {
													        $(heartBtn).removeClass('btn_unlike');
													        $(heartBtn).children('span:eq(1)').removeClass('hi');
													        $(heartBtn).children('span:eq(1)').addClass('bye');
													        
													    } else {
													        $(heartBtn).addClass('btn_unlike');
													        $(heartBtn).children('span:eq(1)').removeClass('bye');
													        $(heartBtn).children('span:eq(1)').addClass('hi');
													    }
													}
												}
											}) 
										
										} else alert("로그인 후 이용 가능합니다.");
									});
									
									classCard.append(btnLike);
									
									const detailInfo = $('<div class="detail-info">');
									
									// 카테고리명 
									const category = $('<span class="category-name">').text(classList.categoryName);
									detailInfo.append(category);
									
									// 클래스명 
									const className = $('<div class="class-name">')
									
									if (classList.classType == 0)
										className.text("[원데이] " + classList.className);
									else
										className.text("["+ classList.episodeNo + "회차] " + classList.className)
										
									detailInfo.append(className);
									
									// 별점, 찜 개수 
									const grade = $('<div class="grade">');
									const starI = $('<i class="fi-rr-star">');
									const star = $('<span>').text(classList.starAverage.toFixed(1));
									
									const heartI = $('<i class="fi-rr-heart">'); 
									const heart = $('<span>').text(classList.heartCount);
									
									grade.append(starI, star, heartI, heart);
									starI.after(" "); star.after(" "); heartI.after(" "); heart.after(" ");
									
									detailInfo.append(grade);
									
									const detailInfoBottom = $('<div class="detail-info-bottom">');
									
									// 강사 프로필 이미지 
									const teacherImg = $('<img src="' + contextPath + '/resources/images/teacher/profile/' + classList.teacherImage + '">');
									
									// 강사명 
									const teacherName = $('<span class="teacher-name">').text(classList.memberName);
									
									// 수업료 
									const classPrice = $('<span class="class-price">').text(classList.episodePrice.toLocaleString('ko-KR') + "원")
									
									detailInfoBottom.append(teacherImg,teacherName,classPrice);
									teacherImg.after(" "); teacherName.after(" "); classPrice.after(" ");
									detailInfo.append(detailInfoBottom);
									
									classCard.append(detailInfo);
									
									// 화면에 클래스 카드 추가 
									$('.hot-class-bottom-view:eq(0)').append(classCard);
									classCard.after(" ");
								}
							}
						})
						
			        }
			    }
		    	geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
			}
		})
	}
	
	

})

