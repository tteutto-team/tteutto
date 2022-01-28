<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
  
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
    <title>회차별 클래스 신청 관리</title>
    <style>
        #table_id_wrapper{
            width: 1000px;

        }

        #table_id th{
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <table id="table_id" class="display">
        <thead>
            <tr>
                <th>번호</th>
                <th>클래스명-회차</th>
                <th>강사명</th>
                <th>신청날짜</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</body>

<script>
  $(function(){
	  createTable();
  })
  
  function createTable(){
	  $.ajax({
	    	url: "classList",
	    	type: "GET",
	    	dataType : "JSON",
	    	success: function(data){
	    		console.log(data);
	    		$('#table_id').DataTable({
	    			data: data,
	    			columns: [
	    				{ data: "classNo"},
	    				{ data: null },
	                    { data: "memberName"},
	                    { data: "classRequestDate"}
	    			],
	    			columnDefs: [
	    				{
	                    "targets": 4,
	                    "data": null,
	                    "render": function(data, type, row){
	                    	console.log(data);
	                            return '<button onclick="agree('+data.classNo+')">승인</button><button onclick="deny('+data.classNo+')">거절</button>';
	                        },
	                    "orderable": false
	                    },
	                    {
	                        "targets": 1,
	                        "data": null,
	                        "render": function(data, type, row){
	                                return '<a href="#">' + data.className + '-' + data.episodeCount + '회차</a>';
	                            },
	                        "orderable": false
	                        }
	    			]
	    		})
	    	}
	    })
  }
    
    function agree(classNo){
	  if(confirm("클래스 회차 등록을 승인하겠습니까?")){
		  $.ajax({
			  url: "agree",
			  dataType: "json",
			  data: {"classNo": classNo},
			  success: function(result){
				  if(result > 0){
					  alert("승인 완료");
					  
					  $('#table_id').DataTable().destroy();
					  createTable();
					  
				  }
			  }
		  })
	  }
  }
</script>
</html>