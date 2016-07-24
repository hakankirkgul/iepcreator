package com.iepcreator.jdbc.implementation;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;

import com.iepcreator.jdbc.proc.ProcedureDefinition;
import com.iepcreator.jdbc.rowmappers.CourseModelRowMapper;
import com.iepcreator.jdbc.rowmappers.GoalModelRowMapper;
import com.iepcreator.jdbc.rowmappers.GoalStatusModelRowMapper;
import com.iepcreator.jdbc.rowmappers.RuleModelRowMapper;
import com.iepcreator.jdbc.services.ICourseService;
import com.iepcreator.models.CourseModel;
import com.iepcreator.models.GoalModel;
import com.iepcreator.models.GoalStatusModel;
import com.iepcreator.models.RuleModel;

public class CourseService implements InitializingBean, ICourseService {
	
	private ProcedureDefinition procgetCourses;
	private ProcedureDefinition procupdateGoalStatus;
	private ProcedureDefinition procgetGoals;
	private ProcedureDefinition procgetGoalStatuses;
	private ProcedureDefinition procgetRules;
	private ProcedureDefinition procgetGoalCountPerSubject;
	private ProcedureDefinition procupdateGoalCountPerSubject;
	private ProcedureDefinition procaddRule;
	private ProcedureDefinition procdelRule;
	private DataSource dataSource;

	@Override
	public void afterPropertiesSet() throws Exception {
		procgetCourses = new ProcedureDefinition(getDataSource(), "GET_COURSES", new CourseModelRowMapper());
		procupdateGoalStatus = new ProcedureDefinition(getDataSource(), "UPDATE_GOAL_STATUS", false, Types.NUMERIC, Types.NUMERIC, Types.NUMERIC);
		procgetGoals = new ProcedureDefinition(getDataSource(), "GET_GOALS", new GoalModelRowMapper(), Types.NUMERIC);
		procgetGoalStatuses = new ProcedureDefinition(getDataSource(), "GET_GOALS_STATUSES", new GoalStatusModelRowMapper(), Types.NUMERIC, Types.NUMERIC);
		procgetRules = new ProcedureDefinition(getDataSource(), "GET_RULES", new RuleModelRowMapper(), Types.NUMERIC, Types.NUMERIC);
		procgetGoalCountPerSubject = new ProcedureDefinition(getDataSource(), "GET_GOAL_COUNT_PER_SUBJECT", Types.NUMERIC, true, Types.NUMERIC, Types.NUMERIC);
		procupdateGoalCountPerSubject = new ProcedureDefinition(getDataSource(), "UPDATE_GOAL_COUNT_PER_SUBJECT", false, Types.NUMERIC, Types.NUMERIC, Types.NUMERIC);
		procaddRule = new ProcedureDefinition(getDataSource(), "ADD_RULE", false, Types.NUMERIC, Types.NUMERIC, Types.NUMERIC);
		procdelRule = new ProcedureDefinition(getDataSource(), "DELETE_RULE", false, Types.NUMERIC);
	}

	@Override
	public List<CourseModel> getCourses() {
		List<CourseModel> list = (List<CourseModel>)procgetCourses.executeProcedure();
		return list;
	}

	@Override
	public void updateGoalStatus(int studentId, int goalId, int status) {
		procupdateGoalStatus.executeProcedureNoReturn(studentId,goalId,status);
	}

	@Override
	public List<GoalModel> getGoals(int courseId) {
		List<GoalModel> list = (List<GoalModel>)procgetGoals.executeProcedure(courseId);
		return list;
	}

	@Override
	public List<GoalStatusModel> getGoalStatuses(int courseId, int studentId) {
		List<GoalStatusModel> list = (List<GoalStatusModel>)procgetGoalStatuses.executeProcedure(courseId,studentId);
		return list;
	}

	@Override
	public List<RuleModel> getRules(int courseId, int studentId) {
		List<RuleModel> list = (List<RuleModel>)procgetRules.executeProcedure(courseId,studentId);
		return list;
	}

	@Override
	public int getGoalCountPerSubject(int studentId, int courseId) {
		return procgetGoalCountPerSubject.executeProcedureInt(studentId,courseId);
	}

	@Override
	public void updateGoalCountPerSubject(int studentId, int courseId, int count) {
		procupdateGoalCountPerSubject.executeProcedureNoReturn(studentId,courseId,count);
	}

	@Override
	public void addRule(int studentId, int subjectId, int preSubjectId) {
		procaddRule.executeProcedureNoReturn(studentId,subjectId,preSubjectId);
	}

	@Override
	public void deleteRule(int ruleId) {
		procdelRule.executeProcedureNoReturn(ruleId);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}