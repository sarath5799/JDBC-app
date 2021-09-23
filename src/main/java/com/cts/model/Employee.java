package com.cts.model;

import java.util.Date;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String city;
	private String country;
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstName, String lastName, String dateOfBirth, String city, String country,
			double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.country = country;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return id + "," + firstName + "," + lastName + "," + dateOfBirth + "," + city + "," + country + "," + salary;
	}
}
