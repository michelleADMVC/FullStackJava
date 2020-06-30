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
	<title>Team Roster</title>
</head>
<body>
<!-- 	<div class="debug"> -->
<!-- 		<p> -->
<%-- 		Action : <c:out value="${action}"/> --%>
<!-- 		</p> -->
<!-- 		<p> -->
<%-- 		ID : <c:out value="${id}"/> --%>
<!-- 		</p> -->
<!-- 	</div> -->
	<div class="navbar bg-dark text-white">
		<c:if test = "${action.equals('add_team')}">
		<h1>Create a new team</h1>
		</c:if>
		<c:if test = "${action.equals('view_team')}">
		<h1><c:out value="${team.getName()}"/></h1>
		</c:if>
		<div class="action_container">
			<form method="post" action="home" class="form-inline">
	   			 <button class="btn btn-danger" type="submit">Back</button>
	 		</form>
	 		<c:if test = "${action.equals('view_team')}">
			<form method="get" action="players" class="form-inline">
	   			 <button class="btn btn-success" type="submit">Add Player</button>
	 		</form>
			</c:if>
		</div>
	</div>
	<c:if test = "${action.equals('add_team')}">
		<div class="jumbotron">
			<div class="flex_center full ">
				<div class="action_container">
					<form method="post" class ="form-inline">
						<input type="hidden" name="action" value="add_team">
						<input type="text" required class= "form-control mr-3" 
						placeholder="Team name" name="team_name">
						<button class="btn btn-success" type="submit">Add team+</button>
					</form>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test = "${action.equals('view_team')}">
		<c:if test = "${team.totalPlayers() > 0}">
		<div>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">First Name</th>
		      <th scope="col">Last Name</th>
		      <th scope="col">Age</th>
		      <th scope="col" class="">Action</th>
		    </tr>
		  </thead>
		  
		  <tbody>
		   <c:forEach var = "i" begin = "0" end = "${team.totalPlayers() -1}">
		    <tr>
		      <th scope="row"> <c:out value="${team.getPlayer(i).getName()}"/></th>
		      <td> <c:out value="${team.getPlayer(i).getLastName()}"/></td>
		      <td> <c:out value="${team.getPlayer(i).getAge()}"/></td>
		      <td>
				<div>
					<form method="post" action="players">
						<input type="hidden" name="action" value="delete_player">
						<input type="hidden" name="player_id" value=<c:out value="${i}"/>>
						<input type="hidden" name="team_id" value=<c:out value="${id}"/>>
							<button type="submit" class="btn btn-outline-danger">Delete</button>
					</form>
				</div>
		      </td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		</div>
		</c:if>
		<c:if test = "${team.totalPlayers() == 0}">
			<div class="p-4 text-center">
				<h2>No players founded</h2>
			</div>
		</c:if>
	</c:if>
	
</body>
</html>