<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta charset="UTF-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	
	<title>Pytania</title>
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
	<jsp:useBean id="QuestionInTest" class="database.entities.QuestionInTest" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="QuestionInTest" />
	
	<jsp:useBean id="Question" class="database.entities.Question" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="Question" />
		
	<jsp:useBean id="test" class="database.entities.Test" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="test" />
	
	<!-- Ponowne użycie tagu jsp:useBean ładujący źródło danych. -->
	<jsp:useBean id="ManageQuestionInTest" class="Manage.ManageQuestionInTest" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="ManageQuestionInTest" />
	
	
	<% if(session.getAttribute("session") == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testów</a></li>
					<li><a href="http://localhost:8080/Bashownik/Logout.jsp">Wyloguj</a></li>
			</ol>
		</div>
	
		<center>Pytania: </center>
		Test ID: ${test.testID} <br />
		Pytania: ${ManageQuestionInTest.ListTestQuestionInTest(test.testID)} <br />
		Rozmiar: ${ManageQuestionInTest.ListTestQuestionInTest(test.testID).size()} <br />
		<center>
				<table>
					<tr>
						<th>ID  </th>
						<th>Pytanie  </th>
						<th>Odpowiedzi  </th>
						<th>Odpowiedź  </th>
						<th>Sprawdź  </th>
			        
			        <c:forEach items="${ManageQuestionInTest.ListTestQuestionInTest(test.testID)}" var="QuestionInTest">
			        	<tr>
			        		<td>${QuestionInTest.question.questionID}</td>
			                <td>${QuestionInTest.question.question}</td>
 			                <td>${QuestionInTest.question.getAnswers(QuestionInTest.question.questionID)}</td> 
 			                <td><input type="text" name="odpowiedz" />  </td> 
 		        			<td><input type="submit" value="Sprawdz odpowiedz">  </td> 
			        	</tr>
					</c:forEach>
				</table>
		</center>
	<% } 
	else { %>
		<div class="nav">
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
			</ol>
		</div>
		<center>Proszę się zalogować.</center>
	<% } %>
	
	
</div>

</body>
</html>