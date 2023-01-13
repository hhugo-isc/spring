package com.hh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.hibernate.entity.Student;

public class DeleteStudentDemo {
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

//			delete the student
//			System.out.println("Deleting Student: " + student);
//			session.delete(student);

//			delete student id = 2
			session.createQuery("delete from Student where id=2").executeUpdate();

//			commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {

		} finally {
			factory.close();
		}
	}
}
