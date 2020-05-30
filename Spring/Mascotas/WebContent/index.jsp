<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	<h1>Mascotas</h1>
	<div>
	<form method="post" action = "dog">
		<h2>Create a dog</h2>
		<div>
			<label for="dog_name">Name:</label>
			<input name = "dog_name" type = "text">
		</div>
		<div>
			<label for="dog_breed">Breed:</label>
			<input name = "dog_breed" type = "text">
		</div>
		<div>
			<label for="dog_weight">Weigth:</label>
			<input name = "dog_weight" type = "text">
		</div>
		<input type = "submit" value = "Create a dog">	
	</form>
	<hr>
	<form method="post" action = "cat">
		<h2>Create a cat</h2>
		<div>
			<label for="cat_name">Name:</label>
			<input name = "cat_name" type = "text">
		</div>
		<div>
			<label for="cat_breed">Breed:</label>
			<input name = "cat_breed" type = "text">
		</div>
		<div>
			<label for="cat_weight">Weight:</label>
			<input name = "cat_weight" type = "text">
		</div>
		<input type = "submit" value = "Create a cat ">	
	</form>
	</div>
</body>
</html>