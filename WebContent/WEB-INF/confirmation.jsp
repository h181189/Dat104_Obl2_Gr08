<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<ul>
	<li><c:out value="${participant.firstName}" /></li>
	<li><c:out value="${participant.surname}" /></li>
	<li><c:out value="${participant.phone}" /></li>
	<li><c:out value="${sex}" /></li>
</ul>

<p><b>NB! Husk å betale til kassereren før festen!</b></p>
<a href="ParticipantList">Gå til deltagerlisten</a>
</body>
</html>