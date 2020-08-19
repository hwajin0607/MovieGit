<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movieList</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
	    .header{
        background-color: black;
        width: 100%;
        height: 111px;
        position: fixed;
        padding-top: 87px;
        display : inline-block;
        top:-5px;
        left:0;
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
		background-color: black;
		height:100%;
	}

    a>li{
        float:left;
        padding: 0px 20px;
        font-weight: 600;
        width: 120px;
        text-align: center;
        color: white;
        margin:25px;
        
    }
    ul{
        min-width: 900px;
        list-style-type: none;
       
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
  /* 영화리스트 vsc */
 /*    li.emList{
        float: left;
        border: 2px solid black;
        width: 200px;
        height: 200px;
        background-color: hotpink;
        margin: 10px;

    } */
    #next{
        clear: left;
    }
    .sort{
        position: absolute;
        text-align: right;
        top: 40%;
        left: 90%;
        color: white;
    }

    .sort>a{
        color: white;
    }
    #more{
        
        clear: left;
        display: block;
        left: 500px;
        text-decoration: none;
        width: 50px;
        color: white;
    }
    .post{
        display: inline;
    }
    .moviebar{
        position: absolute;
        top: 30%;
        left: 9%;
    }

    .searchbar{
        position: absolute;
        top: 40%;
        left: 5%;
    }

    table,th,td{
    	
    	border-collapse : collapse;

    }
    td{
    	background-color : black;
    	width: 250px;
        height: 250px;
        float:left;
        margin:30px;
        
    }
    
    table{
     border-spacing: 30px;
     }
    
    .mList{
    	position: absolute;
    

    	top: 50%;
        left: 20%;
        
    }
       /* img{
        max-width: 60px;
        max-height: 60px;
    }*/
    #zzim{
    	position : absolute;
    	top: 30%;
    	left: 80%;
    }
 	.pageArea{
		margin: 10px;
	}
	#next{
		clear:left;
	}
	.mainImg>img{
		position: relative;
		width: 100%;
		height: 100%;
		opacity: 0.5; 
	}
	a#more{
		position: absolute;
		text-align: center;
		
	}
	.sch_text{
		border:0;
		outline:0;
		width:300px;
		height:30px;
		background-color: black;
		background-color: rgb(0, 0, 0, 0.5);
		
	}
	img{
		max-width: 100%;
		max-height: 100%;
	}

  
</style>
</head>
<body>
    <div class="mainbody">
    <!-- 배경이미지 -->
    	<div class="mainImg">
        	<img src="/photo/main9.jpg"  />
    <div class="header"><a href="like"><img id="logo" src="/photo/main.png"/></a>

        <div id="allmenu"><a href="page">MENU</a></div>
        <div id="mypage"><a href="myPage.jsp">MY PAGE</a></div>
        <div id="login"></div>
        <div id="logout"><a href="logout">logout</a></div>
    </div>
        <div id="ent"><h1>&nbsp;Entire film</h1></div>
        <!-- 전체영화 메뉴 바 -->
        <div class="moviebar">
            <ul class="genre">
           		<a href="./page"><li>ALL</li></a>
                <a href="./movieListG?mGenre=로맨스/코미디"><li id="g">로멘스/코미디</li></a>
                <a href="./movieListG?mGenre=스릴러/공포"><li class="g">스릴러/공포</li></a>
                <a href="./movieListG?mGenre=SF/판타지"><li class="g">SF/판타지</li></a>
                <a href="./movieListG?mGenre=드라마/다큐"><li class="g">드라마/다큐</li></a>
                <a href="./movieListG?mGenre=액션"><li class="g">액션</li></a>
                <a href="./movieListG?mGenre=애니메이션"><li class="g">애니메이션</li></a>
            </ul>
        </div>
        </br></br></br>
        <!-- 검색창 -->
        <form class="searchbar" action="./searchResult">
            <span class='emsearch'>
                <input type='text' placeholder='Search' class='sch_text' name="searchTxt"/>
            </span>
            <button type='submit' class='sch'>√</button>
            <!-- <button type='submit' class='sch'>검색</button>
             <a href="./searchResult" id="sch" target="_parent">검색</a> -->
        </form>
        <!-- 정렬 -->
        <div class="sort">
            <a href="./movieListS?mSort=내림차" ><p id="d">최신 개봉일 순</p></a>/<a href="./movieListS?mSort=오름차"><div id="a">오래된 순</div></a>
        </div>
        </br>
        <!-- 영화목록보여주기 -->
        <div class="mList">
	        <table>
	        	<tr>
	        	<c:forEach items="${movieList }" var="mlist"> 
					<td><a href="./movieDetail?mIdx=${mlist.mIdx }"><img src="/photo/${mlist.mfNew}"/></a></td>
				</c:forEach>
				</tr>
			
			</table>
		<!-- 더보기 -->
		<div class="pageArea">
			<a href="./movieList?page=${currPage +1}" id="more">
			<img src="/photo/more.png" style="width: 30px; height: 30px; ">
			</a>
		</div>
		</div>
        

    </div>
</body>
<script>
var loginId = "${sessionScope.loginId}";

if(loginId !=""){
	   $("#login").html(loginId+' 님♡');
	  /*  if(msg!=""){
	      alert(msg);
	      msg="";
	       } */
	    }
/* $("#d").click(function(){
	$("#d").css({'font-weight':'800'});
	console.log("값확인");
});  */
</script>
</html>