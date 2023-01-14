package com.hh.advancedmapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

//			start transaction
			session.getTransaction().begin();

//			retrieve instructor detail object from database
			int instructorDetailId = 2;
			InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class, instructorDetailId);
//			print the instructor detail
			System.out.println("Instructor detail: " + tmpInstructorDetail);
//			print the associated instructor
			System.out.println("Instryctor: " + tmpInstructorDetail.getInstructor());
//			commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			factory.close();
		}
	}

}
