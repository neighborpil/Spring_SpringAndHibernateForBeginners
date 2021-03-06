package com.neighborpil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neighborpil.hibernate.demo.entity.Course;
import com.neighborpil.hibernate.demo.entity.Instructor;
import com.neighborpil.hibernate.demo.entity.InstructorDetail;
import com.neighborpil.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// print the course
			System.out.println("Deleting the course...");
			System.out.println(tempCourse);
			
			// delete the course
			session.delete(tempCourse);
			
			// print the coruse reviews
			System.out.println(tempCourse.getReviews());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch(Exception ex) {
			session.getTransaction().rollback();
		}finally {
			session.close();
			factory.close();
		} 
		
	}

}
