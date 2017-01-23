<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</h2>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2 style="color:blue;">Sign-up Here.......</h2>
<div class="container">

<c:url var="addAction" value="/useradd"></c:url>

	<form:form action="${addAction}" commandName="user" method="post" >
		<table>
			<tr>
				<td>ID:<form:label path="id"><spring:message text="ID" /></form:label></td>
				
					
						<td><form:input path="id"  required="true"  /></td>
					
					
					
				</tr>
			<tr>
				<td>Name:<form:label path="name"><spring:message text="Name" /></form:label></td>
				<td><form:input path="name" value="${user.name}" required="true" /></td>
			</tr>
			<tr>
				<td>Password:<form:label path="password"><spring:message text="Password" /></form:label></td>
				<td><form:input path="password" value="${user.password}" required="true" /></td>
			</tr>
			<tr>
			
			
			
			<td>Mail:<form:label path="mail"><spring:message text="Mail" /></form:label></td>
				<td><form:input path="mail" value="${user.mail}" required="true" /></td>
			</tr>
			<tr>
			
			<td>Contact<form:label path="contact"><spring:message text="Contact" /></form:label></td>
				<td><form:input path="contact" value="${user.contact}" required="true" /></td>
			</tr>
			<tr>
			
			
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${empty user.name}">
						<button type="submit" class="btn btn-primary">Register</button>
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
	<jsp:include page="footer.jsp"></jsp:include>
	<br>
	</div>
      </body>
      </html>    

