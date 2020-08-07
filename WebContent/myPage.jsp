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
    #ent{
        font-weight: 600;
    }
    .mypage{
        
        float: left;
        background-color: teal;
        width: 500px;
        height: 500px;
        margin: 10px;
        text-align: center;
       
    }
    #view{
        text-align: end;
        text-decoration: none;
    }
    #zzim{
        position: relative;
        width: 450px;
        height: 60px;
        background-color: white;
        margin: 30px;
        float: left;
    }
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
    img{
        max-width: 60px;
        max-height: 60px;
    }
  
</style>
</head>
<body>
    <div class="mainbody">
        <!-- <img src="bgimg.jpg" style="width: 100%; height: 100%; opacity: 0.5; z-index: 0; position: relative;" alt=""> -->
    
        <div id="ent">Mypage</div>
        <br/>

        <div class="mypage">
            <h3>WishList</h3>
            <hr/>
            <a href="./zzim" id="view" target="_parent"><p>더보기</p></a>
            
                <div id="zzim">
                    <div><img src="#" id="cover"></div>
                    <div id="ex">
                    강철비2<br/>
                    감독 : 양우석<br/>
                    장르 : 드라마, 액션
                    </div>
                    <div id="play"><a href="#detail"><img src="재생.jpg"></a></div>
                </div>
            <hr/>
                <div id="zzim">
                    <div><img src="#" id="cover"></div>
                    <div id="ex">
                    반도<br/>
                    감독 : 연상호<br/>
                    장르 : 드라마, 액션
                    </div>
                    <div id="play"><a href="#detail"><img src="재생.jpg"></a></div>
                </div>

        </div>
        <a href="./info" target="_parent">
            <div class="mypage"><h3>User Info</h3></div>
        </a>
    </div>
</body>
<script>


</script>
</html>