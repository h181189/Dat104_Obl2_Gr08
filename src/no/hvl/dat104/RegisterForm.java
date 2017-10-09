package no.hvl.dat104;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;

import no.hvl.dat104.handler.ParticipantHandler;

public class RegisterForm {
	
	@EJB
	private ParticipantHandler handler;
	
	private final Map<String, String> errors = new HashMap<>();
	private final Map<String, String> old = new HashMap<>();
	
	public boolean validate(String name, String surname, String phone, String sex) {
		errors.clear();
		
		if (name.length() > 20 || name.length() < 2) {
			errors.put("name", "navn må være mellom 2 og 20 bokstaver");
		}
		if (surname.length() > 20 || surname.length() < 2) {
			errors.put("surname", "etternavn må være mellom 2 og 20 bokstaver");
		} else if (surname.contains(" ")) {
			errors.put("surname", "etternavn kan ikke inneholde mellomrom");
		}
		if (phone.length() != 8) {
			errors.put("phone", "telefonnummer må ha 8 tall");
		} else if (phone.matches("^[0-9]")) {
			errors.put("phone", "telefonnummer kan bare bestå av tall");
		}
		
		old.put("name", name);
		old.put("surname", surname);
		old.put("phone", phone);
		old.put("sex", sex);
		
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
