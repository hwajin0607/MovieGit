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

		}
		table{
			margin : 10px 0 ;
		}
</style>
</head>
<body>
			<h4>새로운 영화 등록</h4>
			<form action="movieTest" method="post" enctype="multipart/form-data">
				<!-- <input type="hidden" name="_method" value="put" /> -->
				<table>
						<tr>
							<th>영화명</th>
							<td><input type="text" name="movieName"/></td>
						</tr>
						<tr>
						<th>개봉일</th>
						<td>
							<input type="date" name="openDate" />
						</td>
						</tr>
						<tr>
							<th>장르</th>
							<td><input type="text" name="genre"  /></td>
						</tr>
						<tr>
							<th>URL</th>	
							<td><input type="text" name="url" /></td>
						</tr>
						<tr>
							<th>적정연령</th>
							<td><input type="text" name="age"/></td>
						</tr>
						<tr>
							<th>줄거리</th>
							<td>
							<textarea name="story"></textarea>
							</td>
						</tr>
						<tr>
							<th>포스터</th>
							<td><input type="file" name="poster"/></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="영화 등록" /></td>
						</tr>
				</table>
			</form>
				<!--  -->
				<!--  
				<h3>부가정보 등록</h3>
				<table>
						<tr>
							<th>감독</th>
							<td><input type="text" name="director" required /></td>
						</tr>
						<tr>
							<th>배우</th>
							<td><input type="text" name="actor" required /></td>
						</tr>
				</table>
				<table>
				<tr>
					<th>포스터</th>
					<td><input type="file" name="poster"  required /></td>
				</tr>
				</table>
				-->

</body>
<script>

</script>

</html>