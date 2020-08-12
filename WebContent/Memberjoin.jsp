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
			table, td{
				border : 1px solid black;
				border-collapse: collapse;
			}
			td{
				padding: 5px;
				text-align:center;
			}
		</style>
	</head>
	<body>
		<div style="display:block">
			<h3>회원가입</h3>
				<table>
					<tr>
						<td>ID</td>
						<td>
							<input type="text" name="uid"/>
							<input type="button" id="overlay" value="ID 중복 체크"/>
						</td>
					</tr>
					<tr>
						<td>PW</td>
						<td><input type="password" name="uPw"/></td>
					</tr>
					<tr>
						<td>NAME</td>
						<td><input type="text" name="uName"/></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input type="text" name="ubirth"/></td>
					</tr>
					<tr>
						<td>성별</td>
						<td>
							남자: <input type="radio" name="ugender" value="남"/>
							&nbsp;&nbsp;&nbsp;&nbsp;
							여자: <input type="radio" name="ugender" value="여"/>
						</td>
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
						<td>EMAIL</td>
						<td><input type="email" name="uemail"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" id="join" value="회원가입"/>
						</td>
					</tr>
				</table>
			</div>
	</body>
<script>

function count_ck(obj){
	var chkbox = document.getElementsByName("ugenre");
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

var overChk = false;
var checkArr=[];



$("#overlay").click(function(){	
	var id = $("input[name='uid']").val();
	console.log("id : "+id);
	$.ajax({
		type:"get",
		url:"overlay",
		data:{"id":id},
		dataType:"JSON",
		success:function(data){
			console.log(data);
			if(data.overlay){
				alert("이미 사용중인 아이디 입니다.");
				$("input[name='uid']").val("");
			}else{
				alert("사용 가능한 아이디 입니다.");
				overChk = true;
			}
		},
		error:function(e){
			console.log(e);
		}
	});
});

$("#join").click(function(){
	if(overChk){
		var $id = $('input[name="uid"]');
		var $pw = $('input[name="uPw"]');
		var $name = $('input[name="uName"]');
		var $birth = $('input[name="ubirth"]');
		var $gender = $('input[name="ugender"]:checked');
		var $email = $('input[name="uemail"]');
		$('input[type="checkbox"]:checked').each(function(idx,item){
			checkArr.push($(this).val());	
		});
		if($id.val() == ""){
			alert("아이디를 확인해 주세요.");
			$id.focus();
		}else if($pw.val() == ""){
			alert("비밀번호를 넣어 주세요.");
			$pw.focus();
		}else if($name.val() == ""){
			alert("이름을 넣어 주세요.");
			$name.focus();
		}else if($birth.val() == ""){
			alert("나이를 넣어 주세요.");
			$age.focus();
		}else if($gender.val() == null){
			alert("성별을 선택 해 주세요.");			
		}else if($email.val() == ""){
			alert("메일 주소를 입력 해 주세요.");		
			$email.focus();
		}else{//모든 항목을 입력 했을 경우
			console.log('서버로 전송');
			$.ajax({
				type:"post",
				url:"join",
				data:{
					"id" : $id.val(),
					"pw" : $pw.val(),
					"name" : $name.val(),
					"birth" : $birth.val(),
					"gender" : $gender.val(),
					"email" : $email.val(),
					"ugenre" : checkArr},
				dataType:"JSON",
				success:function(data){
					console.log(data);
					if(data.join){
						alert("회원 가입에 성공 했습니다.");
						$('div').css({"display" : "none" });
					}else{
						alert("회원 가입에 실패 했습니다.");
						location.href="Memberjoin.jsp";
					}
				},
				error:function(error){
					console.log(error);
				}				
			});
		}

		
	}else{
		alert("중복 체크를 확인 해 주세요.");
		$('input[name="uId"]').focus();
	}
});
</script>
</html>