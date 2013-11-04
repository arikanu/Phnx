package com.phoenix.mvc.db.initialize;

import java.util.ArrayList;
import org.hibernate.Session;
import com.phoenix.mvc.db.entities.exam.Exam;
import com.phoenix.mvc.db.entities.user.Role;
import com.phoenix.mvc.db.entities.user.User;
import com.phoenix.mvc.db.utils.HibernateUtil;

public class TrySelect {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String q = "from User";
		ArrayList<User> userList = new ArrayList<User>(session.createQuery(q).list()); 
		for(User user : userList)
		{
			System.out.println("FirstName: " + user.getFirstName());
			System.out.println("LastName: " + user.getLastName());
			System.out.println("Email: " + user.getEmailAddress());
			System.out.println("Password: " + user.getPassword());
			for(Role role : user.getRoles()) {
				System.out.println("  Role:" + role.getRoleName());
			}
		}
		
		String q2 = "from Exam";
		ArrayList<Exam> examList = new ArrayList<Exam>(session.createQuery(q2).list()); 
		for(Exam exam : examList)
		{
			System.out.println("ExamId: " + exam.getExamId());
			System.out.println("Year: " + exam.getYear());
		}
		
		String q3 = "from Exam where year='2013' and examid=3";
		ArrayList<Exam> examList2 = new ArrayList<Exam>(session.createQuery(q3).list()); 
		for(Exam exam2 : examList2)
		{
			System.out.println("ExamId: " + exam2.getExamId());
			System.out.println("Year: " + exam2.getYear());
		}
		
		session.getTransaction().commit(); 
		HibernateUtil.getSessionFactory().close();
		
	}
}
