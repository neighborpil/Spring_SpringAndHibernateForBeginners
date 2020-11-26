package com.neighborpil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neighborpil.hibernate.demo.entity.Course;
import com.neighborpil.hibernate.demo.entity.Instructor;
import com.neighborpil.hibernate.demo.entity.InstructorDetail;
import com.neighborpil.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("[NeighborPil]Instructor: " + tempInstructor);

			// get course for thee instructor
			System.out.println("[NeighborPil]Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("\n[Neighborpil] The session is now closed\n");
			// option 1: call getter method while session is open
			
			
			// 세션이 끊겨서 Lazy 예외 발생
			// get course for thee instructor
			System.out.println("[NeighborPil]Courses: " + tempInstructor.getCourses());

			System.out.println("Done!");
		} catch(Exception ex) {
			//session.getTransaction().rollback();
		}finally {
			session.close();
			factory.close();
		} 
	}

}
