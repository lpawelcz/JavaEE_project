<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>Potwierdzenie rejestracji</title>
</head>
<body>
<div class="wrapper">
	<div class="header">
		<div class="logo">
			<span style="color: #c34f4f">Bash</span>ownik
			<div style="clear:both;"></div>
		</div>
	</div>
	
	<div class="nav">
		<ol>
				<li><a href="http://localhost:8080/Bashownik/">Strona glowna</a></li>
				<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
				<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
		</ol>
	</div>
<div class="content">
<form method="post" action="Login.jsp">
	<jsp:useBean id="user" class="database.entities.User"
		scope="session"></jsp:useBean>

	<jsp:setProperty property="*" name="user" />

	<jsp:useBean id="dataSource"
		class="main.DataSource" scope="session"></jsp:useBean>

	<!-- Wyświetlenie nazwy użytkownika. -->
	Nazwa: <%= user.getName() %><br />
	pass: <%= user.getPassword() %><br />

	<!-- Logika sprawdzająca poprawność parametrów logowania. -->
	<% 

		dataSource.register(user.getName(), user.getPassword());
	%>
	
	<form action="http://localhost:8080/Bashownik/Login.jsp">
	<input type="submit" value="Login" /></form>
</form>
</div>
</div>
</body>
</html>