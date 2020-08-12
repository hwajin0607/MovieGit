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
 		
 		  #bg::after{
                width : 100%;
                height : 1000px;
                z-index : 1;
                position : absolute; 
                top: 0; 
                left: 0;
            }

        /*영화 상세 관련*/       
            #ready{
                width: 85%;
                height: 50%;
                background-color: black;
                opacity: 0.9;
                margin-top: 3%;
                margin-bottom: 30px;
                margin-left: 7%;
                position: relative;
                z-index: 10;
            }

            #post{
                position: relative;
                width: 25%;
                height: 75%;
                background-color: blanchedalmond;
                top: 11%;
                left: 3%;
                cursor: pointer;
            }

            #age{
                position: absolute;
                width: 3%;
                height: 7%;
                background-color: cadetblue;
                top: 10%;
                left: 30%;
                border-radius: 50px;
            }

            #title{
                position: absolute;
                width: 25%;
                height: 8%;
                background-color: crimson;
                top: 10%;
                left: 38%;
            }

            #movie{
                position: absolute;
                width: 65%;
                height: 50%;
                background-color: darkblue;
                top: 20%;
                left: 30%;
            }

            #m1{
                position: absolute;
                width: 50px;
                height: 25px;
                background-color: blueviolet;
                top: 10%;

            }

            #m2{
                position: absolute;
                width: 50px;
                height: 25px;
                background-color: darkorange;
                left: 10%;
                top: 10%;
            }

            #bar1{
                position: absolute;
                background-color: white;
                width: 300px;
                height: 2px;
                top: 23%;
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
                left: 30%;
                background-color: aquamarine;
            }

            #pj1{
                position: absolute;
                width: 125px;
                height: 35px;
                left: 35%;
                top: 80%;
                background-color: aquamarine;  
            }

            #pj2{
                position: absolute;
                width: 40px;
                height: 35px;
                left: 45%;
                top: 80%;
                background-color: aquamarine;  
            }

            #pj3{
                position: absolute;
                width: 75px;
                height: 30px;
                left: 29%;
                top: 80%;
                background-color: aquamarine;  
            }

            #m3{
                position: absolute;
                color: black;
                top: 40%;
                left: 40%;
                font-size: 20px;
                width: 50px;
                height: 30px;
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
                background-color: black;
                opacity: 0.9;
                margin-left: 7%;
                position: relative;
                z-index: 10;
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
            <img src = "/photo/main.jpg" style = "width : 100%;  height : 170%; z-index : 2; position : absolute; top: 0; left: 0; opacity: 0.8;" id="bg" > 
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
                <form action="#" method="get">
                    <input type="text" name="content" class="content"/>&nbsp;&nbsp;<input type="submit" value="submit" class="submit"/>
                </form>
                <div class="clickbox">
                    <div class="p1">신고|</div>&nbsp;
                    <div class="p2" id="p2_1">수정|</div>&nbsp;
                    <div class="p3">삭제</div>
                </div>
                <div class="com">user id</div>
                <div class="mon"><textarea>댓글내용</textarea></div>
                <div id="mon">
                    <form action="#" method="get">
                    <input type="text" name="coment" class="recon"/>&nbsp;&nbsp;<input type="submit" value="submit" id="su"/>
                    </form>
                </div>
                &nbsp;
                <div class="bar3"></div>
                &nbsp;&nbsp;
                <div class="clickbox">
                    <div class="p1" >신고|</div>&nbsp;
                    <div class="p2">수정|</div>&nbsp;
                    <div class="p3">삭제</div>
                </div>
                <div class="com">user id</div>
                <div class="mon">댓글내용</div>
                &nbsp;
                <div class="bar3"></div>
                &nbsp;&nbsp;
                <div class="clickbox">
                    <div class="p1">신고|</div>&nbsp;
                    <div class="p2">수정|</div>&nbsp;
                    <div class="p3">삭제</div>
                </div>
                <div class="com">user id</div>
                <div class="mon">댓글내용</div>
                &nbsp;
                <div class="bar3"></div>
                &nbsp;&nbsp;
                <div class="clickbox">
                    <div class="p1">신고|</div>&nbsp;
                    <div class="p2">수정|</div>&nbsp;
                    <div class="p3">삭제</div>
                </div>
                <div class="com">user id</div>
                <div class="mon">댓글내용</div>
                &nbsp;
                <div class="bar3"></div>
                &nbsp;&nbsp;
                <div class="clickbox">
                    <div class="p1">신고|</div>&nbsp;
                    <div class="p2">수정|</div>&nbsp;
                    <div class="p3">삭제</div>
                </div>
                <div class="com">user id</div>
                <div class="mon">댓글내용</div>
                &nbsp;
                <div class="bar3"></div>
                &nbsp;
                <div>페이징 넣을 예정</div>
            </fieldset>
        </div>

	</body>
    <script>

   
        $('.p1').click(function(){
            console.log("찍힌다.");
            alert('신고가 되었습니다');
        });

        $('#p2_1').click(function(){
            $('#mon').css({'display':'block'});
        });

        $('#su').click(function(){
            $('#mon').css({'display':'none'});
        });

        $('.p3').click(function(){
            console.log("찍힌다.");
            alert('삭제되었습니다.');
        });
        

        function pjbox(){
            $('.1').attr("type","range");
            $('.2').attr("type","submit");
            $('.pjbox').attr("type","hidden");
            $('.3').css({'display':'inline'});
        };

    	var msg = "${msg}";
    	if(msg !=""){
    		alert(msg);
    	}
    	
	</script>
</html>