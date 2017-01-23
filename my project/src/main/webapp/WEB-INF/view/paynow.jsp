<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Details</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
   
     <h1 style="color:blue;">Payment Detail</h1>
	<form action="paid" method="post" >
		<table>
 <div class="form-group">
			<tr>
				<td><label>Card holder name</label></td>
				<td><input class="form-control"  type="text" required="true" /></td>
			</tr>
			</div>
			 <div class="form-group">
			<tr>
				<td><label>Account no.</label></td>
				<td><input class="form-control" type="number" required="true" /></td>
			</tr>
			</div>
			 <div class="form-group">
			<tr>
				<td><label>Cv no.</label></td>
				<td><input class="form-control" type="number" required="true" /></td>
			</tr>
			</div>
			 <div class="form-group">
			<tr>
				<td><label>DOB</label></td>
				<td><input class="form-control" type="date" required="true" /></td>
			</tr>
			</div>
			 <div class="form-group">
			<tr>
			 
				<td><label>Email Id</label></td>
				<td><input class="form-control" type="email" required="true" /></td>
			</tr>
			</div>
			 <div class="form-group">
			<tr>
			
				<td><label>Mobile no.</label></td>
				<td><input class="form-control" type="number" required="true" /></td>
			</tr>
			</div>
			 <div class="form-group">
			<tr>
				<td><label>Address.</label></td>
				<td> <textarea class="form-control" rows="5" required="true"></textarea></td>
			</tr>
			</div>
			 <div class="form-group">
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-primary">Paynow</button>
				</td>
			</tr>
			</div>
		</table>
</form>

<jsp:include page="footer.jsp"></jsp:include>
<form>
</form>
</body>
</html>