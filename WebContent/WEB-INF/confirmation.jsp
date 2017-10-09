<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�meldingsbekreftelse</title>
</head>
<body>
<h2>P�meldingsbekreftelse</h2>
<p>P�meldingen er mottatt for</p>
<ul>
	<li><c:out value="${participant.firstName}" /></li>
	<li><c:out value="${participant.surname}" /></li>
	<li><c:out value="${participant.phone}" /></li>
	<li><c:out value="${sex}" /></li>
</ul>

<p><b>NB! Husk � betale til kassereren f�r festen!</b></p>
<a href="ParticipantList">G� til deltagerlisten</a>
</body>
</html>