package com.neighborpil.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neighborpil.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			// start a transaction
			session.beginTransaction();
			
			System.out.println("Student Id: " + studentId);
			
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Get student: " + student);
			
			// update student
			System.out.println("Update student...");
			student.setFirstName("Scooby");
			
			// commit transaction
			session.getTransaction().commit();
			
			// ---------------------------------------
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email = concat('Test', email)").executeUpdate();
			
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
