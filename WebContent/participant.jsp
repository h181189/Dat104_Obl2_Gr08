<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table border="1">

		<c:forEach var="participant" items="${ participant }">
			<tr	<c:if test="${(participant.phone == phone) && participant.paid}">bgcolor="aaffaa"</c:if>
			<c:if test="${(participant.phone == phone) && !participant.paid}">bgcolor="#ffaaaa"</c:if>>
				<td align="center">
				<c:if test="${participant.sex}">&#9794;</c:if>
				<c:if test="${!participant.sex}">&#9792;</c:if>
				</td>

				<td>${ participant.firstName } ${ participant.surname }</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="ferdig.html">Ferdig</a>
	</p>
</body>
</html>