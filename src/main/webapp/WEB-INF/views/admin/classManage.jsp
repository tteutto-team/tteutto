<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
  
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
    <title>클래스 관리</title>
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
                <th>기간</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</body>

<script>
    
  $.ajax({
    	url: "classList",
    	type: "GET",
    	dataType : "JSON",
    	success: function(data){
    		console.log(data);
    		$('#table_id').DataTable({
    			data: data,
    			columns: [
    				{ data: "memberNo"},
                    { data: "memberEmail"},
                    { data: "memberNm"},
                    { data: "memberPw"}
    			],
    			columnDefs: [
    				{
                    "targets": 4,
                    "data": null,
                    "render": function(data, type, row){
                            return '<button onclick="confirm('+data.memberNo+')">승인</button><button onclick="confirm('+data.memberNo+')">거절</button>';
                        },
                    "orderable": false
                    },
                    {
                        "targets": 1,
                        "data": null,
                        "render": function(data, type, row){
                                return '<a href="#">' + data + '</a>';
                            },
                        "orderable": false
                        }
    			]
    		})
    	}
    })
</script>
</html>