<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�melding</title>
</head>
<body>
<h2>P�melding</h2>
<form action="register" method="POST">
  <fieldset>
    <legend>Personlige data</legend>
    
    <p>Fornavn:
    		<input type="text" name="firstname" value="${ oldName }" />
		<font color="red">${ nameError }</font>
	</p>
    
    <p>Etternavn:
    		<input type="text" name="surname"  value="${ oldSurname }" />
		<font color="red">${ surnameError }</font>
	</p>
    
    <p>Mobil (8 siffer):
	    	<input type="text" name="phone" value="${ oldPhone }" />
		<font color="red">${ phoneError }</font>
	</p>
    
    <p>Kj�nn:
	    <input type="radio" name="sex" value="male" ${ male } required />mann
		<input type="radio" name="sex" value="female" ${ female } required />kvinne
	</p>
	
    <p><input type="submit" value="Meld meg p�" /></p>
    
  </fieldset>
</form>
</body>
</html>