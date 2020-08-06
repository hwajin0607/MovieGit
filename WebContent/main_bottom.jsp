<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="utf-8">
        <title>메인 하단</title>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <style>

            #a1{
                width: 500px;
                height: 300px;
                border: 2px solid black;
                background-color: burlywood;
                margin:100px;
                cursor: pointer;
            }

            #a2{
                width: 500px;
                height: 300px;
                border: 2px solid black;
                background-color: coral; 
                margin-left: 100px;
                cursor: pointer;
            }

            #random{
                width: 877px;
                height: 700px;
                border: 2px solid black;
                background-color: darkgray;
                position: absolute;
                left: 750px;
                top: 100px;
                cursor: pointer;
            }
        </style>	
    </head>
    <body>
        <div id="bg">

        </div>
      <div id="a1" onclick="move()">
        광고 1
      </div>
      <div id="a2" onclick="move2()">
        광고 2
      </div>
      <div id="random" onclick="location.href='random'">
        <c:forEach items="${list}" var="bbs">
        	${bbs.mIdx}<br>
        	${bbs.mName}<br>
        	${bbs.mfUrl}
        </c:forEach>
      </div>
	</body>
    <script>
        var a1 = document.getElementById('a1');
        function move() {
            window.location.href="#";
        };

        var a2 = document.getElementById('a2');
        function move2() {
            window.location.href="#";
        };
	</script>
</html>