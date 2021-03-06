package com.ifi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String address;
	private String phone;
	private boolean gender;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String email, String address, String phone, boolean gender) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}
	public Employee(long id2, String name2, String email2, String address2, String phone2, boolean gender2) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id2;
		this.name = name2;
		this.email = email2;
		this.address = address2;
		this.phone = phone2;
		this.gender = gender2;
	}
	public long getId() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone="
				+ phone + ", gender=" + gender + "]";
	}
	
	
}
