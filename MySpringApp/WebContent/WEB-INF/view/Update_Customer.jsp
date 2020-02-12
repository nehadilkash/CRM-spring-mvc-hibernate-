<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>update-customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>

	</div>
	<div id="container">
		<h3>Update Customer</h3>
		<form:form action="updateCustomer" modelAttribute="customer">
		
		<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label> FirstName:</label>
						</td>
						<td><form:input path="firstName" />
						</td>
					</tr>
					<tr>
						<td><label> LastName:</label>
						</td>
						<td><form:input path="lastName" />
						</td>
					</tr>
					<tr>
						<td><label> Email:</label>
						</td>
						<td><form:input path="email" />
						</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="submit">
		</form:form>
		
		<div style="clear; both;"></div>
		
		<a href="${pageContext.request.contextPath}/customer/list">back to list</a>
		
	</div>
</body>
</html>