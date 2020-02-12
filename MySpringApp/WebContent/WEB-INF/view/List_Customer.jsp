<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>

	</div>
	<div id="container">
		<div id="content">
		<input type="button" value="Add Customer"
				   onclick="window.location.href='addForm'; return false;"
				   class="add-button"
			/>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				
				<c:forEach var="temp" items="${customers}">
				
				<c:url var="updatelink" value="/customer/updateForm">
				<c:param name="customerId" value="${temp.id}"></c:param>	
				</c:url>
				
				<c:url var="deletelink" value="/customer/deleteCustomer">
				<c:param name="customerId" value="${temp.id}"></c:param>	
				</c:url>
					<tr>
						<td>${temp.firstName}
						<td>
						<td>${temp.lastName}
						<td>
						<td>${temp.email}
						<td>
						<td><a href="${updatelink}">update</a>|<a
							href="${deletelink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer ?')))return false">delete</a>
						<td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>