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
import com.iepcreator.models.StudentModel;
import com.iepcreator.models.UserLoginModel;

public class StudentReviewController extends BaseController {
	
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
			List<GoalModel> goals = courseService.getGoals(courseId);
			mv.getModelMap().put("goals", goals);
			
			List<GoalStatusModel> statusList = courseService.getGoalStatuses(courseId, studentId);
			List<Integer> completedGoals = new ArrayList<Integer>();
			if(statusList != null){
				for (GoalStatusModel goal : statusList) {
					if(goal.getStatus() == 1){
						completedGoals.add(goal.getGoalId());
					}
				}
			}
			mv.getModelMap().put("completedGoals", completedGoals.toString());
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
