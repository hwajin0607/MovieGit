<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<style>
			table, tr, th, td{
				border: 1px solid;
				border-collapse: collapse;
			}
			table, tr, th{
				padding: 5px 10px;
			}
			button{
				width: 200px;
			}
            #id{
                width: 100px;
            }
            input[type='text'],input[type='password']{
                width: 200;
                margin:  5px 10px;
            }
            #btn{
                width: 80px;
                margin:  5px 10px;
            }
		</style>
	</head>
	<body>
	<!-- 성공하면 index로 실패하면 joinProc -->
		<form action="chang" method="get">
			<table>
				<tr>
					<th colspan="2"><h3>회원 정보 수정</h3></th> 		
				</tr>
				<tr>
					<th>ID</th> 		
					<td>id값
                    </td>
				</tr>
				<tr>
					<th>PW</th> 		
					<td><input type="password" name="PW"/>
                    </td>
				</tr>
				<tr>
					<th>이름</th> 		
					<td>이름값</td>
				</tr>
				<tr>
					<th>생일</th> 		
					<td>생일 값</td>
				</tr>
				<tr>
					<th>성별</th> 		
					<td>성별값</td>
				</tr>
				<tr>
					<th>E-mail</th> 		
					<td><input type="text" name="mail" value="기존 이메일 값"/></td>
				</tr>
				<tr>
					<th>취향</th> 		
					<td>
					<input type="checkbox" name="genre" onClick='count_ck(this)' value="애니메이션"/> 애니메이션
					<input type="checkbox" name="genre" onClick='count_ck(this)' value="액션"/> 액션
					<input type="checkbox" name="genre" onClick='count_ck(this)' value="SF/판타지"/> SF/판타지<br/>
					<input type="checkbox" name="genre" onClick='count_ck(this)' value="로맨스/코미디"/> 로맨스/코미디
					<input type="checkbox" name="genre" onClick='count_ck(this)' value="드라마/다큐"/> 드라마/다큐 
					<input type="checkbox" name="genre" onClick='count_ck(this)' value="스릴러/공포" /> 스릴러/공포<br/></td>
				</tr>
				<tr>
					<th colspan="2" align ="center">
						<button  onclick="value_check()"><b>저장하기</b></button>
					</th> 			
				</tr>
			</table>
		</form>
	</body>
	<script>
	var genre = new Array();
    var str=null;
	function count_ck(obj){
		var chkbox = document.getElementsByName("genre");
		var chkCnt = 0;
		for(var i=0;i<chkbox.length; i++){
			if(chkbox[i].checked){
				chkCnt++;
			}
		}
		if(chkCnt>3){
			alert("3개까지만 선택이 가능합니다.");
			obj.checked = false;
			return false;
		}
	}
    
    function value_check() {
        var check_count = document.getElementsByName("genre").length;
        console.log(check_count);
        for (var i=0; i<check_count; i++) {
            if (document.getElementsByName("genre")[i].checked == true) {
            	genre[i]=(document.getElementsByName("genre")[i].value);
                if(genre[i]!=""){
                    if(str == null){
                        str = genre[i]+",";
                    }else{
                        str += genre[i]+",";
                    }
                }
            }

        }
        console.log(str);
    }

	</script>
</html>