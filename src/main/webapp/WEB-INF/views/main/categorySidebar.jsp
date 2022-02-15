<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="${contextPath}/resources/css/categorySidebar.css" />

<div class="left">
    <div class="list">
    	<ul>
    		<li>
    			<div class="ct" id="c-1">공예/디자인</div>
    			<ul>
    				<li><div class="ctdetail" id="d-1">조향/캔들/비누</div></li>
    				<li><div class="ctdetail" id="d-2">가죽/목공/도예</div></li>
    				<li><div class="ctdetail" id="d-3">캘리그라피</div></li>
    				<li><div class="ctdetail" id="d-4">플라워</div></li>
    				<li><div class="ctdetail" id="d-5">디지털드로잉</div></li>
    				<li><div class="ctdetail" id="d-6">취미미술</div></li>
    			</ul>
    		</li>
    		
    		<li>
    			<div class="ct" id="c-2">요리</div>
    			<ul>
    				<li><div class="ctdetail" id="d-7">베이킹/디저트</div></li>
    				<li><div class="ctdetail" id="d-8">커피/차/음료</div></li>
    				<li><div class="ctdetail" id="d-9">건강/다이어트식</div></li>
    				<li><div class="ctdetail" id="d-10">세계요리</div></li>
    			</ul>
    		</li>
    		<li>
    			<div class="ct" id="c-3">뷰티/헬스</div>
    			<ul>
    				<li><div class="ctdetail" id="d-11">메이크업</div></li>
    				<li><div class="ctdetail" id="d-12">퍼스널컬러</div></li>
    				<li><div class="ctdetail" id="d-13">패션</div></li>
    				<li><div class="ctdetail" id="d-14">pt/gx</div></li>
    			</ul>
    		</li>
   			<li>
   				<div class="ct" id="c-4">사진/영상</div>
    			<ul>
    				<li><div class="ctdetail" id="d-15">사진</div></li>
    				<li><div class="ctdetail" id="d-16">영상</div></li>
    			</ul>
    		</li>
    		<li>
    			<div class="ct" id="c-5">커리어</div>
    			<ul>
    				<li><div class="ctdetail" id="d-17">금융</div></li>
    				<li><div class="ctdetail" id="d-18">개발</div></li>
    				<li><div class="ctdetail" id="d-19">언어/외국어</div></li>
    				<li><div class="ctdetail" id="d-20">주식투자</div></li>
    				<li><div class="ctdetail" id="d-21">자격증</div></li>
    			</ul>
    		</li>
    		<li>
    			<div class="ct" id="c-6">음악</div>
    			<ul>
    				<li><div class="ctdetail" id="d-22">보컬</div></li>
    				<li><div class="ctdetail" id="d-23">악기</div></li>
    				<li><div class="ctdetail" id="d-24">작곡/디제잉</div></li>
    				<li><div class="ctdetail" id="d-25">댄스</div></li>
    			</ul>
    		</li>
    		<li>
    			<div class="ct" id="c-7">기타</div>
    		</li>
   		</ul>
    </div>
</div>

<script>
	(function(){
	    const bigCtList = document.querySelectorAll(".left > .list > ul > li > div");
	    
	    
	    for(let i=0 ; i < bigCtList.length-1 ; i++){
	       const arr = bigCtList[i].getAttribute("id").split("-");
	       
	       if(arr[1] != "${param.ctNo}"){
	          bigCtList[i].nextElementSibling.style.display = "none";
	       }
	    }
	 })()

	// 카테고리 화면 왼쪽에 작성된 모든 카테고리
	const categoryList = document.querySelectorAll(".left .list span");
	
	// 카테고리 하나 씩 반복 접근
	for(let category of categoryList){
		
		// 카테고리에서 얻어온 id를 "-"를 기준으로 쪼갬
		// [0] = c(대분류) 또는 d(소분류), [1] = pk 번호  
		const arr = category.getAttribute("id").split("-");
		
		// 클릭 이벤트 추가
		category.addEventListener("click", function(){
			
			
			let url = location.pathname; // 현재 url 경로를 얻어옴
			
			if(arr[0] == "c"){
					url += "?ctNo=" + arr[1];
			}else{
				// 부모 카테고리 요소를 얻어옴
				const parentCategory = category.parentNode.parentNode.previousElementSibling; 
				
				// [0] = c(대분류), [1] = pk 번호  
				const pArr = parentCategory.getAttribute("id").split("-");
				url += "?ctNo=" + pArr[1] + "&ctDetailNo=" + arr[1];
			}
			
			// 쿼리스트링이 완성된 주소를 요청 -> 지정된 카테고리에 맞는 클래스만 조회됨
			location.href = url;
			
		});
	
		
		if("${param.ctDetailNo}" != ""){ // 소분류 값이 있는 경우
			if(arr[0] == "d" && arr[1] == "${param.ctDetailNo}"){
				category.classList.add("selected")
			}
		}else{
			if(arr[0] == "c" && arr[1] == "${param.ctNo}"){
				category.classList.add("selected")
			}
		}
	}
</script>
