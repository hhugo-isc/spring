package com.hh.advancedmapping.demo;

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

//			create the objects

//			asociacion de los objetos

//			start transaction
			session.getTransaction().begin();

//			get the instructor from db
			int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);

			System.out.println("The instructor: " + instructor);

//			get courses from the instructor
			System.out.println("Courses: " + instructor.getCourses());

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
