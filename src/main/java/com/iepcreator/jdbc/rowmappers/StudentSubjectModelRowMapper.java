package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.StudentSubjectModel;

public class StudentSubjectModelRowMapper implements RowMapper<StudentSubjectModel> {

	@Override
	public StudentSubjectModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		StudentSubjectModel model = new StudentSubjectModel();
		
		model.setSubjectId(rset.getInt(1));
		model.setGoalCount(rset.getInt(2));
		
		return model;
	}

}
