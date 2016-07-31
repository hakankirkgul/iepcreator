package com.iepcreator.jdbc.services;

import java.util.List;

import com.iepcreator.models.CourseModel;
import com.iepcreator.models.GoalModel;
import com.iepcreator.models.GoalStatusModel;
import com.iepcreator.models.RuleModel;
import com.iepcreator.models.SubjectModel;

public interface ICourseService {

	List<CourseModel> getCourses();
	
	void updateGoalStatus(int studentId, int goalId, int status);
	
	List<GoalModel> getGoals(int courseId);
	
	List<GoalStatusModel> getGoalStatuses(int courseId, int studentId);
	
	List<RuleModel> getRules(int courseId, int studentId);
	
	int getGoalCountPerSubject(int studentId, int courseId);
	
	void updateGoalCountPerSubject(int studentId, int courseId, int count);
	
	void addRule(int studentId, int subjectId, int preSubjectId);
	
	void deleteRule(int ruleId);
	
	List<SubjectModel> getSubjects(int courseId);
	
}
