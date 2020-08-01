<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submitted Car</title>
</head>
<body>
<%= " Type : " + request.getAttribute("type") + " - Body Style : " + request.getAttribute("style") %>
</body>
</html>