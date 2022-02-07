const date = new Date();

        const arr = ["2022-01-16", "2022-02-02", "2022-02-26", "2022-03-01", "2022-03-23"];
        const dateArr = [];
        const week = ["일", "월", "화", "수", "목", "금", "토"];
        

        // const startDate = Math.abs(Math.floor((new Date().getTime() - new Date("2022-01-26").getTime())/1000/60/60/24));
        // const endDate = Math.abs(Math.floor((new Date().getTime() - new Date("2022-02-04").getTime())/1000/60/60/24));


        for(d of arr){
            dateArr.push(new Date(d).getTime());
        }

        
        $('#mdp-demo').multiDatesPicker({
            adjustRangeToDisabled: true,
            addDisabledDates: dateArr,
          
        })

        // const startDate = Math.abs(Math.floor((new Date().getTime() - new Date("2022-01-26").getTime())/1000/60/60/24));
        // const endDate = Math.abs(Math.floor((new Date().getTime() - new Date("2022-02-04").getTime())/1000/60/60/24));

        $("#schedule-btn").on("click", function(){
            //console.log($("#mdp-demo").multiDatesPicker('getDates'));
            let dateVal = $("#mdp-demo").multiDatesPicker('getDates');
            //let week3 = $("#mdp-demo").multiDatesPicker('value');
            // let week2 =  week[new Date(week3).getDay()];
            let week2 = [];
            // console.log(dateVal);
            // console.log(dateVal.length);
            for(i=0; i<dateVal.length; i++){
                week2[i]= week[new Date(dateVal[i]).getDay()]
            }
            // console.log(week2); 
            

            let num = 1;
            $("#schedule-table > tbody").html("");

            let dateOrder = dateVal[0].substring(6, 10) + "/" + dateVal[0].substring(0, 5);
            let dateOrder2 = dateVal[dateVal.length - 1].substring(6, 10) + "/" + dateVal[dateVal.length - 1].substring(0, 5);
            $('#schedule-table > tbody:last').append('<tr><td class="time-td3">개강기간</td><td class="time-td">'+dateOrder+'</td><td class="time-td4">&nbsp;~</td><td class="time-td">'+dateOrder2+'</td></tr>');

            for(i= 0; i<dateVal.length; i++){
                /* 
                let months = dateVal[i].substring(0, 5);
                let years = dateVal[i].substring(6, 10);
                let days = dateVal[i].substring(3, 5); 
                */

                dateOrder = dateVal[i].substring(6, 10) + "/" + dateVal[i].substring(0, 5);

                $('#schedule-table > tbody:last').append('<tr><td class="time-td2">'+num+'일차</td><td class="time-td"><input type="text" class="tdInput" name="schdlDt" value="'+dateOrder+'" readonly></td class="time-td4" ><td><input type="text" class="tdInput" name="schdlWeek" value="'+week2[i]+'" readonly></td><td class="time-td"><select name="schdlStartTime" id="startTime'+num+'" class="time-box"></select></td><td> ~ </td><td class="time-td"><input type="text" id="endTime'+num+'" name="schdlEndTime" class="time-box" value="10:00" readonly/></td></tr>');
                
                
                $("select#startTime" + num).append("<option value='9'>09:00</option>");
                $("select#startTime" + num).append("<option value='10'>10:00</option>");
                $("select#startTime" + num).append("<option value='11'>11:00</option>");
                $("select#startTime" + num).append("<option value='12'>12:00</option>");
                $("select#startTime" + num).append("<option value='13'>13:00</option>");
                $("select#startTime" + num).append("<option value='14'>14:00</option>");
                $("select#startTime" + num).append("<option value='15'>15:00</option>");
                $("select#startTime" + num).append("<option value='16'>16:00</option>");
                $("select#startTime" + num).append("<option value='17'>17:00</option>");
                $("select#startTime" + num).append("<option value='18'>18:00</option>");
                $("select#startTime" + num).append("<option value='19'>19:00</option>");
                $("select#startTime" + num).append("<option value='20'>20:00</option>");
                $("select#startTime" + num).append("<option value='21'>21:00</option>");
                $("select#startTime" + num).append("<option value='22'>22:00</option>");
                $("select#startTime" + num).append("<option value='23'>23:00</option>");
                
                /*
                $("select#endTime" + num).append("<option value='10'>10:00</option>");
                $("select#endTime" + num).append("<option value='11'>11:00</option>");
                $("select#endTime" + num).append("<option>12:00</option>");
                $("select#endTime" + num).append("<option>13:00</option>");
                $("select#endTime" + num).append("<option>14:00</option>");
                $("select#endTime" + num).append("<option>15:00</option>");
                $("select#endTime" + num).append("<option>16:00</option>");
                $("select#endTime" + num).append("<option>17:00</option>");
                $("select#endTime" + num).append("<option>18:00</option>");
                $("select#endTime" + num).append("<option>19:00</option>");
                $("select#endTime" + num).append("<option>20:00</option>");
                $("select#endTime" + num).append("<option>21:00</option>");
                $("select#endTime" + num).append("<option>22:00</option>");
                $("select#endTime" + num).append("<option>23:00</option>");
				*/
                
                // 옵션 최소시간 알아서 맞추기
                /*
                $("select#startTime" + num).on("change", function(){
                    // console.log(this.parentNode.nextSibling.nextSibling.firstChild);
                    let et = this.parentNode.nextSibling.nextSibling.firstChild;
                    $(et).children('option').remove();

					let opc = 0;

                    for(i=this.value; i<24; i++){
                            opc = Number(i)+1;
                            $(et).append('<option>'+opc+':00</option>');
                    }

                })
                */
                
                // 옵션 endTime 알아서 맞추기
                $("select#startTime" + num).on("change", function(){
                    let et = this.parentNode.nextSibling.nextSibling.firstChild;
                    let v = $(this).val();
                    let c = $("#num-time").val();
                    let s = Number(v) + Number(c);
                    let t = s + ":00";
					et.value = t;
                })      
                
                
                // 총 수업횟수 구겨넣기
                $("#num-class").val(i + 1);
                $("#sumPrice").html("");
			    let sum = $("#time-price").val() * $("#num-time").val() * $("#num-class").val();
			    let per = Math.floor($("#time-price").val());
			    $("#sumPrice").html("총 <span class='redText'>" + sum + "원</span> <br> 연결수수료 " + per + "원");
			    $("#epPrice").val(sum);

                num++;
            }



            $("#schedule-text").hide();
            $("#schedule-text").slideDown(400);
            

        });


        // 원데이 스케쥴용------------------------------------------------------
        $("#testtest").on("click", function(){
            //$("#schedule-val").attr("display", "none");
            $("#schedule-val").fadeOut(500);
            $("#ptn-multi").fadeOut(500);
            setTimeout(function(){
                $("#test-oneday-schedule").fadeIn(500);
                $("#ptn-one").fadeIn(500);
            }, 500);
        })

        $("#testtest1").on("click", function(){
            //$("#schedule-val").attr("display", "none");
            $("#test-oneday-schedule").fadeOut(500);
            $("#ptn-one").fadeOut(500);
            setTimeout(function(){
                $("#schedule-val").fadeIn(500);
                $("#ptn-multi").fadeIn(500);
            }, 500);

        })


        $("#schedule-btn2").on("click", function(){
            let dateVal = $("#mdp-demo").multiDatesPicker('getDates');
            
            let dateOrder = dateVal[0].substring(6, 10) + "/" + dateVal[0].substring(0, 5);
            let dateOrder2 = dateVal[dateVal.length - 1].substring(6, 10) + "/" + dateVal[dateVal.length - 1].substring(0, 5);


            let week2 = [];

            for(i=0; i<dateVal.length; i++){
                week2[i]= week[new Date(dateVal[i]).getDay()]
            
            }
            
            /* let scheduleDay = ""; */

            $("#schedule-td1").html(dateOrder);
            $("#schedule-td2").html(dateOrder2);
            
            

            let num = 1;
            $("#test-table > tbody").html("");
            $('#test-table > tbody:last').append('<tr><td class="time-td3">개강기간</td><td class="time-td">'+dateOrder+'</td><td class="time-td4">&nbsp;~</td><td class="time-td">'+dateOrder2+'</td></tr>');



            for(i= 0; i<dateVal.length; i++){

                dateOrder = dateVal[i].substring(6, 10) + "/" + dateVal[i].substring(0, 5);
                
                if(num == 1){
                    $('#test-table > tbody:last').append('<tr><td class="time-td2">수업일자</td><td class="time-td">'+dateOrder+'</td class="time-td4"><td>'+week2[i]+'</td><td class="time-td"><select id="startTime'+num+'" class="time-box"></select></td><td> ~ </td><td class="time-td"><select id="endTime'+num+'" class="time-box"></select></td><td><button id="plus-time'+num+'" class="plus-time" type="button">+</button></td></tr>');
                }else{
                    $('#test-table > tbody:last').append('<tr><td class="time-td2"></td><td class="time-td">'+dateOrder+'</td class="time-td4"><td>'+week2[i]+'</td><td class="time-td"><select id="startTime'+num+'" class="time-box"></select></td><td> ~ </td><td class="time-td"><select id="endTime'+num+'" class="time-box"></select></td><td><button id="plus-time'+num+'" class="plus-time" type="button">+</button></td></tr>');
                }

                
                
                $("select#startTime" + num).append("<option value='9'>09:00</option>");
                $("select#startTime" + num).append("<option value='10'>10:00</option>");
                $("select#startTime" + num).append("<option value='11'>11:00</option>");
                $("select#startTime" + num).append("<option value='12'>12:00</option>");
                $("select#startTime" + num).append("<option value='13'>13:00</option>");
                $("select#startTime" + num).append("<option value='14'>14:00</option>");
                $("select#startTime" + num).append("<option value='15'>15:00</option>");
                $("select#startTime" + num).append("<option value='16'>16:00</option>");
                $("select#startTime" + num).append("<option value='17'>17:00</option>");
                $("select#startTime" + num).append("<option value='18'>18:00</option>");
                $("select#startTime" + num).append("<option value='19'>19:00</option>");
                $("select#startTime" + num).append("<option value='20'>20:00</option>");
                $("select#startTime" + num).append("<option value='21'>21:00</option>");
                $("select#startTime" + num).append("<option value='22'>22:00</option>");
                $("select#startTime" + num).append("<option value='23'>23:00</option>");
                
                
                $("select#endTime" + num).append("<option>10:00</option>");
                $("select#endTime" + num).append("<option>11:00</option>");
                $("select#endTime" + num).append("<option>12:00</option>");
                $("select#endTime" + num).append("<option>13:00</option>");
                $("select#endTime" + num).append("<option>14:00</option>");
                $("select#endTime" + num).append("<option>15:00</option>");
                $("select#endTime" + num).append("<option>16:00</option>");
                $("select#endTime" + num).append("<option>17:00</option>");
                $("select#endTime" + num).append("<option>18:00</option>");
                $("select#endTime" + num).append("<option>19:00</option>");
                $("select#endTime" + num).append("<option>20:00</option>");
                $("select#endTime" + num).append("<option>21:00</option>");
                $("select#endTime" + num).append("<option>22:00</option>");
                $("select#endTime" + num).append("<option>23:00</option>");
                
                

                // 옵션 최소시간 알아서 맞추기
                $("select#startTime" + num).on("change", function(){
                    //console.log(this.parentNode.nextSibling.nextSibling.firstChild);
                    let et = this.parentNode.nextSibling.nextSibling.firstChild;
                    $(et).children('option').remove();

					let opc = 0;

                    for(i=this.value; i<24; i++){
                            opc = Number(i)+1;
                            $(et).append('<option>'+opc+':00</option>');
                    }

                })

                // 플러스 버튼
                let plusNo = 1;
                $("#plus-time" + num).on("click", function(e){
                    const tr = $("<tr>");
                    const td = $("<td>");
                    const td2 = $("<td>");
                    const td3 = $("<td>");
                    const td4 = $("<td>");
                    const td5 = $("<td>");
                    const td6 = $("<td>");
                    const td7 = $("<td>");
                    /*
                    td2.addClass("time-td"); 
                    td4.addClass("time-td"); 
                    */
                    const select1 = $("<select>");
                    const select2 = $("<select>");

                    select1.attr("id", "addStartTime" + plusNo);
                    select2.attr("id", "addEndTime" + plusNo);

                    select1.addClass("time-box");
                    select1.append("<option value='09'>09:00</option>");
                    select1.append("<option value='10'>10:00</option>");
                    select1.append("<option value='11'>11:00</option>");
                    select1.append("<option value='12'>12:00</option>");
                    select1.append("<option value='13'>13:00</option>");
                    select1.append("<option value='14'>14:00</option>");
                    select1.append("<option value='15'>15:00</option>");
                    select1.append("<option value='16'>16:00</option>");
                    select1.append("<option value='17'>17:00</option>");
                    select1.append("<option value='18'>18:00</option>");
                    select1.append("<option value='19'>19:00</option>");
                    select1.append("<option value='20'>20:00</option>");
                    select1.append("<option value='21'>21:00</option>");
                    select1.append("<option value='22'>22:00</option>");
                    select1.append("<option value='23'>23:00</option>");
                    
                    
                    select2.addClass("time-box");
                    select2.append("<option>10:00</option>");
                    select2.append("<option>11:00</option>");
                    select2.append("<option>12:00</option>");
                    select2.append("<option>13:00</option>");
                    select2.append("<option>14:00</option>");
                    select2.append("<option>15:00</option>");
                    select2.append("<option>16:00</option>");
                    select2.append("<option>17:00</option>");
                    select2.append("<option>18:00</option>");
                    select2.append("<option>19:00</option>");
                    select2.append("<option>20:00</option>");
                    select2.append("<option>21:00</option>");
                    select2.append("<option>22:00</option>");
                    select2.append("<option>23:00</option>");
                    


                    td4.append(select1);
                    td5.html("~");
                    td6.append(select2);

                    const minus = $("<button>");
                    minus.html("-");
                    minus.addClass("plus-time");
                    minus.addClass("minus-time");
                    minus.attr("id", "minus" + plusNo);
                    minus.attr("type", "button");
                    //minus.setAttribute("onclick", "remove(event);");
                    //minus.addEventListener("click", remove);
                    // minus.attr("onclick", "removeCols();");
                    td7.append(minus);

                    tr.append(td);
                    tr.append(td2);
                    tr.append(td3);
                    tr.append(td4);
                    tr.append(td5);
                    tr.append(td6);
                    tr.append(td7);
                    
                    
	                 // 추가 시간 옵션 최소시간 알아서 맞추기
	                $("select#addStartTime" + plusNo).on("change", function(){
	                    console.log("ㄷㄷ");
	                })
                    
                    // tr 추가
                    $(this).parent().parent().after(tr);

                    $(minus).on("click",function(e){
                        e.target.parentNode.parentNode.remove();
                    })

                    plusNo = plusNo + 1;
                })

                num++;

            }


            $("#test-schedule-text").hide();
            $("#test-schedule-text").slideDown(400);
        })
        
