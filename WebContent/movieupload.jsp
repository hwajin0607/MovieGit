<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com./jquery-3.5.1.min.js"></script>

</head>
<body>
	<form action="movieTest" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>영화명</th>
				<td>
				<input type="text" name="movieName" value=""/>
				</td>
			</tr>
			<tr>
				<th>개봉일</th>
				<td><input type="date" name="openDate" value=""/></td>
			</tr>
			<tr>
				<th>장르</th>
				<td><input type="text" name="genre" value=""/></td>
			</tr>
			<tr>
				<th>URL</th>
				<td><input type="text" name="url" value=""/></td>
			</tr>
			<tr>
				<th>적정연령</th>
				<td><input type="text" name="age" value=""/></td>
			</tr>
			<tr>
				<th>줄거리</th>
				<td><textarea name="story"></textarea></td>
			</tr>
			<tr>
				<th>포스터</th>
				<td><input type="file" name="photo" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장"/></td>
			</tr>
		</table>
	</form>
</body>
<script>
	var msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}
</script>
</html>