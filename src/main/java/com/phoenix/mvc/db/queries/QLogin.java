package com.phoenix.mvc.db.queries;

import java.util.ArrayList;
import org.hibernate.Session;
import com.phoenix.mvc.db.entities.User;
import com.phoenix.mvc.db.initialize.HibernateUtil;

public class QLogin {

	private static Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public static boolean isValidUser(User user) {
		boolean validLogin = false;
		
		session.beginTransaction();
		String qry = "from User where emailAddress = '" + user.getEmailAddress() + "' and passWord='" + user.getPassWord() + "'";
		ArrayList<User> userList = new ArrayList<User>(session.createQuery(qry).list());
		if (userList.size() > 0) {
			validLogin = true;
		}
		
		return validLogin;
	}
}
