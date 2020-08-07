<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style>
            body{
                background-color: black;
                position: relative;
                z-index: 9;
            }
            .logo{
                position: absolute;
                width: 200px;
                height: 200px;
                z-index: 10;
                left: 45%;
            }

            #Log-Out{
                color: white;

            }

            /*.SrMain{
                background-image:url(backimg.jpg);
                background-size: cover;
                position: relative;
                z-index: 5;
                width: 2000px;
                height: 1000px;
            }*/
            .searchLogo>img{
                position: absolute;
                width: 70px;
                height: 70px;

            }

            #WishList{
                position: absolute;
                top: 200px;
                width: 100%;
                height: 200px;
            }

            #WsMainBar{
                color: white;
                position: absolute;
                background-color: gray;
                width: 100%;
                height: 50px;
                border-radius: 10px;
                opacity: 0.5;
            }
            #WishList>a{
                position: absolute;
                color: white;
                font-size: 40px;
            }

            .mo{
                float: left;
                background-color: aquamarine;
                width: 300px;
                height: 500px;
                top: 50%;
                border: 5px solid red;
            }

            .movie{
                position: absolute;
                margin-top: 30%;
            }

            #add{
                top: 1000px;
                left: 45%;
            }
            
            

            #next{
                clear: left;
            }

            #close{
                margin-left: 200px;
            }

            #remove{
                position: absolute;
                top: 20%;
            }
			
		</style>
		
	</head>
	<body>
        <!--로고-->
		<div>
            <img class="logo" src="logo.png"/>
        </div>

        <div class="MainBody">
        <!--<img src="back.jpg" style="width: 100%; height: 100%; opacity: 0.5; z-index: 0; position: relative;">-->
        <!--전체 삭제-->
        <button id="remove">전체 삭제</button>

        <!--로그 아웃-->
        <form>
            <a id="Log-Out" onclick="">Log-Out</a>
        </form>

        <!--WishList 전체 영역-->
        <div class="WsMain">
            <div class="searchLogo">

                <!--돋보기 로고-->
                <img src="search.png">

                <!--WishList-->
                <div id="WishList">
                    <div id="WsMainBar"></div>
                    <a>Wish List</a>
                </div>
            </div>

        
            
            <!--영화 찜목록 리스트-->
            <div class="movie">
                <ul class="Wishlist">
                    <li class="mo">movie ${list}<img id="close" src="closeBar.png"/></li>
                    
                    <li class="mo">movie${list}<img id="close" src="closeBar.png"/></li>
                    
                    <li class="mo">movie${list}<img id="close" src="closeBar.png"/></li>
                    
                    <li class="mo">movie${list}<img id="close" src="closeBar.png"/></li>
                </ul>

                <button id="add">더보기</button>
                
            </div>
        </div>
        </div>

	</body>
	<script>
        $("#add").click(function(){
            $(".Wishlist").append("<li class='mo' id='next'>movie<img id='close' src='closeBar.png'/></li>")
            $(".Wishlist").append("<li class='mo'>movie<img id='close' src='closeBar.png'/></li>")
            $(".Wishlist").append("<li class='mo'>movie<img id='close' src='closeBar.png'/></li>")
            $(".Wishlist").append("<li class='mo'>movie<img id='close' src='closeBar.png'/></li>")
            $(".Wishlist").append("<li class='mo' id='next'>movie<img id='close' src='closeBar.png'/></li>")
            $(".Wishlist").append("<li class='mo'>movie<img id='close' src='closeBar.png'/></li>")
            $(".Wishlist").append("<li class='mo'>movie<img id='close' src='closeBar.png'/></li>")
            $(".Wishlist").append("<li class='mo'>movie<img id='close' src='closeBar.png'/></li>")
        });
	</script>
</html>