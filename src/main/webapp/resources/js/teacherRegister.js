let checkImage = false;


// 프로필 넣었는지 체크함
function checkInput(){
	if(checkImage == false){
		alert("프로필 이미지를 등록해주세요.");
		document.getElementById("register_img_cover").scrollIntoView();
		return false;
	}
	
	if(add > 0){
		if(add != carImg){
			alert("재능/이력을 증명할 이미지를 등록해주세요");
			document.getElementById("record-box").scrollIntoView();
			return false;			
		}
	}
}






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
			checkImage = true;
		}

	}
}

let carImg = 0;
// 이력 이미지 바꾸기
function loadCareerImg(input, num) {
	if (input.files && input.files[0]) {


		var reader = new FileReader();
		reader.readAsDataURL(input.files[0]);
		reader.onload = function(e) {
			$(".upload_img").eq(num).children("img").attr("src", e.target.result);
			carImg++;
		}

	}
}

let add = 0;
// 이력 추가를 추가하는 추가버튼을 추가
document.getElementById("register_record_add").addEventListener("click", function(){
	$("#record-box").append('<div id="record_area"><input type="text" class="profile_input" name="careerContent "placeholder="재능과 관련된 이력을 입력해 주세요." required><div class="upload_area"><div class="upload_img"><img class="preview" src="https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png"><input type="file" class="profile_file" name="images" onchange="loadCareerImg(this,'+add+')"></div><div class="close_record" onclick="close_record_function(this)">닫기</div></div></div>');
	add++;
})



// 이력 닫기
function close_record_function(el) {
    if(confirm("이력칸을 닫으시겠습니까?")){
    	if($(el).parent().children("div").children("img").attr("src").length > 0 ){
    		carImg--;
		}
	
    	$(el).parent().parent().remove();
    	add--;

	} 
};