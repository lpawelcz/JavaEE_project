<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>Rejestracja</title>
</head>
<body> 
<div class="wrapper">

	<div class="header">
		<div class="logo">
			<span style="color: #c34f4f">Bash</span>ownik
			<div style="clear:both;"></div>
		</div>
	</div>
	
	

	<% if(session.getAttribute("session") == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testów</a></li>
					<li><a href="http://localhost:8080/Bashownik/Logout.jsp">Wyloguj</a></li>
			</ol>
		</div>
		<center>Podczas zalogowanej sesji nie można się zarejestrować.</center>
	<% } 
	else { %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
			</ol>
		</div>
	
		<div class="content">
		  <form method="post" action="SubmitRegistration.jsp">
		        Podaj swoj login: <br />
		        <input type="text" name="name" /><br /> 
		        Podaj swoje haslo: <br />
		        <input type="text" name="password" /><br /> 
		        <input type="submit" value="Zarejestruj">
		    </form>
		 </div>
	<% } %>

	
</div>
</body>
</html>