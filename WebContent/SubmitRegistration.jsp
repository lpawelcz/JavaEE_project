<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
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
	
	<% if(session.getAttribute("session") == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testów</a></li>
					<li><a href="http://localhost:8080/Bashownik/Logout.jsp">Wyloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/ViewUser.jsp">Profil</a></li>
					<li><a href="http://localhost:8080/Bashownik/CreateNewQuestion.jsp">Nowe pytania</a></li>
					<li><a href="http://localhost:8080/Bashownik/CreateNewTest.jsp">Nowe testy</a></li>
			</ol>
		</div>
	<% } 
	else { %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
			</ol>
		</div>
	<% } %>
	
<div class="content">
<form method="post" action="Login.jsp">
	<jsp:useBean id="user" class="database.entities.User"
		scope="session"></jsp:useBean>

	<jsp:setProperty property="*" name="user" />

	<jsp:useBean id="dataSource"
		class="main.DataSource" scope="session"></jsp:useBean>

	<!-- Wyświetlenie nazwy użytkownika. -->
	Login: <%= user.getName() %><br />
	Hasło: <%= user.getPassword() %><br />

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