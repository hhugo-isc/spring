package com.hh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		create session
		Session session = factory.getCurrentSession();

		try {
//			use the session object to save a Java Object
//			create 3 student objects
			System.out.println("Creando un nuevo objeto Estudiante");
			Student tempStudent1 = new Student("John", "Doe", "john@hh.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@hh.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@hh.com");

//			start a transaction
			session.beginTransaction();

//			save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

//			commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {

		} finally {
			factory.close();
		}
	}

}
