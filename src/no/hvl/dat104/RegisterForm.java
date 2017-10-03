package no.hvl.dat104;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	
	private final Map<String, String> errors = new HashMap<>();
	private final Map<String, String> old = new HashMap<>();
	
	public boolean validate(String name, String surname, String phone) {
		errors.clear();
		
		if (name.isEmpty()) {
			errors.put("name", "navn kan ikke være tomt");
		}
		if (surname.isEmpty()) {
			errors.put("surname", "etternavn kan ikke være tomt");
		}
		if (phone.length() != 8) {
			errors.put("phone", "telefonnummer må ha 8 tall");
		} else if (phone.matches("^[0-9]")) {
			errors.put("phone", "telefonnummer kan bare bestå av tall");
		}
		
		old.put("name", name);
		old.put("surname", surname);
		old.put("phone", phone);
		
		return errors.isEmpty();
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public String old(String key) {
		return old.get(key);
	}
	
	public void clear() {
		errors.clear();
		old.clear();
	}
	
}
