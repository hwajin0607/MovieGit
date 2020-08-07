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
		<form action="/info" method="get">
			<table>
				<tr>
					<th colspan="2"><h3>회원 정보 수정</h3></th> 		
				</tr>
				<tr>
					<th>ID</th> 		
					<td>${info.uiden}
                    </td>
				</tr>
				<tr>
					<th>PW</th> 		
					<td><input type="password" name="uPw"/>
                    </td>
				</tr>
				<tr>
					<th>이름</th> 		
					<td>${info.uname}</td>
				</tr>
				<tr>
					<th>생일</th> 		
					<td><input type="text" name="ubirth" value="${info.uBirth}" /></td>
				</tr>
				<tr>
					<th>성별</th> 		
					<td>${info.ugender}</td>
				</tr>
				<tr>
					<th>E-mail</th> 		
					<td><input type="text" name="uemail" value="${info.uemail}"/></td>
				</tr>
				<tr>
					<th>취향</th> 		
					<td>
						<input type="checkbox" name="ugenre" onClick='count_ck(this)' value="애니메이션"/> 애니메이션
						<input type="checkbox" name="ugenre" onClick='count_ck(this)' value="액션"/> 액션
						<input type="checkbox" name="ugenre" onClick='count_ck(this)' value="SF/판타지"/> SF/판타지<br/>
						<input type="checkbox" name="ugenre" onClick='count_ck(this)' value="로맨스/코미디"/> 로맨스/코미디
						<input type="checkbox" name="ugenre" onClick='count_ck(this)' value="드라마/다큐"/> 드라마/다큐 
						<input type="checkbox" name="ugenre" onClick='count_ck(this)' value="스릴러/공포" /> 스릴러/공포<br/>
					</td>
				</tr>
				<tr>
					<th colspan="2" align ="center">
						<input type="button" id="Changing" value="정보수정"/>
					</th> 			
				</tr>
			</table>
		</form>
	</body>
	<script>
	function count_ck(obj){
		var chkbox = document.getElementsByName("ugenre");
		var chkCnt = 0;
		for(var i=0;i<chkbox.length; i++){
			if(chkbox[i].checked){
				chkCnt++;
				console.log(chkCnt);
			}
		}
		if(chkCnt>3){
			alert("3개까지만 선택이 가능합니다.");
			obj.checked = false;
			return false;
		}
	}

	var checkArr=[];


	$("#Changing").click(function(){
			var $pw = $('input[name="uPw"]');
			var $birth = $('input[name="ubirth"]');
			var $email = $('input[name="uemail"]');
			$('input[type="checkbox"]:checked').each(function(idx,item){
				checkArr.push($(this).val());	
			});
			if($birth.val() == ""){
				alert("생년월일를 넣어 주세요.");
				$age.focus();
			}else if($email.val() == ""){
				alert("메일 주소를 입력 해 주세요.");		
				$email.focus();
			}else{
				console.log('서버로 전송');
				$.ajax({
					type:"post",
					url:"infoc",
					data:{
						"pw" : $pw.val(),	
						"birth" : $birth.val(),
						"email" : $email.val(),
						"ugenre" : checkArr
						},
					dataType:"JSON",
					success:function(data){
						console.log(data);
						if(data.overlay){
							alert("회원 정보가 수정되었습니다.");
							location.href="./info";
						}else{
							alert("회원 정보가 수정 실패되었습니다.");
							location.href="./changing";
						}
					},
					error:function(error){
						console.log(error);
					}				
				});
			}
	});
	</script>
</html>