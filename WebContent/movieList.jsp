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


    a>li{
        float:left;
        padding: 0px 20px;
        font-weight: 600;
        width: 120px;
        text-align: center;
        color: white;
        
    }
    ul{
        min-width: 900px;
        list-style-type: none;
       
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
        top: 30%;
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
        top: 20%;
    }

    .searchbar{
        position: absolute;
        top: 35%;
    }
/* 영화리스트 vsc */
/*     .mo{
        position: absolute;
        top: 40%;
        left: 20%; 
    }*/
    table,th,td{
    	
    	border-collapse : collapse;

    }
    td{
    	background-color : hotpink;
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
    

    	top: 40%;
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

  
</style>
</head>
<body>
    <div class="mainbody">
    <!-- 배경이미지 -->
    	<div class="mainImg">
        	<img src="/photo/back.jpg"  />
    	</div>
        <div id="ent"><h1>&nbsp;Entire film</h1></div>
        <!-- 전체영화 메뉴 바 -->
        <div class="moviebar">
            <ul class="genre">
           		<a href="./page"><li>전체</li></a>
                <a href="./movieListG?mGenre=로맨스/코미디"><li>로멘스/코미디</li></a>
                <a href="./movieListG?mGenre=스릴러/공포"><li>스릴러/공포</li></a>
                <a href="./movieListG?mGenre=SF/판타지"><li>SF/판타지</li></a>
                <a href="./movieListG?mGenre=드라마/다큐"><li>드라마/다큐</li></a>
                <a href="./movieListG?mGenre=액션"><li>액션</li></a>
                <a href="./movieListG?mGenre=애니메이션"><li>애니메이션</li></a>
            </ul>
        </div>
        </br></br></br>
        <!-- 검색창 -->
        <form class="searchbar" action="./searchResult">
            <span class='emsearch'>
                <input type='text' class='sch_text' name="searchTxt"/>
            </span>
            <button type='submit' class='sch'>검색</button>
            <!-- <button type='submit' class='sch'>검색</button>
             <a href="./searchResult" id="sch" target="_parent">검색</a> -->
        </form>
        <!-- 정렬 -->
        <div class="sort">
            <a href="./movieListS?mSort=내림차">최신 개봉일 순</a>/<a href="./movieListS?mSort=오름차">오래된 순</a>
        </div>
        </br>
        <!-- 영화목록보여주기 -->
        <div class="mList">
        <table>
        	<tr>
        	<c:forEach items="${movieList }" var="mlist"> 
				<td><a href="./movieDetail?mIdx=${mlist.mIdx }">${mlist.mIdx}</a></td>
			</c:forEach>
			</tr>
		
		</table>
		<div class="pageArea">
			<a href="./movieList?page=${currPage +1}" id="more">
			<img src="/photo/more.png" style="width: 30px; height: 30px; ">
			</a>
		</div>
		</div>
        

    </div>
</body>
<script>


    
</script>
</html>