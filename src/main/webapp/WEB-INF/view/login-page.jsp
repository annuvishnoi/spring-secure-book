<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="secure" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Instead of using html form tag we use spring framework tag lib  
	1. action : same as defined in config file
	2. method : POST
	3. user name text : username
	4. Password : password
#need to add context path	
-->

<!--
 Form Tags
  <secure:form action="${pageContext.request.contextPath}/checkUser" method="POST">
 -->
<core:if test="${not empty firstname}">
	<h2>User added successfully.</h2>
</core:if>
<form action="${pageContext.request.contextPath}/checkUser" method="POST">
	
	<core:if test="${param.error !=null}">
		<i>Sorry! You entered invalid username/password</i>
	</core:if>
	
	<core:if test="${param.logout !=null}">
		<i>You have been logged out</i>
	</core:if>
	
	<!-- Support for resolve CSRF attack -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<p>
	User Name :	<input type="text" name="username">
	</p>
	
	<p>
	Password  :	<input type="password" name="password">
	</p>
	
	<input type="submit" value="Login" />
	<a href="${pageContext.request.contextPath}/register">Register</a>
	<!-- 
	</secure:form>
	 -->
</form>

</body>
</html>