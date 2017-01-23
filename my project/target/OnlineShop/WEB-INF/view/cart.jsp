<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Cart</title>
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

<font color="red"> My Cart</font>
</h1>

	<c:url var="addAction" value="/cartadd"></c:url>

	 
	 <form:form action="${addAction}" role="form" commandName="cart"  method="POST">
	
		<table>
			<tr>
				<td><form:label path="id"><spring:message text="ID" /></form:label></td>
				
					<c:if test="${!empty cart.id}">
						<td><form:input cssClass="form-control" path="id" value="${cart.id}" readonly="true" /></td>
					</c:if>

					<c:if test="${empty cart.id}">
						<td><form:input cssClass="form-control" path="id" pattern =".{4,7}" required="true" title="id should contains 4 to 7 characters" /></td>
					</c:if>
			</tr>
				
				
				
			<tr>
			
			<form:input path="id" hidden="true"/>
			
				<td><form:label path="billingaddress"><spring:message text="Name" /></form:label></td>
				<td><form:input path="billingaddress" cssClass="form-control" value="${cart.billingaddress}" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="orderid"><spring:message text="price" /></form:label></td>
				<td><form:input path="orderid" cssClass="form-control" value="${cart.orderid}" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="paymentmethod"><spring:message text="paymentmethod" /></form:label></td>
				<td><form:input path="paymentmethod" cssClass="form-control" value="${cart.paymentmethod}" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="shippingaddress"><spring:message text="size" /></form:label></td>
				<td><form:input path="shippingaddress" cssClass="form-control" value="${cart.shippingaddress}" required="true" /></td>
			</tr>
			<tr>
			<%-- 	<td><form:label path="product_stock"><spring:message text="product_stock" /></form:label></td>
				<td><form:input path="product_stock" cssClass="form-control" value="${product.product_stock}" required="true" /></td>
			</tr>
			<tr> --%>
				
				<%-- <td><form:label path="category.name"><spring:message text="category" /></form:label></td>
				<td><form:select path="category.name" cssClass="form-control" items="${categoryList}" itemLabel="name" itemValue="name"></form:select></td>
				
			</tr>
			<tr>
				
				<td><form:label path="supplier.name"><spring:message text="supplier" /></form:label></td>
				<td><form:select path="supplier.name" cssClass="form-control"  items="${supplierList}" itemLabel="name" itemValue="name"></form:select></td>
				 --%>
			<!-- </tr>
			<tr> -->
<!-- //======================FOR IMAGE PRODUCT===================//	 -->
            		
			<%-- <td>Image:</td>
			<td><form:input type="file" value="${product.image}" path="image" required="true"/> </td>
			</tr> --%>
<!-- //==============================================================================// -->
			
			<tr>
				<td colspan="2">
					<c:if test="${!empty cart.id}">
						<button type="submit" class="btn btn-primary">Update cart</button>	`
					</c:if> <c:if test="${empty cart.id}">
					<button type="submit" class="btn btn-primary">Add cart</button>
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>
	<font color="red"> cart List</font>
	</h3>
	<c:if test="${!empty cartList}">
		<table class="tg">
			<tr>
			    <th width="120">ID</th>
				<th width="80">billing address ID</th>
				<th width="120">order ID</th>
				<th width="120">payment method</th>
				<th width="120">shipping address ID</th>
				
				<!-- <th width="120">product_stock</th> -->
<!--  //==============================ADD IMAGE FOR PRODUCT============// -->
				<!-- <th width="120">Image</th> -->
				  
	<!-- //===============================================================//	 -->
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${cartList}" var="cart">
				<tr>
				    <td>${cart.ID}</td>
					<td>${cart.billing address ID}</td>
					<td>${cart.order ID}</td>
					<td>${cart.payment method}</td>
					<td>${cart.shipping address ID}</td>
					
					<%-- <td>${product.product_stock}</td> --%>
<!-- //===============ADD IMAGE FOR PRODUCT=============================// -->
<%-- <td><img src="<c:url value='resources/images/${cart.ID }.jpg' />" style="width: 100px; height: 150px;"></td> --%>
<!-- //=============================================================================// -->

					<td><a href="manage_cart_edit-${cart.id}"><button type="button">Edit</button></a></td>
					<td><a href="manage_cart_delete-${cart.id}"><button type="button">Delete</button></a></td>
					</tr>
					<br/>
			</c:forEach>
		</table>
	</c:if>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

