package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.GoalStatusModel;

public class GoalStatusModelRowMapper implements RowMapper<GoalStatusModel> {

	@Override
	public GoalStatusModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		GoalStatusModel model = new GoalStatusModel();

		model.setSubjectId(rset.getInt(1));
		model.setGoalId(rset.getInt(2));
		model.setStatus(rset.getInt(3));
		
		return model;
	}

}
