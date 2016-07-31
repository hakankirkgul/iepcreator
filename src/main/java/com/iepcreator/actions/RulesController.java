package com.iepcreator.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.ICourseService;
import com.iepcreator.models.RuleModel;
import com.iepcreator.models.SubjectModel;

public class RulesController extends BaseController {
	
	private ICourseService courseService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String studentIdTxt = request.getParameter("studentId");
		int studentId = studentIdTxt == null || studentIdTxt.isEmpty() ? 0 : Integer.parseInt(studentIdTxt);
		
		String courseIdTxt = request.getParameter("courseId");
		int courseId = courseIdTxt == null || courseIdTxt.isEmpty() ? 0 : Integer.parseInt(courseIdTxt);
		
		if(studentId > 0 && courseId > 0){
			List<SubjectModel> subjects = courseService.getSubjects(courseId);
			mv.getModelMap().put("subjects",subjects);
			
			int goalCountPerSubject = courseService.getGoalCountPerSubject(studentId, courseId);
			mv.getModelMap().put("goalCountPerSubject", goalCountPerSubject);
			
			List<RuleModel> rules = courseService.getRules(courseId, studentId);
			mv.getModelMap().put("rules", rules);
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
