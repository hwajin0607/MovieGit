<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
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
   /* .mypage{

        float: left;
        background-color: teal;
        width: 500px;
        height: 500px;
        margin: 10px;
        text-align: center;
       
    }*/
    #view{
        text-align: end;
        text-decoration: none;
    }
    /*#zzim{
        
        width: 450px;
        height: 60px;
        background-color: white;
        margin: 30px;
        float: left;
    }*/
    #play{
        position: absolute;
        text-align: end;
        left: 400px;
    }

    #cover{
        position: absolute;
        left: 0px;
    }
    #ex{
        position: absolute;
        text-align: left;
        left: 180;
    }
    /*.mypage img{
        width:100%;
        height:100%
    }*/
    #user{
    	position: absolute;
    	background-image:url("/photo/userinfo.jpg");
    	background-repeat: repeat;
    	top: 40%;
    	left: 60%;
        width: 500px;
        height: 500px;
        margin: 10px;
        text-align: center;
        border-radius: 15%;
    }
    #wishList{
        position: absolute;
		background-image:url("/photo/heart.jpg");
    	background-repeat: repeat;
    	top: 40%;
    	left: 10%;
        width: 500px;
        height: 500px;
        margin: 10px;
        text-align: center;
        border-radius: 15%;
    }
    h3{
    	position:absolute;
    	top:30%;
    	left:40%;
    	font-weight: 600;
    }
    #wishList:hover{
    	color:black;
    	font-size: xx-large;
    }
    #user:hover{
	   	color:black;
	   	font-size: xx-large;
    }
  	.mypage>a:visited{
  		color:black;
  	}

</style>
</head>
<body>
    <div class="mainbody">
        <img src="/photo/back.jpg" style="width: 100%; height: 100%; opacity: 0.5; position:relative;">
    	 <div class="header"><a href="like"><img id="logo" src="/photo/main.png"/></a>
        <div id="search"></div>
        <div id="allmenu"><a href="movieList">전체 메뉴</a></div>
        <div id="mypage"><a href="myPage.jsp">마이페이지</a></div>
        <div id="login"></div>
        <div id="logout"><a href="logout">로그아웃</a></div>
    </div>
        <div id="ent"><h1>&nbsp; profile Detail</h1></div>
        <br/>

        <div class="mypage">
	        <a href="./zzim" target="_parent">
	        	<div  id="wishList"><h3>WishList</h3></div>
	        </a>
	        <a href="./info" target="_parent">
	            <div  id="user"><h3>UserInfo</h3></div>
	        </a>
        </div>
    </div>
</body>
<script>

var loginId = "${sessionScope.loginId}";

if(loginId !=""){
	   $("#login").html(loginId+' 님♡');
	   if(msg!=""){
	      alert(msg);
	      msg="";
	       }
	    }

</script>
</html>