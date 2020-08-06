<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
    /* body{
        background-image: url('main.jpg');
        background-repeat: no-repeat;
        object-fit: fill;
        background-size: 4160px 5100px;
    } */
    table,tr,td{
        border:1px solid black;
        border-collapse: collapse;
        width: 96%;
        height: 100px;
        margin: 10px;
    }
    div{
        text-align: center;
        width: 462px;
        height: 373px;
        position: absolute;
        top:30%;
        left:37%;
        background-color: gray;
        z-index: 8;
        color: white;
    }
    #login{
        padding: 48px;
    }


</style>
</head>
<body>
    
        <form action="login" method="post">  
            <div><h3>로그인</h3>   
            <table>
                <tr>
                    <td>
                        &nbsp; ID : <input type="text" name="id"/><br/><br/>
                        PW : <input type="password" name="pw"/></td>
                    <td id="login" colspan="2"><input type="submit" value="로그인"/></td>
                </tr>
                <tr>
                    <td colspan="2">회원가입 하시려면<br/>여기를 <a href="#">클릭</a>해 주세용</td>
                </tr>

            </table>
        </div>
        </form>
    
        

</body>
<script>

    // $(document).ready(function(){


    // });

</script>

</html>