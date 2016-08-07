package com.iepcreator.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.ICourseService;

public class UpdateStudentCourseSettingsController extends BaseController {
	
	private ICourseService courseService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String studentIdTxt = request.getParameter("studentId");
		int studentId = studentIdTxt == null || studentIdTxt.isEmpty() ? 0 : Integer.parseInt(studentIdTxt);
		
		String courseIdTxt = request.getParameter("courseId");
		int courseId = courseIdTxt == null || courseIdTxt.isEmpty() ? 0 : Integer.parseInt(courseIdTxt);
		
		String goalPerSubjectTxt = request.getParameter("goalPerSubject");
		int goalPerSubject = goalPerSubjectTxt == null || goalPerSubjectTxt.isEmpty() ? 0 : Integer.parseInt(goalPerSubjectTxt);
		
		String subjectPerPlanTxt = request.getParameter("subjectPerPlan");
		int subjectPerPlan = subjectPerPlanTxt == null || subjectPerPlanTxt.isEmpty() ? 0 : Integer.parseInt(subjectPerPlanTxt);
		
		if(studentId > 0 && courseId > 0 && goalPerSubject > 0 && subjectPerPlan > 0){
			try {
				courseService.updateStudentCourseSettings(studentId, courseId, goalPerSubject, subjectPerPlan);
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
