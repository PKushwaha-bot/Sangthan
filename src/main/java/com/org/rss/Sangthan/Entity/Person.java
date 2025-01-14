package com.org.rss.Sangthan.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@NamedQuery(name = "SELECT_ALL", query = "select p from Person p")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min = 10,max = 40, message = "Name should be between 10 to 40")
	private String name;
	@NotEmpty
	@Email(message = "Email should be in format.")
	private String email;
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "Contact no should be in format.")
	private String Contact_no;
	@JsonIgnore
	@ManyToOne 
	private Address address;
	@JsonIgnore
	@ManyToOne
	private Designation designation;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact_no() {
		return Contact_no;
	}
	public void setContact_no(String contact_no) {
		Contact_no = contact_no;
	}
	@ManyToOne
	private Shakha shakha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	public Shakha getShakha() {
		return shakha;
	}
	public void setShakha(Shakha shakha) {
		this.shakha = shakha;
	}

}
