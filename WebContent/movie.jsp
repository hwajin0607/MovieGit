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
		.btn_wrap_frm{
			float:left;
			margin-left : 10px;
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
			<form class="btn_wrap_frm">
				<!-- <input type = "button" value="영화 등록" onclick="openNew()" /> -->
				<input type="button" value="영화 등록" onclick="location.href='movieupload.jsp'"/>
			</form>
			<form class="btn_wrap_frm" action="movie" name="selectDelete" method="post">
				<input type="hidden" name="_method" value="delete" />
				<input type="hidden" name="mIdxList" />
				<input type = "button" value="선택영화삭제" onclick="callDelete()" />
			</form>
			<br/>
			<br/>
			
			<table>
					<tr>
						<th><input type="checkbox" name="allCheck" onclick="allCheckBox()" /></th>
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
						<td><input type="checkbox" name="mIdx" value="${movie.mIdx}" /></td>
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
	//
	var msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}

	//
	function callDelete(){
		let checkedList = $('input[name=mIdx]:checked').serializeArray().map(v => v.value);
		if(!!checkedList && checkedList.length){
			document.querySelector('input[name=mIdxList]').value = checkedList.join();
			document.selectDelete.submit();
		}else {
			alert('선택된 항목이 존재하지 않습니다.');
		}
	}
	function openNew(){
       var url="movieCreate.jsp";
       window.open(url,"","width=680,height=800,left=600");
	}
	//
	function allCheckBox(){
		let allTarget = document.querySelectorAll('input[name=mIdx]');	
		allTarget.forEach(v => {
			v.checked = !v.checked;
		});
	}
	//
	var d = ${currPage};
		if(d < 1){
		location.href="./movie?page=${currPage+1}";		
	}
</script>

</html>