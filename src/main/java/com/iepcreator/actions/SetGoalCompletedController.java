package com.iepcreator.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.ICourseService;

public class SetGoalCompletedController extends BaseController {
	
	private ICourseService courseService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String studentIdTxt = request.getParameter("studentId");
		int studentId = studentIdTxt == null || studentIdTxt.isEmpty() ? 0 : Integer.parseInt(studentIdTxt);
		
		String goalIdTxt = request.getParameter("goalId");
		int goalId = goalIdTxt == null || goalIdTxt.isEmpty() ? 0 : Integer.parseInt(goalIdTxt);
		
		String statusTxt = request.getParameter("status");
		int status = statusTxt == null || statusTxt.isEmpty() ? 0 : Integer.parseInt(statusTxt);
		
		if(studentId > 0 && goalId > 0){
			try {
				courseService.updateGoalStatus(studentId, goalId, status);
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
