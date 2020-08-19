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
			    .header{
        background-color: black;
        left:0;
        width: 100%;
        height: 111px;
        position: fixed;
        padding-top: 87px;
        display : inline-block;
        top:-5px;
        z-index: 10;
	}
    #logo{
        width: 185px;
        height: 158px;
        position: absolute;
        top: 5px;
        left: 869px;
        z-index: 9;
    }
    #allmenu{
        width: 100px;
        height: 30px;
        z-index: 9;
        position: absolute;
        top: 150px;
        left: 657px;
        font-size: 20px;
    }
    #mypage{
        width: 303px;
        height: 30px;
        z-index: 9;
        position: absolute;
        top: 150px;
        left: 1200px;
        font-size: 20px;
    }

    a{
        text-decoration: none;
        color: white;
        font-weight: 600;
    }
    a:link a:visited a:active a:hover{
        text-decoration: none;
        color: white;
    }
    #logout{
        width: 75px;
        height: 36px;
        position: absolute;
        top: 26px;
        left: 95%;
    }
    #login{
       width: 90px;
       height: 36px;
       position: absolute;
       top: 26px;
       left: 1686px;
       color: white;
       text-align: right;
    }
    
	body{

		background-color:black;
		height:100%;
	}
	 #ent{
    	position:absolute;
    	background-color:gray;
    	background-color: rgba(128, 128, 128, 0.5);
    	width:100%;
    	color:white;
    	top:20%;
    	left:0;
        font-weight: 600;
    }
	table{
		position: absolute;
		top: 37%;
		left: 33%;
		width: 700px;
		height: 500px;
	}
	table, tr, th, td{
		
		border: 1px solid white;
		border-collapse: collapse;
		color: white;
	}
	table, tr, th{
		padding: 5px 10px;
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
	<div class="mainbody">
    <div id="background">
        <img src="/photo/main9.jpg" style="width:100%; height:77%; position:relative; opacity:0.5;"/>
    	</div>
       
    	 <div class="header"><a href="like"><img id="logo" src="/photo/logo3.png"/></a>
        <div id="search"></div>
		<div id="allmenu"><a href="page">MENU</a></div>
        <div id="mypage"><a href="myPage.jsp">MY PAGE</a></div>
        <div id="login"></div>
        <div id="logout"><a href="logout">logout</a></div>
    </div>
        <div id="ent"><h1>&nbsp; User Info</h1></div>
        <br/>
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
		</div>
	</body>
	<script>
	
	var loginId = "${sessionScope.loginId}";



		 if(loginId !=""){
		$("#login").html(loginId+' 님♡');

			 
		 }
	</script>
</html>