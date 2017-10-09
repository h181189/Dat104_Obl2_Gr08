<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
<style>
	
	h3 {
		font-size: 16px;
		color: red;
	}

</style>
</head>
<body>
<h2>Kasserer login</h2>
<form method="POST" action="administratorlogin">
  <fieldset>
    <legend>Kasserer login</legend>
    <p>Passord: <input type="password" name="password" value="allstars" /></p> <h3><c:out value="${ error } /></h3>
    <input type="submit" value="Logg inn" />
  </fieldset>
</form>

</body>
</html>