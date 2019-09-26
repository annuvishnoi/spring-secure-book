<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<div class="container">
	<div id="msg">
		<c:if test="${not empty subject}">
		   <h2>Subject added successfully</h2>
		   <h3>${subject.subjectId} || ${subject.subtitle} || ${subject.durationInHours}</h3>   
		</c:if>
		
		<c:if test="${not empty book}">
		   <h2>Book added successfully</h2>
		   <h3>${book.bookId} || ${book.title} || ${book.price} || ${book.volume} || ${book.publishDate}</h3>   
		</c:if>		
	</div>
</div>
</body>
</html>