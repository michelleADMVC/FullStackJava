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
 	
 	.guide{
 		border:solid 1px black;
 	}
</style>
</head>
<body>
	<h1 class="container-fluid text-center">Word Generator</h1>
	<div class="container-fluid text-center">
		<p>Has generado una palabra : <c:out value="${count}"/> veces <p>
		<div class="container p-4 mt-4">
			<div class= "border">
				<h3><c:out value="${lastWord}"/></h3>
			</div>
		</div>
		<div class="mt-4 button-container">
			<div class = "mr-4" > 
				<form method="post" action = "home">
				<input type="hidden"
	            name="add"
	            value="true">
				<button class = "btn btn-primary">Generate </button>
				</form >
			</div>
			<div> 
				<form method="post" action = "home">
				<input type="hidden"
	            name="add"
	            value="false">
				<button class = "btn btn-secondary">Reset </button>
				</form >
			</div>
		</div>
		<div class= "mt-5">
		<h4>Fecha de ultima palabra generada :  <c:out value="${date}"/>:</h4>
		</div>
	</div>
	
	
</body>
</html>