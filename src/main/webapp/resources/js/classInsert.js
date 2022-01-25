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
                            console.log(f.properties)
                            let 행정구역코드 = f.properties.ctprvn_cd;
                            let 행정구역명 = f.properties.ctp_kor_nm;
                            
                            html +=`<option value="${행정구역코드}">${행정구역명}</option>`
                            
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
        
                            data.response.result.featureCollection.features.forEach(function(f){
                                console.log(f.properties)
                                let 행정구역코드 = f.properties.sig_cd;
                                let 행정구역명 = f.properties.sig_kor_nm;
                                
                                html +=`<option value="${행정구역코드}">${행정구역명}</option>`
                                
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
                                console.log(f.properties)
                                let 행정구역코드 = f.properties.emd_cd;
                                let 행정구역명 = f.properties.emd_kor_nm;
                                html +=`<option value="${행정구역코드}">${행정구역명}</option>`
                                
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

    if(c == "공예"){
        $("select#ct2").append("<option>캔들,디퓨저,방향제</option>");
        $("select#ct2").append("<option>실크스크린, 염색</option>");
        $("select#ct2").append("<option>발향,룸스프레이</option>");
        $("select#ct2").append("<option>자수,재봉,펠트</option>");
        $("select#ct2").append("<option>뜨개, 마크라메</option>");
        $("select#ct2").append("<option>가죽</option>");
        $("select#ct2").append("<option>금속,악세서리</option>");
        $("select#ct2").append("<option>네온사인,와이어</option>");
        $("select#ct2").append("<option>유리</option>");
        $("select#ct2").append("<option>목공</option>");
        $("select#ct2").append("<option>도자기</option>");
        $("select#ct2").append("<option>기타</option>");
    }else if(c == "요리"){
        $("select#ct2").append("<option>떡,앙금케익</option>");
        $("select#ct2").append("<option>베이킹</option>");
        $("select#ct2").append("<option>커피,차,음료</option>");
        $("select#ct2").append("<option>초콜릿,캔디</option>");
        $("select#ct2").append("<option>한식,양식,중식,퓨전</option>");
        $("select#ct2").append("<option>기타</option>");
    }else if(c == "미술"){
        $("select#ct2").append("<option>민화,동양화</option>");
        $("select#ct2").append("<option>수채화,서양화</option>");
        $("select#ct2").append("<option>팝아트,아크릴,인물화</option>");
        $("select#ct2").append("<option>캘라그라피,서예</option>");
        $("select#ct2").append("<option>드로잉,일러스트</option>");
        $("select#ct2").append("<option>기타</option>");
    }else if(c == "플라워"){
        $("select#ct2").append("<option>테라리움,가드닝</option>");
        $("select#ct2").append("<option>하바리움</option>");
        $("select#ct2").append("<option>프리저브드,드라이플라워</option>");
        $("select#ct2").append("<option>리스,화환</option>");
        $("select#ct2").append("<option>꽃다발,바구니,박스</option>");
        $("select#ct2").append("<option>기타</option>");
    }else if(c == "뷰티"){
        $("select#ct2").append("<option>천연화장품</option>");        
        $("select#ct2").append("<option>비누</option>");        
        $("select#ct2").append("<option>향수</option>");        
        $("select#ct2").append("<option>기타</option>");        
    }else if(c == "체험 및 기타"){
        $("select#ct2").append("<option>기타</option>");      
    }else{

    }

})


