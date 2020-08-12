<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com./jquery-3.5.1.min.js"></script>

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
</head>
<body>

			<h4>영화 관리페이지</h4>
			<br/>
			<div class="backpage">
				<a href="manager.jsp">초기화면으로 돌아가기</a>
			
			</div>
			<form method="GET" action = "movie">
			<input type="text" class="sech" name="search">
			
			<input type="submit" class="movie_btn" value="영화명 검색" />
			</form>
			<br/>
			<br/>
			<button type = submit> 영화 등록 </button>
			<button type = submit> 선택 영화 삭제 </button>
			<button type = submit> 전체 영화 삭제 </button>
			<br/>
			<br/>
			
			<table >
					<tr>
						<th>No</th>
						<th>개봉일</th>
						<th>장르</th>
						<th>URL</th>
						<th>조회수</th>
						<th>등록일</th>
						<th>적정연령</th>
						<th>줄거리</th>
						<th>영화명</th>
						
					</tr>
					<c:forEach items="${list}" var ="movie">
					<tr>
						<td>${movie.mIdx}</td>
						<td>${movie.mOpen}</td>
						<td>${movie.mGenre}</td>
						<td>${movie.mUrl}</td>
						<td>${movie.mBhit}</td>
						<td>${movie.mDate}</td>
						<td>${movie.mAge}</td>
						<td>${movie.mContent}</td>
						<td>${movie.mName}</td>
						
					</tr>
					</c:forEach>

			</table>
					<div class = "pageArea">
				<a href = "./movie?page=${currPage-1}"><span >이전 페이지</span></a>
				<span><b>${currPage}</b></span>
				<a href = "./movie?page=${currPage+1}"><span>다음 페이지</span></a>
					</div>			




</body>
<script>

	
	var d = ${currPage};
	
	
		if(d < 1){
		location.href="./movie?page=${currPage+1}";		
	}
	
	
		
	
</script>

</html>