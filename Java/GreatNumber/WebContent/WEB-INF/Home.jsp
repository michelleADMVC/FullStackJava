<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Word Generator</title>
<style>
 	.button-container{
 		display:flex;
 		 align-items: center;
  		justify-content: center;
 	}
 	.box{
 	display:flex;
 	align-items: center;
  	justify-content: center;
 	width: 250px;
 	height: 250px;
 	}
 	.guide{
 		border:solid 1px black;
 	}
 	.game_box_container{
 		display:flex;
 		 align-items: center;
 		 justify-content: center;
 	}
</style>
</head>
<body> 
	<h1 class="container-fluid text-center">Great number game </h1>
	<div class="text-center">
		<div class="mt-3">
			<p>Estoy pensando en un numero del 1 al 100</p> 
		</div>
		
		<div class= "game_box_container">
			<c:if test = "${gameResponse.equals('high')}">
			<div class="box border border-danger">
			<h3>Too high!</h3>
			</div>
			</c:if>
			<c:if test = "${gameResponse.equals('low')}">
			<div class="box border border-danger">
			<h3>Too low!</h3>
			</div>
			</c:if>
			<c:if test = "${gameResponse.equals('win')}">
			<div class="box border border-success">
			<h3>You WIN!</h3>
			</div>
			</c:if>
		</div>
		<div>
			<form method="post" action = "home">
			<div class="mt-3">
				<input type= "number" name="number" required>
			</div>
			<c:if test = "${gameResponse.equals('win')}">
			<div class="mt-3">
				<button class="btn btn-success"type ="submit">Jugar de nuevo</button>
			</div>
			</c:if>
			<c:if test = "${!gameResponse.equals('win')}">
			<div class="mt-3">
				<button class="btn btn-primary"type ="submit">Adivinar</button>
			</div>
			</c:if>
			</form>
		</div>
	
	</div>
</body>
</html>