<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="utf-8">
        <title>메인 하단</title>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <style>


			
            #a1{
                width: 500px;
                height: 300px;
                border: 2px solid black;
                border-radius: 10%;
                /* background-image: url(유경목장.png);
                background-repeat: no-repeat;
                background-size: 58%; 
                background-position-x: center; */
                margin:100px;
                cursor: pointer;
            }

            #ad1{
                width: 100%;
                height: 100%;
                border-radius: 10%;
            }

            #a2{
                width: 500px;
                height: 300px;
                border: 2px solid black;
                border-radius: 10%;
                margin-left: 100px;
                cursor: pointer;
            }
            
             #ad2{
                width: 100%;
                height: 100%;
                border-radius: 10%;
            }

            #random{
                width: 1000px;
                height: 700px;
  /*               border: 2px solid black; */
                /*  background-color: darkgray;*/
                position: absolute;
                left: 750px;
                top: 100px;
                cursor: pointer;
            }

         	#ad3{
                width: 100%;
                height: 100%;
/*                 background-color: yellow; */
                position: relative;
                left: 0%;
                top: 0%;
            }

          #ad4{
                width: 100%;
                height: 100%;
                border-radius: 40%;
            } 

            #ran1{
                border: 2px solid black;  
                width: 40%;
                height: 90%;
                position: relative;
                left: 5%;
                top: 6%;
                z-index: 0;
                display: none;
            }

            #ran2{
                border: 2px solid black;
                width: 30%;
                height: 10%;
                position: relative;
                left: 51%;
                top: -50%;
                z-index: 0;
                display: none;
            }
            
        </style>	
    </head>
    <body>
        <div id="bg">

        </div>
      <div id="a1" onclick="move()">
			<img src="/photo/유경목장.png" id="ad1"/>
      </div>
      <div id="a2" onclick="move2()">
			<img src="/photo/뭐입개.png" id="ad2"/>
      </div>
      	<div id="random" > 
     		<div id="ad3"><img src="/photo/클릭.gif" id="ad4"/></div>
     
      	<div id="ran1">
	      	<img src="" alt="포스터1" class="poster_img" />
      	</div>
        <div id="ran2">
        	<h3 class="movie_title"></h3>
        </div>
      </div>
	</body>
    <script>

    var a1 = document.getElementById('a1');
    function move() {
        window.open("http://www.naver.com");
    };



        var a2 = document.getElementById('a2');
        function move2() {
            window.location.href="#";
        };
              
		var movie;
         $("#random").click(function(){
        	 //location.href='random'; // location.href 는 주소줄에 있는 url을 변경하여 해당 url로 화면을 이동시켜줄때 사용하는 것
        	 $.ajax({ // js 비동기 통신의 기본
        		 url : 'random',
        		 type: 'GET',
        		dataType:'json',
        		success : function(result){ // 성공시 처리 ->  화면에 포스터를 그려줌
        			movie = result.movie;
	        		if(movie){
	            		console.log(movie.mName);
	        			$('#ad3').css({'display':'none'});
	     	            $('#ran1').css({'display':'block'});
	     	            $('#ran2').css({'display':'block'});
	        			$('img.poster_img').attr('src', movie.mfUrl);
						$('h3.movie_title').html(movie.mName); 
						//parent.Form.input.value = movie.mIdx;
						// window.opener.location.href = "movieDetail?mIdx="+movie.mIdx ;
						
						
						var midx = movie.mIdx;
	        			$("#ran1").click(function(){
		    	        	console.log("??"+movie.mIdx);
		    	        	parent.DoSend();
		    	        });
	        			$("#ran2").click(function(){
		    	        	console.log(movie.mIdx);
		    	        	
		    	        	parent.DoSend();
		    	        }); 
	        		}
        		},
        		error : function (){ // 에러처리
    	           
        		}
        	 });
        	// 방법 1. ajax로 데이터를 가져와서 원하는 화면을 그려주는법
        	// 방법 2. 화면에 진입했을때 포스터 목록을 가져와서 FrontEnd에서 랜덤함수를 구현하는 법 (이건 편법) 
        }); 
        
	  	</script>
</html>