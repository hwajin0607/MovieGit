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
			body{
				background-color: white;
			}
			table, td{
				border : 1px solid black;
				border-collapse: collapse;
			}
			td{
				padding: 5px;
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
						<td>생년월일</td>
						<td> 
							<select name="year">
	                            <option value="1990">1990</option>
	                            <option value="1991">1991</option>
	                            <option value="1992">1992</option>
	                            <option value="1993">1993</option>
	                            <option value="1994">1994</option>
	                            <option value="1995" selected>1995</option>
	                            <option value="1996">1996</option>
	                            <option value="1997">1997</option>
	                            <option value="1998">1998</option>
	                            <option value="1999">1999</option>
	                            <option value="2000">2000</option>
	                            <option value="2001">2001</option>
	                            <option value="2002">2002</option>
	                            <option value="2003">2003</option>
	                            <option value="2004">2004</option>
	                            <option value="2005">2005</option>
	                            <option value="2006">2006</option>
	                            <option value="2007">2007</option>
	                            <option value="2008">2008</option>
	                            <option value="2009">2009</option>
	                            <option value="2010">2010</option>
	                            <option value="2011">2011</option>
	                            <option value="2012">2012</option>
	                            <option value="2013">2013</option>
	                            <option value="2014">2014</option>
	                            <option value="2015">2015</option>
	                            <option value="2016">2016</option>
	                            <option value="2017">2017</option>
	                            <option value="2018">2018</option>
	                            <option value="2019">2019</option>
	                            <option value="2020">2020</option>
	                        </select>년 &nbsp;
                        
	                        <select name="month">
	                            <option value="01">01</option>
	                            <option value="02">02</option>
	                            <option value="03">03</option>
	                            <option value="04">04</option>
	                            <option value="05">05</option>
	                            <option value="06">06</option>
	                            <option value="07">07</option>
	                            <option value="08">08</option>
	                            <option value="09">09</option>
	                            <option value="10">10</option>
	                            <option value="11">11</option>
	                            <option value="12">12</option>
	                        </select>월 &nbsp;
	
	                        <select name="day">
	                            <option value="01">01</option>
	                            <option value="02">02</option>
	                            <option value="03">03</option>
	                            <option value="04">04</option>
	                            <option value="05">05</option>
	                            <option value="06">06</option>
	                            <option value="07">07</option>
	                            <option value="08">08</option>
	                            <option value="09">09</option>
	                            <option value="10">10</option>
	                            <option value="11">11</option>
	                            <option value="12">12</option>
	                            <option value="13">13</option>
	                            <option value="14">14</option>
	                            <option value="15" selected>15</option>
	                            <option value="16">16</option>
	                            <option value="17">17</option>
	                            <option value="18">18</option>
	                            <option value="19">19</option>
	                            <option value="20">20</option>
	                            <option value="21">21</option>
	                            <option value="22">22</option>
	                            <option value="23">23</option>
	                            <option value="24">24</option>
	                            <option value="25">25</option>
	                            <option value="26">26</option>
	                            <option value="27">27</option>
	                            <option value="28">28</option>
	                            <option value="29">29</option>
	                            <option value="30">30</option>
	                            <option value="31">31</option>
	                        </select>일 &nbsp;
						</td>
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
					<td>취향</td> 		
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
	/* if(overChk){
		var $id = $('input[name="uid"]');
		var $pw = $('input[name="uPw"]');
		var $name = $('input[name="uName"]');
		var $year = $('select[name="year"]');
		var $month = $('select[name="month"]');
		var $day = $('select[name="day"]');
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
					"year" : $year.val(),
					"month" : $month.val(),
					"day" : $day.val(),
					"gender" : $gender.val(),
					"email" : $email.val(),
					"ugenre" : checkArr},
				dataType:"JSON",
				success:function(data){
					console.log(data);
					if(data.join){
						alert("회원 가입에 성공 했습니다.");
				        $("#memberjoin").css('display','none');
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
	} */
	$("html").css('display','none');

});
</script>
</html>