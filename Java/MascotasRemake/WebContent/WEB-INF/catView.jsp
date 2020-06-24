<%@page import="com.codingdojo.web.models.Cat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cat</title>
</head>
<body>
	<h1>Congratulations : You created a cat</h1>
	<div class="card m-4 p-3 bg-dark">
		<h4 class= "text-white">
		<c:out value="${cat.showAffection()}"/>
		</h4>
	</div>
	<div class="text-center img-fluid img-thumbnail rounded mx-auto d-block">
	<img style="width:300px" alt="" src="https://i.redd.it/xc6w46jbg4oz.jpg">
	</div>
</body>
</html>
