<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
	<div class="container">
		<div id="msg">
			<c:if test="${not empty subjects}">
				<c:forEach items="${subjects}" var="subject">
					 <h3>${subject.subjectId} || ${subject.subtitle} || ${subject.durationInHours} || ${subject.references}</h3>   
				</c:forEach>
			</c:if>
			
			<c:if test="${not empty books}">
				<c:forEach items="${books}" var="book">
					<h3>${book.bookId} || ${book.title} || ${book.price} || ${book.volume} || ${book.publishDate}</h3>    
				</c:forEach>
			</c:if>		
			<c:if test="${empty books and empty subjects}">
				<h2> No Record Found..</h2>
			</c:if>
		</div>
	</div>
</body>
</html>