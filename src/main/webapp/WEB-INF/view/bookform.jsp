<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="forms" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.red {
	color: red;
}

.form-area {
	background-color: #FAFAFA;
	padding: 10px 40px 60px;
	margin: 10px 0px 60px;
}
</style>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${fn:length(subjects) == 0}">
				<div id="msg">
					<h2>No Subject available. Please add the subject first.</h2>
				</div>

			</c:when>
			<c:otherwise>
				<div class="form-area">
					<forms:form action="savebook" modelAttribute="book">
						<br style="clear: both">
						<h3 style="margin-bottom: 25px;">Book Form</h3>
						<div class="form-group">
							<forms:input required="required" class="form-control"
								placeholder="Book Name" minlength="3" maxlength="100"
								path="title" />
						</div>
						<div class="form-group">
							<forms:input class="form-control"
								required="required" placeholder="Price" path="price"
								title="Must be number" />
						</div>
						<div class="form-group">
							<forms:input class="form-control"
								required="required" placeholder="Volume" path="volume"
								title="Must be number" />
						</div>
						<div class="form-group">
							<forms:input type="date" class="form-control" required="required"
								placeholder="Publish Date" path="publishDate" />
						</div>

						<div class="form-group">
							<forms:select path="selectedSubject" class="form-control">
								<c:forEach items="${subjects}" var="subject">
									
									<forms:option value="${subject.subjectId}">
										<c:out value="${subject.subtitle}" />
									</forms:option>
								</c:forEach>
							</forms:select>
							<%-- <forms:select path="subject" class="form-control" itemValue="subjectId" itemLabel="subtitle" items="${subjects}"/> --%>
						</div>


						<input type="submit" value="Add Book" class="btn btn-primary">

					</forms:form>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
</body>

</html>