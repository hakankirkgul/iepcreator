package com.iepcreator.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.ICourseService;

public class SetGoalCountPerSubjectController extends BaseController {
	
	private ICourseService courseService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String studentIdTxt = request.getParameter("studentId");
		int studentId = studentIdTxt == null || studentIdTxt.isEmpty() ? 0 : Integer.parseInt(studentIdTxt);
		
		String courseIdTxt = request.getParameter("courseId");
		int courseId = courseIdTxt == null || courseIdTxt.isEmpty() ? 0 : Integer.parseInt(courseIdTxt);
		
		String countTxt = request.getParameter("count");
		int count = countTxt == null || countTxt.isEmpty() ? 0 : Integer.parseInt(countTxt);
		
		if(studentId > 0 && courseId > 0 && count > 0){
			try {
				courseService.updateGoalCountPerSubject(studentId,courseId,count);
				mv.getModelMap().put("success", "success");
			} catch (Exception e) {
				mv.getModelMap().put("error", "System Error");
			}
		}
		return mv;
	}
	
	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}
}
