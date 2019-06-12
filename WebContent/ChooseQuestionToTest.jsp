<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>Tworzenie nowego testu - wybieranie pytań</title>
</head>
<body>
<div class="wrapper">

	<div class="header">
		<div class="logo">
			<span style="color: #c34f4f">Bash</span>ownik
			<div style="clear:both;"></div>
		</div>
	</div>
	
	<!-- To jest tak jakby deklaracja zmiennej Test -->
	<jsp:useBean id="Test" class="database.entities.Test"
		scope="session"></jsp:useBean>
		
	<!-- Użycie tagu jsp:setProperty. Tag ten umieszcza wszystkie parametry
	przesyłane z innych plików jsp pasujące do obiektu o nazwie user. Jeśli
	parametry te nie będą się zgadzać, tomcat wyrzuci wyjątkiem -->
	
	
	<!-- Ponowne użycie tagu jsp:useBean ładujący źródło danych. -->
	<jsp:useBean id="ManageTest"
		class="Manage.ManageTest" scope="session"></jsp:useBean>
		
	<jsp:useBean id="Question" class="database.entities.Question" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="Question" />
		
	
	<!-- Ponowne użycie tagu jsp:useBean ładujący źródło danych. -->
	<jsp:useBean id="ManageQuestion" class="Manage.ManageQuestion" scope="session"></jsp:useBean>
	
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

		<center>
				<table>
					<tr>
						<th>ID  </th>
						<th>Pytanie  </th>
						<th>Dodaj pytanie do testu  </th>
			        
			        <c:forEach items="${ManageQuestion.ListQuestions()}" var="Question">
			        	<tr>
			        		<td>${Question.questionID}</td>
			                <td>${Question.question}</td>
<%-- 			                <td>${Question.answers}</td> --%>
							<td></td>
							<form action="AddQuestionToTest">
		        				<td><input type="submit" value="Dodaj pytanie">  </td>
		        				<input type="hidden" name="question_ID" value=${Question.questionID} />
		        				<input type="hidden" name="test_ID" value=<%= request.getAttribute("testID") %> /> <!-- zobaczyć czy dobrze się wysyłą -->
							</form>
			        	</tr>
					</c:forEach>
				</table>
		</center>
		<center>
			<form action="CreateNewTest.jsp">
				<input type="submit" value="Utwórz test">
			</form>
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