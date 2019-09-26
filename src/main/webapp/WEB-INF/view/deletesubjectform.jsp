<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Subject Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
	.form-area {
		background-color: #FAFAFA;
		padding: 10px 40px 60px;
		margin: 10px 0px 60px;
	}
</style>
</head>

<body>
	<div class="container">
		<div class="form-area">
			<forms:form action="deleteSubject" method="GET">
				<br style="clear:both">
				<h3 style="margin-bottom: 25px;">Delete Subject Form</h3>
				<div class="form-group">
					<input required="required" class="form-control"
						placeholder="Enter Subject Title" minlength="3" maxlength="100" name="subjectTitle"/>
				</div>
				<input type="submit" value="Delete Subject" class="btn btn-primary">
			</forms:form>
		</div>
	</div>
</body>
</html>