package com.allen.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allen.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();

			// query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Lau'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Lau");
			
			displayStudents(theStudents);
			
			// query students: lastName='Wu' OR firstName='Irene'
			theStudents = session.createQuery("from Student s where"
							+ " s.lastName='Wu' OR s.firstName='Irene'").getResultList();
			
			System.out.println("\n\nStudents who have lastName='Wu' OR s.firstName='Irene'");
			displayStudents(theStudents);
			
			// query students: where email LIKE '%gmail.com'
			theStudents = session.createQuery("from Student s where"
							+ " s.email LIKE '%gmail.com'").getResultList();
			
			System.out.println("\n\nStudents who have email ending with 'gmail.com'");
			displayStudents(theStudents);
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		// display the students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
