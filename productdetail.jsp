<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
		
			<img class="col-md-4" alt="Bootstrap Image Preview" src="<c:url value='resources/images/${selectedProduct.product_id}.jpg' />" class="img-circle" />
		
		<div class="col-md-8">
		<h1 style="color:blue;">Product Detail</h1>
			<table border="1" class="table">
			
				<tbody>
					
					<tr>
					<th>NAME:-</th>
						<td>
							${selectedProduct.product_name }
						</td>
						
					</tr>
					<tr>
					<th>PRICE:-</th>
						<td>
							${selectedProduct.product_price }
						</td>
						
					</tr>
					<tr>
					<th>DESCRIPTION:-</th>
						<td>
							${selectedProduct.product_description }
						</td>
						<tr>
					<th>SIZE:-</th>
						<td>
							${selectedProduct.size }
						</td>
						
					</tr>
			
				<tr>
					<th>PRODUCT-STOCK:-</th>
						<td>
							${selectedProduct.product_stock }
						</td>
						
					</tr>
					
					
						<tr>
					<th>CATEGORY:-</th>
						<td>
							${cname }
						</td>
						
					</tr>
						<tr>
					<th>SUPPLIER:-</th>
						<td>
							${sname }
						</td>
						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-8">
		</div>
		<div class="col-md-4">
			 
			<a href="pay"><button type="button" class="btn btn-primary">
				Buy now
			</button> </a>
			<a href="cartadd-${selectedProduct.product_id }"><button type="button" class="btn btn-primary">
				Add to cart
			</button></a>
		</div>
	</div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>