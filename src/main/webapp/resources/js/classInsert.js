let checkImage = false;
let checkTitle = false;

// 다 했는지 체크함
function checkInput(){
	if(checkImage == false){
		alert("최소 1장 이상의 이미지를 등록해주세요.");
		document.getElementById("img-plus-btn").scrollIntoView();
		return false;
	}
	
	if(checkTitle == false){
		alert("수업제목을 20글자 이상 작성해주세요.");
		document.getElementById("titleArea").scrollIntoView();
		return false;
	}
	
	const img = $(".note-editable img");
	
	for(let i=0; i< img.length; i++ ){
		//console.log(img.eq(i).attr("src"));
		$("#summerImg").append('<input type="hidden" name="introImgName" value="'+img.eq(i).attr("src").replace(contextPath, "")+'"/>');
	}
	
}





// 브이월드 행정도 API
$.support.cors = true;
            
            $(function(){
                $.ajax({
                    type: "get",
                    url: "https://api.vworld.kr/req/data?key=CEB52025-E065-364C-9DBA-44880E3B02B8&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADSIDO_INFO",
                    async: false,
                    dataType: 'jsonp',
                    success: function(data) {
                        let html = "<option>선택</option>";
        
                        data.response.result.featureCollection.features.forEach(function(f){
                            //console.log(f.properties.ctp_kor_nm);
                            let scode = f.properties.ctprvn_cd;
                            let sname = f.properties.ctp_kor_nm;
                            
                            if(sname == "충청북도"){
                                sname = "충북";
                            }else if(sname == "충청남도"){
                                sname = "충남";
                            }else if(sname == "경상남도"){
                                sname = "경남";
                            }else if(sname == "경상북도"){
                                sname = "경북";
                            }else if(sname == "전라남도"){
                                sname = "전남";
                            }else if(sname == "전라북도"){
                                sname = "전북";
                            }else{
                                sname = sname.substring(0,2);
                            }
                            


                            html +=`<option value="${scode}">${sname}</option>`
                            
                        })
                        
                        $('#sido_code').html(html);
                        
                    },
                    error: function(xhr, stat, err) {}
                });
                
                
                $(document).on("change","#sido_code",function(){
                    let thisVal = $(this).val();		
        
                    $.ajax({
                        type: "get",
                        url: "https://api.vworld.kr/req/data?key=CEB52025-E065-364C-9DBA-44880E3B02B8&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADSIGG_INFO",
                        data : {attrfilter : 'sig_cd:like:'+thisVal},
                        async: false,
                        dataType: 'jsonp',
                        success: function(data) {
                            let html = "<option>선택</option>";
        					const arr = [];
                            data.response.result.featureCollection.features.forEach(function(f){
                                let scode = f.properties.sig_cd;
                                let sname = f.properties.sig_kor_nm;
                                
                                //let cut = sname.indexOf(' ');
                                if(sname == '세종특별자치시'){
									sname = '특별시'
								}else{
                                	sname = sname.substr(0, 3);
								}
                                
                                if(arr.indexOf(sname) == -1){
	                                arr.push(sname);
	                                html +=`<option value="${scode}">${sname}</option>`
								}
                                
                            })
                            $('#sigoon_code').html(html);
                            
                        },
                        error: function(xhr, stat, err) {}
                    });
                });
                
                $(document).on("change","#sigoon_code",function(){ 
                    
                    let thisVal = $(this).val();		
        
                    $.ajax({
                        type: "get",
                        url: "https://api.vworld.kr/req/data?key=CEB52025-E065-364C-9DBA-44880E3B02B8&domain=http://localhost:8080&service=data&version=2.0&request=getfeature&format=json&size=1000&page=1&geometry=false&attribute=true&crs=EPSG:3857&geomfilter=BOX(13663271.680031825,3894007.9689600193,14817776.555251127,4688953.0631258525)&data=LT_C_ADEMD_INFO",
                        data : {attrfilter : 'emd_cd:like:'+thisVal},
                        async: false,
                        dataType: 'jsonp',
                        success: function(data) {
                            let html = "<option>선택</option>";
        
                            data.response.result.featureCollection.features.forEach(function(f){
                                //console.log(f.properties)
                                let scode = f.properties.emd_cd;
                                let sname = f.properties.emd_kor_nm;
                                html +=`<option value="${scode}">${sname}</option>`
                                
                            })
                            $('#dong_code').html(html);
                            
                        },
                        error: function(xhr, stat, err) {}
                    });
        
                });
        
            });


