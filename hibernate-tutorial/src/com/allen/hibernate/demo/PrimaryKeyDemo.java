package com.allen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allen.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create 3 student objects
			System.out.println("Creating 3 student objects");
			Student tempStudent1 = new Student("Allen1", "Wu1", "1allenwuyujie@gmail.com");
			Student tempStudent2 = new Student("Allen2", "Wu2", "2allenwuyujie@gmail.com");
			Student tempStudent3 = new Student("Allen3", "Wu3", "3allenwuyujie@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}		
		
	}

}
