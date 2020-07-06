<%@ page language="java" contentType="text/html;UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<div id="app">
	<div class="navbar text-white bg-dark">
		<h2>Your gold:$<c:out value="${userData.getGold()}"/></h2>
		<form method = "post" action="gold">
			<input type="hidden" name="action" value="reset"> 
			<button class="btn btn-primary mt-3">Reset!</button>
		</form>
	</div>
	<div class="game_buttons">
		<div class="game_action card">
			<span class="game_action_title">Farm</span>
			<span class="game_action_content">(earns 10-20 gold)</span>
			<form method = "post" action="gold">
				<input type="hidden" name="action" value="farm"> 
				<button class="btn btn-primary mt-3">Find gold!</button>
			</form>
		</div>
		<div class="game_action card">
			<span class="game_action_title">Cave</span>
			<span class="game_action_content">(earns 5-10 gold)</span>
			<form method = "post" action="gold">
				<input type="hidden" name="action" value="cave"> 
				<button class="btn btn-primary mt-3">Find gold!</button>
			</form>
		</div>
		<div class="game_action card">
			<span class="game_action_title">House</span>
			<span class="game_action_content">(earns 2-5 gold)</span>
			<form method = "post" action="gold">
				<input type="hidden" name="action" value="house"> 
				<button class="btn btn-primary mt-3">Find gold!</button>
			</form>
		</div>
		<div class="game_action card">
			<span class="game_action_title">Casino</span>
			<span class="game_action_content">(earns 0-50 gold)</span>
			<form method = "post" action="gold">
				<input type="hidden" name="action" value="casino"> 
				<button class="btn btn-primary mt-3">Bet gold!</button>
			</form>
		</div>
	</div>
	<div class="activities_title">Activities</div>
	<div class="activities card">
		<ul class="list-group full">
<%-- 		<c:out value="${userData.getLogs().size()}"/> --%>
 		<c:if test = "${userData.getLogs().size() > 0}">	
			 <c:forEach var = "i" begin = "0" end = "${userData.getLogs().size()-1}">
			 	<c:if test = "${userData.getLog(i).getLose() == false}">	
	         		<li class="list-group-item text-success"><c:out value="${userData.getLog(i).getLog()}"/> 
	         		<c:out value="${userData.getLog(i).getDate()}"/></li>
	         	</c:if>
	         	<c:if test = "${userData.getLog(i).getLose() == true}">	
	         		<li class="list-group-item text-danger"><c:out value="${userData.getLog(i).getLog()}"/> 
	         		<c:out value="${userData.getLog(i).getDate()}"/></li>
	         	</c:if>
	     	 </c:forEach>
     	 </c:if>
		
		</ul>
	</div>
</div>
</body>
</html>