//---------------------------------------------------------------
// 수업참여인원
$("#solo-class").on("click", function(){
    //$("#group-input").html("");
    $("#group-input").slideUp(250);
})

$("#group-class").on("click", function(){
    //$("#group-input").html('<input type="number" id="peopel-count1" class="input-style"> &nbsp명~&nbsp <input type="number" id="peopel-count2" class="input-style" required>');
    $("#group-input").slideDown(250);
})


// 카테고리 옵션
$("#ct1").on("change", function(){
    let c = $("#ct1 option:checked").text()

    $("select#ct1 option[value='base']").remove();
    $("select#ct2 option").remove();

    if(c == "공예/디자인"){
        $("select#ct2").append("<option value='1'>조향,캔들,비누</option>");
        $("select#ct2").append("<option value='2'>가죽,목공,도예</option>");
        $("select#ct2").append("<option value='3'>플라워</option>");
        $("select#ct2").append("<option value='4'>캘리그라피</option>");
        $("select#ct2").append("<option value='5'>디지털드로잉</option>");
        $("select#ct2").append("<option value='6'>취미미술</option>");
    }else if(c == "요리"){
        $("select#ct2").append("<option value='7'>베이킹,디저트</option>");
        $("select#ct2").append("<option value='8'>커피,차,음료</option>");
        $("select#ct2").append("<option value='9'>건강,다이어트식</option>");
        $("select#ct2").append("<option value='10'>세계요리</option>");
    }else if(c == "뷰티/헬스"){
        $("select#ct2").append("<option value='11'>메이크업</option>");
        $("select#ct2").append("<option value='12'>퍼스널컬러</option>");
        $("select#ct2").append("<option value='13'>패션</option>");
        $("select#ct2").append("<option value='14'>PT,GX</option>");
    }else if(c == "사진/영상"){
        $("select#ct2").append("<option value='15'>사진</option>");
        $("select#ct2").append("<option value='16'>영상</option>");
    }else if(c == "커리어"){
        $("select#ct2").append("<option value='17'>금융</option>");        
        $("select#ct2").append("<option value='18'>개발</option>");        
        $("select#ct2").append("<option value='19'>언어,외국어</option>");        
        $("select#ct2").append("<option value='20'>주식투자</option>");        
        $("select#ct2").append("<option value='21'>자격증</option>");        
    }else if(c == "음악"){
        $("select#ct2").append("<option value='22'>보컬</option>");      
        $("select#ct2").append("<option value='23'>악기</option>");      
        $("select#ct2").append("<option value='24'>작곡,디제잉</option>");      
        $("select#ct2").append("<option value='25'>댄스</option>");      
    }else{
        $("select#ct2").append("<option value='26'>기타</option>");      
    }

})

let leng = 0;

