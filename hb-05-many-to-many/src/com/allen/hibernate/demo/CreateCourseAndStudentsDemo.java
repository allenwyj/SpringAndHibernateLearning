package com.allen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.allen.hibernate.demo.entity.Course;
import com.allen.hibernate.demo.entity.Instructor;
import com.allen.hibernate.demo.entity.InstructorDetail;
import com.allen.hibernate.demo.entity.Review;
import com.allen.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			// save the course
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("saved the course: " + tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("A", "b", "A@b.com");
			Student tempStudent2 = new Student("C", "d", "C@d.com");
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			System.out.println("\nsaving the students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			
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
