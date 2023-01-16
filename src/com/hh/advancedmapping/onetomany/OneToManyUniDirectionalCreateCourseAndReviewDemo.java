package com.hh.advancedmapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;
import com.hh.advancedmapping.entity.Review;

public class OneToManyUniDirectionalCreateCourseAndReviewDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

//			create a course
			Course tmpCourse = new Course("PACMAN - How To Score One Million Points");

//			add some reviews
			tmpCourse.addReview(new Review("Great Course..."));
			tmpCourse.addReview(new Review("Cool course, job well done"));
			tmpCourse.addReview(new Review("What a dumb course, you are an idion!"));

//			save the course ... and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tmpCourse.getReviews());
			session.save(tmpCourse);

//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}
}
