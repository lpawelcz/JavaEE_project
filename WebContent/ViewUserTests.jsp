<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>Użytkownik</title>
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
		<jsp:setProperty property="*" name="ManageTest" />
		
	<jsp:useBean id="User" class="database.entities.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="User" />
	
	<jsp:useBean id="Test" class="database.entities.Test" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="Test" />
	
	<!-- session.getAttribute("session") -->
	<% if(session.getAttribute("session") == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testów</a></li>
					<li><a href="http://localhost:8080/Bashownik/Logout.jsp">Wyloguj</a></li>
			</ol>
		</div>
		
		Testy stworzone przez użytkownika: <br />
		<center>
				<table>
					<tr>
						<th>ID  </th>
						<th>Temat  </th>
						<th>Opis  </th>
			        
			        <c:forEach items="${ManageTest.ListUserTests(User.userID)}" var="Test">
			        	<tr>
			        		<td>${Test.testID}</td>
			                <td>${Test.description.topic}</td>
			                <td>${Test.description.description}</td>
							<td></td>
			        	</tr>
					</c:forEach>
				</table>
		</center>
	
		
	<% } 
	else { %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
			</ol>
		</div>
		<center>Do stworzenia nowego testu proszę być zalogowanym.</center>
	<% } %>
</div>

</body>
</html>