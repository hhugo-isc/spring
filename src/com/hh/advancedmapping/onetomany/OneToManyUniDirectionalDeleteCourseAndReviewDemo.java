package com.hh.advancedmapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;
import com.hh.advancedmapping.entity.Review;

public class OneToManyUniDirectionalDeleteCourseAndReviewDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

//			get the course
			int courseId = 3;
			Course tmpCourse = session.get(Course.class, courseId);

//			print the course
			System.out.println("Deleting the course...");
			System.out.println(tmpCourse);

//			print the course reviews
			System.out.println(tmpCourse.getReviews());

//			delete the course
			session.delete(tmpCourse);

//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}
}
