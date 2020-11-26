package com.neighborpil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neighborpil.hibernate.demo.entity.Course;
import com.neighborpil.hibernate.demo.entity.Instructor;
import com.neighborpil.hibernate.demo.entity.InstructorDetail;
import com.neighborpil.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

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
			
			// create a course
			Course tempCourse = new Course("Pacman - How to score one millon points");
			
			// add some reviews
			tempCourse.addReview(new Review("Great course"));
			tempCourse.addReview(new Review("Worst course"));
			tempCourse.addReview(new Review("Great course"));
			
			// save the course and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			

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
