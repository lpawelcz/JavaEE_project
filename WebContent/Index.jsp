<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>Strona glowna</title>
</head>
<body>
<div class="wrapper">

	<div class="header">
		<div class="logo">
			<span style="color: #c34f4f">Bash</span>ownik
			<div style="clear:both;"></div>
		</div>
	</div>
	
	<div class="nav">
		<ol>
				<li><a href="http://localhost:8080/Bashownik/">Strona glowna</a></li>
				<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
				<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
		</ol>
	</div>

  <center> <font color="gray" size="7"> Hello World! </font> </center>

<%
    // To jest skryptlet.  Zauważ, że zmienna
    // "date" zadeklarowana w pierwszym wbudowanym
    // wyrażeniu jest dostępna również w tym późniejszym.
    System.out.println( "Test helloworld" );
    java.util.Date date = new java.util.Date();
%>
Obecnie mamy <%= date %>
</div>
</body>
</html>