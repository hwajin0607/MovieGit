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

    body{
        background-color: gray;
      
    }

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
        position: absolute;
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
        left: 20%; */
    }
    table,th,td{
    	
    	border-collapse : collapse;

    }
    td{
    	background-color : hotpink;
    	width: 250px;
        height: 250px;
        
    }
    
    table{
     border-spacing: 30px;
     }
    
    .mList{
    	position: absolute;
    

    	top: 40%;
        left: 20%;
        
    }
        img{
        max-width: 60px;
        max-height: 60px;
    }
    #zzim{
    	position : absolute;
    	top: 30%;
    	left: 80%;
    }
 	.pageArea{
		margin: 10px;
	}

  
</style>
</head>
<body>
    <div class="mainbody">
    <!-- 배경이미지 -->
        <!-- <img src="bgimg.jpg" style="width: 100%; height: 100%; opacity: 0.5; z-index: 0; position: relative;" alt=""> -->
    
        <div id="ent">Entire film</div>
        <!-- 전체영화 메뉴 바 -->
        <div class="moviebar">
            <ul class="genre">
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
        <div class="searchbar">
            <span class='emsearch'>
                <input type='text' class='sch_text' />
            </span>
            <!-- <button type='submit' class='sch'>검색</button> -->
             <a href="./search" id="sch" target="_parent">검색</a>
        </div>
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
				<td><a href="./movieDetail?mIdx=${mlist.mIdx }">${mlist.mIdx }</a></td>
			</c:forEach>
			</tr>
		
		</table>
		<div class="pageArea">
			<a href="./movieList?=${currPage+1}" id="more">더보기</a>
		</div>
		</div>
        
        <%-- <div class="mList">
        <c:set var="i" value="0" /> 
        <c:set var="j" value="4" /> 
        <table > 
        <c:forEach items="${movieList }" var="mlist"> 
        <c:if test="${i%j == 0 }"><tr> </c:if> 
        <td ><a href="./movieDetail?mIdx=${mlist.mIdx }">${mlist.mIdx }</a></td>
        <c:if test="${i%j == j-1 }"> </tr> </c:if> 
        <c:set var="i" value="${i+1 }" /> 
        </c:forEach> 
        </table>
        <a href="#" id="more">더보기</a>
        </div>  --%>
        

<!-- 영화리스트 vsc -->
        <%-- <div class="mo">
        <ul class="movie">
        <c:forEach items="${movieList }" var="mlist">
            <a href="#"><li class="emList">${mlist.mName }</li></a>
        </c:forEach>
        </ul>
        <a href="#" id="more">더보기</a>
        </div> --%>
        
    </div>
</body>
<script>

    
/*         $("#more").click(function(){
            
            
            $(".movie").append("<a href='#'><li class='emList' id='next'>movie</li></a>");
            $(".movie").append("<a href='#'><li class='emList'>movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");
            $(".movie").append(" <a href='#'><li class='emList' id='next'>movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>"); 

        });*/
        
</script>
</html>