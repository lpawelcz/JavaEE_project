<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>zapraszam na tets</title>
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
	<!-- Użycie tagu jsp:useBean. Tag ten szuka obiektu klasy User z pakiecie
	javastart.jspexample.model w sesji użytkownika. Jeśli znajdzie, to go 
	wykorzysta, jeśli nie stworzy nowy obiekt klasy user o nazwie "user"-->
	<jsp:useBean id="Test" class="database.entities.Test"
		scope="session"></jsp:useBean>

	<!-- Użycie tagu jsp:setProperty. Tag ten umieszcza wszystkie parametry
	przesyłane z innych plików jsp pasujące do obiektu o nazwie user. Jeśli
	parametry te nie będą się zgadzać, tomcat wyrzuci wyjątkiem -->
	<jsp:setProperty property="*" name="Test" />
	
	<jsp:useBean id="dataSource"
		class="main.DataSource" scope="session"></jsp:useBean>
		
	<jsp:useBean id="ManageUser"
		class="Manage.ManageUser" scope="session"></jsp:useBean>

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
		
				<table>
					<tr>
						<th>Twórca</th>
						<th>Temat</th>
						<th>Opis</th>
						<th>Ilość pytań</th>
						<th></th>
					</tr>

			        <tr>
			        	<td>${Test.author.name}</td>
			        	<td>${Test.description.topic}</td>
			        	<td>${Test.description.description}</td>
			        </tr>

				</table>
				
				<tr>
					<br />
					<br />
					<td><a href="SignUpForTest?user_ID=<%=session.getAttribute("userID").toString()%>&test_ID=${Test.testID}">Rozpocznij test.</a></td>
						<%-- <td>${Test.testID}</td> --%> 
				</tr>
		<!-- if(session.getAttribute("userID").toString() != "") -->		
	<% } 
	else { %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
			</ol>
		<center>Proszę się zalogować.</center>
	<% } %>
</div>
</div>
</body>
</html>