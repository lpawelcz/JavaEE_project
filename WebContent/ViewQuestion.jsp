<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
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
	
	<jsp:useBean id="Answer" class="database.entities.Answer" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="Answer" />
	
	
	<% if(session.getAttribute("session") == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testów</a></li>
					<li><a href="http://localhost:8080/Bashownik/Logout.jsp">Wyloguj</a></li>
			</ol>
		</div>
	
		<center>Powodzenia! </center>
		ID testu: ${test.testID} <br />
		Liczba Pytań: ${ManageQuestionInTest.ListTestQuestionInTest(test.testID).size()} <br />
		<center>
	<form method="post" action="ProcessCompletedTest">		        
				<table>
<!-- 						<th>ID  </th> -->
<!-- 						<th>Pytanie  </th> -->
<!-- 						<th>Odpowiedzi  </th> -->
<!-- 						<th>Odpowiedź  </th> -->
<!-- 						<th>Sprawdź  </th> -->
			        <c:forEach items="${ManageQuestionInTest.ListTestQuestionInTest(test.testID)}" var="QuestionInTest" varStatus="loop1">
<%-- 			        <p>${QuestionInTest.question.questionID}.${QuestionInTest.question.question}</p> 		<%--	ID testu													--%>
			        	<p>${loop1.index+1}.${QuestionInTest.question.question}</p>			<%-- numer pytania w teście --%>
						<c:choose>
   							<c:when test="${QuestionInTest.question.DTYPE == '2'}">
   								odp: <input type="text" name="${QuestionInTest.question.questionID}" />
    						</c:when>    
    						<c:otherwise>
			        			<c:forEach items="${QuestionInTest.question.getAnswers(QuestionInTest.question.questionID)}" var="Answer" varStatus="loop2">
									<input type="radio" name="${QuestionInTest.question.questionID}" value="${QuestionInTest.question.correctID}" >${Answer.answer}
								</c:forEach> 
									<input type="radio" name="${QuestionInTest.question.questionID}" value="-1" checked="checked" style="display:none" >${Answer.answer}
        						<br />
    						</c:otherwise>
						</c:choose>		        	
						<br><br>
					</c:forEach>
				</table>
				<br><br><br><br>
				<input type="hidden" name="testID" value="${test.testID}" />
				<td><input type="submit" value="Prześlij odpowiedzi">  </td>
	</form>
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