

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
