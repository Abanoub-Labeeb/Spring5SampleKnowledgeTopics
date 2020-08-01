<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit Full Car</title>
</head>
<body>
<form:form action="viewcarfull" modelAttribute="car">
Type (Model) :<form:input path="model"/> <br/>
              <form:errors path="model" cssStyle="color:red;"></form:errors>
<br/>
Body Style   : 
<form:radiobutton path="type" value="Sedan"/> Sedan
<form:radiobutton path="type" value="HatchBack"/> HatchBack
<br/>
Engine :
<form:radiobuttons path="engine" items="${engines}"/> <br/>
Country : 
<form:select path="country">
<form:option value="USA" label="United States"></form:option>
<form:option value="Egypt"></form:option>
</form:select>
<br/>

Wheel Position :
<form:select path="wheelPos" items="${wheelpos}" />
<br/>

Free Options:
Gold Color <form:checkbox path="freeOptions" value="Gold Color"/>
V Shape Plate <form:checkbox path="freeOptions" value="V Shape Plate"/>
<br/>

Paid Options:
<form:checkboxes items="${paidoptions}" path="paidOptions"/>

<br/>
Extra Info :
<form:textarea path="extraInfo"/>
<br/>
<input type="submit" value="Submit"> <br/>
<input type="submit" value="Submit with hibernate validation" formaction="hibernatevalidateandviewcarfull">
</form:form>
</body>
</html>