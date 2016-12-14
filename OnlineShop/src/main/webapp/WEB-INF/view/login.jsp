<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>onlineshop</title>
</head>
<body>


<jsp:include page="header.jsp"></jsp:include>


<h2>

<p><font color="red">Login here...</font></p>   

</h2>



<form action="validate">
<br>
username:<input type="text" name="username"><br></br>
password:<input type="password" name="password"><br></br>
<input type="submit" value="login">
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>