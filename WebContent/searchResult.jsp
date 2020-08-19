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
            }
            
            .header{
		        background-color: black;
		        width: 100%;
		        height: 203px;
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
		        background-color: gray;
		        position: absolute;
		        top: 129px;
		        left: 77px;
		        z-index: 10;
		        display: none;
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
                background-color: white;
                width: 300px;
                height: 500px;
                margin:50px;
                
            }

            .movie{
                position: absolute;
                z-index: 1;
                top: 30%;
            }

            #next{
                clear: left;
            }
			
         
           .backimg{
                margin-left: 2%;
                margin-top: 9%;
                margin-right: 2%;
                position: relative;
                width: 1800px;
                height: 1000px;
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
            
            .molist{
            float:left;
            }

            .blackopcaity{
                background-color: black;
                position: absolute;
                width: 100%;
                height: 100%;
                opacity: 0.5;

            }

            .blackopcaity1{
                background-color: black;
                position: absolute;
                width: 100%;
                height: 100%;
                opacity: 0.6;
            }
            
            #more{
                position: absolute;
                background-image: url("/photo/more3.png");
                width: 3%;
                height: 4%;
                background-size: cover;
                background-position: center;
                top: 102%;
                left: 50%;
                background-position: bottom;
            }
            
            .mainBody{
            position:relative;
            width:100%;
            height:200%;
            opacity:0.5;
            
            }
          
            
		</style>
		
	</head>
	
	<body>
	
	
		<div class="header"><a href="like"><img id="logo" src="/photo/logo3.png"/></a>
	        <div id="search"><img id="search2" src="/photo/search.png"/></div>
	        <div id="allmenu"><a href="page">MENU</a></div>
	        <div id="mypage"><a href="myPage.jsp">MY PAGE</a></div>
	        <div id="login"></div>
	        <div id="logout"><a href="logout">logout</a></div>
    	</div>
    
    
    	<div class="panel"><a href="">검색창</a></div>
		
        <div class="blackopcaity"></div>

        <!--SearchResult 전체 영역-->
        <div class="SrMain">
            

            <div class="backimg" >
            	<img class="mainBody" src="/photo/main9.jpg">
                <!--돋보기 로고-->
                <div class="searchLogo">
                    <!--Search Result-->
                    <div id="SearchResult">
                        <div id="SrMainBar"></div>
                        <a>Search Result</a>
                    </div>
                </div>

                <!--검색 바-->
                
                <form action="./search">
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
                        <c:forEach items="${slist}" var="srlist">
	                        <div class="molist">
	                            <li class="mo">movie${srlist.mName}
	                                <a href="#">
	                                <span class="glyphicon glyphicon-heart"></span>
	                                </a>
	                            </li>
	                        </div>
                        </c:forEach>
                    </ul>
                    <div class="pageArea">
							<a href="./search?page=${currPage+1}" id="more"></a>
						</div>
                </div>
        </div>

	</body>
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
		 });
	</script>
</html>