<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
		table, th, td{
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px 10px;
		}
		.pageArea{
			margin : 10px;
			
		}
		.pageArea span{
			border : 1px solid gray;
			padding : 2px 10px;
			margin : 5px;
		}
		a{
			text-decoration: none;
			
		}
		.backpage{
			padding-left: 600px;
		}
</style>
<body>

   <div class="큰 틀">
      <div class = "텍스트">
      
      <input type = "text" class="댓글 넣는곳" name = "conContent">
      <input type = "submit" value="submit">
      
      </div>
      <div class ="댓글목록">
      <ul>
         <c:forEach items="${list}" var ="content">
         <li>
         <div>
         <div>
         
         <h3>${content.uIden}</h3>
        <div> <h3>${content.conContent}</h3></div>
         <h3>${content.conRedate}</h3>
         </div>
         <div>버튼, 수정, 삭제</div>
         </div>

         </li>

         
         </c:forEach>
      
      </ul>
      
      </div>
   
   </div>
   	<div class = "pageArea">
				<a href = "./content?page=${currPage-1}"><span >이전 페이지</span></a>
				<span><b>${currPage}</b></span>
				<a href = "./content?page=${currPage+1}"><span>다음 페이지</span></a>
	</div>			
   
</body>
<script>

var d = ${currPage};


	if(d < 1){
	location.href="./content?page=${currPage+1}";		
}



</script>
</html>