<%@ page language="java" contentType="text/html;UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Survey</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<div class="text-center card mt-3">
	<h1>Survey </h1>
</div>
<div id="app" class="p-5">
	<div class="survey card p-3">
		<form class="form-group" method = "post" action="">
			<div>
				<label for ="name">Name :</label>
				<input type="text" required name="name" placeholder= "Your name" class="form-control">
			</div>
			<div class="form-group">
		   	<label for="location">Dojo Location : </label>
		    	<select class="form-control" name="location" >
				    <option>San Jose</option>
				    <option>Your home</option>
				    <option>Your another home</option>
				    <option>Your neighbor home</option>
				    <option>Classroom</option>
			    </select>
	 		 </div>
	 		 <div class="form-group">
	   		 	<label for="favLenguage">Favorite Language : </label>
	   			<select class="form-control" name="favLenguage" >
				    <option>Python</option>
				    <option>Java</option>
				    <option>Javascript </option>
				    <option>C#</option>
				    <option>Rust</option>
			    </select>
	 		 </div>
	 		 <div class="form-group">
			    <label for="comment">Example textarea</label>
			    <textarea class="form-control" name="comment" rows="3"></textarea>
			 </div>
			 <div>
			 	<button class="btn btn-primary form-control" type="submit">Enviar</button>
			 </div>
		</form>
	</div>
</div>
</body>
</html>