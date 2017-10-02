package no.hvl.dat104.modules;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//TODO add schema name
@Table(schema = "", name = "registration")
public class Registration {

	@Id
	private Integer phone;
	private String first_name;
	private String surname;
	private boolean sex;
	private boolean paid;

	public Registration() {

	}

	public Registration(Integer phone, String first_name, String surname, boolean sex, boolean paid) {
		this.phone= phone;
		this.first_name=first_name;
		this.surname=surname;
		this.sex=sex;
		this.paid=paid;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSur_name(String surname) {
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