// 썸머노트
$(document).ready(function() {
    $('#summernote').summernote({ // summernote를 사용하기 위한 선언
        height: 525,
        width: 750,
        minHeight: 525,    
        placeholder: '<p style="font-size:18px; font-weight: 500; color: #bbb;">수업소개 EX)</p><p style="font-size:25px; font-weight: 600;">간단한 클래스 소개</p><p>UX 디자인 입문자분들을 위한 꿀조합 클래스입니다 :)</p ><br><br><p style="font-size:18px; font-weight: 500; color: #bbb;">[Image]</p><br><p>오일파스텔을 쓰기위해서는 어떻게 명암이 들어가는지 아는 것이 중요해요. 기본적인 명암법을 배우고, 오일파스텔을 쓰기 전 특성을 알아볼 거예요. 또 기초를 바탕으로 어떻게 얼굴을 채워넣으면 좋은지 이야기 해볼게요. 그렇게 채색을 시작하면서 서서히 각자의 색으로 완성할 수 있도록 도와드리겠습니다.</p><br><br><p style="font-size:25px; font-weight: 600;">이런분들께 추천합니다</p><p></p><ul style="font-size:14px; font-weight:normal; color:gray;"><li>⦁ UX디자이너가 되기위해 취업준비중인 취준생</li><li>⦁ 타 전공자분들을 위한 UX입문과정</li><li>⦁ UX팀으로 이직을 위한 이직 준비 과정(경력 기술서 만들기!!)</li><li>⦁ UX 디자인 포트폴리오 준비 및 취업 컨설팅이 필요한 대학생</li><li>⦁ 프로토파이/인비전/XD 등 다양한 프로토 타이핑 툴 학습이 필요하신분</li><li>⦁ UX디자인 분석/휴리스틱 분석에 대한 학습이 필요하신분</li><li>⦁ 스타트업을 시작하기 위해 반응형 APP Design이 필요한 분</li></ul>',     
        //focus: true,
        lang: "ko-KR",
        

		
		callbacks: {
			onImageUpload : function(files, editor){
				sendFile(files[0],this);
			}
			/*
			,
			onChange : function(contents, $editable){
				const img = $(".note-editable img");
				
				$("#summerImg").html("");
				if(img.length != leng){
					
					for(let i=0; i< img.length; i++ ){
						//console.log(img.eq(i).attr("src"));
						$("#summerImg").append('<input type="hidden" name="IntroImgName" value="'+img.eq(i).attr("src").replace(contextPath, "")+'"/>');
					}
					
				}
				
				leng = img.length;
				
			}
			*/
			
			
		}
		

    });
});

/*
// 썸머노트 이미지
function sendFile(file, editor){
	var data = new FormData();
	data.append("file", file);
	console.log(file);
	$.ajax({
		data : data,
		type : "POST",
		url : "SummerNoteImageFile",
		contentType : false,
		processData : false,
		success : function(data){
			console.log(data);
			console.log(editor);
			$(editor).summernote("insertImage",data.url);
		}
	});
}
*/

function sendFile(file, editor) {
    data = new FormData()
    data.append("file", file)
    

    $.ajax({
      data: data,
      type: "POST",
      url: "uploadFile",
      cache: false,
      contentType: false,
      enctype: "multipart/form-data",
      processData: false,
      success: function (result) {
        $(editor).summernote('editor.insertImage', ""+contextPath+"/resources/images/class/"+result+"");

      const img = $("img");

      if(img.outerWidth() > 800){
        img.css("width", "800px");
      }
      
      },
    })
  }





// 제목 글자수
$("#titleArea").on("input focus change", function(){
    // 현재 작성된 글자 수를 변수에 저장
    let count = $(this).val().length;
    // 안넘으면 빨간색
    if(count < 20){
		$("#titleText-count").css("color", "red");
		checkTitle = false;
	}
	
	else if(count >= 20 && count < 50){
		$("#titleText-count").css("color", "green");
		checkTitle = true;
	}
	
	else if( count >= 50 ){
        $(this).val( $(this).val().substr(0,50) );
        count = 50;
        checkTitle = true;
    }
    else{}

    // 글자 수를 출력하는 span
    $("#titleText-count").text( count ); 
});


// 시,도 바꾸면 input 값 바꾸기
$("#sido_code").on("change", function(){
	
	const st = $("#sido_code option:checked").text();
	const si = $("#sido_code option:selected").val();
	$("#sidoVal").val(si);
    $('#classArea1').val(st);
    //console.log($('#classArea1').val());
})


$("#sigoon_code").on("change", function(){
	
	const st = $("#sigoon_code option:checked").text();
	const si = $("#sigoon_code option:selected").val();
	$("#sigoonVal").val(si);
    $('#classArea2').val(st);
    //console.log($('#classArea2').val());
})


// 이미지 추가
var index = 0;
$("#img-plus-btn").on("click", function(){
	// 현재 클릭된 요소가 .boardImg 중 몇 번째 인덱스인지 반환
	//$("[type=file]").eq(index).click();
	// 타입이 file인 요소 중 몇번째 인덱스 요소를 선택하여 클릭해라
	//document.getElementById("why").setAttribute("src", "hhhhh");
	//console.log($("#img-file-box > input:last-child"));
	//console.log(index);
	if(index < 5){
		$("#img-file-box > input:last-child").val("");
		$("#img-file-box > input:last-child").click();		
	}else{
		alert("이미지는 최대 4장까지 등록이 가능합니다.");
	}
})

