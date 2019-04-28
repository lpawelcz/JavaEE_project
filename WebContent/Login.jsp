<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
  <form method="post" action="Validate.jsp">
        Podaj numerek: <br />
        <input type="number" name="userID" /><br /> 
        Podaj swój login: <br />
        <input type="text" name="name" /><br /> 
        Podaj swoje hasło: <br />
        <input type="text" name="password" /><br /> 
        <input type="submit" value="zaloguj">
    </form>
</body>
</html>