// 가격 계산스
$("#time-price").on("input", function(){
    $("#pt1").html("");
    $("#pt1").html($(this).val());
})

$("#num-time").on("input", function(){
    $("#pt2").html("");
    $("#pt2").html("x " + $(this).val());
})

$("#num-class").on("propertychange change keyup paste input", function(){
    $("#pt3").html("");
    $("#pt3").html("x " + $(this).val());
})

$("#time-price, #num-time, #num-class").on("input", function(){
    $("#sumPrice").html("");
    let sum = $("#time-price").val() * $("#num-time").val() * $("#num-class").val();
    let per = Math.floor($("#time-price").val());
    $("#sumPrice").html("총 <span class='redText'>" + sum + "원</span> <br> 연결수수료 " + per + "원");
    $("#epPrice").val(sum);
})

//------------------ test------------------------
// 원데이 가격 계산스
$("#time-price-one").on("input", function(){
    $("#pt1").html("");
    $("#pt3").html("");
    $("#pt1").html($(this).val());
})

$("#num-time-one").on("input", function(){
    $("#pt2").html("");
    $("#pt3").html("");
    $("#pt2").html("x " + $(this).val());
})

$("#time-price-one, #num-time-one").on("focus", function(){
    $("#sumPrice").html("");
    let sum = $("#time-price-one").val() * $("#num-time-one").val();
    let per = Math.floor(sum * 0.2);
    $("#sumPrice").html("총 <span class='redText'>" + sum + "원</span> <br> 연결수수료 " + per + "원");
})

// ------------------------------------------------


// ---------- 주소검색 --------------
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/tteutto/register/addrPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.addrDetail.value = addrDetail;

}
/*

$("#roadAddrPart1").on("propertychange change keyup paste input", function(){
	$("#epPlace1").val($(this).val());
})

$("#addrDetail").on("propertychange change keyup paste input", function(){
	$("#epPlace2").val($(this).val());
})
*/

