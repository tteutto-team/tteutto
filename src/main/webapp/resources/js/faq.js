$(document).ready(function(){
	$("#student").trigger("click");
})

$("#student").on("click", function(){
	const faqDiv = $(this).attr("value");
	$(this).attr("class", "tab_on");
	$("#teacher").attr("class", "tab");
	let html = "";
	$.ajax({
		url : "selectFaq",
		type : "GET",
		data : {"faqDiv": faqDiv},
		success : function(result){
			for(let i=0; i<result.length; i++){
				html += "<div class='faq'>"
                html += "<span class='faq_title'>"
                html += "<span class='faq_title_no'>" + (i+1) +"&nbsp&nbsp</span> "+ result[i].faqQuestion
                html += "</span><br>"+result[i].faqAnswer
                html += "</div>"
			}
            $("#faq_list").html(html);
		}
	})
});


$("#teacher").on("click", function(){
	const faqDiv = $(this).attr("value");
	$(this).attr("class", "tab_on");
	$("#student").attr("class", "tab");
	let html = "";
	$.ajax({
		url : "selectFaq",
		type : "GET",
		data : {"faqDiv": faqDiv},
		success : function(result){
			for(let i=0; i<result.length; i++){
				html += "<div class='faq'>"
                html += "<span class='faq_title'>"
                html += "<span class='faq_title_no'> "+ (i+1) +"&nbsp&nbsp</span> "+ result[i].faqQuestion
                html += "</span><br>"+result[i].faqAnswer
                html += "</div>"
			}
            $("#faq_list").html(html);
		}
	})
});


