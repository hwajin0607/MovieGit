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
                background-color:black;
                position: relative;
                z-index: 9;
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
		    }
		    a:link a:visited a:active a:hover{
		        text-decoration: none;
		        color: white;
		    }
		    #mypage>a{
 			    
 			    text-decoration: none;
		        color: white;
		    }
   		    #allmenu>a{
 			    
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
            #WishList>p{
                position: absolute;
                color: white;
                font-size: 40px;
            }

            #WishList{
                position: absolute;
                top: 20%;
            }

            .mo{
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
                top: 40%;
            }

            #add{
                top: 1000px;
            }
            
            

            #next{
                clear: left;
            }

            #close{
            	position:relative;
            	left:80%;
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

            .blackopcaity{
                background-color: black;
                position: absolute;
                width: 100%;
                height: 100%;
                opacity: 0.5;

            }

            #more{
                position: absolute;
                background-image: url("/photo/l화살표.png"");
                width: 8%;
                height: 9%;
                background-size: cover;
                background-position: center;
                top: 101%;
                left: 210%;
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
        <!--로고-->
            <img class="logo" src="./photo/logo3.png"/>
        

        <div class="MainBody">
        <!--전체 삭제-->
       

        <!--로그 아웃-->
        <form>
            <a id="Log-Out" style="position: absolute;">Log-Out</a>
        </form>

        <!--WishList 전체 영역-->
        <div class="WsMain">
            <div class="backimg">
                <img src="/photo/main9.jpg" style="width: 100%; height: 200%; opacity: 0.5; position: relative; " >

                    <!--WishList-->
                    <div id="WishList">
                        <div id="WsMainBar"></div>
                        <p>Wish List</p>
                    </div>
                </div>

                
                

            
                <!--영화 찜목록 리스트-->
                <div class="movie">
                    <ul class="Wishlist">
                     <div class="AllDelMain" style="left: 396%; margin-top: -8%; width:15%">
           				 <a id="AllDel" href="./Alldel?uidx=${Alldel.uidx}" style="color: white;">전체 삭제</a>
        			</div>
                        <c:forEach items="${list }" var="list">
                            <div class="molist">
                                <li class="mo">${list.mIdx}
                                <a href="./del?zidx=${list.zidx }"><img id="close" src="/photo/closeBar.png" /></a>
                                </li>
                            </div>
                        </c:forEach>

                        <div class="pageArea">
							<a href="./zzim?page=${currPage+1}" id="more"></a>
                        </div>
                        
                    </ul>
                    
                    
                
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