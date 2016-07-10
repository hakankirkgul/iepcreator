package com.iepcreator.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.IUserManagerService;

public class RegisterController extends BaseController {

	private IUserManagerService userManagerService;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		
		if(email != null && !email.isEmpty() && password != null && !password.isEmpty() && name != null && !name.isEmpty() && surname != null && !surname.isEmpty()){
			try {
				userManagerService.registerUser(email, password, name, surname);
				mv.getModelMap().put("success", true);
			} catch (DuplicateKeyException e) {
				mv.getModelMap().put("error", "This email address has been taken by another user.");
			}
		}
		
		return mv;
	}

	public IUserManagerService getUserManagerService() {
		return userManagerService;
	}

	public void setUserManagerService(IUserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

}
