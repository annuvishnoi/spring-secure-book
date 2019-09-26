<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
		<div class="form-area">
			<forms:form action="savesubject" modelAttribute="subject">
				<br style="clear:both">
				<h3 style="margin-bottom: 25px;">Subject Form</h3>
				<div class="form-group">
					<forms:input required="required" class="form-control"
						placeholder="Subject Title" minlength="3" maxlength="100"
						path="subtitle" />
				</div>
				<div class="form-group">
					<forms:input class="form-control"
						required="required" placeholder="Duration In Hours" path="durationInHours" title="Must be number"/>
				</div>						
				<input type="submit" value="Add Subject" class="btn btn-primary">
			</forms:form>
		</div>
	</div>
</body>
</html>