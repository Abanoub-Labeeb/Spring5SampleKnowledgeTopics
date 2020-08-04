<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<table border="1" align="left">
	<tr>
		<th>User ID</th>
		<th>Name</th>
		<th>Email</th>
	<tr/>

    <c:forEach items="${users}" var="user">
    <tr>
		<td>${user.userID}</td>
		<td>${user.name}</td>
		<td>${user.email}</td>
	<tr/>
    </c:forEach>
</table>

</body>
</html>