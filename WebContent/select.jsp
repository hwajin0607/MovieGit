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
		<table>
		<tr>
            <td rowspan="5">
          		<a href="location.href='selectBhit'">조회순</a> / 
            	<a href="location.href='selectGrade'">평점순</a>
            </td>
            <td>1등</td>
            <td rowspan="5">
                <form method="GET">
                    <input type="text" name="select"/>
                    <button>검색</button>
				</form></td>
		</tr>
        <tr>
			<td>2등</td>
        </tr>
		<tr>
            <td>3등</td>
        </tr>
		<tr>
            <td>4등</td>
        </tr>
		<tr>
            <td>5등</td>
        </tr>
		</table>
	</body>
	<script>
		
	</script>
</html>