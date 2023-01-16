package com.hh.advancedmapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

//			start transaction
			session.getTransaction().begin();

//			get the instructor by primary key / id
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);

			System.out.println("Found Instructor: " + instructor);

//			delete the instructor

			if (instructor != null) {
				System.out.println("Deleting instructor: " + instructor);
//				Will also delete associated "details" object
//				because of CascadeType.ALL
				session.delete(instructor);
			}
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
