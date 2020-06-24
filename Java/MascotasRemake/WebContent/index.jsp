<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<title>Create a pet</title>
</head>
<body>
	<header class = "text-center bg-dark text-white p-3">
		<h1>Create your pets<span class="material-icons">
		add</span></h1>
		
		
	</header>
	<div class = "row pt-4 container-fluid">
		<div class = "col-1">
		</div>
		<div class = "card col-5 p-3 mr-4">
			<form method="post" class = "form-group" action = "dog">
				<h3>Create a dog</h3>
				<div>
					<label for="dog_name" class="col-form-label">Name:</label>
					<input class="form-control" name = "dog_name" type = "text" required>
				</div>
				<div>
					<label for="dog_breed">Breed:</label>
					<input class="form-control" class="col-form-label" name = "dog_breed" type = "text" required>
				</div>
				<div>
					<label for="dog_weight">Weight:</label>
					<input class="form-control" class="col-form-label" name = "dog_weight" type = "number" placeholder = "lbs"required>
				</div>
				<div>
				<input class="btn btn-primary form-control mt-4" type = "submit" value = "Create a dog">	
				</div>	
			</form>
		</div>
		<div class="card col-5 p-3" >
			<form method="post" class = "form-group" action = "cat">
				<h3>Create a cat</h3>
				<div>
					<label for="cat_name" class="col-form-label" >Name:</label>
					<input class="form-control" name = "cat_name" type = "text" required>
				</div>
				<div>
					<label for="cat_breed" class="col-form-label" >Breed:</label>
					<input class="form-control" name = "cat_breed" type = "text" required>
				</div>
				<div>
					<label for="cat_weight">Weight:</label>
					<input class="form-control"name = "cat_weight" type = "number" placeholder = "lbs" required>
				</div>
				<div>
				<input class="btn btn-primary form-control mt-4" type = "submit" value = "Create a cat">	
				</div>
			</form>
			
		</div>
		<div class = "col-1">
		</div>
	</div>
</body>
</html>