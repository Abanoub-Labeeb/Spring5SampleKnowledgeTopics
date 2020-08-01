<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submitted Car 2</title>
</head>
<body>

Type (Model) :  ${type}  <br/>
Body Style (Type) :  ${style} <br/>
Today is : ${today} <br/>

_______________Car List_____________________ <br/>
Car List : ${cars} <br/>
<c:forEach var="car" items="${cars}">
	${car} <br/>
</c:forEach>
 
</body>
</html>