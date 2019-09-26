<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<div class="container">
	
		<div id="msg">
			<h2>${result}</h2>
		</div>
		<c:if test="${fromSubject}">
			<c:choose>
				<c:when test="${fn:length(subjects) > 0}">
					<h2>Available subjects :</h2>
					<c:forEach items="${subjects}" var="subject">
						<h3>${subject}</h3>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h2>No Subject available</h2>
				</c:otherwise>
			</c:choose>
		</c:if>
			
		
		<c:if test="${fromBook}">
			<c:choose>
				<c:when test="${fn:length(books) > 0}">
					<h2>Available books :</h2>
					<c:forEach items="${books}" var="book">
						<h3>${book}</h3>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<h2>No Book available</h2>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
</body>
</html>