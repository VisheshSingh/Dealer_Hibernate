<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Details</title>
</head>
<body>

	<jsp:useBean id="u" class="dealership.User" scope="session"></jsp:useBean> 
	<!-- SET PROPERTY, IF * then it will take all properties--> 
	<jsp:setProperty property="*" name="u"/>  
	 
	<jsp:forward page="Loginservlet" /> 
</body>
</html>