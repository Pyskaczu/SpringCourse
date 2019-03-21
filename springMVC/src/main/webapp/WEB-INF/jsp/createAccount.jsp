<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create an account</title>
</head>
<body>

	<h1>Enter account details</h1>
	<!-- Typical http form -->
	<!-- form -->
	<!-- JSP form. Now I can use java classes -->
	<form:form commandName="newAccount" method="post" action="accountCreated">
		<table>
			<tr><td>
				First Name: <form:input path="firstName" type="text" name="firstName"/>
				<form:errors path="firstName" cssClass="error" />
			</td></tr>
			
			<tr><td>
				Last Name: <form:input path="lastName" type="text" name="lastName"/>
				<form:errors path="lastName" cssClass="error" />
			</td></tr>
			
			<tr><td>
				Age: <form:input path="age" type="text" name="age"/>
				<form:errors path="age" cssClass="error" />
			</td></tr>
			
			<tr><td>
				Address: <form:input path="address" type="address" name="address"/>
				<form:errors path="address" cssClass="error" />
			</td></tr>
			
			<tr><td>
				Email: <form:input path="email" type="text" name="email"/>
				<form:errors path="email" cssClass="error" />
			</td></tr>
			
			<tr><td>
				<input type="submit" value="Create  "/>
			</td></tr>
		</table>
	</form:form>

</body>
</html>