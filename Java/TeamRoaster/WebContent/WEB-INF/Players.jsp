<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
crossorigin="anonymous">
<style><%@include file="/WEB-INF/css/style.css"%></style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>JSP template</title>

</head>
<body>
	<div class="navbar bg-dark text-white">
		<h1>Create a new player</h1>
		<form method="post" action="home" class="form-inline">
   			 <button class="btn btn-danger" type="submit">Back</button>
 		</form>
	</div>
	<div class="jumbotron">
			<div class="flex_center full ">
				<div class="action_container">
					<form method="post" action="players" class ="form-inline">
						<input type="hidden" name="action" value="add_player">
						<input type="text" required class= "form-control mr-3" 
						placeholder="First name" name="name">
						<input type="text" required class= "form-control mr-3" 
						placeholder="Last name" name="last_name">
						<input type="number" required class= "form-control mr-3" 
						placeholder="Age" name="age">
						<button class="btn btn-success" type="submit">Add player+</button>
					</form>
				</div>
			</div>
		</div>
</body>
</html>