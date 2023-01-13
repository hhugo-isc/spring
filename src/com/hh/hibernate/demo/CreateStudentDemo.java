package com.hh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		create session
		Session session = factory.getCurrentSession();

		try {
//			use the session object to save a Java Object
//			create a student object
			System.out.println("Creando un nuevo objeto Estudiante");
			Student tempStudent = new Student("Paul", "Wall", "paul@hh.com");

//			start a transaction
			session.beginTransaction();

//			save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);

//			commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {

		} finally {
			factory.close();
		}
	}

}
