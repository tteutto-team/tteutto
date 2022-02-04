<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<jsp:include page="../common/header.jsp"/>
	<link rel="stylesheet" href="${contextPath}/resources/css/classInsert.css"/>
	<link rel="stylesheet" href="http://openlayers.org/en/latest/css/ol.css" type="text/css">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	
    <section id="classInsert">
    	<form action="${contextPath}/register/class" enctype="multipart/form-data" id="form" name="form" method="post" onclick="return checkInput();">
        <div class="fixWidth">
            <div id="register_header">
                <div>클래스 등록</div>
                <div><span class="redText">* </span>필수</div> 
            </div>
            <div class="bottomLine">
                <div class="line1 h4-height"><h4>수업난이도 <span class="redText">*</span></h4></div>
                <div id="c-level"  class="line2">
                    <div><input type="radio" name="classLevel" value="하"required> 하</div>
                    <div><input type="radio" name="classLevel" value="중" required> 중</div>
                    <div><input type="radio" name="classLevel" value="상" required> 상</div>
                </div>
            </div>
            <div class="bottomLine" style="clear: both;">
                <div class="line1 h4-height"><h4>수업등록지역 <span class="redText">*</span></h4></div>
                <div class="line2">
                    <!-- 브이월드 행정구역도를 이용한 셀렉트 박스 구현... 공간정보를 기반으로 하고 있어서 국가공간정보포털보다 느림 -->
                    <!-- <form id="nsdiSearchForm" action="#" class="form_data" onsubmit="return false;search();"> -->
                        <select id="sido_code" name="area1" class="select-style btn-select" required>
                            <option class="list-member">선택</option>
                        </select>
                        <select id="sigoon_code" name="area2" class="select-style btn-select" required>
                            <option class="list-member">선택</option>
                        </select>
                        <input type="hidden" id="classArea1" name="classArea1" value=""/>
                        <input type="hidden" id="classArea2" name="classArea2" value=""/>
                    <!-- </form> -->
                </div>        
            </div>
            <div class="bottomLine">
                <div class="line1 h4-height"><h4>수업카테고리 <span class="redText">*</span></h4></div> 
                <div class="line2">
                    <select id="ct1" name="categoryNo" class="select-style" required>
                        <option value="base" checked>선택</option>
                        <option value='1'>공예/디자인</option>
                        <option value='2'>요리</option>
                        <option value='3'>뷰티/헬스</option>
                        <option value='4'>사진/영상</option>
                        <option value='5'>커리어</option>
                        <option value='6'>음악</option>
                        <option value='7'>기타</option>
                    </select>
                    
                    <select id="ct2" name="categoryDetailNo" class="select-style" required>
                        <option>선택</option>
                    </select>
                </div>
            </div>
            <div id="class-select" class="bottomLine">
                <div class="line1 h4-height"><h4>수업형태 <span class="redText">*</span></h4></div>
                <div>
                    <div>
                        <input type="radio" name="classType" value="0"required> 원데이 클래스
                        <input type="radio" name="classType" value="1" required> 정규 수업
                    </div>
                    <div style="color: rgb(124, 124, 124);">* 시범강의가 아닌, 하루만에 무언가를 얻어갈 수 있는 원데이 클래스를 준비해주세요. </div>
                </div>
            </div>
            <div id="people-num" class="bottomLine">
                <div class="line1 div-height"><h4>수업참여인원 <span class="redText">*</span></h4></div>
                <div class="div-height">
                    <input type="radio" id="solo-class" name="classPerson" value="1" required> 1:1 수업
                    <input type="radio" id="group-class" name="classPerson" value="0" required> 그룹수업
                    <div id="group-input" style="display: none;"><input type="number" name="classMinPerson" class="input-style"> &nbsp명~&nbsp <input type="number" name="classMaxPerson" class="input-style">&nbsp&nbsp명</div>                    <p class="explan" style="color: rgb(124, 124, 124);">* 그룹수업인데 일대일 수업도 가능한 경우, 수업소개 페이지에 별도로 기재부탁드립니다.<br>
                    ex) 일대일 수업을 원하는 경우, 채팅으로 문의 주세요.
                    </p>
                </div>
            </div>
            <div id="c-title" class="bottomLine">
                <div class="line1">
                    <div class="div-height"><h4>수업제목 <span class="redText">*</span></h4></div>
                    <div class="explan" style="color: rgb(124, 124, 124);">공백포함<br>최소 20자 ~ 최대 50자 이내</div>
                </div>
                <div>
                    <div id="tip-area">
                        <div>TIP</div>
                        <div>* 누구를 대상으로, 어떤 재능을 가르치나요?<br>
                            * 수업을 통해 어떤 것을 얻어갈 수 있나요?<br>
                            * 예시 : 미국주식, 내 손으로 직접 투자하자 / 4회만에 내 손으로 만든 영상, 유튜브에 업로드❤<br>
                        </div>
                    </div>
                    <input type="text" id="titleArea" name="className" class="input-style" style="width: 750px;" required>&nbsp&nbsp<span id="titleText-count">0</span><span id="titleText-max">/50</span>
                </div>
            </div>
            <div id="cover-img" class="bottomLine">
                <div class="line1">
                    <div class="div-height"><h4>커버이미지 <span class="redText">*</span></h4></div>
                    <div class="explan" style="color: rgb(124, 124, 124);">
                        최소 1장 이상 등록,<br>
                        3~10장 등록하시는 것이<br> 좋습니다.
                    </div>
                </div>
                <div>
                    <div id="img-select" class="div-height">
                        <div id="img-insert">
                        	<img class="why" id="why" src="https://cdn.epnc.co.kr/news/photo/202107/212199_212130_3942.jpg">
                       	</div>
                        <div>
                            <div><button id="img-plus-btn" class="img-btn btn-click" type="button"> + 이미지 추가</button></div>
                            <div><button id="img-del-btn" class="img-btn btn-click" type="button"> - 이미지 삭제</button></div>
                            <div id="img-text">
                                - <span class="redText">10MB 이하</span>의 jpg, jpeg, png 파일<br>
                                - 840x540 픽셀<br><br>
                                    
                                다음 사진은 <span class="redText">사용이 불가</span>합니다.<br>
                                - 프로필 사진과 동일한 커버 사진<br>
                                - 커버 사진의 경우 텍스트가 포함된 사진<br>
                                - 인위적인 홍보문구가 포함된 사진<br>
                                - 저작권에 위배되는 사진 
                            </div>
                        </div>
                    </div>
                    <div id="marketing">
                        <input type="checkbox" id="check1" name="marketing" value="mkok">
                        <label for="check1"></label>
                        강사님께서 등록한 이미지를 마케팅에 활용하는 것에 동의합니다(선택)
                    </div>
                    <div id="mini-img" class="mini-img">
                        <%-- <div class="mini-img-box"><img src="${contextPath}/webapp/resource/images/profile/20220203214639_56036.jpg"></div> --%>
                    </div>
                    <div id="img-file-box" class="img-file-box">
                    	<input type="file" name="images" onchange="loadImg(this,0)"> 
                    </div>
                </div>
            </div>
            <div id="c-introduce">
                <div class="line1">
                    <div class="div-height"><h4>수업소개 <span class="redText">*</span></h4></div>
                    <!-- <div style="color: rgb(124, 124, 124);">공백포함 300자 이상 권장</div> -->
                </div>
                <div>
                    <div class="tip" id="tip-area1">
                        <div class="tip-text">TIP</div>
                        <div class="tip-content">
                            * 수업의 목표와 수업 진행 방식에 대해 설명해주세요.<br>
                            * 수업을 진행하는 동안 얻을 수 있는 결과물 혹은 수업 후 기대할 수 있는 발전에 대해 소개해주세요.<br>
                            * 다른 학원, 수업과는 다른 강사님만의 장점에 대해서 설명해주세요.<br>
                            * 해당 수업에 대한 자신 어필도 가능합니다.<br>
                            * 해당 수업에서 배울 내용에서 대해 설명해주세요. (커리큘럼 가능)
                            * 수업을 추천하는 대상은 누구일까요? <br>
                            * 예시 : 인턴/입사를 앞두고 엑셀이 걱정되는 분 / 토익 00점 이상의 기초적인 의사소통만 가능하신 분
                        </div>
                        <div class="tip-text">주의</div>
                        <div class="tip-content">
                            * 일부 이모티콘은 인식이 되지 않아, 정성스럽게 작성해주신 내용이 날아갈 수 있습니다.<br>
                            * 강조를 해야 할 내용이 있는 경우 되도록이면 일반 특수문자를 사용해주세요.
                        </div>
                    </div>
                    <textarea id="summernote" name="classIntro"></textarea>
                </div>
            </div>
