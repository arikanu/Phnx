package com.phoenix.mvc.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.phoenix.mvc.db.entities.User;
import com.phoenix.mvc.db.queries.QLogin;
import com.phoenix.mvc.db.queries.QUser;
import com.phoenix.mvc.viewmodels.VM_Home;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);
		VM_Home vm_home = new VM_Home();
		vm_home.setValidLogin(false);
		vm_home.setFormattedDate(formattedDate);
		vm_home.setUser(null);
		ModelAndView mavHome = new ModelAndView();
		mavHome.setViewName("home");
		mavHome.addObject("model", vm_home);
		return mavHome;
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		mav.addObject("loginUser", new User());
		return mav;
	}
	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public ModelAndView loginSubmit(Locale locale, @ModelAttribute User userLoginAttempt) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);
		boolean isValidLogin = QLogin.isValidUser(userLoginAttempt);
		VM_Home vmHome = new VM_Home();
		vmHome.setValidLogin(isValidLogin);
		vmHome.setFormattedDate(formattedDate);
		if (isValidLogin) {
			vmHome.setUser(QUser.getUser(userLoginAttempt.getEmailAddress()));
		} else {
			vmHome.setUser(userLoginAttempt);
		}
		ModelAndView mavHome = new ModelAndView("home");
		mavHome.addObject("model", vmHome);
		return mavHome;
	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		mav.addObject("registerUser", new User());
		return mav;
	}
	@RequestMapping(value = "/registerSubmit", method = RequestMethod.POST)
	public ModelAndView registerSubmit(Locale locale, @ModelAttribute User userRegisterAttempt) {
		ModelAndView mav = new ModelAndView();
		if (QUser.existsUser(userRegisterAttempt.getEmailAddress())) {
			mav.setViewName("register");
			mav.addObject("registerUser", new User());			
		} else {
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
			String formattedDate = dateFormat.format(date);
			QUser.addUser(userRegisterAttempt);
			VM_Home vmHome = new VM_Home();
			vmHome.setValidLogin(true);
			vmHome.setFormattedDate(formattedDate);
			vmHome.setUser(userRegisterAttempt);
			mav.setViewName("home");
			mav.addObject("model", vmHome);
		}
		return mav;
	}
	
}
