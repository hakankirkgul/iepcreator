package com.iepcreator.jdbc.services;

import java.util.List;

import com.iepcreator.models.CourseModel;
import com.iepcreator.models.GoalModel;
import com.iepcreator.models.GoalStatusModel;
import com.iepcreator.models.RuleModel;
import com.iepcreator.models.StudentCourseSettingsModel;
import com.iepcreator.models.StudentSubjectModel;
import com.iepcreator.models.SubjectModel;

public interface ICourseService {

	List<CourseModel> getCourses();
	
	void updateGoalStatus(int studentId, int goalId, int status);
	
	List<GoalModel> getGoals(int courseId);
	
	List<GoalStatusModel> getGoalStatuses(int courseId, int studentId);
	
	List<RuleModel> getRules(int courseId, int studentId);
	
	StudentCourseSettingsModel getStudentCourseSettings(int studentId, int courseId);
	
	void updateStudentCourseSettings(int studentId, int courseId, int goalPerSubject, int subjectPerPlan);
	
	void addRule(int studentId, int subjectId, int preSubjectId);
	
	void deleteRule(int ruleId);
	
	List<SubjectModel> getSubjects(int courseId);
	
	List<StudentSubjectModel> getStudentSubjects(int courseId, int studentId);
	
	List<StudentSubjectModel> getStudentPreSubjects(int subjectId, int studentId);
	
	List<GoalModel> getStudentGoals(int courseId, int studentId, int status);
	
	List<GoalStatusModel> getSubjectGoals(int subjectId, int studentId);
	
}
