package com.iepcreator.jdbc.implementation;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;

import com.iepcreator.jdbc.proc.ProcedureDefinition;
import com.iepcreator.jdbc.rowmappers.UserLoginModelRowMapper;
import com.iepcreator.jdbc.services.IUserManagerService;
import com.iepcreator.models.UserLoginModel;

public class UserManagerService implements InitializingBean, IUserManagerService {

	private ProcedureDefinition proccheckUser;
	private ProcedureDefinition procregisterUser;
	private DataSource dataSource;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		proccheckUser = new ProcedureDefinition(getDataSource(), "CHECK_USER", new UserLoginModelRowMapper(),Types.VARCHAR,Types.VARCHAR);
		procregisterUser = new ProcedureDefinition(getDataSource(), "REGISTER_USER", false, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserLoginModel checkUser(String email, String password) {
		UserLoginModel user = (UserLoginModel)proccheckUser.executeProcedureSingle(email,password);
		return user;
	}

	@Override
	public void registerUser(String email, String password, String name, String surname) {
		procregisterUser.executeProcedureNoReturn(email,password,name,surname);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
