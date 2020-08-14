<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	html,body{
		background-color:black;
		height:100%;
	}
    .header{
        background-color: black;
        width: 100%;
        height: 111px;
        position: fixed;
        padding-top: 87px;
        display : inline-block;
        top:-20px;
        left:0px;
        z-index: 10;
    }
    #search{
        width: 59px;
        height: 52px;
        z-index: 9;
        position: relative;
        top: 48px;
        left: 367px;
        z-index: 9;
        cursor: pointer;
    }
    #search2{
        width: 62px;
        height: 57px;
        z-index: 9;
        position: absolute;

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
    .panel{
        width: 92%;
        height: 420px;
        background-color: gray;
        position: absolute;
        top: 129px;
        left: 77px;
        z-index: 10;
        display: none;
    }
    #alllist{
        position: relative;
        top: 315px;
        left: 85px;
        transition: 1s;
        width: 1698px;
        height: 380px;
        transform-style: preserve-3d;
        padding: 0px;
    }
    .recommend{
        position: relative;
        width: 95%;
        height: 730px;
        top: -2154px;
        left: 48px;
        background-color: rgb(0, 0, 0, 0.8);
        z-index: 9;
    }

    #recommendmovie{
        width: 100%;
        height: 50px;
        background-color: gray;
        position: absolute;
        top: 110px;
        left: 0%;
        border-radius: 15px;
        text-align: center;
        font-size: 24px; font-weight: 600;
        color: white;
        line-height: 50px;
    }
    .sidebar{
        width: 98px;
        height: 149px;
        top: 265px;
        left: 1774px;
        position: absolute;
        cursor: pointer;
        background-color: tan;
        z-index: 10;
        position: fixed;
    }
    .list{
        backface-visibility: hidden;
        float: left;
        margin: 0px 19px 0px 73px;
        width: 300px;
    	height: 380px;
        background-color: gray;
        list-style-type: none;
        position: relative;
    }
    .front{
        position: absolute;
        width: 100%;
        height: 380px;
        backface-visibility: hidden;
    }
    .back{
        position: absolute;
        width: 100%;
        height: 380px;
        backface-visibility: hidden;
        transform: rotateX(180deg);
    }
       #mainbottom{
	    position: absolute;
	    background-color: rgb(0, 0, 0, 0.8);
	    top: 946px;
	    left: 48px;
	    width: 95%;
	    height: 100%;
	    z-index: 9;
          }
    #main{
       width: 100%;
       height: 100%;
       border: 0;
       top: 8px;
       left: 13px;
       position: absolute;
       
    }
        #down{
       width: 100%;
       height: 100%;
       border: 0;
       top: 102px;
       left: 13px;
       position: absolute;
       
    }
    #footer{
	position: absolute;
    background-color: rgb(0, 0, 0, 0.8);
    top: 1667px;
    left: 8px;
    width: 100%;
    height: 50%;
    z-index: 9;
    }

</style>
</head>
<body>
	<div id="mainbottom">
	
		<iframe id ="main" src="main_bottom.jsp" scrolling=no></iframe>
	
	</div>

    <div class="header"><a href="like"><img id="logo" src="/photo/logo.png"/></a>
        <div id="search"><img id="search2" src="/photo/search.png"/></div>
        <div id="allmenu"><a href="movieList">전체 메뉴</a></div>
        <div id="mypage"><a href="myPage.jsp">마이페이지</a></div>
        <div id="login"></div>
        <div id="logout"><a href="logout">로그아웃</a></div>
    </div>
    
    
    <div class="panel"><a href="">검색창</a></div>
    
    		<div id="background">
        <img src="/photo/main.jpg" style="width:100%; height:77%; position:relative;"/>
    	</div>

    <div class="recommend">

        <div id="recommendmovie" >Recommend Movie</div>

        <div id="alllist">
            <div class="front">
         		<c:forEach items="${list }" var="likelist"  begin="0" end="3" step="1">
            		<a href="./movieDetail?mIdx=${likelist.mIdx}"><li class="list">${likelist.mfIdx}</li></a>
           		</c:forEach>
            </div>
            <div class="back">
           		<c:forEach items="${list }" var="likelist"  begin="4" end="7" step="1">
            		<a href="./movieDetail?mIdx=${likelist.mIdx}"><li class="list">${likelist.mfIdx}</li></a>
           		</c:forEach>
            </div>

    </div>
    <div class="sidebar">
        <div id="sid1"><a href="">찜목록</a></div>
    </div>
</body>
<footer>
<div id="footer">
	
		<iframe id="down" src="footer.jsp" scrolling=no></iframe>
	
	</div>
</footer>
<script>

 var uIdx = "${sessionScope.uIdx}";
var loginId = "${sessionScope.loginId}";
var loginPw = "${sessionScope.loginPw}";


/*   if(loginPw=="" || loginId==""){
	alert("로그인이 필요한 서비스입니다.");
	location.href="login.jsp";

  }else(loginPw !="" || loginId !=""){ */
	 if(loginId !=""){
	$("#login").html(loginId+' 님♡');

		 
	 }


 

$(document).ready(function() {

        $("#search").click(function(){
            $(".panel").css({"display":"block"});
        });
	    var arr = ['rotateX(180deg)','rotateX(0deg)','rotateX(180deg)','rotateX(0deg)'];
        var i=0;
        setInterval(function(){
            $("#alllist").css({transform:arr[i]});
                i++;
                if(i>=arr.length){
                        i=0;
                    }
        },3000);  


    });
	function DoSend() {
		location.href="./randomDetail";
	}
		var uIdx = "${sessionScope.uIdx}";
		var loginId = "${sessionScope.loginId}";
		var loginPw = "${sessionScope.loginPw}";
		var msg = "${msg}";
		
		/*   if(loginPw=="" || loginId==""){
			alert("로그인이 필요한 서비스입니다.");
			location.href="login.jsp";
		
		  }else(loginPw !="" || loginId !=""){ */
			 if(loginId !=""){
			$("#login").html(loginId+' 님♡');
/* 			if(msg!=""){
				alert(msg);
				msg="";
				 } */
			 }
				
		$(document).ready(function() {
		
		    $("#search").click(function(){
		        $(".panel").css({"display":"block"});
		    });
		
		    });



</script>

</html>