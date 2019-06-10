<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>Walidacja</title>
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
	<jsp:useBean id="user" class="database.entities.User"
		scope="session"></jsp:useBean>

	<!-- Użycie tagu jsp:setProperty. Tag ten umieszcza wszystkie parametry
	przesyłane z innych plików jsp pasujące do obiektu o nazwie user. Jeśli
	parametry te nie będą się zgadzać, tomcat wyrzuci wyjątkiem -->
	<jsp:setProperty property="*" name="user" />

	<!-- Ponowne użycie tagu jsp:useBean ładujący źródło danych. -->
	<jsp:useBean id="dataSource"
		class="main.DataSource" scope="session"></jsp:useBean>
		
	<jsp:useBean id="userManage"
		class="Manage.ManageUser" scope="session"></jsp:useBean>

	<% if(session.getAttribute("session") == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/">Strona glowna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testów</a></li>
			</ol>
		</div>
		
		<center>Nastąpiło wylodowanie.</center>
		
		<%
			session.setAttribute("session","False"); 
			session.setAttribute("userID", "");
			session.setAttribute("userName", "");
		%>
	<% } 
	else { %>
	<%
		String result = "";
		System.out.println("User w validate: " + user.getUserID() + " ," + user.getName());
		if(dataSource.userInData(user)) {
			result = "Poprawny użytkownik oraz hasło- ZALOGOWANO";
			session.setAttribute("session","TRUE"); 
			user = userManage.GetUser(user.getName());
			String id = Integer.toString(user.getUserID());
			session.setAttribute("userID", id);
			session.setAttribute("userName", user.getName());
		%>
			<div class="nav">
				<ol>
						<li><a href="http://localhost:8080/Bashownik/">Strona glowna</a></li>
						<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
						<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
						<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testów</a></li>
				</ol>
			</div>
		<% }
		else { %>
			<div class="nav">
				<ol>
						<li><a href="http://localhost:8080/Bashownik/">Strona glowna</a></li>
						<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
						<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
				</ol>
			</div>
			
			<% result = "Dane niepoprawne - BLAD";%>
		<% }%>
		
		<!-- Wyświetlenie nazwy użytkownika. -->
		Nazwa: <%= user.getName() %><br />
		pass: <%= user.getPassword() %><br />
		ID ż: <%= user.getUserID() %><br />
	
		
		<%= result %>
	<% } %>
</div>
</div>
</body>
</html>