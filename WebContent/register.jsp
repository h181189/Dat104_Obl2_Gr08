<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<form action="register" method="POST">
  <fieldset>
    <legend>Personlige data</legend>
    
    <p>Fornavn:
    		<input type="text" name="firstname" value="${ oldName }" required />
		<font color="red">${ firstNameError }</font>
	</p>
    
    <p>Etternavn:
    		<input type="text" name="surname"  value="${ oldSurname }" />
		<font color="red">${ surnameError }</font>
	</p>
    
    <p>Mobil (8 siffer):
	    	<input type="text" name="phone" value="${ oldPhone }" required />
		<font color="red">${ phoneError }</font>
	</p>
    
    <p>Kjønn:
	    <input type="radio" name="sex" value="male" checked="checked" required />mann
		<input type="radio" name="sex" value="female" required />kvinne
	</p>
	
    <p><input type="submit" value="Meld meg på" /></p>
    
  </fieldset>
</form>
</body>
</html>