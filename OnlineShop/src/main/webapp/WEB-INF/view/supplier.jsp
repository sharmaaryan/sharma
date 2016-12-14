 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/responsive-slider.js"></script>
<script

	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
<meta name="viewport"content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>supplier</title>
<style>
body{
background-image: url("resources/image/back10.jpg");
background-size: cover;
background-repeat: no-repeat;

}
</style>
</head>
<body>


</head>
<body>


<jsp:include page="header.jsp"></jsp:include>


${msg}
<h1><font color="orange"> Add a supplier</font></h1>

	<c:url var="addAction" value="/manage_supplier_add"></c:url>

	<form:form action="${addAction}" commandName="supplier" method="post" >
		<table>
			<tr>
				<td><form:label path="id"><spring:message text="ID" /></form:label></td>
				
					<c:if test="${!empty supplier.id}">
						<td><form:input path="id" value="${supplier.id}" readonly="true" /></td>
					</c:if>

					<c:if test="${empty supplier.id }">
						<td><form:input path="id" pattern =".{4,7}" required="true" title="id should contains 4 to 7 characters" /></td>
					</c:if>
				
				</tr>
			<tr>
				<td><form:label path="name"><spring:message text="Name" /></form:label></td>
				<td><form:input path="name" value="${supplier.name}" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="address"><spring:message text="address" /></form:label></td>
				<td><form:input path="address" value="${supplier.address}" required="true" /></td>
			</tr>
			
			
			<tr>
				<td colspan="2">
					<c:if test="${!empty supplier.name}">
						<button type="submit" class="btn btn-primary">Update supplier</button>
					</c:if> <c:if test="${empty supplier.name}">
						<button type="submit" class="btn btn-primary">Add supplier</button>
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3><font color="orange"> supplier List</font></h3>
	<c:if test="${!empty supplierlist}">
		<table class="tg">
			<tr>
				<th width="80">supplier ID</th>
				<th width="120">supplier Name</th>
				<th width="120">supplier address</th>
				
		
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${supplierlist}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>
					
					<td><a href="manage_supplier_edit-${supplier.id}"><button type="button">Edit</button></a></td>
					<td><a href="manage_supplier_delete-${supplier.id}"><button type="button">Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>










