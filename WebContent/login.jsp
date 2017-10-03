<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<p>Det er kun registrerte deltagere som får se deltagerlisten.
Logg inn ved å gi mobil-nummeret ditt.</p>
<form method="POST">
  <fieldset>
    <legend>Logg inn</legend>
    <p>Mobil: <input type="text" name="phone" value="" />
    <font color="red">${ error }</font></p>
    <p><input type="submit" value="Logg inn" /></p>
  </fieldset>
</form>

</body>
</html>