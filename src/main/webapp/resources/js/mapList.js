$(".location").on("click", function(){
	var geocoder = new kakao.maps.services.Geocoder();
	let location ="";
	if (navigator.geolocation) {
	
		// GeoLocation을 이용해서 접속 위치를 얻어옵니다
		navigator.geolocation.getCurrentPosition(function(position) {
	
			var lat = position.coords.latitude; // 위도
			var lng = position.coords.longitude; // 경도
			
			
			getAddr(lat,lng);
			function getAddr(lat,lng){
			
			    let coord = new kakao.maps.LatLng(lat, lng);
			    let callback = function(result, status) {
			        if (status === kakao.maps.services.Status.OK) {
			            location =result[0].address.region_1depth_name + " " + result[0].address.region_2depth_name;
			            $("#location").text(location);
			            console.log($("#location").text());
			        }
			    }
		    	geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
			}
		})
	}
	
	

})

