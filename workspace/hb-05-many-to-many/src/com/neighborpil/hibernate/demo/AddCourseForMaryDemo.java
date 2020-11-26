package com.neighborpil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neighborpil.hibernate.demo.entity.Course;
import com.neighborpil.hibernate.demo.entity.Instructor;
import com.neighborpil.hibernate.demo.entity.InstructorDetail;
import com.neighborpil.hibernate.demo.entity.Review;
import com.neighborpil.hibernate.demo.entity.Student;

public class AddCourseForMaryDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the student mary from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());
			
			// create mroe courses
			Course tempCourse1 = new Course("Rubik's Cube - how to speed cubpe");
			Course tempCourse2 = new Course("Atari2000 - Game play");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the coruses
			System.out.println("\nSaving the courses..");
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
		}

	}

}
