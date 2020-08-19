<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<style>
			body{
				background-image: url("/photo/memberinfo.jpg");
				background-repeat: no-repeat;
			}
			#mainbody{
				position: absolute;
				top : 0px;
				left: 0px;
				height: 100%;
				width: 100%;
				background-color: rgba(0, 0, 0, 0.4);
			}
			table{
				position: absolute;
				top : 20%;
				left: 35%;
			}
			table, tr, th, td{
				border:1px solid rgb(37, 35, 35);
				border-collapse: collapse;
				background-color: rgb(37, 35, 35);
				font:white;
			}
			table, tr, th, td{
				padding: 5px 20px;
			}
			td,th{
				background-color: rgb(37, 35, 35);
				color: white;
			}
			.topbox{
				background-color: black;
				color: white;
			}
			button{
				width: 200px;
			}
            #id{
                width: 100px;
            }
            input[type='text'],input[type='password']{
                width: 200;
                margin:  5px 10px;
            }
            #btn{
                width: 80px;
                margin:  5px 10px;
            }
		</style>
	</head>
	<body>
	<!-- 성공하면 index로 실패하면 joinProc -->
		<form action='./changing' method="post">
			<table>
				<tr>
					<th colspan="2"><h3>회원 정보</h3></th> 		
				</tr>
				<tr>
					<th>ID</th> 		
					<td>${info.uiden}
                    </td>
				</tr>
				<tr>
					<th>이름</th> 		
					<td>${info.uname}</td>
				</tr>
				<tr>
					<th>생일</th> 		
					<td>${info.uBirth}</td>
				</tr>
				<tr>
					<th>성별</th> 		
					<td>${info.ugender}</td>
				</tr>
				<tr>
					<th>E-mail</th> 		
					<td>${info.uemail}</td>
				</tr>
				<tr>
					<th>취향</th> 		
					<td>
					<c:forEach items="${infoG}" var="genre">
					${genre}
					</c:forEach>
					
					</td>
				</tr>
				<tr>
					<th colspan="2" align ="center">
						<button><b>수정하기</b></button>
					</th> 			
				</tr>
			</table>
		</form>
	</body>
	<script>
	</script>
</html>