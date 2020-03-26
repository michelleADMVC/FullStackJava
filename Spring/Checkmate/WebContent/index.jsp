<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkboard</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
int h = 0;
int w = 0;
String hParameter = request.getParameter("h");
String wParameter = request.getParameter("w");
if(hParameter != null){
	h = Integer.parseInt(hParameter);
}
if(wParameter != null){
	w = Integer.parseInt(wParameter);
}
int[][] checkboard = new int[w][h];

%>
<div class= "title">

<h1>CheckBoard </h1>
<%if(h == 0 && w== 0){%>
<h3>Please enter parameters in the address bar</h3>
<h4>Example : /index.jsp?h=10&w=10</h4>
<%}else{%>
<h2>Height = <%=h %> Width = <%=w %></h2>
<%} %>
</div>
<div class="container">
	<div class= "checkboard">
	<%
	boolean colorAux = false; 
	for (int i = 0; i < checkboard.length; i++){%>
		<div class= "fila">
			<%
			if(h%2 == 0){
				if(!colorAux ){%>
					<div class="block color1"></div>
					<%colorAux = false;
				}else{%>
					<div class="block color2"></div>
					<%colorAux = true;
			}}else{
				if(colorAux ){ %>
				<div class="block color1"></div>
				<%colorAux = false;
			}else{%>
				<div class="block color2"></div>
				<%colorAux = true;
			}}%>
			<% for (int j = 1; j < checkboard[i].length; j++) {%>
			<%if(colorAux){ %>
			<div class="block color1"></div>
			<%colorAux = false;
			}else{%>
			<div class="block color2"></div>
			<%colorAux = true;
			}%>
			<%}%>
		</div>
					
	<%}%>
	</div>
	
</div>
</body>
</html>

