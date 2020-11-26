package com.neighborpil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.neighborpil.hibernate.demo.entity.Course;
import com.neighborpil.hibernate.demo.entity.Instructor;
import com.neighborpil.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			// options 2: Hibernate query with HQL
			
			// get the instructor from db
			int theId = 1;
			
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId", 
					Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("[NeighborPil]Instructor: " + tempInstructor);

			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("[Neighborpil] The session is closed.\n\n");
			
			
			System.out.println("[Neighborpil] Courses: " + tempInstructor);
			
			
			System.out.println("[Neighborpil] Courses: " + tempInstructor.getCourses());
			
			session.close();
			
			System.out.println("Done!");
		} catch(Exception ex) {
			//session.getTransaction().rollback();
		}finally {
			session.close();
			factory.close();
		} 
	}

}
