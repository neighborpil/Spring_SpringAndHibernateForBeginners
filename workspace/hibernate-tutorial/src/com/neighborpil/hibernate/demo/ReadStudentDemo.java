package com.neighborpil.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neighborpil.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Wall'").getResultList();					
			
			displayStudents(theStudents);
			
			
			// query students: lastName = 'Wall' or firstName = '한';
			theStudents = session.createQuery("from Student s where"
					+ " s.lastName = 'Wall' or firstName = '한1'").getResultList();
			
			displayStudents(theStudents);
			
			// query students: s.email LIKE '%@메일.com'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%@메일.com'").getResultList();
			
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		} 
	}

	private static void displayStudents(List<Student> theStudents) {
		System.out.println("---------------------------");
		// display the students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		System.out.println("---------------------------");
		System.out.println();
	}
}
