package com.hh.advancedmapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;

public class OneToManyDeleteCourseDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

//			start transaction
			session.getTransaction().begin();

//			get the course from db
			int courseId = 1;
			Course course = session.get(Course.class, courseId);

//			delete the course from db
			System.out.println("Deleteing course: " + course);
			session.delete(course);

//			commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			factory.close();
		}
	}
}