// 썸네일 이미지 바꾸기
function loadImg(input, num){
	//console.log(input.files);
	//console.log(input.files[0]);
	
	//console.log(input);
	if(index == 0){
		$("#mini-img").css("height", "150px");
	}
	


	if (input.files && input.files[0]) {
		
		// div, img와 클릭이벤트 추가
		const dv = $("<div>");
		const dv2 = $("<div>");
		const im = $("<img>");
		dv2.addClass("deleteImg");
		dv2.append("❌");
		$(dv).append(dv2);
		
		dv.append(im);
		dv.addClass("mini-img-box");

		$("#mini-img").append(dv);
		
		$(dv).on("click", function(){
			var src = $(this).children("img").attr("src");
			$("#img-insert").children("img").attr("src", src);
		})
		
		$(dv2).on("click", function(e){
			e.stopPropagation(); 
			
			const tumnailImg = $("#why").attr("src");
			const thisImg = e.target.nextSibling.src;
			//console.log("지금이미지" + thisImg);
			//console.log("섬네일" + tumnailImg);
			//console.log(e.target.parentNode.parentNode.childNodes[1].childNodes[1].src);
			
			if(tumnailImg == thisImg){
				if(e.target.parentNode.parentNode.childNodes[1].childNodes[1].src.length > 0){
					$("#why").attr("src", e.target.parentNode.parentNode.childNodes[1].childNodes[1].src);
				}
			}
			
			index = index - 1;
			if(index == 0){
				checkImage = false;
				$("input[name=images]").val("");
				$("#mini-img").css("height", "17px");
				$("#why").attr("src", "https://cdn.epnc.co.kr/news/photo/202107/212199_212130_3942.jpg");
			}
		
			
			$("#img-file-box > input:last-child").remove();
			e.target.parentNode.remove();
			
		})
		
		/*$("#mini-img").append('<div id="m'+index+'" class="mini-img-box"><img><div>');*/
		var reader = new FileReader();
		reader.readAsDataURL(input.files[0]);
		reader.onload = function(e) {
		$("#img-insert").children("img").attr("src", e.target.result);
		//$("#mini-img").children("div").eq(num).children("img").attr("src", e.target.result);
		$("#mini-img > div:last-child > img").attr("src", e.target.result);
		//document.getElementById("why").setAttribute("src", e.target.result);
		index = index + 1;

		// input 추가
		$("#img-file-box").append('<input type="file" name="images" onchange="loadImg(this,'+index+')">');
		
		checkImage = true;

		}
	}else{
		//console.log("응~");
	}

	
}

// 이미지 삭제
$("#img-del-btn").on("click", function(){
	
	if(index == 0){
		
	}else{
		$("#mini-img > div:last-child").remove();
		$("#img-file-box > input:last-child").remove();
		let pre = $("#mini-img > div:last-child > img").attr("src");
		$("#img-insert").children("img").attr("src", pre);
		index = index - 1;
		if(index == 0){
			checkImage = false;
			$("input[name=images]").val("");
			$("#mini-img").css("height", "17px");
			$("#why").attr("src", "https://cdn.epnc.co.kr/news/photo/202107/212199_212130_3942.jpg");
		}
	
	}
})


/* 임시저장
$("#save-btn").on("click", function(){
	
	$.ajax({
		url : "save",
		data : {"classLevel" : classLevel,				
				"classArea1" : classArea1,
				"classArea2" : classArea2,
				"categoryNo" : categoryNo,
				"categoryDetailNo" : categoryDetailNo,
				"classType" : classType,
				"classPerson" : classPerson,
				"classMinPerson" : classMinPerson,
				"classMaxPerson" : classMaxPerson,
				"className" : className,
				"classIntro" : classIntro},
		type : "POST",
		success : function(result){
			if(result > 0){
				alert("임시저장이 완료되었습니다.");
			}
		},
		error : function(){
			
		}
	})
	
	
}) */

