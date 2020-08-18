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

			<h4>회원 댓글 관리 페이지</h4>
			<br/>
			<form class="btn_wrap_frm" action="memberComment" name="selectDelete" method="POST">
				<input type="hidden" name="_method" value="delete" />
				<input type="hidden" name="conIdxList" />
				
				<input type="hidden" name="uidx" value="${uidx}" />
				<input type ="button" value="선택댓글삭제" onclick="callDelete()" />
			</form>
			<br/>
			<br/>
			<table >
					<tr>
						<th><input type="checkbox" name="allCheck" onclick="allCheckBox()" /></th>
						<th>영화번호</th>
						<th>영화이름</th>
						<th>댓글내용</th>
						<th>댓글등록일</th>
					</tr>
					<c:forEach items="${list}" var ="con">
						<tr>
							<td><input type="checkbox" name="conIdx" value="${con.conIdx}" /></td>
							<td>${con.mIdx}</td>
							<td>${con.mName}</td>
							<td>${con.conContent}</td>
							<td>${con.mDate}</td>
						</tr>
					</c:forEach>

			</table>
	


</body>
<script>

	
//
	function callDelete(){
		let checkedList = $('input[name=conIdx]:checked').serializeArray().map(v => v.value);
		if(!!checkedList && checkedList.length){
			document.querySelector('input[name=conIdxList]').value = checkedList.join();
			document.selectDelete.submit();
			alert('삭제완료');
		}else {
			alert('선택된 항목이 존재하지 않습니다.');
		}
	};
	
	function allCheckBox(){
	let allTarget = document.querySelectorAll('input[name="conIdx"]');	
	allTarget.forEach(v => {
		v.checked = !v.checked;
	})
	};
</script>

</html>