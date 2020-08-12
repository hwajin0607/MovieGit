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
	body{

		background-color:black;
	}
    #ent{
    	position:absolute;
    	background-color:black;
    	opacity: 0.5;
    	width:100%;
    	color:white;
    	top:11%;
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
  	a:visited{
  		color:black;
  	}

</style>
</head>
<body>
    <div class="mainbody">
        <img src="/photo/back.jpg" style="width: 100%; height: 100%; opacity: 0.5; position:relative;">
    
        <div id="ent"><h1>&nbsp; profile Detail</h1></div>
        <br/>

        <div class="mypage">
	        <a href="./zzim" target="_parent">
	        	<div  id="wishList"><h3>WishList</h3></div>
	        </a>
	        <a href="./info" target="_parent">
	            <div  id="user"><h3>userInfo</h3></div>
	        </a>
        </div>
    </div>
</body>
<script>


</script>
</html>