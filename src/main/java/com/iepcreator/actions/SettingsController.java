package com.iepcreator.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.ICourseService;
import com.iepcreator.jdbc.services.IStudentService;
import com.iepcreator.models.CourseModel;
import com.iepcreator.models.StudentModel;
import com.iepcreator.models.UserLoginModel;

public class SettingsController extends BaseController {
	
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
