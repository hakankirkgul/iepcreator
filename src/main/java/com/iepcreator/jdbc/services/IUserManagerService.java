package com.iepcreator.jdbc.services;

import com.iepcreator.models.UserLoginModel;

public interface IUserManagerService {

	UserLoginModel checkUser(String email, String password);

	void addUser(String email, String password);
	
}
