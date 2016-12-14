<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>online shop</title>
</head>
<body>

<hr>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="corousels.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
 

<p>${successmessage}</p>

<c:if test="${userClickedloginHere }">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${userClickedsignUpHere }">
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<c:if test="${isAdminClickedCategories== true }">
<jsp:include page="category.jsp"></jsp:include>
</c:if>


</body>
</html>