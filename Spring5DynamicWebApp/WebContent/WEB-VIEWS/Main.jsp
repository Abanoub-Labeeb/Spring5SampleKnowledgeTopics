<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page - Cars</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/files/css/style.css">
</head>
<body>
Submit Your Wish

<form action="displayCarSubmitted">
<!-- HTML Validator -->
Type  :  <input type="text" name="type" required="true" placeholder="Enter Type"> <br/>
Style :  <input type="text" name="style"> <br/>
<input type="submit" value="Submit Car 1">
<!-- Submit Car 2 will not call the action="displayCarSubmitted" of the form but formaction="displayCarSubmitted2" -->
<input type="submit" formaction="displayCarSubmitted2" value="Submit Car 2">
<input type="submit" formaction="displayCarSubmitted3" value="Submit Car 3">
</form>
</body>
</html>