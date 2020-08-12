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
	${list[0].mfUrl }
	${list[0].mName }<br/>
	${list[0]}
		<table>
		<tr>
            <td rowspan="5">
          		<a href="./selectBhit"><b>조회순</b></a> / 
            	<a href="./selectGrade">평점순</a>
            	<p class="re">${list[0].mfUrl }</p>
            	<!-- <img src = "#"> -->
            </td>
            <td><a href="#" class="movie1">${list[0].mName }</a><!--<a href="#" class="movie6">${list[5].mName }</a>--></td>
            <td rowspan="5">
                <form action="./search" method="GET">
                    <input type="text" name="mGenre"/>
                    <button>검색</button>
				</form></td>
		</tr>
        <tr>
			<td><a href="#" class="movie2">${list[1].mName }</a><!--<a href="#" class="movie7">${list[6].mName }</a>--></td>
        </tr>
		<tr>
            <td><a href="#" class="movie3">${list[2].mName }</a><!--<a href="#" class="movie8">${list[7].mName }</a>--></td>
        </tr>
		<tr>
            <td><a href="#" class="movie4">${list[3].mName }</a><!--<a href="#" class="movie9">${list[8].mName }</a>--></td>
        </tr>
		<tr>
            <td><a href="#" class="movie5">${list[4].mName }</a><!--<a href="#" class="movie10">${list[9].mName }</a>--></td>
        </tr>
		</table>
	</body>
	<script>
		$(".movie1").mouseenter(function(){
			$(".re").html("${list[0].mfUrl }");
		});
		$(".movie2").mouseenter(function(){
			$(".re").html("123");
		});
	</script>
</html>