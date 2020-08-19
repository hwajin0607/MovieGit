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

			<h4>회원 관리페이지</h4>
			<br/>
			<div class="backpage">
				<a href="manager.jsp">초기화면으로 돌아가기</a>
			
			</div>
			<form method="GET" action = "member">
			<input type="text" class="sech" name="search">
			
			<input type="submit" class="member_btn" value="회원명검색" />
			</form>
			<br/>
			<br/>



			<table >
					<tr>
						
						<th>No</th>
						<th>이름</th>
						<th>생년월일</th>
						<th>성별</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이메일</th>
						<th>회원가입일</th>
						<th>댓글</th>
					</tr>
					<c:forEach items="${list}" var ="member">
					<tr>
						<td>${member.uIdx} <input type ="hidden" name="uIdx" value="${member.uIdx}"/></td>
						<td>${member.uName}</td>
						<td>${member.uBirth}</td>
						<td>${member.uGender}</td>
						<td>${member.uIden}</td>
						<td>${member.uPw}</td>
						<td>${member.uEmail}</td>
						<td>${member.uDate}</td>
						<!-- <td><input type = "button" value="댓글목록" onclick="openNew()" /></td> -->
						<td><input type = "button" value="댓글목록" onclick='window.open("./memberComment?uidx=${member.uIdx}","","width=680,height=800,left=600")' /></td>
					</tr>	
					</c:forEach>

			</table>
					<div class = "pageArea">
				<a href = "./member?page=${currPage-1}"><span id="prevPage">이전 페이지</span></a>
				<span><b>${currPage}</b></span>
				<a href = "./member?page=${currPage+1}"><span>다음 페이지</span></a>
					</div>			




</body>
<script>

	
	var d = ${currPage};
	//var e = ${endPage};
	
	/*
	if(d==1){
		document.getElementById('prevPage').style.display="none";
	}
	
	if(currpage <1 && currpage < endpage){
		document.getElementById('prevPage').style.display="inline";
		document.getElementById('nextPage').style.display="inline";
	}
	
	if(currpage == endPage){
		페이지 사라지게 -->
	}
	
	*/
	if(d < 1){
		location.href="./member?page=${currPage+1}";		
	}
	
	var uidx = $('input[name="uIdx"]').val();	
	function openNew(){
		console.log(uidx);
       	var url="./memberComment?uidx="+uidx;
       	window.open(url,"","width=680,height=800,left=600");
	}
	
</script>

</html>