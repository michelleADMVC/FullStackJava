<%@ page language="java" contentType="text/html;UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Results</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>

<body>
<div class="text-center card mt-3">
	<h1>Submitted info:</h1>
</div>
<div id="app" class="p-5">
	<div class="results card p-3 table-responsive">
		<table class="table table-hover">
		  <tbody>
		    <tr>
		      	<td>Name:</td>
		     	<td><c:out value="${survey.getName()}"/></td>
		    </tr>
		    <tr>
		      	<td>Location:</td>
		      	<td><c:out value="${survey.getLocation()}"/></td>
		    </tr>
		    <tr>
				<td>Favorite Language:</td>
		    	<td><c:out value="${survey.getFavLenguage()}"/></td>
		    </tr>
		    <tr>
				<td>Comment:</td>
		    	<td><c:out value="${survey.getComment()}"/></td>
		    </tr>
		  </tbody>
		</table>
		
	</div>
</div>
<%-- 	private String name; --%>
<%-- 	private String location; --%>
<%-- 	private String favLenguage; --%>
<%-- 	private String comment; --%>
</body>
</html>