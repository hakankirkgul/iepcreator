package com.iepcreator.actions;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.IStudentService;
import com.iepcreator.models.UserLoginModel;

public class AddStudentController extends BaseController{
	
	private IStudentService studentService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		UserLoginModel user = (UserLoginModel)request.getSession().getAttribute("LOGGEDIN_USER");
		if(user != null){
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String gender = request.getParameter("gender");
			String parentName = request.getParameter("parentName");
			String parentSurname = request.getParameter("parentSurname");
			String dateTxt = request.getParameter("birthDate");
			Date birthDate = dateTxt == null || dateTxt.isEmpty() ? null : new SimpleDateFormat("dd.MM.yyyy").parse(dateTxt);
			
			if(name != null && !name.isEmpty() && surname != null && !surname.isEmpty() && gender != null && !gender.isEmpty() 
			&& parentName != null && !parentName.isEmpty() && parentSurname != null && !parentSurname.isEmpty() && birthDate != null){
				try {
					studentService.addStudent(user.getUserId(), name, surname, gender, parentName, parentSurname, birthDate);
					mv.getModelMap().put("success", "success");
				} catch (Exception e) {
					if(e.getMessage().contains("Duplicate")){
						mv.getModelMap().put("error", "Student Exists");
					} else {
						mv.getModelMap().put("error", "System Error");
					}
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