/*
// 미리보기
$("#priview-btn").on("click", function(){
	const url = "/tteutto/register/preview"
	const name = "test"
	const option = "width = 1200, height = 1200, left = 500, location = no"	
	window.open(url, name, option);
	
	var w = window.open('/tteutto/register/preview','newPopup','scrollbars=yes, width=1200, height=1200');
	var testForm = document.getElementById('form');
	testForm.target = 'newPopup';
	testForm.submit(w);
})
*/

// 팝업오픈하여 폼데이터 Post 전송
function PopUp(){
	
	/*
    var pop_title = "preview" ;
    var option = "width = 1200, height = 1200, left = 500, location = no"	
     
    window.open("/tteutto/register/preview", pop_title, option) ;
    */
    
    //path, 이름, option
	window.open('/tteutto/register/preview','preview','width=1200, height=1200');
	
	//opener.document.getElementById('summernote').value = $('#summernote').val();
	//opener.document.getElementById('titleArea').value = $('#className').html();
	//opener.document.getElementByName('classLevel').value = $('#classLevel').val();
	//opener.document.getElementById('maxPerson').value = $('#maxPerson').val();
	//console.log(document.getElementByName('images'));
	//console.log(document.getElementByName('images').value);
	
	//console.log(document.getElementById("summernote").value);
	//console.log(document.getElementById("titleArea").value);
	//console.log(document.getElementByName("classLevel").value);
	//console.log(document.getElementById("maxPerson").value);
    /*
    var frmData = document.getElementById("form");
    console.log(frmData);
    
    frmData.target = pop_title ;
    frmData.action = "preview" ;
     
    frmData.submit() ;
    */ 
     /*
     console.log($("input[name=images]"));
     console.log($("input[name=images]".length));
     console.log($(".mini-img-box").children("img").attr("src"));
     console.log($(".mini-img-box"));
     console.log($(".mini-img-box").length);
     console.log($("#mini-img").children(3));
     */
     for(i = 1; i<$(".mini-img-box").length; i++){
	     let e = document.getElementById("mini-img").childNodes[1].childNodes[0].src
	     //console.log(e);	
	 }
     
}

// 참여인원 음수,기호 방지, 맥스 초과 방지
$("#maxPerson").on("input", function(){
	$(this).val($(this).val().replace(/[^0-9]/gi,""));
})

$("#minPerson").on("input", function(){
	$(this).val($(this).val().replace(/[^0-9]/gi,""));
})


$("#minPerson").on("change keyup", function(){
	let max = $("#maxPerson").val();
	let min = $("#minPerson").val();
	
	if( parseInt(min) >= parseInt(max) ){
		$(this).val(max);
		$("#alertPerson").html("최소인원은 최대인원을 초과할 수 없습니다!");
	}else{
		$("#alertPerson").html("");
	}
})

// 1:1 그룹 클릭시
$("#solo-class").on("click", function(){
	$("#maxPerson").val(0);
	$("#minPerson").val(0);
})



// 시군 임시저장
 window.onload = function(){
	$("#sido_code > option").each(function(){	
	const sv = $("#sidoVal").val();
	const sgv = $("#sigoonVal").val(); 

	// val에 저장된 값을 가져와서 넣어주면 된다
    if($(this).val() == sv){
        $(this).prop("selected", true)
        $("#sido_code").change();
        
        $("#sigoon_code > option").each(function(){
			setTimeout(function(){
				//if($("#sigoon_code").val() == sgv){
				$("#sigoon_code").val(sgv);	
                $("#sigoon_code").prop("selected", true);
                //$("#sigoon_code").change();
            //}
				
		}, 200);

            
        });
    }
	});
	
	
	// 임시저장 카테고리
	if(ctNo > 0){
		$("#ct1").val(ctNo);
		$("#ct1").change();	
		
		if(ctdNo > 0){
			setTimeout(function(){
				$("#ct2").val(ctdNo);
				$("#ct2").change();
			}, 200);
		}
	
	}
	
  
}

// 
$("#solo-class").on("click", function(){
	$("#minPerson").val(1);
	$("#maxPerson").val(1);
})
