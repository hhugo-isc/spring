package com.hh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.hibernate.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

//			start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

//			Retrieve student based on the id: primary key
			System.out.println("Getting student with id: " + studentId);

			Student student = session.get(Student.class, studentId);

			System.out.println("Updating Student...");
			student.setFirstName("Scooby");

//			commit transaction
			session.getTransaction().commit();

//			NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();

//			update email for all students
			System.out.println("uodate email for all students");
			session.createQuery("update Student set email='foo.gmail.com'").executeUpdate();

//			commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {

		} finally {
			factory.close();
		}
	}
}
