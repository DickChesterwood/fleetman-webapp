<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>Vehicles page</h1>

<ul>
<c:forEach items="${vehicles}" var="vehicle">
   <li><a href="<c:url value="/website/vehicles/vehicle/${vehicle.name}"/>">${vehicle}</a></li>
</c:forEach>
</ul>