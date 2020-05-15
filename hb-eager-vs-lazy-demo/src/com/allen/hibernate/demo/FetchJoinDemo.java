package com.allen.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.allen.hibernate.demo.entity.Course;
import com.allen.hibernate.demo.entity.Instructor;
import com.allen.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// option 2: Hibernate query with HQL
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+ "JOIN FETCH i.courses "
															+ "where i.id = :theInstructorId",
															Instructor.class);
			
			// set parameter on query :theInstructorId
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult(); // load instructor and courses all at once.
			//List<Instructor> instructorList = query.getResultList();
			
			//System.out.println(">> tempInstructor: " + tempInstructor);
			
			//Instructor tempInstructor = instructorList.get(0);
			
			System.out.println(tempInstructor);
			
			System.out.println("\n>> The session now is closed.\n");
			
			// commit the transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// get course for the instructor
			//System.out.println(">> Course: " + tempInstructor.getCourses());
			
			System.out.println(">> Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
