package com.dinil.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.regex.Pattern;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;




public class User {

	Integer id;
	
	@Size(min=2 ,message="Name should have atleast 2 charaters.")
	String name;
	@Past 

	Date birthDate;
	
	public User(){
		
	}
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
