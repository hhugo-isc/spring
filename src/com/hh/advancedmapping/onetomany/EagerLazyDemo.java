package com.hh.advancedmapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;

public class EagerLazyDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

//			start transaction
			session.getTransaction().begin();

//			get the course from db
			int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);

			System.out.println("Instructor: " + instructor);

//			get courses form the instructor
			System.out.println("Courses: " + instructor.getCourses());

//			commit transaction
			session.getTransaction().commit();

//			close the session
			session.close();
			System.out.println("Closing the session\n");

			System.out.println("Courses: " + instructor.getCourses());

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}
}
