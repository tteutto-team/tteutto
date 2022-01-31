var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};



var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();
// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

// 지도 api는 모달창으로 할경우 이미지가 깨지기 때문에 크기를 한번 맞쳐줘야 한다.
function relayout() {    
    
    // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
    // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다 
    // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
    map.relayout();
}

var currentPos;
function locationLoadSuccess(pos) {
    // 현재 위치 받아오기
    currentPos = new kakao.maps.LatLng(pos.coords.latitude, pos.coords.longitude);
	
    // 지도 이동(기존 위치와 가깝다면 부드럽게 이동)
    map.panTo(currentPos);

    map.setCenter(currentPos);

};

function locationLoadError(pos) {
    alert('위치 정보를 가져오는데 실패했습니다.');
};
function getCurrentPosBtn() {
    navigator.geolocation.getCurrentPosition(locationLoadSuccess, locationLoadError);
};
getCurrentPosBtn();
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
// 내 위치와 클래 위치의 거리
var distance = [];
// 클래스위치 담을 곳
var studyClass = [];
// 결과값으로 받은 위치를 마커로 표시합니다
var markerArr = [];
// 인포윈도우로 장소에 대한 설명을 표시합니다
var infowindow;
var linePath = [];
var polyline = [];
var proClassAddr = [];
var proClassNm = [];
var len;
var searchLocation; // 좌표

function AddrChangeCoords(){

    for(let i = 0; i < len; i++){
        // 주소로 좌표를 검색합니다
        geocoder.addressSearch(proClassAddr[i]/* 클래스 주소 */, function (result, status) {
            // status == OK or ZERO_RESULT
            // 정상적으로 검색이 완료됐으면
            if (status == kakao.maps.services.Status.OK) {
                studyClass[i] = new kakao.maps.LatLng(result[0].y, result[0].x);
                // 내 위치 ~ 클래싀위치[i]의 직선거리 계산을 위한 배열로 저장
                linePath[i] = [searchLocation, studyClass[i]];

                // 결과값으로 받은 위치를 마커로 표시합니다
                markerArr[i] = new kakao.maps.Marker({
                    map: map,
                    position: studyClass[i],
                    
                });
                // // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                // map.setCenter(currentPos);
                
				var iwContent = '<div style="padding:5px;">'+proClassNm[i]+'</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
				    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
				
				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
				    content : iwContent,
				    removable : iwRemoveable
				});
                // 클릭을 가능하게 해주는 구문(true : 불가능)
				markerArr[i].setClickable(true);
				kakao.maps.event.addListener(markerArr[i], 'click', function() {
				   	// 마커 위에 인포윈도우를 표시합니다
				    infowindow.open(map, markerArr[i]);  
				});
				 
            } else if (status == "ZERO_RESULT") {
                alert("검색결과가 없습니다.");
            }
			polyline[i] = new kakao.maps.Polyline({
                path: linePath[i] // 선을 구성하는 좌표배열 입니다
            });
            distance[i] = Math.round(polyline[i].getLength());
            //console.log(distance);
        });
    }
}


function searchPos(addr){
    
   
    geocoder.addressSearch(addr, function (result, status) {
        if (status == kakao.maps.services.Status.OK) {
    
            searchLocation = new kakao.maps.LatLng(result[0].y, result[0].x);
    
            map.setCenter(searchLocation);
    
        } else if (status == "ZERO_RESULT") {
            alert("검색결과가 없습니다.");
        }
    });
    
}

function ajaxLoad(){
	
	$.ajax({
		url : "classLocation",
		dataType : "json",
		success : function(result){
			len = result.length;
			$.each(result, function(i, item){
				proClassAddr[i] = item.epPlace;
				proClassNm[i] = item.classNm;
			});
			setTimeout(function(){
				AddrChangeCoords();
			}, 500)
		},
		error : function(request, status, error){
	        if( request.status == 404 ){
	            console.log("ajax 요청 주소가 올바르지 않습니다.");
	        } else if( request.status == 500){
	            console.log("서버 내부 에러 발생");
	        }
	    },
	    complete : function(){}
	});
}
		
$("#locationSearchBtn").on("click", function(){
	const LocationSearch = $("#locationSearch").val();
	const LocationSearchName = $(".modal-location").children();
	
	$(LocationSearchName).text(LocationSearch);
	searchPos(LocationSearch);
	ajaxLoad();
})

$("")
