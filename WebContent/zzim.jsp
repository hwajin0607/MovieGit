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

            #WishList{
                position: absolute;
                top: 20%;
            }

            .mo{
                background-color: aquamarine;
                width: 300px;
                height: 500px;
                top: 50%;
                border: 5px solid white;
                list-style-type: none;
                margin:50px;
            }
            
            .molist{
            float:left;
            }

            .movie{
                position: absolute;
                top: 30%;
            }

            #add{
                top: 1000px;
            }
            
            

            #next{
                clear: left;
            }

            #close{
            	position:relative;
            	left:60%;
                cursor:pointer
            }

            #remove{
                position: absolute;
                top: 20%;
            }
            .AllDelMain{
                position: absolute;
                border-top: 10px;
            }
            .backimg{
                margin-left: 2%;
                margin-top: 5%;
                margin-right: 2%;
                position: relative;
                width: 1800px;
                height: 1000px;
                z-index: 0;
            }
            
            
			
		</style>
		
	</head>
	<body>
        <!--로고-->
            <img class="logo" src="/photo/logo.png"/>
        

        <div class="MainBody">
        <!--전체 삭제-->
        <div class="AllDelMain" style="left: 90%; margin-top: 8%; z-index: 10;">
            <a id="AllDel" href="./Alldel?uidx=${Alldel.uidx}" style="color: white;">전체 삭제</a>
        </div>

        <!--로그 아웃-->
        <form>
            <a id="Log-Out" style="position: absolute;">Log-Out</a>
        </form>

        <!--WishList 전체 영역-->
        <div class="WsMain">
            <div class="backimg">
                <img style="width: 100%; height: 100%; opacity: 0.5; z-index: 0; position: relative;" src="/photo/back.jpg" alt="">
            
                <div class="searchLogo">
                    <!--돋보기 로고-->
                    <img src="/photo/search.png" style="top: 10%;">

                    <!--WishList-->
                    <div id="WishList">
                        <div id="WsMainBar"></div>
                        <a>Wish List</a>
                    </div>
                </div>

                
                

            
                <!--영화 찜목록 리스트-->
                <div class="movie">
                    <ul class="Wishlist">
                        <c:forEach items="${list }" var="list">
                            <div class="molist">
                                <li class="mo">${list.mIdx}
                                <a href="./del?zidx=${list.zidx }"><img id="close" src="/photo/closeBar.png" /></a>
                                </li>
                            </div>
                        </c:forEach>
                        <div class="pageArea">
							<a href="./zzim?page=${currPage+1}" id="more">더보기</a>
						</div>
                    </ul>
                    
                    
                
                </div>

            </div>
        </div>

	</body>
	<script>
        
	</script>
</html>