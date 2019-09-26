<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="secure"%>
 <%@taglib uri="http://www.springframework.org/security/tags"  prefix="secure_tag"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FSE</title>
<style>
	
	.spancolor {
			color: #3366ff;
		}
	.form-area {
		background-color: #FAFAFA;
		padding: 10px 40px 60px;
		margin: 10px 0px 60px;
	}
</style>
</head>
<body>
	<h1>Menu Page</h1>
	<hr>
	
	<!-- Display the user info -->
	<!-- User info is maintained inside a object principal -->
	User : <secure_tag:authentication property="principal.username"/>
	<br>
	Role(s) : <secure_tag:authentication property="principal.authorities"/>
	<div class="container">
		<div class="form-area">
			<!-- <h2 style="text-align: center;">Menu Page</h2> -->
			<ul style="list-style-type: circle;">
			<secure_tag:authorize access="hasRole('PRINCIPAL')">
				<li><span class = "spancolor"><a href="subject/addsubject"><em>Add a Subject</em></a></span></li>
				<li><span class = "spancolor"><a href="subject/searchsubjectform"><em>Search for a subject</em></span></li>
				
				<li><span class = "spancolor"><a href="subject/deletesubjectform"><em>Delete a Subject</em></span></li>
			</secure_tag:authorize>
			
			<secure_tag:authorize access="hasRole('LIBIARIAN')">
				<li><span class = "spancolor"><a href="book/addbook"><em>Add a Book</em></span></li>
				<li><span class = "spancolor"><a href="book/searchbook"><em>Search for a book</em></span></li>
				<li><span class = "spancolor"><a href="book/deletebookform"><em>Delete a Book</em></span></li>
			</secure_tag:authorize>	
				
			</ul>
		</div>
	</div>
	<secure:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</secure:form>
</body>
</html>