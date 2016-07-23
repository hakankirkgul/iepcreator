package com.iepcreator.actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.IStudentService;

public class UpdateStudentController extends BaseController{
	
	private IStudentService studentService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String studentIdTxt = request.getParameter("studentId");
		int studentId = studentIdTxt == null || studentIdTxt.isEmpty() ? 0 : Integer.parseInt(studentIdTxt);
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String gender = request.getParameter("gender");
		String parentName = request.getParameter("parentName");
		String parentSurname = request.getParameter("parentSurname");
		String dateTxt = request.getParameter("birthDate");
		Date birthDate = dateTxt == null || dateTxt.isEmpty() ? null : new SimpleDateFormat("dd.mm.yyyy").parse(dateTxt);
		
		if(studentId > 0 && name != null && !name.isEmpty() && surname != null && !surname.isEmpty() && gender != null && !gender.isEmpty() 
		&& parentName != null && !parentName.isEmpty() && parentSurname != null && !parentSurname.isEmpty() && birthDate != null){
			try {
				studentService.updateStudent(studentId, name, surname, gender, parentName, parentSurname, birthDate);
				mv.getModelMap().put("success", "success");
			} catch (Exception e) {
				if(e.getMessage().contains("Duplicate")){
					mv.getModelMap().put("error", "Student Exists");
				} else {
					mv.getModelMap().put("error", "System Error");
				}
			}
		}
		
		return mv;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

}
