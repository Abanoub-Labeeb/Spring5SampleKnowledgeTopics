<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Car Full</title>
</head>
<body>
Type (Model) :  ${car.model}  <br/>
Body Style (Type) :  ${car.type} <br/>
Engine :  ${car.engine} <br/>
Country :  ${car.country} <br/>
Wheel Position :  ${car.wheelPos} <br/>
Free Options :
<ul>
<c:forEach items="${car.freeOptions}" var="freeOption" >
  <li>${freeOption}</li>
</c:forEach>
</ul>
<br/>
Paid Options :
<ul>
<c:forEach items="${car.paidOptions}" var="paidOption">
  <li>${paidOption}</li>
</c:forEach>
</ul>
<br/>
Extra Info. : ${car.extraInfo} <br/>
</body>
</html>