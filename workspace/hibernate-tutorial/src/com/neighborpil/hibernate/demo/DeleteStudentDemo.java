package com.neighborpil.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neighborpil.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 5;
			
			// start a transaction
			session.beginTransaction();
			
			System.out.println("Student Id: " + studentId);
			
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Get student: " + student);
			
			// delete the student
			System.out.println("Delete student: " + student);
			session.delete(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			// ---------------------------------------------
			// delete student id=2
			System.out.println("delete student id=2");
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=2").executeUpdate();
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
