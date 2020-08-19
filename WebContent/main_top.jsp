<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPACE Dugi</title>
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
        top:-5px;
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
        width: 110px;
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
       width: 120px;
       height: 36px;
       position: absolute;
       top: 26px;
       left: 1670px;
       color: white;
       text-align: right;
    }
    .panel{
        width: 92%;
        height: 420px;
        position: absolute;
        top: 129px;
        left: 77px;
        z-index: 10;
        display: none;
        border: 0px solid;
    }
    #alllist{
        position: relative;
        top: 315px;
        left: 85px;
        transition: 1.5s;
        width: 1698px;
        height: 380px;
        transform-style: preserve-3d;
        padding: 0px;
    }
    .recommend{
        position: relative;
        width: 95%;
        height: 730px;
 		top: -2074px;
        left: 48px;
        z-index: 9;
    }

    #recommendmovie{
        width: 100%;
        height: 50px;
        background-color: rgb(128, 128, 128, 0.4);
        position: absolute;
        top: 110px;
        left: 0%;
        
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
        z-index: 10;
        position: fixed;
        color:white;
        border:2px solid white;
        background-color:gray;
        text-align:center;
    }
    #sid1, #chu{
           width: 98px;
          height: 74px;
          line-height: 76px;
    }
        #sid1{
    	    border-bottom:1px solid white;
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
    .re{
    	 position: absolute;
    	 width:100%;
    	 height:100%;
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

    top: 1800px;
    left: 8px;
    width: 100%;
    height: 50%;
    z-index: 9;
    }
    
    #select{
	    position: absolute;
	    width: 90%;
	    height: 100%;
	    top: 0px;
   		left: 100px;
   		border: 0px solid;
    }

</style>
</head>
<body>
   <div id="mainbottom">
   
      <iframe id ="main" src="main_bottom.jsp" scrolling=no></iframe>
   
   </div>

    <div class="header"><a href="like"><img id="logo" src="/photo/logo3.png"/></a>
        <div id="search"><img id="search2" src="/photo/search.png"/></div>
        <div id="allmenu"><a href="page">MENU</a></div>
        <div id="mypage"><a href="myPage.jsp">MY PAGE</a></div>
        <div id="login"></div>
        <div id="logout"><a href="logout">logout</a></div>
    </div>
    
    
    <div class="panel"><iframe  id = "select" src="./selectBhit"></iframe></div>
    
          <div id="background">
        <img src="/photo/main9.jpg" style="width:100%; height:77%; position:relative; opacity:0.5;"/>
       </div>

    <div class="recommend">

        <div id="recommendmovie" >Recommend Movie</div>

        <div id="alllist">
            <div class="front">
         		<c:forEach items="${list }" var="likelist"  begin="0" end="3" step="1">
            		<a href="./movieDetail?mIdx=${likelist.mIdx}"><li class="list"><img class="re" src="/photo/${likelist.mfNew}"></li></a>
           		</c:forEach>
            </div>
            <div class="back">
           		<c:forEach items="${list }" var="likelist"  begin="4" end="7" step="1">
            		<a href="./movieDetail?mIdx=${likelist.mIdx}"><li class="list"><img class="re" src="/photo/${likelist.mfNew}"></li></a>
           		</c:forEach>
            </div>

    </div>
    <div class="sidebar">
       <a href="./zzim"><div id="sid1">찜목록</div></a>
       <div id="chu">추천</div>
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
      
   var top = document.querySelector('#main').scrollTop;
   console.log(top);
    });

	function DoSend() {
		location.href="./randomDetail";
	}

		$(document).ready(function() {
		
		    $("#search").click(function(){
		        $(".panel").css({"display":"block"});
		    });
		    
			$("#chu").click(function(e){
				$('html, body').scrollTop(850);
			});
		
		    });

</script>

</html>