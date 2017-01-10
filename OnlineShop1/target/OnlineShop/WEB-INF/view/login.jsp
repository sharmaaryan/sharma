<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>onlineshop</title>
</head>
<body>
  <jsp:include page="header.jsp"></jsp:include>
  <h2> login here</h2>

<form action="<c:url value='j_spring_security_check'/>"  method="post" role="form">
       <c:if test="${not empty error}">
       <p class="loginerror" >${error}</p>
       </c:if>
       
 <c:if test="${not empty msg}">
       <p class="loginmsg" >${msg}</p>
       </c:if> 
         <!--  <h2 style="color:#000000">Please Login</h2> -->
	     <hr class="colorgraph"> 
        <div class="row">
				<div class="col-sm-12 ">
					<div class="form-group">
						<input style="background-color:#FFFFE0" type="text"  name="username" class="form-control input-lg" placeholder="Name"  />
					</div>
				</div>
			
				
			</div>
			 <div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<input style="background-color:#FFFFE0" type="password"  name="password" class="form-control input-lg" placeholder="Password" tabindex="2" />
					</div>
				</div>
			
				
			</div>
			<hr class="colorgraph"> 
 			<div class="row">
				<div class="col-xs-12 col-md-6"><input type="submit" value="Login" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
				
			</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			
        </form>
  
  
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>