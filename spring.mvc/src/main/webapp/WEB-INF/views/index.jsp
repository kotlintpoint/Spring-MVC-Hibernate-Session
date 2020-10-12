<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<style>
	.error{color:red}  
</style>
</head>
<body>
<h2>Hello World!</h2>
<h2>Name : ${user.getName()}</h2>
<a href="hello.html">Hello</a> | <a href="welcome.html">Welcome</a>

<%-- <form action="postSubmit.html" method="post">
	First Name : <input name="fname" placeholder="Enter first name"><br>
	Last Name : <input name="lname" placeholder="Enter last name"><br>
	<input type="submit">
</form> --%>

<f:form action="postSubmit.html" method="post" modelAttribute="userData">
<div>
	<f:errors path="name" cssClass="error"></f:errors><br>
	<f:errors path="age"  cssClass="error"></f:errors><br>
	<f:errors path="email"  cssClass="error"></f:errors><br>
</div>
	Name : <f:input path="name"/><br><br>
	Age : <f:input path="age"/><br><br>
	Email : <f:input path="email"/><br><br>
	
	<input type="submit" />
</f:form>
</body>
</html>
