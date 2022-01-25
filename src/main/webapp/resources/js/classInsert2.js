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

                $('#schedule-table > tbody:last').append('<tr><td class="time-td2">'+num+'회차</td><td class="time-td">'+dateOrder+'</td class="time-td4"><td>'+week2[i]+'</td><td class="time-td"><select id="startTime'+num+'" class="time-box"></select></td><td> ~ </td><td class="time-td"><select id="endTime'+num+'" class="time-box"></select></td></tr>');
                $("select#startTime" + num).append("<option>08:00</option>");
                $("select#startTime" + num).append("<option>09:00</option>");
                $("select#startTime" + num).append("<option>10:00</option>");
                $("select#startTime" + num).append("<option>11:00</option>");
                $("select#startTime" + num).append("<option>12:00</option>");
                $("select#startTime" + num).append("<option>13:00</option>");
                $("select#startTime" + num).append("<option>14:00</option>");
                $("select#startTime" + num).append("<option>15:00</option>");
                $("select#startTime" + num).append("<option>16:00</option>");
                $("select#startTime" + num).append("<option>17:00</option>");
                $("select#startTime" + num).append("<option>18:00</option>");
                $("select#startTime" + num).append("<option>19:00</option>");
                $("select#startTime" + num).append("<option>20:00</option>");
                $("select#startTime" + num).append("<option>21:00</option>");
                $("select#startTime" + num).append("<option>22:00</option>");
                $("select#startTime" + num).append("<option>23:00</option>");
                $("select#startTime" + num).append("<option>24:00</option>");
                
                $("select#endTime" + num).append("<option>08:00</option>");
                $("select#endTime" + num).append("<option>09:00</option>");
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
                $("select#endTime" + num).append("<option>24:00</option>");
                num++;
            }


            $("#schedule-text").hide();
            $("#schedule-text").slideDown(400);
            

        });


        // 테스트용------------------------------------------------------
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

        /*
        $("#schedule-btn2").on("click", function(){
            let dateVal = $("#mdp-demo").multiDatesPicker('getDates');

            let num = 1;
            $("#test-table > tbody").html("");
            $('#test-table > tbody:last').append('<tr><td class="time-td3">개강기간</td><td class="time-td">'+dateVal[0]+'</td><td>~&nbsp</td><td class="time-td">'+dateVal[dateVal.length -1]+'</td></tr>');
            $('#test-table > tbody:last').append('<tr><td class="time-td2">수업시간</td><td class="time-td"><select id="startTime'+num+'" class="time-box"></select></td><td>&nbsp~&nbsp</td><td class="time-td"><select id="endTime'+num+'" class="time-box"></select></td><td><button class="plus-time">+</button></td></tr>');

            $("select#startTime" + num).append("<option>08:00</option>");
            $("select#startTime" + num).append("<option>09:00</option>");
            $("select#startTime" + num).append("<option>10:00</option>");
            $("select#startTime" + num).append("<option>11:00</option>");
            $("select#startTime" + num).append("<option>12:00</option>");
            $("select#startTime" + num).append("<option>13:00</option>");
            $("select#startTime" + num).append("<option>14:00</option>");
            $("select#startTime" + num).append("<option>15:00</option>");
            $("select#startTime" + num).append("<option>16:00</option>");
            $("select#startTime" + num).append("<option>17:00</option>");
            $("select#startTime" + num).append("<option>18:00</option>");
            $("select#startTime" + num).append("<option>19:00</option>");
            $("select#startTime" + num).append("<option>20:00</option>");
            $("select#startTime" + num).append("<option>21:00</option>");
            $("select#startTime" + num).append("<option>22:00</option>");
            $("select#startTime" + num).append("<option>23:00</option>");
            $("select#startTime" + num).append("<option>24:00</option>");
            
            $("select#endTime" + num).append("<option>08:00</option>");
            $("select#endTime" + num).append("<option>09:00</option>");
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
            $("select#endTime" + num).append("<option>24:00</option>");
        

            $("#test-schedule-text").hide();
            $("#test-schedule-text").slideDown(400);

        })
        */

        $("#schedule-btn2").on("click", function(){
            let dateVal = $("#mdp-demo").multiDatesPicker('getDates');
            
            let dateOrder = dateVal[0].substring(6, 10) + "/" + dateVal[0].substring(0, 5);
            let dateOrder2 = dateVal[dateVal.length - 1].substring(6, 10) + "/" + dateVal[dateVal.length - 1].substring(0, 5);


            let week2 = [];

            for(i=0; i<dateVal.length; i++){
                week2[i]= week[new Date(dateVal[i]).getDay()]
            }

            let scheduleDay = "";

            $("#schedule-td1").html(dateOrder);
            $("#schedule-td2").html(dateOrder2);
            
            for(i= 0; i<dateVal.length; i++){
                let dates = dateVal[i].substring(0, 5);
                let days = week2[i]
                if(i != dateVal.length - 1){
                    scheduleDay += dates + "(" + days + "), ";
                }else{
                    scheduleDay += dates + "(" + days + ")";
                }
            }

            $("#schedule-day").html(scheduleDay);

            $("#test-schedule-text").hide();
            $("#test-schedule-text").slideDown(400);
        })

        let plusNo = 1;
        $("#plus-time").on("click", function(){
            const tr = $("<tr>");
            const td = $("<td>");
            const td2 = $("<td>");
            const td3 = $("<td>");
            const td4 = $("<td>");
            const td5 = $("<td>");
            td2.addClass("time-td"); 
            td4.addClass("time-td"); 

            const select1 = $("<select>");
            const select2 = $("<select>");

            select1.attr("id", "startTime" + plusNo);
            select2.attr("id", "endTime" + plusNo);

            select1.addClass("time-box");
            select1.append("<option>08:00</option>");
            select1.append("<option>09:00</option>");
            select1.append("<option>10:00</option>");
            select1.append("<option>11:00</option>");
            select1.append("<option>12:00</option>");
            select1.append("<option>13:00</option>");
            select1.append("<option>14:00</option>");
            select1.append("<option>15:00</option>");
            select1.append("<option>16:00</option>");
            select1.append("<option>17:00</option>");
            select1.append("<option>18:00</option>");
            select1.append("<option>19:00</option>");
            select1.append("<option>20:00</option>");
            select1.append("<option>21:00</option>");
            select1.append("<option>22:00</option>");
            select1.append("<option>23:00</option>");
            select1.append("<option>24:00</option>");
            
            select2.addClass("time-box");
            select2.append("<option>08:00</option>");
            select2.append("<option>09:00</option>");
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
            select2.append("<option>24:00</option>");


            td2.append(select1);
            td3.html("&nbsp~&nbsp");
            td4.append(select2);

            const minus = $("<button>");
            minus.html("-");
            minus.addClass("plus-time");
            minus.addClass("minus-time");
            minus.attr("id", "minus" + plusNo);
            //minus.setAttribute("onclick", "remove(event);");
            //minus.addEventListener("click", remove);
            // minus.attr("onclick", "removeCols();");
            td5.append(minus);

            tr.append(td);
            tr.append(td2);
            tr.append(td3);
            tr.append(td4);
            tr.append(td5);
            $('#test-table > tbody:last').append(tr);
            //console.log(plusNo);

            $(minus).on("click",function(e){
                e.target.parentNode.parentNode.remove();
            })

            plusNo = plusNo + 1;
        })

        /*
        function removeCols(){
            alert("왜 안됨");
            console.log(this)
            this.parentNode.parentNode.remove();
        }*/
        /*
        $("#minus" + plusNo).on("click", function(e){
            e.target.parentNode.parentNode.remove();
        })  */

        // $(document).on("click","#minus" + plusNo,function(e){
        //     //plusNo = plusNo - 1;
        //     //this.parentNode.parentNode.remove();
        //     console.log(this);
        //     console.log(e.target);
        //     e.target.parentNode.parentNode.remove();
        //     /*
        //         $(document).on("이벤트","선택자",함수(){});
        //         id가 test인 태그를 click했을 때 function(){} 중괄호 안의 이벤트를 실행하라.
        //         라는 의미입니다.
                
        //         무엇이 다르냐 하면, DOM 트리 구조의 상위요소(document)에 바인딩되며,
        //         document안의 선택자와 일치하는 요소가 존재 혹은 생성 될 때 실행됩니다.
         
        //         즉, 이벤트를 선택자가 아니라 document에 위임한다고 보시면 됩니다.*/
            
        // });


        //----------------------------------------------------------------

// 가격 계산스
$("#time-price").on("input", function(){
    $("#pt1").html("");
    $("#pt1").html($(this).val());
})

$("#num-time").on("input", function(){
    $("#pt2").html("");
    $("#pt2").html("x " + $(this).val());
})

$("#num-class").on("input", function(){
    $("#pt3").html("");
    $("#pt3").html("x " + $(this).val());
})

$("#time-price, #num-time, #num-class").on("input", function(){
    $("#sumPrice").html("");
    let sum = $("#time-price").val() * $("#num-time").val() * $("#num-class").val();
    let per = Math.floor($("#time-price").val());
    $("#sumPrice").html("총 <span class='redText'>" + sum + "원</span> <br> 연결수수료 " + per + "원");
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