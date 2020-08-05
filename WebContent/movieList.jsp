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
        background-color: black;
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
  
    li.emList{
        float: left;
        border: 2px solid black;
        width: 200px;
        height: 200px;
        background-color: hotpink;
        margin: 5px;

    }
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

    .mo{
        position: absolute;
        top: 40%;
        left: 20%;
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
                <a href="#"><li>로멘스/코미디</li></a>
                <a href="#"><li>스릴러/공포</li></a>
                <a href="#"><li>SF/판타지</li></a>
                <a href="#"><li>드라마/다큐</li></a>
                <a href="#"><li>액션</li></a>
                <a href="#"><li>애니메이션</li></a>
            </ul>
        </div>
        </br></br></br>
        <!-- 검색창 -->
        <div class="searchbar">
            <span class='emsearch'>
                <input type='text' class='input_text' />
            </span>
            <button type='submit' class='sch_smit'>검색</button>
        </div>
        <!-- 정렬 -->
        <div class="sort">
            <a href="#">최신 개봉일 순</a>/<a href="#">오래된 순</a>
        </div>
        </br>
        <!-- 영화목록보여주기 -->
        <div class="mo">
        <ul class="movie">
            <a href="#"><li class="emList">movie</li></a>
            <a href="#"><li class="emList">movie</li></a>
            <a href="#"><li class="emList">movie</li></a>
            <a href="#"><li class="emList">movie</li></a>
        </ul>
        <a href="#" id="more">더보기</a>
        </div>
    </div>
</body>
<script>
    
        $("#more").click(function(){
            
            
            $(".movie").append("<a href='#'><li class='emList' id='next'>movie</li></a>");
            $(".movie").append("<a href='#'><li class='emList'>movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");
            $(".movie").append(" <a href='#'><li class='emList' id='next'>movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");
            $(".movie").append("<a href='#'><li class='emList'> movie </li></a>");

        });
</script>
</html>