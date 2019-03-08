package org.duckdns.microserv.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "driverslicense")
	private String driverslicense;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "email")
	private String email;
	

	public Person(int id, String firstName, String lastName, String driverslicense, String city, String email) {
		super();
		this.id = id;
		this.first_name = firstName;
		this.last_name = lastName;
		this.driverslicense = driverslicense;
		this.city = city;
		this.email = email;
	}



	public Person(int id) {
		super();
		this.id = id;
	}



	public Person() {
		super();
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	public String getDriverslicense() {
		return driverslicense;
	}
	public void setDriverslicense(String driverslicense) {
		this.driverslicense = driverslicense;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	

}
