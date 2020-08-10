<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<style>
		#serbar{
                position: absolute;
                left: 405%;
                top: 3%;
                height: 100%;
                border-radius: 10px;
            }
    	.searchBar{
                position: absolute;
                top: 20%;
            }
       
       
	</style>
</head>
<body>
	<form action="./searchResult">
	<div class="SearchZone">
                <div class="searchBar">${slist }
                    <input id="searchTxt" type="text" name="searchTxt" placeholder="Search..."/>
                    <button id="serbar">검색</button>
                </div>
    </div>
    </form>
</body>
</html>