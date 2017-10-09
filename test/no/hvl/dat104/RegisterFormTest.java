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
	public void validateNameTooShortTest() {
		Assert.assertFalse(rf.validate("a", surname, phone, sex));
		Assert.assertEquals(1, rf.getErrors().size());
	}
	
	@Test
	public void validateNameTooLongTest() {
		Assert.assertFalse(rf.validate("aaaaaaaaaaaaaaaaaaaaa", surname, phone, sex));
		Assert.assertEquals(1, rf.getErrors().size());
	}
	
	@Test
	public void validateSurameTooShortTest() {
		Assert.assertFalse(rf.validate(name, "a", phone, sex));
		Assert.assertEquals(1, rf.getErrors().size());
	}
	@Test
	public void validateSurameTooLongTest() {
		Assert.assertFalse(rf.validate(name, "aaaaaaaaaaaaaaaaaaaaa", phone, sex));
		Assert.assertEquals(1, rf.getErrors().size());
	}
	@Test
	public void validateSurameContainsSpaceTest() {
		Assert.assertFalse(rf.validate(name, "mellom rom", phone, sex));
		Assert.assertEquals(1, rf.getErrors().size());
	}
	
	@Test
	public void validatePhoneTest() {
		Assert.assertFalse(rf.validate(name, surname, "1", sex));
		Assert.assertEquals(1, rf.getErrors().size());
	}
	
	@Test
	public void multipleErrorsTest() {
		Assert.assertFalse(rf.validate("h", "e", phone, sex));
		Assert.assertEquals(2, rf.getErrors().size());
	}
	
}
