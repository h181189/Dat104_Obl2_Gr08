<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Betalingsoversikt</title>
</head>
<body>
	<h2>Betalingsoversikt</h2>
		<table border="1">
			<tr bgcolor="#cccccc">
				<th align="left">Navn</th>
				<th>Mobil</th>
				<th>Betalingsstatus</th>
			</tr>
			<c:forEach var="participant" items="${participants}">
			<tr>
				<td><c:out value="${ participant.firstName } ${ participant.surname }" /></td>
				<td><c:out value="${ participant.phone }" /></td>
				<c:if test = "${ participant.paid }">
					<td align="center">Betaling mottatt</td>
				</c:if>
				<c:if test="${ !participant.paid }">
					<td>
						<form method="POST" action="registerPayment">
							<input type="hidden" name="participant-phone" value="${ participant.phone }" />
							<input type="submit" name="${ participant.phone }" value="Registrer betaling">
						</form>
					</td>
				</c:if>
				
			</tr>
			</c:forEach>
		</table>
	<p>
		<a href="administratorlogin">Ferdig</a>
	</p>
</body>
</html>