package com.hh.advancedmapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;

public class OneToManyCreateInstructorDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

//			create the objects
			Instructor instructor = new Instructor("Susana", "Public", "susan@hh.com");
			InstructorDetail detail = new InstructorDetail("http://www.youtube.com/", "Video Games");

//			asociacion de los objetos
			instructor.setInstructorDetailId(detail);

//			start transaction
			session.getTransaction().begin();

//			save the instructor 
//			NOTE: This will ALSO save the details object 
//			because of CascadeType.ALL
			System.out.println("saving instructor: " + instructor);
			session.save(instructor);

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
