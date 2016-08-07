package com.iepcreator.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.ICourseService;
import com.iepcreator.jdbc.services.IStudentService;
import com.iepcreator.models.CourseModel;
import com.iepcreator.models.GoalModel;
import com.iepcreator.models.GoalStatusModel;
import com.iepcreator.models.StudentCourseSettingsModel;
import com.iepcreator.models.StudentModel;
import com.iepcreator.models.StudentSubjectModel;
import com.iepcreator.models.UserLoginModel;

public class CreatePlanController extends BaseController {
	
	private IStudentService studentService;
	private ICourseService courseService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		List<CourseModel> courses = courseService.getCourses();
		mv.getModelMap().put("courses", courses);
		
		UserLoginModel user = (UserLoginModel)request.getSession().getAttribute("LOGGEDIN_USER");
		if(user != null){
			List<StudentModel> students = studentService.getStudents(user.getUserId());
			mv.getModelMap().put("students", students);
		}
		
		String studentIdTxt = request.getParameter("studentId");
		int studentId = studentIdTxt == null || studentIdTxt.isEmpty() ? 0 : Integer.parseInt(studentIdTxt);
		
		String courseIdTxt = request.getParameter("courseId");
		int courseId = courseIdTxt == null || courseIdTxt.isEmpty() ? 0 : Integer.parseInt(courseIdTxt);
		
		if(studentId > 0 && courseId > 0){
			int subjectCountPerPlan = 3;
			int goalCountPerSubject = 3;
			
			StudentCourseSettingsModel settings = courseService.getStudentCourseSettings(studentId, courseId);
			if(settings != null){
				subjectCountPerPlan = settings.getSubjectPerPlan();
				goalCountPerSubject = settings.getGoalPerSubject();
			}
			
			List<StudentSubjectModel> subjects = courseService.getStudentSubjects(courseId, studentId);
			for (StudentSubjectModel subject : subjects) {
				if(subjectCountPerPlan == 0){
					break;
				}
				List<StudentSubjectModel> presubjects = courseService.getStudentPreSubjects(subject.getSubjectId(), studentId);
				if(presubjects == null){
					List<GoalStatusModel> goals = courseService.getSubjectGoals(subject.getSubjectId(), studentId);
					int goalCount = goalCountPerSubject;
					for (GoalStatusModel goal : goals) {
						if(goalCount == 0){
							break;
						}
						courseService.updateGoalStatus(studentId, goal.getGoalId(), 0);
						goalCount--;
					}
					subjectCountPerPlan--;
				}
			}
			
			List<GoalModel> finishedGoals = courseService.getStudentGoals(courseId, studentId, 1);
			mv.getModelMap().put("finishedGoals", finishedGoals);
			
			List<GoalModel> unfinishedGoals = courseService.getStudentGoals(courseId, studentId, 0);
			mv.getModelMap().put("unfinishedGoals", unfinishedGoals);
		}
		
		return mv;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}
}
