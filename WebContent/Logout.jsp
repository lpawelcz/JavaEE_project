<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<meta charset="utf-8">
	<title>Wylogowano</title>
</head>
<body>
<div class="wrapper">

	<div class="header">
		<div class="logo">
			<span style="color: #c34f4f">Bash</span>ownik
			<div style="clear:both;"></div>
		</div>
	</div>

<div class="content">

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
		
		<center>Nastąpiło wylogowanie.</center>
		
		<%
			session.setAttribute("session","False"); 
			session.setAttribute("userID", "");
			session.setAttribute("userName", "");
		%>

		
</div>
</div>
</body>
</html>