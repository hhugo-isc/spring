package com.hh.advancedmapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;

public class FetchJoinDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

//			start transaction
			session.getTransaction().begin();

//			HIBERNATE QUERY CON HQL
			int instructorId = 1;
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id = :theInstructorId",
					Instructor.class);

//			 set the parameter on query
			query.setParameter("theInstructorId", instructorId);

//			execute query and get instructor
			Instructor instructor = query.getSingleResult();

			System.out.println("Instructor: " + instructor);

//			commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
