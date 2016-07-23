package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.StudentModel;

public class StudentModelRowMapper implements RowMapper<StudentModel> {

	@Override
	public StudentModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		StudentModel model = new StudentModel();
		
		model.setStudentId(rset.getInt(1));
		model.setName(rset.getString(2));
		model.setSurname(rset.getString(3));
		model.setGender(rset.getString(4));
		model.setBirthDate(rset.getDate(5));
		model.setParentName(rset.getString(6));
		model.setParentSurname(rset.getString(7));
		
		return model;
	}

}
