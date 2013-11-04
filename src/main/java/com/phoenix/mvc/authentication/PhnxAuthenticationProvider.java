package com.phoenix.mvc.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.phoenix.mvc.db.entities.user.Role;

@Component
public class PhnxAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("     @PhnxAuthenticationProvider.authenticate");
		
		String emailAddress = authentication.getName();
		String password = authentication.getCredentials().toString();
		boolean isValidLogin = LoginAuthentication.isValidLogin(emailAddress, password);
		
		if (isValidLogin) {
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			List<Role> roles = LoginAuthentication.getRoles(emailAddress);
			for(Role role : roles) {
				SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase());
				grantedAuths.add(sga);
			}
			Authentication auth = new UsernamePasswordAuthenticationToken(emailAddress, password, grantedAuths);
			return auth;
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		System.out.println("     @PhnxAuthenticationProvider.supports");		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
