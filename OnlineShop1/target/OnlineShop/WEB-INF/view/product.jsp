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
<jsp:include page="header.jsp"></jsp:include>


</head>
<body>
${msg}
<a href="backToHome">back</a>
<h1>
<font color="red"> Add a Product</font>
</h1>

	<c:url var="addAction" value="/productadd"></c:url>

	 <%-- <form:form action="${addAction}" commandName="product" method="post" > --%>
	 <form:form action="${addaction}" role="form" commandName="product" enctype="multipart/form-data" method="POST">
	
		<table>
			<tr>
				<td><form:label path="product_id"><spring:message text="ID" /></form:label></td>
				
					<c:if test="${!empty product.product_id}">
						<td><form:input cssClass="form-control" path="product_id" value="${product.product_id}" readonly="true" /></td>
					</c:if>

					<c:if test="${empty product.product_id}">
						<td><form:input cssClass="form-control" path="product_id" pattern =".{4,7}" required="true" title="id should contains 4 to 7 characters" /></td>
					</c:if>
			</tr>
				
				
				
			<tr>
			
			<form:input path="product_id" hidden="true"/>
			
				<td><form:label path="product_name"><spring:message text="Name" /></form:label></td>
				<td><form:input path="product_name" cssClass="form-control" value="${product.product_name}" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="product_price"><spring:message text="price" /></form:label></td>
				<td><form:input path="product_price" cssClass="form-control" value="${product.product_price}" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="product_description"><spring:message text="product_description" /></form:label></td>
				<td><form:input path="product_description" cssClass="form-control" value="${product.product_description}" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="size"><spring:message text="size" /></form:label></td>
				<td><form:input path="size" cssClass="form-control" value="${product.size}" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="product_stock"><spring:message text="product_stock" /></form:label></td>
				<td><form:input path="product_stock" cssClass="form-control" value="${product.product_stock}" required="true" /></td>
			</tr>
			<tr>
				<%-- <td><form:label path="category_id"><spring:message text="category_id" /></form:label></td> --%>
				<td><form:label path="category.name"><spring:message text="category" /></form:label></td>
				<td><form:select path="category.name" cssClass="form-control" items="${categoryList}" itemLabel="name" itemValue="name"></form:select></td>
				<%-- <td><form:input path="category_id" required="true" /></td> --%>
			</tr>
			<tr>
				<%-- <td><form:label path="supplier_id"><spring:message text="supplier_id" /></form:label></td>--%>
				<td><form:label path="supplier.name"><spring:message text="supplier" /></form:label></td>
				<td><form:select path="supplier.name" cssClass="form-control"  items="${supplierList}" itemLabel="name" itemValue="name"></form:select></td>
				<%-- <td><form:input path="supplier_id" required="true" /></td> --%>
			</tr>
			<tr>
<!-- //======================FOR IMAGE PRODUCT===================//	 -->		
			<td>Image:</td>
			<td><form:input type="file" value="${product.image}" path="image" required="true"/> </td>
			</tr>
<!-- //==============================================================================// -->
			
			<tr>
				<td colspan="2">
					<c:if test="${!empty product.product_name}">
						<button type="submit" class="btn btn-primary">Update product</button>	`
					</c:if> <c:if test="${empty product.product_name}">
					<button type="submit" class="btn btn-primary">Add product</button>
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>
	<font color="red"> product List</font>
	</h3>
	<c:if test="${!empty productList}">
		<table class="tg">
			<tr>
				<th width="80">product ID</th>
				<th width="120">product Name</th>
				<th width="120">product price</th>
				<th width="120">category_id</th>
				<th width="120">supplier_id</th>
				<th width="120">product_stock</th>
<!--  //==============================ADD IMAGE FOR PRODUCT============// -->
				<th width="120">Image</th>
				  
	<!-- //===============================================================//	 -->
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.product_id}</td>
					<td>${product.product_name}</td>
					<td>${product.product_price}</td>
					<td>${product.category_id}</td>
					<td>${product.supplier_id}</td>
					<td>${product.product_stock}</td>
<!-- //===============ADD IMAGE FOR PRODUCT=============================// -->
<td><img src="resource/image1/${plist.product_id}.jpg" style="width: 100px; height: 150px;"></td>
<!-- //=============================================================================// -->

					<td><a href="manage_product_edit-${product.product_id}"><button type="button">Edit</button></a></td>
					<td><a href="manage_product_delete-${product.product_id}"><button type="button">Delete</button></a></td>
			</c:forEach>
		</table>
	</c:if>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

