package com.phoenix.mvc.db.initialize;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.phoenix.mvc.db.entities.Choice;
import com.phoenix.mvc.db.entities.Exam;
import com.phoenix.mvc.db.entities.ExamMasterPart;
import com.phoenix.mvc.db.entities.ExamPart;
import com.phoenix.mvc.db.entities.ExamType;
import com.phoenix.mvc.db.entities.Question;
import com.phoenix.mvc.db.entities.Role;
import com.phoenix.mvc.db.entities.User;

public class InitializeDb {

	public static void main(String[] args) {
		
		// CREATE TABLES
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(Role.class);
		config.addAnnotatedClass(ExamType.class);
		config.addAnnotatedClass(Exam.class);
		config.addAnnotatedClass(ExamMasterPart.class);
		config.addAnnotatedClass(ExamPart.class);
		config.addAnnotatedClass(Question.class);
		config.addAnnotatedClass(Choice.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
		
		
		// ADD SAMPLE DATA
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		// USER
		User uur = new User();
		uur.setEmailAddress("arikanu@metu.edu.tr");
		uur.setFirstName("Ugur");
		uur.setLastName("Arikan");
		uur.setPassWord("pass");		
		session.save(uur);
		User baco = new User();
		baco.setEmailAddress("huseyinbacanak@gmail.com");
		baco.setFirstName("Huseyin");
		baco.setLastName("Bacanak");
		baco.setPassWord("pass");
		session.save(baco);
		User ikiz = new User();
		ikiz.setEmailAddress("umut@ikizler.com");
		ikiz.setFirstName("Umut");
		ikiz.setLastName("Gumus");
		ikiz.setPassWord("pass");
		session.save(ikiz);
		
		// ROLE
		Role admin = new Role();
		admin.setRoleName("Admin");
		admin.getUsers().add(uur);
		session.save(admin);
		Role student = new Role();
		student.setRoleName("Student");
		student.getUsers().add(baco);
		student.getUsers().add(ikiz);
		session.save(student);	
		
		
		// EXAM TYPE
		ExamType oss = new ExamType();
		oss.setExamTypeCode("oss");
		oss.setExamTypeName("Ogrenci Secme Yerlestirme Sinavi");
		session.save(oss);
		
		ExamType kpss = new ExamType();
		kpss.setExamTypeCode("kpss");
		kpss.setExamTypeName("Kamu Personeli Secme Sinavi");
		session.save(kpss);
		
			// EXAM
			Exam oss2013 = new Exam();
			oss2013.setYear("2013");
			oss2013.setIdInYear(1);
			oss2013.setTimeLimit(180);
			oss2013.setNbQuestions(180);
			oss2013.setExamType(oss);
			session.save(oss2013);
			
			Exam oss2012 = new Exam();
			oss2012.setYear("2012");
			oss2012.setIdInYear(1);
			oss2012.setTimeLimit(180);
			oss2012.setNbQuestions(180);
			oss2012.setExamType(oss);
			session.save(oss2012);
			
			Exam kpss2013A = new Exam();
			kpss2013A.setYear("2013");
			kpss2013A.setIdInYear(1);
			kpss2013A.setIdName("guz");
			kpss2013A.setTimeLimit(180);
			kpss2013A.setNbQuestions(180);
			kpss2013A.setExamType(kpss);
			session.save(kpss2013A);
			
			Exam kpss2013B = new Exam();
			kpss2013B.setYear("2013");
			kpss2013B.setIdInYear(2);
			kpss2013B.setIdName("bahar");
			kpss2013B.setTimeLimit(180);
			kpss2013B.setNbQuestions(180);
			kpss2013B.setExamType(kpss);
			session.save(kpss2013B);
			
				// EXAM MASTER PART
				ExamMasterPart sayisal1oss2013 = new ExamMasterPart();
				sayisal1oss2013.setIdInExam(1);
				sayisal1oss2013.setMasterPartName("Sayisal 1");
				sayisal1oss2013.setSuggestedTime(90);
				sayisal1oss2013.setTimeRestricted(true);
				sayisal1oss2013.setExam(oss2013);
				session.save(sayisal1oss2013);
			
				ExamMasterPart sayisal2oss2013 = new ExamMasterPart();
				sayisal2oss2013.setIdInExam(1);
				sayisal2oss2013.setMasterPartName("Sayisal 2");
				sayisal2oss2013.setSuggestedTime(90);
				sayisal2oss2013.setTimeRestricted(true);
				sayisal2oss2013.setExam(oss2013);
				session.save(sayisal2oss2013);
				
					// EXAM PART
					ExamPart mat1oss2013 = new ExamPart();
					mat1oss2013.setPartIdInMasterPart(1);
					mat1oss2013.setPartName("Matematik 1");
					mat1oss2013.setSuggestedTime(30);
					mat1oss2013.setTimeRestricted(false);
					mat1oss2013.setExamMasterPart(sayisal1oss2013);
					session.save(mat1oss2013);
					
					ExamPart fzk1oss2013 = new ExamPart();
					fzk1oss2013.setPartIdInMasterPart(2);
					fzk1oss2013.setPartName("Fizik 1");
					fzk1oss2013.setSuggestedTime(30);
					fzk1oss2013.setTimeRestricted(false);
					fzk1oss2013.setExamMasterPart(sayisal1oss2013);
					session.save(fzk1oss2013);
					
						// QUESTION
						Question mat1q1 = new Question();
						mat1q1.setQuestionIdInExam(1);
						mat1q1.setQuestionText("Uc kere dort kac eder?");
						mat1q1.setCorrectChoice("A");
						mat1q1.setExamPart(mat1oss2013);
						session.save(mat1q1);
		
						Question mat1q2 = new Question();
						mat1q2.setQuestionIdInExam(2);
						mat1q2.setQuestionText("Alti kere alti kac eder?");
						mat1q2.setCorrectChoice("B");
						mat1q2.setExamPart(mat1oss2013);
						session.save(mat1q2);			
			
			
							// CHOICE
							Choice mat1q1A = new Choice();
							mat1q1A.setChoiceLabel("A");
							mat1q1A.setChoiceText("12");
							mat1q1A.setCorrectAnswer(true);
							mat1q1A.setQuestion(mat1q1);
							session.save(mat1q1A);
		
							Choice mat1q1B = new Choice();
							mat1q1B.setChoiceLabel("B");
							mat1q1B.setChoiceText("11");
							mat1q1B.setCorrectAnswer(false);
							mat1q1B.setQuestion(mat1q1);
							session.save(mat1q1B);
							
							Choice mat1q1C = new Choice();
							mat1q1C.setChoiceLabel("C");
							mat1q1C.setChoiceText("24");
							mat1q1C.setCorrectAnswer(false);
							mat1q1C.setQuestion(mat1q1);
							session.save(mat1q1C);
							
							Choice mat1q1D = new Choice();
							mat1q1D.setChoiceLabel("D");
							mat1q1D.setChoiceText("33");
							mat1q1D.setCorrectAnswer(false);
							mat1q1D.setQuestion(mat1q1);
							session.save(mat1q1D);
							
							Choice mat1q1E = new Choice();
							mat1q1E.setChoiceLabel("E");
							mat1q1E.setChoiceText("43");
							mat1q1E.setCorrectAnswer(false);
							mat1q1E.setQuestion(mat1q1);
							session.save(mat1q1E);
						
		//*/
		session.getTransaction().commit();
		
		
		
		
		

	}

}
