package com.iepcreator.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iepcreator.models.RuleModel;

public class RuleModelRowMapper implements RowMapper<RuleModel> {

	@Override
	public RuleModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		RuleModel model = new RuleModel();
		
		model.setRuleId(rset.getInt(1));
		model.setSubjectId(rset.getInt(2));
		model.setSubject(rset.getString(3));
		model.setSubjectNo(rset.getInt(4));
		model.setPreSubjectId(rset.getInt(5));
		model.setPreSubject(rset.getString(6));
		model.setPreSubjectNo(rset.getInt(7));
		
		return model;
	}

}
