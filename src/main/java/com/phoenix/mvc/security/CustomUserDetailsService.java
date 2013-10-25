package com.phoenix.mvc.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoenix.mvc.db.entities.User;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
		User domainUser = userDAO.getUser(emailAddress);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		return new org.springframework.security.core.userdetails.User
		(
			domainUser.getEmailAddress(), 
			domainUser.getPassWord(), 
			enabled, 
			accountNonExpired, 
			credentialsNonExpired, 
			accountNonLocked, 
			getAuthorities(domainUser.getRoles().get(0).getRoleId())
		);
	}
	
	 public Collection getAuthorities(Integer role) {  
	        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));  
	        return authList;  
    }

	private List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();
		if (role.intValue() == 1) {
			roles.add("ROLE_MODERATOR");
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_MODERATOR");
		}
		return roles;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {  
            authorities.add(new SimpleGrantedAuthority(role));  
        }  
        return authorities; 
	}
	
}
