<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<jsp:include page="../common/header.jsp"/>
	<link rel="stylesheet" href="${contextPath}/resources/css/classInsert2.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/jquery-ui.multidatespicker.css">
	
    <section id="classInsert2">
    	<form action="${contextPath}register/schedule" id="form" name="form" method="post">
        <div class="fixWidth">
        <div id="register_header">
            <div>스케쥴 등록</div>
            <div><span class="redText">* </span>필수</div> 
        </div>

        <div> 코딩 오지게 잘하는 비법 <span id="ep-count">(1회차)</span> </div>    
            
            <div>
                <div id="c-schedule">
                    <div><h4>수업기간 <span class="redText">*</span></h4></div>
                    <div id="mdp-box">
                        <div id="mdp-demo"></div>
                        <button type="button" id="testtest" >원데이테스트용</button>
                        <button type="button" id="testtest1" >다회차테스트용</button>
                    </div>
                    <div id="schedule-val">
                        <div><input type="button" id="schedule-btn" class="btn-click" value="날짜 불러오기"></input></div>
                        <div>* 일자별 수업 날짜를 선택하여 일정을 불러온 뒤 수업시간을 선택해주세요.</div>
                        <div id="schedule-text" style="display: none;">
                            <table id="schedule-table">
                                <thead>

                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="time-td2">0회차</td>
                                        <td class="time-td">0/00/0000</td>
                                        <td class="time-td"><select class="time-box"><option>선택</option></select></td>
                                        <td> ~ </td>
                                        <td class="time-td"><select class="time-box"><option>선택</option></select></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="test-oneday-schedule" style="display: none;">
                        <div><button type="button" id="schedule-btn2" class="btn-click">날짜 불러오기</button></div>
                        <div>* 수업 날짜를 선택 후 불러온뒤 가능한 수업시간을 선택해주세요.</div>
                        <div id="test-schedule-text" style="display: none;">
                            <table id="test-table">
                                <thead>

                                </thead>
                                <tbody>
<!--                                     <tr>
                                        <td class="time-td3">개강기간</td>
                                        <td class="time-td">00/00/0000</td>
                                        <td>~</td><td class="time-td">00/00/0000</td>
                                    </tr> -->
                                    <tr>
                                        <td class="time-td3">개강기간</td>
                                        <td id="schedule-td1" class="time-td">00/00/0000</td>
                                        <td class="time-td4">~&nbsp</td>
                                        <td id="schedule-td2" class="time-td">00/00/0000</td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>

            <div id="c-location" class="bottomLine">
                <div class="line1 h4-height"><h4>수업장소 주소 <span class="redText">*</span></h4></div> 
                <div class="line2">
                    <input type="text" id="roadAddrPart1"  name="roadAddrPart1" class="input-style" placeholder="서울시 구로구 구로동 100">
                    <input type="text" id="addrDetail"  name="addrDetail" class="input-style" placeholder="스터디카페 비버통 2층">
                    <!-- <button type="button" class="btn-click" onClick="goPopup();" >주소검색</button> -->
                    <input type="button" class="btn-click" onClick="goPopup();" value="주소검색"/>
                </div>
            </div>

            <div id="c-ptn">
                <div class="line1">
                    <div><h4>가격/시간/횟수 <span class="redText">*</span></h4></div>
                </div>
                <div id="ptn-multi">
                    <div>시간당 가격</div>
                    <div><input type="number" id="time-price" class="input-style largeSize"> &nbsp원</div>
                    <div>1회당 수업시간</div>
                    <div><input type="number" id="num-time" class="input-style largeSize"> &nbsp시간</div>
                    <div>총 수업횟수</div>
                    <div><input type="number" id="num-class" class="input-style largeSize"> &nbsp회</div>
                </div>
                <div id="ptn-one" style="display: none;">
                    <div>시간당 가격</div>
                    <div><input type="number" id="time-price-one" class="input-style largeSize"> &nbsp원</div>
                    <div>수업시간</div>
                    <div><input type="number" id="num-time-one" class="input-style largeSize"> &nbsp시간</div>
                </div>
            </div>

            <div id="c-price" class="bottomLine">
                <div class="line1">
                    <div><h4>총 수업가격</h4></div>
                </div>
                <div>
                    <div id="price-area" class="tip">
                        <div id="price">
                            <span id="pt1">99999</span> 
                            <span id="pt2">x 1</span> 
                            <span id="pt3">x 10</span> 
                        </div>
                        <div id="sumPrice">
                            총 <span class="redText">999,999원</span> <br>
                            연결수수료 <span>99,999원</span>
                        </div>
                    </div>
                    <div><span class="redText" style="font-weight: bold; font-size: large;">Q.</span> 뜨또의 수수료 정책은 어떻게 되나요?</div>
                    <div><span style="font-weight: bold; font-size: large;">A.</span> 뜨또 연결 수수료는 다회차 수업의 경우 첫 1시간 수업료, 원데이 클래스의 경우 전체 수업료의 20%입니다.</div>
                </div>
            </div>
            
            <div id="next-btn">
                <button type="button" class="btn-click" style="background-color: #3a3424; color: white;">임시저장</button>
                <button type="submit" class="btn-click" style="background-color: #FFDF3E;">승인 요청</button>
            </div>
        </div>
        </form>
    </section>

	<jsp:include page="../common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/jquery-ui.multidatespicker.js"></script>
    <script src="${contextPath}/resources/js/classInsert2.js"></script>
    
</body>
</html>