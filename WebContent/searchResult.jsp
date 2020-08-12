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
                position: relative;
                color: white;
                left: 90%;
                cursor: pointer;
                font-size: 15px;

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

            #SearchResult{
                position: absolute;
                top: 10%;
                width: 100%;
                height: 200px;
            }

            #SrMainBar{
                color: white;
                position: absolute;
                background-color: gray;
                width: 100%;
                height: 50px;
                border-radius: 10px;
                opacity: 0.5;
            }
            #SearchResult>a{
                position: absolute;
                color: white;
                font-size: 40px;
            }

            .searchBar{
                position: absolute;
                top: 20%;
            }

            .mo{
                float: left;
                background-color: white;
                width: 300px;
                height: 500px;
                border: 5px solid red;
                margin:1%;
            }

            .movie{
                position: absolute;
                z-index: 10;
                margin-left: 15%;
                top: 30%;
            }

            #next{
                clear: left;
            }
			
         
            .backimg{
                /* background-image: url(back.jpg); */
                margin-left: 2%;
                margin-top: 9%;
                margin-right: 2%;
                position: relative;
                width: 1800px;
                height: 1000px;
                z-index: 0;
            }

            #searchTxt{
                width: 400%;
                font-size: 18px;
                border-radius: 10px;
            }
            #serbar{
                position: absolute;
                left: 405%;
                top: 3%;
                height: 100%;
                border-radius: 10px;
            }
            
		</style>
		
	</head>
	<body>
        <!--로고-->
        <img class="logo" src="/photo/logo.png"/>
        

        <!--로그 아웃-->
        <form>
            <a id="Log-Out" onclick="">Log-Out</a>
        </form>

        <!--SearchResult 전체 영역-->
        <div class="SrMain">
            <div class="backimg">
                <img style="width: 100%; height: 100%; opacity: 0.5; z-index: 0; position: relative;" src="/photo/back.jpg" alt="">
                
                <!--돋보기 로고-->
                <div class="searchLogo">
                    <img style="top: 2%; cursor: pointer;" src="/photo/search.png">

                    <!--Search Result-->
                    <div id="SearchResult">
                        <div id="SrMainBar"></div>
                        <a>Search Result</a>
                    </div>
                </div>

                <!--검색 바-->
                
                <form action="./searchResult">
                    <div class="SearchZone">
                        <div class="searchBar">
                            <input id="searchTxt" type="text" name="searchTxt" placeholder="Search..."/>
                            <button id="serbar">검색</button>
                        </div>
                    </div>
                </form>
                
                <!--영화 검색 리스트-->
                <div class="movie">
                    <ul class="list">
                        <c:forEach items="${srlist}" var="srlist">
                            <li class="mo">movie${srlist.mName}
                                <a href="#">
                                <span class="glyphicon glyphicon-heart"></span>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>

                    <button id="add">더보기</button>
                    
                </div>
        </div>
        </div>


	</body>
	<script>
       
	</script>
</html>