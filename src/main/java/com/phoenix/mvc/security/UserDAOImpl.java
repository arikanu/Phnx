package com.phoenix.mvc.security;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.mvc.db.entities.User;
import com.phoenix.mvc.db.initialize.HibernateUtil;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private static Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public User getUser(String emailAddress) {
		String qry = "from User where emailAddress = '" + emailAddress + "'";
		ArrayList<User> userList = new ArrayList<User>(session.createQuery(qry).list());
		if (userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}		
	}
}
