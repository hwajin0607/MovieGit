<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
    body{
        background-color: black;
    }

    table,tr,td{

        border-collapse: collapse;
        width: 96%;
        height: 100px;
        margin: 10px;
    }
    .loginBox{
        text-align: center;
        width: 462px;
        height: 373px;
        position: absolute;
        top:30%;
        left:37%;
        background-color: black;
        color: white;
        opacity: 0.9;
    }
    #login{
        padding: 40px;
    }
    #login2{
        background-color:white;
        width: 70px;
        height: 80px;
        border-radius: 8px;
        font-weight: 600;
        font-size: 17px;
    }
    #id,#pw{
        width: 240px;
        height: 30px;
        border-radius: 8px;
        font-size: 15px;
    }
    #login-top{
        position: absolute;
        background-color: rgb(37, 35, 35);
        width: 100%;
        height: 69px;
        font-size: 31px;
        text-align: center;
        line-height: 0px;
        z-index: 2;
    }
    #login-top::after{
        position: absolute;
        background-color: rgb(37, 35, 35);
        opacity: 0.6;
        width: 100%;
        height: 69px;
        font-size: 31px;
        text-align: center;
        line-height: 0px;
        z-index: 1;
    }
    table{
        top:20%;
        position: absolute;

    }
    a{
        color: white;
    }
    a:link a:visited a:active a:hover{
        color: white;
    }
    #memberjoin{
       position: absolute;
       top: 200px;
       left: 703px;
       width: 473px;
       height: 404px;
       z-index: 9;
       background-color: white;
      display:none;
    }
    iframe{
       width: 100%;
       height: 100%;
       border: 0;
       top: 8px;
       left: 13px;
       position: absolute;
    }
    span{
       cursor:pointer;
    }
</style>
</head>
<body>
   <div id="memberjoin"><iframe src="Memberjoin.jsp"></iframe></div>
   
       <div>
        <img src="/photo/main.jpg" style="width: 100%; height: 900px; opacity: 0.3;">
       </div>
        <form action="login" method="post">  
            <div class="loginBox"><div id="login-top"><h3>LOGIN</h3></div>   
                <table>
                    <tr>
                        <td>
                            <input name ="id" id="id" type="text" placeholder="   아이디를 입력하세요"/><br/><br/>
                            <input name ="pw" id="pw" type="password" placeholder="   비밀번호를 입력하세요"/></td>
                        <td id="login" colspan="2"><input id="login2" type="submit" value="로그인"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">회원가입 하시려면 <span><ins>여기</ins></span>를 클릭해 주세용</td>
                    </tr>
                </table>
            </div>
        </form>

</body>
<script>
   var uIdx = "${sessionScope.uIdx}";
   var loginId = "${sessionScope.loginId}";
   var loginPw = "${sessionScope.loginPw}";
   console.log(uIdx)
   
    if(uIdx=="0" || loginId==""){
      var msg = "${msg}";
      if(msg!=""){
         alert(msg);
       }
    }
 
     $(document).ready(function(){
      
        $("span").click(function(){
          $("#memberjoin").css('display','block');
        });

     });

     function DoSend() {

        $("#memberjoin").css('display','none');
   }




</script>

</html>