<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Login to FleetMan</title>
	</head>		

	<body>
	
		<h1><strong>Welcome to FleetMan</strong></h1>
						
		<c:url value="/website/login" var="loginUrl"/>
		
		<c:if test="${param.error != null}">
			<p>Bad username/password</p>
		</c:if>
		
		<form:form action="${loginUrl}" method="post">
			<label>Username:</label> <input type="text" name="username" value="rac"/>
			<label>Password:</label> <input type="text" name="password" value="secret"/>
			<input type="submit"/>
		</form:form>
	</body>
</html>