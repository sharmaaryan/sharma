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
<title>Product</title>
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
${msg}
<h1>Add a Product</h1>

	<c:url var="addAction" value="/manage_product_add"></c:url>

	<form:form action="${addAction}" commandName="product" method="post" >
		<table>
			<tr>
				<td><form:label path="id"><spring:message text="ID" /></form:label></td>
				<c:choose>
					<c:when test="${!empty product.id}">
						<td><form:input path="id" disabled="true" readonly="true" /></td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id" pattern =".{4,7}" required="true" title="id should contains 4 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<td><form:label path="name"><spring:message text="Name" /></form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="price"><spring:message text="price" /></form:label></td>
				<td><form:input path="price" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="category_id"><spring:message text="id" /></form:label></td>
				<td><form:input path="category_id" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="supplier_id"><spring:message text="id" /></form:label></td>
				<td><form:input path="supplier_id" required="true" /></td>
			</tr>
			
			
			<tr>
				<td colspan="2">
					<c:if test="${!empty product.name}">
						<input type="submit" value="<spring:message text="Update product"/>" />
					</c:if> <c:if test="${empty product.name}">
						<input type="submit" value="<spring:message text="Add product"/>" />
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>product List</h3>
	<c:if test="${!empty productlist}">
		<table class="tg">
			<tr>
				<th width="80">product ID</th>
				<th width="120">product Name</th>
				<th width="120">product price</th>
				<th width="120">category_id</th>
				<th width="120">supplier_id</th>
		
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productlist}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.category_id}</td>
					<td>${product.supplier_id}</td>
					<td><a href="<c:url value='manage_product_edit/${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='manage_product_delete/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>