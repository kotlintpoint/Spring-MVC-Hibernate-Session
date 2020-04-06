<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>  
<html>
<style>
	.error{color:red}  
</style>
<body>
<h2>Hello World!</h2>
<a href="welcome">Welcome</a> | <a href="hello">Hello</a>
<hr>
${username }
<hr>
<%-- <form action="userPost" method="post">
	Name : <input name="name"><br>
	Age : <input name="age"><br>
	<input type="submit">
</form> --%>

<f:form action="register" method="post" modelAttribute="userData">
<div>
	<f:errors path="name" cssClass="error"></f:errors><br>
	<f:errors path="age"  cssClass="error"></f:errors><br>
	<f:errors path="email"  cssClass="error"></f:errors><br>
</div>
	Name : <f:input path="name"/><%-- <f:errors path="name" cssClass="error"></f:errors> --%><br>
	Age : <f:input path="age"/><br>
	Email : <f:input path="email"/><br>
	
	<input type="submit" value="Submit">
</f:form>

</body>
</html>
