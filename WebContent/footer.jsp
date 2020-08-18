<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<style>
	                .bottom{
                    text-align: center;

                    margin-left: 100px;
                }
                .bottom div{
                    float: left;
                    text-align: left;
                    margin: 0px 180px;
                    left: 30%;
                    
                }

                .tit{
                    color: darkslategray;
                    font-weight: 800;
                    font-size: small;
                }
                .txt{
                    font-size: small;
                    color: gray;
                }
                </style>
</head>
<body>
	
	 <div class="bottom">
            <div>
                <p class="tit">customer center</p>
                <br/>
                <br/>
                <p class="txt">-고객 센터-</p>
                <p class="txt">Tel : 070-1234-5678</p>
            </div>
            <div>
                <p class="tit">영화</p>
                <p class="txt">101-32-15428</p>
                <p class="txt">3530000-037-2020-0022</p>
                <p class="txt"></p>
                <br/>
                <p class="txt">Gudi Pet Corp</p>
            </div>
            <div>
                <p class="tit">Location</p>
                <p class="txt">안산본점</p>
                <p class="txt">인천직영점</p>
                <p class="txt">신림직영점</p>
                <p class="txt">안양직영점</p>
                <p class="txt">전주점</p>
                <p class="txt">서초점</p>
            </div>
        </div>
</body>
</html>