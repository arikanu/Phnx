package com.phoenix.mvc.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.phoenix.mvc.db.entities.user.Role;

@Component
public class PhnxSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess
			(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
			throws IOException, ServletException {
		
		System.out.println("     @PhnxSuccessHandler.onAuthenticationSuccess");
		System.out.println("          authentication.getName = " + authentication.getName());
		
		List<Role> roles = LoginAuthentication.getRoles(authentication.getName());
			
		List<String> strRoles = new ArrayList<String>();
		for(Role role : roles) {
			strRoles.add("ROLE_" + role.getRoleName().toUpperCase());
		}
		
		// Redirecting actions according to the roles
		if (strRoles.contains("ROLE_ADMIN")) {
			response.sendRedirect("/mvc/admin/home");
		} else if (strRoles.contains("ROLE_STUDENT")) {
			response.sendRedirect("/mvc/student/home");
		} else {
			response.sendRedirect("/mvc/home");
		}
		
	}

}
