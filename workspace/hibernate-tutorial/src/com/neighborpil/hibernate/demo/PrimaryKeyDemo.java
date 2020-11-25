package com.neighborpil.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.neighborpil.hibernate.demo.entity.Student;

class PrimaryKeyDemo {

	public static void main(String[] args) {

		var factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		var session = factory.getCurrentSession();
		
		try {
			
			var student1 = new Student("한1", "글1", "한글1@메일.com");
			var student2 = new Student("한2", "글", "한글1@메일.com");
			var student3 = new Student("한3", "글32", "한글1@메일.com");
			
			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
