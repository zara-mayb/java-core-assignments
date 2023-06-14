<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji!</h1>
		<form action="/omikuji/submit" method="post">
			<div>
				<label class="form-label"> Pick any number from 5 to 25</label>
				<input type= "number" class="form-control" min=5 max=25 name="num"/>
			</div>
			<div>
				<label class="form-label"> Enter the name of any city: </label>
				<input type= "text" class="form-control" name="city"/>
			</div>
			<div>
				<label class="form-label"> Enter the name of any real person: </label>
				<input type= "text" class="form-control" name="person"/>
			</div>
			<div>
				<label class="form-label"> Enter professional endeavor or hobby:</label>
				<input type= "text" class="form-control" name="hobby"/>
			</div>
			<div>
				<label class="form-label"> Enter any type of living thing:</label>
				<input type= "text" class="form-control" name="livingThing"/>
			</div>
			<div>
				<label class="form-label"> say something nice to someone:</label>
				<textarea class="form-control" name="comment" ></textarea>
			</div>
			<p> Send and show a friend </p>
			<input type="submit" class="btn btn-warning" />
		</form>
	</div>
</body>
</html>