<!--             <div id="c-target" class="bottomLine">
                <div class="line1">
                    <div><h4>수업대상 <span class="redText">*</span></h4></div>
                    <div style="color: rgb(124, 124, 124);">공백포함 200자 이상 권장</div>
                </div>
                <div>
                    <div class="tip" id="tip-area2">
                        <div class="tip-text">TIP</div>
                        <div class="tip-content">
                            * 수업을 추천하는 대상은 누구일까요? <br>
                            * 예시 : 인턴/입사를 앞두고 엑셀이 걱정되는 분 / 토익 00점 이상의 기초적인 의사소통만 가능하신 분
                        </div>
                        <div class="tip-text">주의</div>
                        <div class="tip-content">
                            * 일부 이모티콘은 인식이 되지 않아, 정성스럽게 작성해주신 내용이 날아갈 수 있습니다.<br>
                            * 강조를 해야 할 내용이 있는 경우 되도록이면 일반 특수문자를 사용해주세요.
                        </div>
                    </div>
                    <textarea class="textarea-style"></textarea>
                </div>
            </div> -->
            <div id="next-btn">
                <button class="btn-click" style="background-color: #3a3424; color: white;">미리보기</button>
                <button class="btn-click" style="background-color: #3a3424; color: white;">임시저장</button>
                <button class="btn-click" style="background-color: #FFDF3E;">승인요청</button>
            </div>
        </div>
        </form>

    </section>
	
	<jsp:include page="../common/footer.jsp"/>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    
    
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    
    <script src="${contextPath}/resources/js/classInsert.js"></script>
</body>
</html>