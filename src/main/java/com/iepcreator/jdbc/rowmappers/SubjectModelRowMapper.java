package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.SubjectModel;

public class SubjectModelRowMapper implements RowMapper<SubjectModel> {

	@Override
	public SubjectModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		SubjectModel model = new SubjectModel();
		
		model.setSubjectId(rset.getInt(1));
		model.setSubjectNo(rset.getInt(2));
		model.setSubject(rset.getString(3));
		
		return model;
	}

}
