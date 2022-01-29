$("#sendEmail").on("click", function(){
	const inputEmail = $("#email").val();
	$.ajax({
		url : "emailDupCheck",
		type : "GET",
		data : {"inputEmail" : inputEmail},
		success : function(result){
			if(result == 1){
				$.ajax({
					url : "sendEmail",
					type : "POST",
					data : {"inputEmail" : inputEmail},
					
				})
			}else{
				swal({
					text : "이메일을 다시 확인해 주세요.",
					icon : "warning"
				});
			}
		}		
	});
	
});