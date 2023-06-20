<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add a new Ninja</h1>
	<form:form action="/ninjas/add" mode="post" modelAttribute="ninja">
		<div>
			<form:label path="dojo"> Dojo: </form:label>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${ dojo.id }"><c:out value="${dojo.name}"/></form:option>
				</c:forEach>
			</form:select>
			<form:errors path="dojo" class="text-danger"/>
		</div>
		<div>
			<form:label path="first_name"> First Name: </form:label>
			<form:input path="first_name"/>
			<form:errors path="first_name" class="text-danger"/>
		</div>
		<div>
			<form:label path="last_name"> Last Name: </form:label>
			<form:input path="last_name"/>
			<form:errors path="last_name" class="text-danger"/>
		</div>
		<div>
			<form:label path="age"> Age: </form:label>
			<form:input path="age"/>
			<form:errors path="age" class="text-danger"/>
		</div>
		<div>
			<input type="submit" value="Create"/>		
		</div>
	</form:form>
</body>
</html>