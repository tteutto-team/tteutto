// 프로필 추가 클릭
document.getElementById("register_img_cover").addEventListener("click", function(){
	$("#picture").click();
})

// 프로필 이미지 바꾸기
function loadImg(input){
		if (input.files && input.files[0]) {

		var reader = new FileReader();
		reader.readAsDataURL(input.files[0]);
		reader.onload = function(e) {
			$("#register_img_cover").children(".ppap").attr("src", e.target.result);
		}

	}
}


// 이력 이미지 바꾸기
function loadCareerImg(input, num) {
	if (input.files && input.files[0]) {


		var reader = new FileReader();
		reader.readAsDataURL(input.files[0]);
		reader.onload = function(e) {
			$(".upload_img").eq(num).children("img").attr("src", e.target.result);
		}

	}
}

let add = 2;
// 이력 추가를 추가하는 추가버튼을 추가
document.getElementById("register_record_add").addEventListener("click", function(){
	// 추가모양
/*	<div id="record_area">
		<input type="text" class="profile_input" name="careerContent"
			placeholder="재능과 관련된 이력을 입력해 주세요.">
		<div class="upload_area">
			<div class="upload_img">
				<img class="preview"
					src="https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png">
				<input type="file" class="profile_file" name="careerImage" onchange="loadCareerImg(this,1)">
			</div>
		</div>
	</div>*/
	
	$("#record-box").append('<div id="record_area"><input type="text" class="profile_input" name="careerContent "placeholder="재능과 관련된 이력을 입력해 주세요."><div class="upload_area"><div class="upload_img"><img class="preview" src="https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png"><input type="file" class="profile_file" name="careerImage" onchange="loadCareerImg(this,'+add+')"></div></div></div>');
	add = add + 1;
})