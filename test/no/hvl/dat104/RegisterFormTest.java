package no.hvl.dat104;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegisterFormTest {
	
	private RegisterForm rf;
	
	private final String name = "John";
	private final String surname = "Doe";
	private final String phone = "12345678";
	private final String sex = "male";
	
	@Before
	public void setup() {
		rf = new RegisterForm();
	}
	
	@Test
	public void validateNameInvalidCharactersTest() {
		Assert.assertFalse(rf.validate("<h1>test</h1>", surname, phone, sex));
	}
	
	@Test
	public void validateSpaceInNameTest() {
		Assert.assertTrue(rf.validate("Ole-Brumm", surname, phone, sex));
		Assert.assertTrue(rf.validate("Ole Brumm", surname, phone, sex));
		Assert.assertTrue(rf.validate("Ole Brumm-brumm", surname, phone, sex));
	}
	
	@Test
	public void validateNameTooShortTest() {
		Assert.assertFalse(rf.validate("a", surname, phone, sex));
		Assert.assertTrue(rf.getErrors().containsKey("name"));
	}
	
	@Test
	public void validateNameTooLongTest() {
		Assert.assertFalse(rf.validate("aaaaaaaaaaaaaaaaaaaaa", surname, phone, sex));
		Assert.assertTrue(rf.getErrors().containsKey("name"));
	}
	
	@Test
	public void validateSurameTooShortTest() {
		Assert.assertFalse(rf.validate(name, "a", phone, sex));
		Assert.assertTrue(rf.getErrors().containsKey("surname"));
	}
	@Test
	public void validateSurameTooLongTest() {
		Assert.assertFalse(rf.validate(name, "aaaaaaaaaaaaaaaaaaaaa", phone, sex));
		Assert.assertTrue(rf.getErrors().containsKey("surname"));
	}
	@Test
	public void validateSurameContainsSpaceTest() {
		Assert.assertFalse(rf.validate(name, "mellom rom", phone, sex));
		Assert.assertTrue(rf.getErrors().containsKey("surname"));
	}
	
	@Test
	public void validatePhoneTest() {
		rf.validate(name, surname, "1324", sex);
		Assert.assertTrue(rf.getErrors().containsKey("phone"));
	}
	
	@Test
	public void multipleErrorsTest() {
		Assert.assertFalse(rf.validate("h", "e", phone, sex));
		Assert.assertTrue(rf.getErrors().containsKey("name"));
		Assert.assertTrue(rf.getErrors().containsKey("surname"));
	}
	
	@Test
	public void everythingIsValidTest() {
		Assert.assertTrue(rf.validate(name, surname, phone, sex));
		Assert.assertEquals(0, rf.getErrors().size());
	}
	
}
