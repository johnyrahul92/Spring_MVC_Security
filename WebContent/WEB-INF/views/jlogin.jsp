<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Custom Login Page</h1>

<h2>${Meaasge}</h2>
<c:if test="${ not empty errMsg }">
<h2>${errMsg}</h2>
</c:if>
<form action="perform_login" name="myForm" method="post">



UserName : <input type="text" name="username" value="" />
Password : <input type="password" name="password" />

<input type="submit" name="submit" value="login">
</form>
</body>
</html>