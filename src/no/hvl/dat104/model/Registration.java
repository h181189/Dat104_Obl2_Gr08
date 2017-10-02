package no.hvl.dat104.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// TODO add schema name
@Table(schema = "", name = "registration")
public class Registration {

	@Id
	private Integer phone;
	private String firstName;
	private String surname;
	private boolean sex;
	private boolean paid;

	public Registration() {

	}

	public Registration(Integer phone, String firstName, String surname, boolean sex, boolean paid) {
		this.phone = phone;
		this.firstName = firstName;
		this.surname = surname;
		this.sex = sex;
		this.paid = paid;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}
