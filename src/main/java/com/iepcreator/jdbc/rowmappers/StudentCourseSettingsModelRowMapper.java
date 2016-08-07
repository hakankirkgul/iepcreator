package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.StudentCourseSettingsModel;

public class StudentCourseSettingsModelRowMapper implements RowMapper<StudentCourseSettingsModel> {

	@Override
	public StudentCourseSettingsModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		StudentCourseSettingsModel model = new StudentCourseSettingsModel();
		
		model.setGoalPerSubject(rset.getInt(1));
		model.setSubjectPerPlan(rset.getInt(2));
		
		return model;
	}

}
