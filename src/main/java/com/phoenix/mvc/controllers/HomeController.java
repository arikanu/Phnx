package com.phoenix.mvc.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.phoenix.mvc.authentication.Login;
import com.phoenix.mvc.authentication.LoginAuthentication;


@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView root() {
		System.out.println("@CTRLR: /GET");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("login", new Login());
		return mav;
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("@CTRLR: homeGET");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("login", new Login());
		return mav;
	}
	
	
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		System.out.println("@CTRLR: adminHomeGET");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/home");
		mav.addObject("user", LoginAuthentication.getUser(SecurityContextHolder.getContext().getAuthentication().getName()));
		return mav;
	}
	
	
	@RequestMapping(value = "/student/home", method = RequestMethod.GET)
	public ModelAndView studentHome() {
		System.out.println("@CTRLR: studentHomeGET");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student/home");
		mav.addObject("user", LoginAuthentication.getUser(SecurityContextHolder.getContext().getAuthentication().getName()));
		return mav;
	}
	
}