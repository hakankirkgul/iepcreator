package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.UserLoginModel;

public class UserLoginModelRowMapper implements RowMapper<UserLoginModel> {

	@Override
	public UserLoginModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		UserLoginModel model = new UserLoginModel();
		
		model.setUserId(rset.getInt(1));
		model.setEmail(rset.getString(2));
		model.setName(rset.getString(3));
		model.setSurname(rset.getString(4));
		
		return model;
	}

}
