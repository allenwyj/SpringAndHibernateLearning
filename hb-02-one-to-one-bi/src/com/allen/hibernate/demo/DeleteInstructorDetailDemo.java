package com.allen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allen.hibernate.demo.entity.Instructor;
import com.allen.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("Instructor detail: " + tempInstructorDetail);
			
			// print the associated instructor
			System.out.println("Associate instructor: " + tempInstructorDetail.getInstructor());

			
			// remove the assoicated object ref
			// break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			// commit the transaction
			session.getTransaction().commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}

	}

}
