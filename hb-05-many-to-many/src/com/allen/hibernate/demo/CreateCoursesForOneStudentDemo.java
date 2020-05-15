package com.allen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allen.hibernate.demo.entity.Course;
import com.allen.hibernate.demo.entity.Instructor;
import com.allen.hibernate.demo.entity.InstructorDetail;
import com.allen.hibernate.demo.entity.Review;
import com.allen.hibernate.demo.entity.Student;

public class CreateCoursesForOneStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the student 1 from database
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\n Loaded student: " + tempStudent);
			System.out.println("courses: " + tempStudent.getCourses());
			
			// create more courses
			Course course1 = new Course("Programming in Java");
			Course course2 = new Course("Intro to database");
			
			// add the student to courses
			course1.addStudent(tempStudent);
			course2.addStudent(tempStudent);
			
			System.out.println("\nSaving the courses,,,");
			
			session.save(course1);
			session.save(course2);
			
			
			// save the courses
			
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
