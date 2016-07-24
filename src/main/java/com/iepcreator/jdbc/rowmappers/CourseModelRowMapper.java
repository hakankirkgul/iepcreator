package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.CourseModel;

public class CourseModelRowMapper implements RowMapper<CourseModel> {

	@Override
	public CourseModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		CourseModel model = new CourseModel();
		
		model.setCourseId(rset.getInt(1));
		model.setName(rset.getString(2));
		
		return model;
	}

}
