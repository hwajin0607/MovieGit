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
		
			.movieName,  #search{
				base target="_parent";
			}
            body{
            	background-color: white;
            }
            th,td, table{
            	border: 1px solid;
            }
            th{
            	height: 350px;
            	width: 300px;
            }
            td{
				height: 70px;
				width: 200px;
            }
           
            #search{
            	width: 1000px;
            }
            #moviefoster{
            	width : 250px
            }
            #foster{
            	position: relative;
            	width: 80%;
            }
		</style>
	</head>
	<body>  
		<table>
		<tr>
            <td id = "moviefoster" rowspan="5" align="center" style="vertical-align: top;">
          		<a href="./selectBhit"><b>조회순</b></a> / 
            	<a href="./selectGrade">평점순</a><br/><br/><br/>
            	<!-- <p class="re">${list[0].mfUrl }</p> -->
            	<img id = "foster" src = "/photo/${list[0].mfNew }" >
            </td>
            <td class = "movieName" ><a href="javascript:link1();" class="movie1">${list[0].mName }</a><!--<a href="javascript:link6();"  class="movie6">${list[5].mName }</a>--></td>
            <th id = "search" rowspan="5">
                <form action="javascript:search()">
                    <input type="text" name="searchTxt"/>
                    <button>검색</button>
				</form>
			</th>
		</tr>
        <tr>
        <td class = "movieName" >
			<a href="javascript:link2();" class="movie2">${list[1].mName }</a><!--<a href="javascript:link7();" " class="movie7">${list[6].mName }</a>--></td>
        </tr>
		<tr>
            <td class = "movieName" ><a href="javascript:link3();"  class="movie3">${list[2].mName }</a><!--<a href="javascript:link8();"  class="movie8">${list[7].mName }</a>--></td>
        </tr>
		<tr>
            <td class = "movieName" ><a href="javascript:link4();"  class="movie4">${list[3].mName }</a><!--<a href="javascript:link9();"  class="movie9">${list[8].mName }</a>--></td>
        </tr>
		<tr>
            <td class = "movieName" ><a href="javascript:link5();" class="movie5">${list[4].mName }</a><!--<a href="javascript:link10();" class="movie10">${list[9].mName }</a>--></td>
        </tr>
		</table>
	</body>
	<script>
		$(".movie1").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[0].mfNew }"});
		});
		$(".movie2").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[1].mfNew }"});
		});
/* 		$(".movie3").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[2].mfNew }"});
		});
		$(".movie4").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[3].mfNew }"});
		});
		$(".movie5").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[4].mfNew }"});
		});
		$(".movie6").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[5].mfNew }"});
		});
		$(".movie7").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[6].mfNew }"});
		});
		$(".movie8").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[7].mfNew }"});
		});
		$(".movie9").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[8].mfNew }"});
		});
		$(".movie10").mouseenter(function(){
			$("#foster").attr({"src" : "/photo/${list[9].mfNew }"});
		}); */

		function link1() {
			var z = ${list[0].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
		function link2() {
			var z = ${list[1].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
/* 		function link3() {
			var z = ${list[2].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
		function link4() {
			var z = ${list[3].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
		function link5() {
			var z = ${list[4].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
		function link6() {
			var z = ${list[5].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
		function link7() {
			var z = ${list[6].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
		function link8() {
			var z = ${list[7].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
		function link9() {
			var z = ${list[8].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		}
		function link10() {
			var z = ${list[9].mIdx };
			window.parent.location.href='./movieDetail?mIdx='+z;
		} */
		
		function search() {
			var str = $("input[name = 'searchTxt']").val()
			console.log(str);
			window.parent.location.href='./searchResult?searchTxt='+str;
			location.href="./selectBhit";
		}

	</script>
</html>