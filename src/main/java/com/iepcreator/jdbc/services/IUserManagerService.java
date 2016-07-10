package com.iepcreator.jdbc.services;

import com.iepcreator.models.UserLoginModel;

public interface IUserManagerService {

	UserLoginModel checkUser(String email, String password);

	void registerUser(String email, String password, String name, String surname);
	
}
