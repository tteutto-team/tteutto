// 클래스 장소
var detail_addr = $("#classAddress").text();
//console.log(detail_addr);

var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
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

// 현재 위치담을 변수 선언
var currentPos;
function locationLoadSuccess(pos) {
    // 현재 위치 받아오기
    currentPos = new kakao.maps.LatLng(pos.coords.latitude, pos.coords.longitude);
	

    // 지도 이동(기존 위치와 가깝다면 부드럽게 이동)
    map.panTo(currentPos);

    // 마커 생성
    var marker = new kakao.maps.Marker({
        position: currentPos
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    //marker.setMap(map); // 내위치를 찍어주는 마커
    map.setCenter(currentPos);

    // 기존에 마커가 있다면 제거
    // marker.setMap(null);

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
let studyClass;
let markerArr;

geocoder.addressSearch(detail_addr, function (result, status) {

    // 정상적으로 검색이 완료됐으면
    if (status == kakao.maps.services.Status.OK) {

        studyClass = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        markerArr = new kakao.maps.Marker({
            map: map,
            position: studyClass
        });
        // // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(studyClass);
	
		 markerArr.setMap(map);
    } else if (status == "ZERO_RESULT") {
        alert("검색결과가 없습니다.");
    }

});



// 좌표로 상세주소
var myDetailAddr;
function searchDetailAddrFromCoords(coords, callback) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}
function getClassAddress() {
    searchDetailAddrFromCoords(currentPos, function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
            myDetailAddr = !!result[0].road_address ? result[0].road_address.address_name : '';
        }
    });
}
$(function(){
	getClassAddress();
})

// 길찾기
function loadSearch(){
    return 'https://map.kakao.com/?sName=' + myDetailAddr +
        '&eName=' + detail_addr;
}

