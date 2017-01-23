<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="row">
<c:forEach items="${plist}" var="p">
<a href="productget-${p.product_id}">
<img class="col-md-3" src="<c:url value='resources/images/${p.product_id}.jpg' />" /> 
</a>
</c:forEach>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>