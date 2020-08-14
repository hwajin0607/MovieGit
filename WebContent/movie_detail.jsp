<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
      <meta charset="utf-8">
        <title>영화 상세 페이지</title>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <style>
        
        body{
           background-color: black;
           height: 100%;
        }
       
       .header{
              background-color: black;
              width: 99%;
              height: 111px;
              position: fixed;
              padding-top: 87px;
              display : inline-block;
              top:-20px;
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
             width: 90px;
             height: 36px;
             position: absolute;
             top: 26px;
             left: 1686px;
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
    
        /*영화 상세 관련*/       
            #ready{
                width: 85%;
                height: 55%;
                background-color: rgb(0,0,0,0.9);
                margin-top: 3%;
                margin-bottom: 30px;
                margin-left: 7%;
                position: relative;
                z-index: 9;
                top : -180%;
            }

            #post{
                position: relative;
                width: 25%;
                height: 88%;
                background-color: blanchedalmond;
                top: 5%;
                left: 2%;
                cursor: pointer;
            }

            #age{
                position: absolute;
                width: 2%;
                height: 7%;
                background-color: cadetblue;
                top: 10%;
                left: 30%;
                border-radius: 50px;
                text-align: center;
                line-height: 35px;
            }

            #title{
                position: absolute;
                width: 25%;
                height: 8%;
                background-color: crimson;
                top: 10%;
                left: 34%;
            }

            #movie{
                position: absolute;
                width: 69%;
                height: 60%;
                background-color: darkblue;
                top: 20%;
                left: 29%;
            }

            #m1{
                position: absolute;
                width: 110px;
                height: 25px;
                background-color: blueviolet;
                top: 10%;
                left: 3%;
                text-align: center;
            }

            #m2{
                position: absolute;
                width: 70px;
                height: 25px;
                background-color: darkorange;
                left: 14%;
                top: 10%;
            }

            #bar1{
                position: absolute;
                background-color: white;
                width: 300px;
                height: 2px;
                top: 23%;
                left:3%;
            }

            #bar2{
                position: absolute;
                background-color: white;
                width: 300px;
                height: 2px;
                top: 85%;
                left: 71%;
            }

             #pj{
                position: absolute;
                width: 100px;
                height: 50px;
                left: 29%;
                background-color: aquamarine;
                top: 83%;
            }

            #pj1{
                position: absolute;
                width: 125px;
                height: 35px;
                left: 35%;
                top: 83%;
                background-color: aquamarine;  
            }

            #pj2{
                position: absolute;
                width: 40px;
                height: 35px;
                left: 45%;
                top: 83%;
                background-color: aquamarine;  
            }

            #pj3{
                position: absolute;
                width: 75px;
                height: 30px;
                left: 29%;
                top: 83%;
                background-color: aquamarine;  
            }

            #m3{
                position: absolute;
                color: black;
                top: 30%;
                left: 3%;
                font-size: 20px;
                width: 1030px;
                height: 120px;
                background-color: tomato;
                
            }

            #heart{
                position: absolute;
                background-color: red;
                width: 30px;
                height: 25px;
                left: 90%;
                color: white;
                text-align: center;
                top: 10%;
            }

            /*댓글 관련*/
             #com{
                width: 85%;
                height: 110%;
                background-color: rgb(0,0,0,0.9);
                margin-left: 7%;
                position: relative;
                z-index: 9;
                top : -178%;
            }

            .content{
                position: relative;
                width: 85%;
                height: 3%;
                left: 3%;
            }

            .submit{
                position: relative; 
                left: 3%;
                width: 8%;
                height: 3%;
            }

           h3{
                color: white;
            }

            .com{
                width: 7%;  
                background-color: cornflowerblue;
                height: 3%;
                border: 1px solid black;
                position: relative;
                left: 3%;
            }

            .mon{
                width: 95%;  
                background-color: darkcyan;
                height: 8%;
                border: 1px solid black;
                position: relative;
                left: 3%; 
            }

            .bar3{
                position: relative;
                background-color: white;
                width: 80%;
                height: 2px;
                left: 3%;
            }

            /*신고, 수정, 삭제*/
            .clickbox{
                display: flex;
                color: darkgrey;
                position: relative;
                left: 90%;
                margin-bottom: -15;
                cursor: pointer;
                width: 115px;
            }

            textarea{
                width: 100%;
                height: 100%;
                resize: none;
            }

            #mon{
                width: 93%;  
                background-color: darkcyan;
                height: 8%;
                border: 1px solid black;
                position: absolute;
                top: 15%;
                left: 4%;
                display: none;
            }

            .recon{
                position: relative;
                width: 85%;
                height: 80%;
                left: 2%;
                top: 5%;
            }

            #su{
                position: relative;
                left: 5%;   
            }

        </style>   
    </head>
    <body>
     <div>
            <img src = "/photo/main.jpg" style = "width : 100%;  height : 100%; position:relative" > 
      </div>
       <div class="header"><a href="like"><img id="logo" src="/photo/logo.png"/></a>
        <div id="search"><img id="search2" src="/photo/search.png"/></div>
        <div id="allmenu"><a href="movieList">전체 메뉴</a></div>
        <div id="mypage"><a href="myPage.jsp">마이페이지</a></div>
        <div id="login"></div>
        <div id="logout"><a href="logout">로그아웃</a></div>
    </div>
        <div class="panel"><a href="">검색창</a></div>
    
          <div id="background">
        <img src="/photo/main.jpg" style="width:100%; height:100%; position:relative;"/>
       </div>
        <c:forEach items="${list}" var="mms">
           <div id="ready">
               <div id="post" onclick="location.href='#'">
                   ${mms.mUrl}
               </div>
               <div id="age">
                   ${mms.mAge}
               </div>
               <div id="title">
                   ${mms.mName}
               </div>
          
               <div id="heart"><button onclick="location.href='./zzimadd?midx=${mms.mIdx}'">찜</button></div>
   
               <div id="movie">
                   <div id="m1">${mms.mGenre}</div>
                   <div id="m2">${mms.mdDirector}</div>
                   <div id="bar1"></div>
                   <div id="bar2"></div>
                   <div id="m3">${mms.mContent}</div>
               </div>
              <div><input class = "pjbox" id ="pj" type="button" value="${mms.mrRating}&nbsp;&nbsp;( ${mms.uidx} )" onclick="pjbox()"/></div>
            <div>
                <form action = "writeRating" id="va">
                   <input type ="hidden" name="mIdx" value="${mms.mIdx}"/>
                    <div class="3" style="display:none" id="pj3">평점(1~5) </div>
                    <input class = "1" type="hidden" name="pjpoint" min="1" max="5" id ="pj1" />
                    <input class = "2" type="hidden" id="pj2" />
                </form> 
            </div>
        </div>
        </c:forEach>
        <!--댓글 창-->
        <div id="com">
            <fieldset>
                <legend><h3>댓글</h3></legend>
                <form action="./movieconten" method="get">
                    <input type="text" name="contentTxt" class="content"/>&nbsp;&nbsp;<input type="submit" value="submit" class="submit"/>
                </form>
                &nbsp;&nbsp;
                <c:forEach items="${Content }" var="moviecontent">
                <div class="clickbox">
                    <div class="p1" >신고|</div>&nbsp;
                    <div class="p2">수정|</div>&nbsp;
                    <div class="p3">삭제</div>
                </div>
                <input type ="hidden" name="conIdx" value="${moviecontent.conidx}"/>
                <div class="com">${moviecontent.uiden }</div>
                <div class="mon">${moviecontent.conContent }</div>
                &nbsp;
                <div class="bar3"></div>
                </c:forEach>
                <div>페이징 넣을 예정</div>
            </fieldset>
        </div>

   </body>
    <script>

   
        $('.p1').click(function(){
            console.log("찍힌다.");
            alert('신고가 되었습니다');
        });
        
        var midx = $('input[name = "mIdx"]').val();
        var conidx = $('input[name = "conIdx"]').val();
        $('.p2').click(function(){
             console.log(conidx);
             $(this).parent().next().next().next().html('<form action="./conup" method="GET">'
                   +'<input type="text" name="coment" class="recon"/>&nbsp;&nbsp;<input type="submit" value="submit" id="su"/>'
                   +'<input type="hidden" name="midx" value="'+midx+'"/>'
                   +'<input type="hidden" name="conIdx" value="'+conidx+'"/>'
                   +'</form>');
       });
       $('.p3').click(function(){
             console.log(conidx);
             location.href="./conDel?conidx="+conidx;
       });
        
        $('#p2').click(function(){
            $('#mon').css({'display':'block'});
        });

        $('#su').click(function(){
            $('#mon').css({'display':'none'});
        });

        

        function pjbox(){
            $('.1').attr("type","range");
            $('.2').attr("type","submit");
            $('.pjbox').attr("type","hidden");
            $('.3').css({'display':'inline'});
        };
        
        var msg = "${msg}";
        if(msg!=""){
           alert(msg);
        }

   </script>
</html>