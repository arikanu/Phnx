package com.phoenix.mvc.authentication;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.phoenix.mvc.db.entities.user.Role;
import com.phoenix.mvc.db.entities.user.User;
import com.phoenix.mvc.db.utils.HibernateUtil;

public class LoginAuthentication {

	static Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public static User getUser(String emailAddress) {
		
		session.beginTransaction();
		Query query = session.createQuery(SqlAuthentication.qUserByEmail(emailAddress));
		ArrayList<User> userList = new ArrayList<User>(query.list());
		if (userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}
	}
	
	public static boolean doesUserExist(String emailAddress) {
		
		session.beginTransaction();
		Query query = session.createQuery(SqlAuthentication.qUserByEmail(emailAddress));
		ArrayList<User> userList = new ArrayList<User>(query.list());
		if (userList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isValidLogin(String emailAddress, String password) {
		
		session.beginTransaction();
		Query query = session.createQuery(SqlAuthentication.qUserByEmailPassword(emailAddress, password));
		ArrayList<User> userList = new ArrayList<User>(query.list());
		if (userList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static List<Role> getRoles(String emailAddress) {
		
		session.beginTransaction();
		Query query = session.createQuery(SqlAuthentication.qUserByEmail(emailAddress));
		ArrayList<User> userList = new ArrayList<User>(query.list());
		if (userList.size() > 0) {
			return userList.get(0).getRoles();
		} else {
			return null;
		}
	}
	
}
