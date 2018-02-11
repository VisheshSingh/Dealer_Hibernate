<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success! LOGIN</title>
</head>
<body>
	<jsp:useBean id="u" class="dealership.User" scope="session"></jsp:useBean>
	Hi, <jsp:getProperty property="username" name="u"/><br/>
	You are logged in!
	<form action="Carservlet" method="post">
		If you like to see cars<br/>
		<input type="submit" value="Visit Catalog"/>
	</form>
</body>
</html>