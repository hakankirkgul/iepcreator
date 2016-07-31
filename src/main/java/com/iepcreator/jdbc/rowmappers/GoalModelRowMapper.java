package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.GoalModel;

public class GoalModelRowMapper implements RowMapper<GoalModel> {

	@Override
	public GoalModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		GoalModel model = new GoalModel();
		
		model.setSubjectId(rset.getInt(1));
		model.setSubject(rset.getString(2));
		model.setSubjectNo(rset.getInt(3));
		model.setGoalId(rset.getInt(4));
		model.setGoal(rset.getString(5));
		model.setGoalNo(rset.getInt(6));
		
		return model;
	}

}
