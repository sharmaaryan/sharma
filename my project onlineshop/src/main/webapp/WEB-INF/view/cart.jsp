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

<div class="alert alert-danger">
  <strong>${msg}</strong> 
</div>
<a href="backToHome">back</a>


<div>
<h1>
<font color="red"> My Cart</font>
</h1>
<br>
	<h3>
	<font color="red"> cart List</font>
	</h3>
	<c:if test="${!empty cartList}">
		<table class="table">
			<tr>
			    <th width="120">Product</th>
				<th width="80">Image</th>
				<th width="120">Price</th>
				
			</tr>
			<c:forEach items="${cartList}" var="cart">
				<tr>
				    <td>${cart.productName}</td>
					<td> <img width="100 px" height="100 px" src="<c:url value='resources/images/${cart.cartproduct_id }.jpg' />" /></td>
					<td>${cart.price}</td>
     <td align="centre"><a href="<c:url value='cart/delete/${cart.id}' />"><button type="button" class="btn btn-default">delete</button>
     </a></td>
     </tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${pageContent.request.userPrinciple.name !=null}">
	<h2><centre>Total:${sum}</centre></h2>
	</c:if>
	
	<div style="text-align: centre;">
	<a href="home"><button type="button" class="btn btn-default align="centre">CONTINUE SHOPPING</button></a>
	<%-- <c:if test="${!empty cartlist}"> --%>
	<a href="pay"><h4 style="color: #c19a6b "><button type="button" class="btn btn-default">Checkout and pay</button></h4></a>
<%-- 	</c:if> --%>
</div>
</div>

	
 
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

