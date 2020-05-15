package com.allen.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatePracticeApp {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
//			// create a employee object
//			Employee myEmployee = new Employee("Bosco", "Su", "Student");
//			
//			// start a transaction
//			session.beginTransaction();
//			
//			// save the object to the db
//			session.save(myEmployee);
//			
//			// commit the transaction
//			session.getTransaction().commit();
//						
//			// start a new session
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			// Retrieve the employee from the database by pk
//			Employee tempEmployee = session.get(Employee.class, 2);
//			
//			session.getTransaction().commit();
//			
//			System.out.println("Read employee: " + tempEmployee.getFirstName() + " " + tempEmployee.getLastName());
//			
			
			// start a transaction
			session.beginTransaction();
			
			// Retrieve the employee by querying its company
			List<Employee> tempEmployeeList = session.createQuery("from Employee e where e.company='student'").getResultList();
			
			session.getTransaction().commit();
			
			for (Employee tEmployee : tempEmployeeList) {
				System.out.println(tEmployee.getFirstName() + " " + tEmployee.getLastName());
			}
			
			// start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// delete an employee by pk
			System.out.println("\nStart deleting...");
			Employee tempEmployee = session.get(Employee.class, 3);
			System.out.println(tempEmployee);
			session.delete(tempEmployee);
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
	}

}
