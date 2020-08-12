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
			table,th,td{
                border: 1px solid brown;
            }
		</style>
	</head>
	<body>  
	${list }
	${list[0].mName }
		<table>
		<tr>
            <td rowspan="5">
          		<a href="./selectBhit">조회순</a> / 
            	<a href="./selectGrade">평점순</a>
            </td>
            <td>${list[0].mName }</td>
            <td rowspan="5">
                <form method="GET">
                    <input type="text" name="select"/>
                    <button>검색</button>
				</form></td>
		</tr>
        <tr>
			<td>${list[1].mName }</td>
        </tr>
		<tr>
            <td>${list[2].mName }</td>
        </tr>
		<tr>
            <td>${list[3].mName }</td>
        </tr>
		<tr>
            <td>${list[4].mName }</td>
        </tr>
		</table>
	</body>
	<script>
		
	</script>
</html>