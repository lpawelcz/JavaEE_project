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
	<title>Stworzone pytania</title>
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
	<jsp:useBean id="ManageQuestion"
		class="Manage.ManageQuestion" scope="session"></jsp:useBean>
		
	<jsp:useBean id="User" class="database.entities.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="User" />
	
	<!-- session.getAttribute("session") -->
	<% if(session.getAttribute("session") == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona glowna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testow</a></li>
			</ol>
		</div>
		
		Stworzone pytania przez użytkownika: <br />
		<center>
				<table>
					<tr>
						<th>ID  </th>
						<th>Typ pytania  </th>
			        	<th>Pytanie  </th>
			        <c:forEach items="${ManageQuestion.ListUserQuestions(User.userID)}" var="Question">
			        	<tr>
			        		<td>${Question.questionID}</td>
			                <td>${Question.DTYPE}</td>
			                <td>${Question.question}</td>
			        	</tr>
					</c:forEach>
				</table>
		</center>
		
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