package com.hh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.hibernate.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		create session
		Session session = factory.getCurrentSession();
		try {
//			begin transaction
			session.beginTransaction();

			List<Student> students = session.createQuery("from Student", Student.class).getResultList();

			displayStudents(students);

			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(students);

//			Query students: lastname='Doe' OR firstName='Daffy'
			students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'")
					.getResultList();

			System.out.println("\n\nStudents who have last name of Doe OR firstName of Daffy");
			displayStudents(students);

//			query student where email LIKE '%hh.com'
			students = session.createQuery("from Student s where s.email LIKE '%hh.com'").getResultList();

			System.out.println("\n\nStudents whose email ends with hh.com");
			displayStudents(students);

//			commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
