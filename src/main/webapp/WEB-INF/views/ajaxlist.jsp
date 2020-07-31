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
					
						//json 버전 1(제일 많이 쓰이는 것)
						var htmls="";
						
			        	$("#ajaxList").html(""); // 

						$("<tr>" , {
							html : "<td>" + "번호" + "</td>"+  // 컬럼명들
									"<td>" + "이름" + "</td>"+
									"<td>" + "제목" + "</td>"+
									"<td>" + "날짜" + "</td>"+				
									"<td>" + "히트" + "</td>"
						}).appendTo("#ajaxList")//이것을 테이블에 붙임
						
						if(result.length <1){
							htmls.push("등록된 댓글이 없습니다.");
						}else{
							
						
						
						$(result).each(function(){
							htmls += '<tr>';
			            	htmls += '<td>'+ this.bId + '</td>';
			            	htmls += '<td>'+ this.bName + '</td>';
			            	htmls += '<td>'
			            	
			            	for(var i=0; i<this.bIndent; i++){
			            		htmls += '-'
			            	}
			            	
			            	htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + this.bId + '">' + this.bTitle + '</a></td>';
			            	htmls += '<td>'+ this.bDate + '</td>';
			            	htmls += '<td>'+ this.bHit + '</td>';
			            	htmls += '</td>';
			            							
						});//each end
			        	
			        	htmls+= '<tr>';
			        	htmls+= '<td colspan=5> <a href="${pageContext.request.contextPath}/write_view">글작성</a> </td>';
			        	htmls+= '</tr>';
			        	
			        	
						}
						
					 $("#ajaxList").append(htmls);
				},
				
				
				error: function(request, status, error){
					alert("실패");
					console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					
				}
				
				
			});// ajax end
			
		}// end getlist()
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