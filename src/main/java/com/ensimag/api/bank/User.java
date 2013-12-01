package com.ensimag.api.bank;

public class User implements IUser {
	
	private String _name;
	private String _firstName;
	private String _age;
	
	public User(String name, String firstName, String age){
		super();
		_name = name;
		_firstName = firstName;
		_age = age;
	}

	public String getName() {
		return _name;
	}

	public String getFirstName() {
		return _firstName;
	}

	public String getAge() {
		return _age;
	}

}
