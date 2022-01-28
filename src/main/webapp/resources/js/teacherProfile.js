console.log("dfdfdfd");

$(".record_add").on("click", function(){
	
	const html1 = "<div id='record_area'>";
    const html2 = "<input type='text' class='profile_input' placeholder='재능과 관련된 이력을 입력해 주세요.'>";
    const html3 = "<div class='upload_area'>";
    const html4 = "<div class='upload_img'>";
    const html5 = "<img class='preview' src='https://front-img.taling.me/Content/app3/img/bg/bg-add-img-grey-115px@2x.png'>"
    const html6 = "<input type='file' class='profile_file'>"
    const html7 = "</div></div></div>";
	
	$(this).prev().after(html1+html2+html3+html4+html5+html6+html7);
});