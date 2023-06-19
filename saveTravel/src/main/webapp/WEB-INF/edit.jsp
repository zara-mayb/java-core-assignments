<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit</title>
</head>
<body>
<div>
	<h1>Edit Expense:</h1>
	<a href="/"> Go Back</a>
</div>
	<form:form action="/edit/${expense.id}" mode="put" modelAttribute="expense">
		<div> 
			<form:label path="name"> Expense Name: </form:label>
			<form:input path="name"/>
		</div>
		<div> 
			<form:label path="vendor"> Vendor: </form:label>
			<form:input path="vendor"/>
		</div>
		<div> 
			<form:label path="amount"> Amount: </form:label>
			<form:input path="amount"/>
		</div>
		<div> 
			<form:label path="description"> Notes: </form:label>
			<form:input path="description"/>
		</div>
		<div>
			<form:errors path="name" class="text-danger"/>
		</div>
		<div>
			<form:errors path="vendor" class="text-danger"/>
		</div>
		<div>
			<form:errors path="amount" class="text-danger"/>
		</div>
		<div>
			<form:errors path="description" class="text-danger"/>
		</div>
		<div>
			<input type="submit" value="Submit"/>
		</div>
	</form:form>
</body>
</html>