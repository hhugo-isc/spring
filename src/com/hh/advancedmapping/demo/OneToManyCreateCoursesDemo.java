package com.hh.advancedmapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;

public class OneToManyCreateCoursesDemo {
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

//			create some courses
			Course tmpCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tmpCourse2 = new Course("The Oainball Masterclass");

//			add courses to the instructor
			instructor.addCourse(tmpCourse1);
			instructor.addCourse(tmpCourse2);

//			save the courses
			session.save(tmpCourse1);
			session.save(tmpCourse2);

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
