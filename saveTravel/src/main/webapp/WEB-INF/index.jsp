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
<title>Homepage</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
		    <tr>
		        <th>Expense</th>
		        <th >Vendor</th>
		        <th >Amount</th>
		        <th >Action</th>
		        <th>Delete</th>
		     </tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><a href="/show/${expense.id}"><c:out value="${expense.name}"/></a> </td>
					<td> <c:out value="${expense.vendor}"/> </td>
					<td> <c:out value="${expense.amount}"/> </td>
					<td> <a href="/edit/${expense.id}"> Edit </a> </td>
					<td> 
						<form action="/delete/${expense.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Add an expense:</h1>
	<form:form action="/add" mode="post" modelAttribute="expense">
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