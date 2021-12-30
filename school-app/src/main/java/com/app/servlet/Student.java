package com.app.servlet;

public class Student {
	
	private int id;
	private String name;
	private String gender;
	private String address;
	private String email;
	
	public Student() {
	}

	public Student(int id,String name, String gender, String address, String email) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	

}
	