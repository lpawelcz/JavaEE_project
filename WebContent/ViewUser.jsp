<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>Tworzenie nowego pytania</title>
</head>
<body>
<div class="wrapper">

	<div class="header">
		<div class="logo">
			<span style="color: #c34f4f">Bash</span>ownik
			<div style="clear:both;"></div>
		</div>
	</div>
	
	<!-- Ponowne użycie tagu jsp:useBean ładujący źródło danych. -->
	<jsp:useBean id="ManageTest"
		class="Manage.ManageTest" scope="session"></jsp:useBean>
	
	<!-- session.getAttribute("session") -->
	<% if("TRUE" == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona glowna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testow</a></li>
			</ol>
		</div>
	
	<div class="content">
		Informacje o użytkowniku: <br />
		<form action="CreateQuestionNew">
			<input type="hidden" name="user_ID" value=<%=session.getAttribute("userID") %> /><br />  
			<input type="submit" value="Wyświetl zrobione testy">
		</form>
		
		<form action="ViewUserTests.jsp">
			<input type="hidden" name="user_ID" value=<%=session.getAttribute("userID") %> /><br />  
			<input type="submit" value="Wyświetl stworzone testy">
		</form>
		
		<form action="CreateQuestionNew">
			<input type="hidden" name="user_ID" value=<%=session.getAttribute("userID") %> /><br />  
			<input type="submit" value="Wyświetl stworzone pytania">
		</form>
	</div>
	
		
	<% } 
	else { %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona glowna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
			</ol>
		</div>
		<center>Do stworzenia nowego testu proszę być zalogowanym.</center>
	<% } %>
</div>

</body>
</html>