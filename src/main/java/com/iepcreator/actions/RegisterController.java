package com.iepcreator.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.iepcreator.jdbc.services.IUserManagerService;

public class RegisterController extends BaseController {

	private IUserManagerService userManagerService;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(getPageName());
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email != null && !email.isEmpty() && password != null && !password.isEmpty()){
			userManagerService.addUser(email, password);
			mv.getModelMap().put("success", true);
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
