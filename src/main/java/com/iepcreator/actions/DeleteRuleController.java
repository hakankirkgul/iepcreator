package com.iepcreator.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.ICourseService;

public class DeleteRuleController extends BaseController {
	
	private ICourseService courseService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String ruleIdTxt = request.getParameter("ruleId");
		int ruleId = ruleIdTxt == null || ruleIdTxt.isEmpty() ? 0 : Integer.parseInt(ruleIdTxt);
		
		if(ruleId > 0){
			try {
				courseService.deleteRule(ruleId);
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
