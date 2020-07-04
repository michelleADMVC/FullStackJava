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
</head>

<body>

<div class= "row mt-5">
	<div class= "col-4 "></div>

	<div class= " col-4 text-center mt-5">
		<c:if test = '${error.equals("true")}'>
		<h2 class = "text-danger">You must train harder</h2>
		</c:if>
		<form class = "form-control card" method ="post" action="">
		<label for="code">Whats is the code?</label>
		<input class = "form-control" type="text" name="code" required placeholder="The code!">
		<button class="btn btn-primary mt-4" type ="submit">Submit</button>
		</form>
	</div>
</div>

</body>
</html>