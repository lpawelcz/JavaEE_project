<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Login.jsp">
	<jsp:useBean id="user" class="database.entities.User"
		scope="session"></jsp:useBean>

	<jsp:setProperty property="*" name="user" />

	<jsp:useBean id="dataSource"
		class="main.DataSource" scope="session"></jsp:useBean>

	<!-- Wyświetlenie nazwy użytkownika. -->
	Nazwa: <%= user.getName() %><br />
	pass: <%= user.getPassword() %><br />

	<!-- Logika sprawdzająca poprawność parametrów logowania. -->
	<% 

		dataSource.register(user.getName(), user.getPassword());
	%>
	
	<form action="http://localhost:8080/Bashownik/Login.jsp">
	<input type="submit" value="Login" /></form>
	
</form>
</body>
</html>