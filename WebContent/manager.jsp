<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>관리자 페이지</title>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<style>
			
		</style>
		
	</head>
	<body>
		<h2>관리자 페이지</h2>
		<br/>
			<input type="submit" value="회원관리" onclick="location.href='member'">
			<input type="submit" value="영화관리" onclick="location.href='movie'">
			<input type="submit" value="영화댓글" onclick="location.href='content?page=1&mIdx=6'">


	</body>
	<script>
		
	</script>
</html>

