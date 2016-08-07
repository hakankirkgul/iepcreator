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
import com.iepcreator.jdbc.rowmappers.StudentCourseSettingsModelRowMapper;
import com.iepcreator.jdbc.rowmappers.StudentSubjectModelRowMapper;
import com.iepcreator.jdbc.rowmappers.SubjectModelRowMapper;
import com.iepcreator.jdbc.services.ICourseService;
import com.iepcreator.models.CourseModel;
import com.iepcreator.models.GoalModel;
import com.iepcreator.models.GoalStatusModel;
import com.iepcreator.models.RuleModel;
import com.iepcreator.models.StudentCourseSettingsModel;
import com.iepcreator.models.StudentSubjectModel;
import com.iepcreator.models.SubjectModel;

public class CourseService implements InitializingBean, ICourseService {
	
	private ProcedureDefinition procgetCourses;
	private ProcedureDefinition procupdateGoalStatus;
	private ProcedureDefinition procgetGoals;
	private ProcedureDefinition procgetGoalStatuses;
	private ProcedureDefinition procgetRules;
	private ProcedureDefinition procgetStudentCourseSettings;
	private ProcedureDefinition procupdateStudentCourseSettings;
	private ProcedureDefinition procaddRule;
	private ProcedureDefinition procdelRule;
	private ProcedureDefinition procgetSubjects;
	private ProcedureDefinition procgetStudentSubjects;
	private ProcedureDefinition procgetStudentPreSubjects;
	private ProcedureDefinition procgetStudentGoals;
	private ProcedureDefinition procgetSubjectGoals;
	private DataSource dataSource;

	@Override
	public void afterPropertiesSet() throws Exception {
		procgetCourses = new ProcedureDefinition(getDataSource(), "GET_COURSES", new CourseModelRowMapper());
		procupdateGoalStatus = new ProcedureDefinition(getDataSource(), "UPDATE_GOAL_STATUS", false, Types.NUMERIC, Types.NUMERIC, Types.NUMERIC);
		procgetGoals = new ProcedureDefinition(getDataSource(), "GET_GOALS", new GoalModelRowMapper(), Types.NUMERIC);
		procgetGoalStatuses = new ProcedureDefinition(getDataSource(), "GET_GOAL_STATUSES", new GoalStatusModelRowMapper(), Types.NUMERIC, Types.NUMERIC);
		procgetRules = new ProcedureDefinition(getDataSource(), "GET_RULES", new RuleModelRowMapper(), Types.NUMERIC, Types.NUMERIC);
		procgetStudentCourseSettings = new ProcedureDefinition(getDataSource(), "GET_STUDENT_COURSE_SETTINGS", new StudentCourseSettingsModelRowMapper(), Types.NUMERIC, Types.NUMERIC);
		procupdateStudentCourseSettings = new ProcedureDefinition(getDataSource(), "UPDATE_STUDENT_COURSE_SETTINGS", false, Types.NUMERIC, Types.NUMERIC, Types.NUMERIC, Types.NUMERIC);
		procaddRule = new ProcedureDefinition(getDataSource(), "ADD_RULE", false, Types.NUMERIC, Types.NUMERIC, Types.NUMERIC);
		procdelRule = new ProcedureDefinition(getDataSource(), "DELETE_RULE", false, Types.NUMERIC);
		procgetSubjects = new ProcedureDefinition(getDataSource(), "GET_SUBJECTS", new SubjectModelRowMapper(), Types.NUMERIC);
		procgetStudentSubjects = new ProcedureDefinition(getDataSource(), "GET_STUDENT_SUBJECTS", new StudentSubjectModelRowMapper(), Types.NUMERIC, Types.NUMERIC);
		procgetStudentPreSubjects = new ProcedureDefinition(getDataSource(), "GET_STUDENT_PRE_SUBJECTS", new StudentSubjectModelRowMapper(), Types.NUMERIC, Types.NUMERIC);
		procgetStudentGoals = new ProcedureDefinition(getDataSource(), "GET_STUDENT_GOALS", new GoalModelRowMapper(), Types.NUMERIC, Types.NUMERIC, Types.NUMERIC);
		procgetSubjectGoals = new ProcedureDefinition(getDataSource(), "GET_SUBJECT_GOALS", new GoalStatusModelRowMapper(), Types.NUMERIC, Types.NUMERIC);
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
	public StudentCourseSettingsModel getStudentCourseSettings(int studentId, int courseId) {
		return (StudentCourseSettingsModel)procgetStudentCourseSettings.executeProcedureSingle(studentId,courseId);
	}

	@Override
	public void updateStudentCourseSettings(int studentId, int courseId, int goalPerSubject, int subjectPerPlan) {
		procupdateStudentCourseSettings.executeProcedureNoReturn(studentId,courseId,goalPerSubject,subjectPerPlan);
	}

	@Override
	public void addRule(int studentId, int subjectId, int preSubjectId) {
		procaddRule.executeProcedureNoReturn(studentId,subjectId,preSubjectId);
	}

	@Override
	public void deleteRule(int ruleId) {
		procdelRule.executeProcedureNoReturn(ruleId);
	}

	@Override
	public List<SubjectModel> getSubjects(int courseId) {
		List<SubjectModel> list = (List<SubjectModel>)procgetSubjects.executeProcedure(courseId);
		return list;
	}

	@Override
	public List<StudentSubjectModel> getStudentSubjects(int courseId, int studentId) {
		List<StudentSubjectModel> list = (List<StudentSubjectModel>)procgetStudentSubjects.executeProcedure(courseId,studentId);
		return list;
	}

	@Override
	public List<StudentSubjectModel> getStudentPreSubjects(int subjectId, int studentId) {
		List<StudentSubjectModel> list = (List<StudentSubjectModel>)procgetStudentPreSubjects.executeProcedure(subjectId,studentId);
		return list;
	}

	@Override
	public List<GoalModel> getStudentGoals(int courseId, int studentId, int status) {
		List<GoalModel> list = (List<GoalModel>)procgetStudentGoals.executeProcedure(courseId,studentId,status);
		return list;
	}

	@Override
	public List<GoalStatusModel> getSubjectGoals(int subjectId, int studentId) {
		List<GoalStatusModel> list = (List<GoalStatusModel>)procgetSubjectGoals.executeProcedure(subjectId,studentId);
		return list;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
