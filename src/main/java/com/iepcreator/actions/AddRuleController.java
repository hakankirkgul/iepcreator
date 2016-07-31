package com.iepcreator.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.ICourseService;

public class AddRuleController extends BaseController {
	
	private ICourseService courseService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String studentIdTxt = request.getParameter("studentId");
		int studentId = studentIdTxt == null || studentIdTxt.isEmpty() ? 0 : Integer.parseInt(studentIdTxt);
		
		String subjectIdTxt = request.getParameter("subjectId");
		int subjectId = subjectIdTxt == null || subjectIdTxt.isEmpty() ? 0 : Integer.parseInt(subjectIdTxt);
		
		String preSubjectIdTxt = request.getParameter("preSubjectId");
		int preSubjectId = preSubjectIdTxt == null || preSubjectIdTxt.isEmpty() ? 0 : Integer.parseInt(preSubjectIdTxt);
		
		if(studentId > 0 && subjectId > 0 && preSubjectId > 0){
			try {
				courseService.addRule(studentId, subjectId, preSubjectId);
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
