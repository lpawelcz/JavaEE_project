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
	
	<title>Podsumowanie rozwiązanego testu</title>
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
			</ol>
		</div>
	
		<center>Test zakończony, oto wyniki</center>
		ID testu: ${RestID} <br />
		Liczba Pytań: ${Questions.size()} <br />
		Uzyskany wynik: ${Result.points} <br />
		Procent opanowania materiału: ${Result.prcntgOfUnderstanding} <br />
		<center>
	<form method="post" action="ProcessCompletedTest">		        
				<table>
<!-- 						<th>ID  </th> -->
<!-- 						<th>Pytanie  </th> -->
<!-- 						<th>Odpowiedzi  </th> -->
<!-- 						<th>Odpowiedź  </th> -->
<!-- 						<th>Sprawdź  </th> -->
			        <c:forEach items="${Questions}" var="QuestionInTest" varStatus="loop1">
			        	<p>${loop1.index+1}.${QuestionInTest.question}</p>			<%-- numer pytania w teście --%>
						<c:choose>
   							<c:when test="${QuestionMap[loop1.index]}">
   								Odpowiedz poprawna
    						</c:when>    
    						<c:otherwise>
			        			Odpowiedz błędna
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