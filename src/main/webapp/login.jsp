<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<!-- Creating an instance of user class with instance name 'user' -->
	<!-- Establishing bean connection to forward it to the Servlet-->
	<jsp:useBean id="user" class="dealership.User" scope="session"></jsp:useBean> 
	<!-- SET PROPERTY, IF * then it will take all properties--> 
	<jsp:setProperty property="*" name="user"/>  
	  
<!-- 	Record:<br>   -->
<%-- 	<jsp:getProperty property="username" name="user"/><br>   --%>
<%-- 	<jsp:getProperty property="password" name="user"/><br> --%>
	
	<jsp:forward page="Frontservlet" />  
</body>
</html>