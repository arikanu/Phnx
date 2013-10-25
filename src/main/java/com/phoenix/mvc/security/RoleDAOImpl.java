package com.phoenix.mvc.security;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phoenix.mvc.db.entities.Role;
import com.phoenix.mvc.db.initialize.HibernateUtil;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private static Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public Role getRole(int id) {
		Role role = (Role) session.load(Role.class, id);
		return role;
	}
}
