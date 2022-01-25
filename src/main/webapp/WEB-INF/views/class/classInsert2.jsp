<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<jsp:include page="../common/header.jsp"/>
	<link rel="stylesheet" href="${contextPath}/resources/css/classInsert2.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/jquery-ui.multidatespicker.css">
	
    <section id="classInsert2">
        <div class="fixWidth">
            <div class="bottomLine"><h1>클래스 등록</h1></div>
            <div class="bottomLine"><span class="redText">*</span> 필수</div>
            <div id="c-introduce" class="bottomLine">
                <div class="line1">
                    <div><h4>수업소개 <span class="redText">*</span></h4></div>
                    <div style="color: rgb(124, 124, 124);">공백포함 300자 이상 권장</div>
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
                        </div>
                        <div class="tip-text">주의</div>
                        <div class="tip-content">
                            * 일부 이모티콘은 인식이 되지 않아, 정성스럽게 작성해주신 내용이 날아갈 수 있습니다.<br>
                            * 강조를 해야 할 내용이 있는 경우 되도록이면 일반 특수문자를 사용해주세요.
                        </div>
                    </div>
                    <textarea class="textarea-style"></textarea>
                </div>
            </div>
            <div id="c-target" class="bottomLine">
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
            </div>
            
            <div>
                <div id="c-schedule">
                    <div><h4>수업기간 <span class="redText">*</span></h4></div>
                    <div id="mdp-box">
                        <div id="mdp-demo"></div>
                        <button id="testtest">원데이테스트용</button>
                        <button id="testtest1">다회차테스트용</button>
                    </div>
                    <div id="schedule-val">
                        <div><button id="schedule-btn" class="btn-click">날짜 불러오기</button></div>
                        <div>* 회차별 수업 날짜를 선택하여 일정을 불러온 뒤 수업시간을 선택해주세요.</div>
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
                        <div><button id="schedule-btn2" class="btn-click">날짜 불러오기</button></div>
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
                                        <td>~&nbsp</td>
                                        <td id="schedule-td2" class="time-td">00/00/0000</td>
                                    </tr>
                                    <tr>
                                        <td class="time-td3">수업날짜</td>
                                        <td colspan="5" id="schedule-day" style="white-space: pre-line; width: 266px;"></td>
                                    </tr>
                                    <tr>
                                        <td class="time-td2">수업시간</td>
                                        <td class="time-td">
                                            <select id="startTime1" class="time-box">
                                                <option>08:00</option>
                                                <option>09:00</option>
                                                <option>10:00</option>
                                                <option>11:00</option>
                                                <option>12:00</option>
                                                <option>13:00</option>
                                                <option>14:00</option>
                                                <option>15:00</option>
                                                <option>16:00</option>
                                                <option>17:00</option>
                                                <option>18:00</option>
                                                <option>19:00</option>
                                                <option>20:00</option>
                                                <option>21:00</option>
                                                <option>22:00</option>
                                                <option>23:00</option>
                                                <option>24:00</option>
                                            </select></td>
                                        <td>&nbsp~&nbsp</td>
                                        <td class="time-td">
                                            <select id="endTime1" class="time-box">
                                                <option>08:00</option>
                                                <option>09:00</option>
                                                <option>10:00</option>
                                                <option>11:00</option>
                                                <option>12:00</option>
                                                <option>13:00</option>
                                                <option>14:00</option>
                                                <option>15:00</option>
                                                <option>16:00</option>
                                                <option>17:00</option>
                                                <option>18:00</option>
                                                <option>19:00</option>
                                                <option>20:00</option>
                                                <option>21:00</option>
                                                <option>22:00</option>
                                                <option>23:00</option>
                                                <option>24:00</option>
                                            </select></td>
                                        <td><button id="plus-time" class="plus-time">+</button></td>
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
                    <input type="text" class="input-style" placeholder="서울시 구로구 구로동 100">
                    <input type="text" class="input-style" placeholder="스터디카페 비버통 2층">
                    <button class="btn-click">주소검색</button>
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
                <button class="btn-click" style="background-color: #3a3424; color: white;">미리보기</button>
                <button class="btn-click" style="background-color: #3a3424; color: white;">임시저장</button>
                <button class="btn-click" style="background-color: #FFDF3E;">최종 승인요청</button>
            </div>
        </div>
    </section>

	<jsp:include page="../common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
    <script src="js/jquery-ui.multidatespicker.js"></script>
    <script src="js/classInsert2.js"></script>
    
</body>
</html>