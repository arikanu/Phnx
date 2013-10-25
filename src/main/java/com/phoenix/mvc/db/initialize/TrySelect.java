package com.phoenix.mvc.db.initialize;

import java.util.ArrayList;
import org.hibernate.Session;
import com.phoenix.mvc.db.entities.Exam;
import com.phoenix.mvc.db.entities.User;

public class TrySelect {

	
	//private static SessionFactory factory = null;
	//private static Session session = null;
	
	public static void main(String[] args) {
		//*
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String q = "from User";
		
		ArrayList<User> userList = new ArrayList<User>(session.createQuery(q).list()); 
		for(User user : userList)
		{
			System.out.println("FirstName: "+user.getFirstName());
			System.out.println("LastName: "+user.getLastName());
			System.out.println("Email: "+user.getEmailAddress());
			System.out.println("Password: "+user.getPassWord());
		} 
		
		//*/
		
		//*
		//Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
		//session2.beginTransaction();
		
		String q2 = "from Exam";
		
		ArrayList<Exam> userList2 = new ArrayList<Exam>(session.createQuery(q2).list()); 
		for(Exam user : userList2)
		{
			System.out.println("ExamId: "+user.getExamId());
			System.out.println("Year: "+user.getYear());
		}
		
		
		
		String q3 = "from Exam where year='2013' and examid=3";
		ArrayList<Exam> userList3 = new ArrayList<Exam>(session.createQuery(q3).list()); 
		for(Exam user : userList3)
		{
			System.out.println("ExamId: "+user.getExamId());
			System.out.println("Year: "+user.getYear());
		}
		
		
		session.getTransaction().commit(); 
		HibernateUtil.getSessionFactory().close();

		
		

	}

}
