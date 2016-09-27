<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Welcome to Fleetman, the date and time is ${dateAndTime}</h1>

<c:forEach var="i" begin="1" end="5">
	<p>${i}</p>
</c:forEach>