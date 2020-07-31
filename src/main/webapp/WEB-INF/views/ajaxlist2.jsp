<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
		<script type="text/javascript">
			function getAjaxList(){
				
				var url = "${pageContext.request.contextPath}/restful/after.json";
				
				$.ajax({
					
					url: url,
					type: 'GET',//get 또는 post, 무조건 대문자로
					cache: false,//이걸 안쓰거나 true하면 수정해도 값반영이 잘 안될때가 있음
					dataType: "json", //response해서 내가 받을 타입
					//data: "id:"abcd"",//-->내가 넘겨줄 데이터//지금 당장 보내줄 데이터가 없으니 삭제(나는 주석처리)
					success: function(result){//result값을 객체에 올려놨다
						
						//json 버전 2
						 $.each(result,function(){
							$('#ajaxList').append("<tr><td>"+this.bId+"</td><td>"+this["bName"]+"</td><td>"+this["bTitle"]+"</td><td>"+this["bContent"]+"</td></tr>");
							
						})
						 
						/* $.each(result,function(index,entry){
							$('#ajaxList').append("<tr><td>"+entry.bId+"</td><td>"+entry["bName"]+"</td></tr>");
						})  */
					},
					
					
					error: function(request, status, error){
						alert("실패");
						console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						
					}
					
					
				});
				
			}
			
			
	
		</script>
		
		<script>
		$(document).ready(function(){
			getAjaxList();
		});
		
		</script>
	</head>
	
	
	<body>
		
		<table id="ajaxList" width="500" cellpadding="0" cellspacing="0" border="1" align="center">
			
		</table>
		
	</body>
</html>