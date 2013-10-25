package com.phoenix.mvc.db.queries;

import java.util.ArrayList;
import org.hibernate.Session;
import com.phoenix.mvc.db.entities.User;
import com.phoenix.mvc.db.initialize.HibernateUtil;


public class QUser {
 
	private static Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public static User getUser(String emailAddress) {
		User user = null;
		session.beginTransaction();
		String qry = "from User where emailAddress = '" + emailAddress + "'";
		ArrayList<User> userList = new ArrayList<User>(session.createQuery(qry).list());
		for (User dbUser : userList) {
			user = dbUser;
		}
		HibernateUtil.getSessionFactory().close();
		return user;
	}
	
	public static void addUser(User user) {
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit(); 
		HibernateUtil.getSessionFactory().close();
	}
	
	public static boolean existsUser(String emailAddress) {
		boolean userExists = false;
		session.beginTransaction();
		String qry = "from User where emailAddress = '" + emailAddress + "'";
		ArrayList<User> userList = new ArrayList<User>(session.createQuery(qry).list());
		if (userList.size() > 0) {
			userExists = true;
		}
		return userExists;
	}
	
}
