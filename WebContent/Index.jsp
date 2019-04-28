<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <center> <font color="gray" size="7"> Hello World! </font> </center>

<%
    // To jest skryptlet.  Zauważ, że zmienna
    // "date" zadeklarowana w pierwszym wbudowanym
    // wyrażeniu jest dostępna również w tym późniejszym.
    System.out.println( "Test helloworld" );
    java.util.Date date = new java.util.Date();
%>
Obecnie mamy <%= date %>
</body>
</html>