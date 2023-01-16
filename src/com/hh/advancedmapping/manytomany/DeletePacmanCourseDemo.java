package com.hh.advancedmapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;
import com.hh.advancedmapping.entity.Review;
import com.hh.advancedmapping.entity.Student;

public class DeletePacmanCourseDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

//			start transaction
			session.beginTransaction();

//			get the pacman course from db
			int courseId = 4;
			Course tmpCourse = session.get(Course.class, courseId);

			System.out.println("\nLoaded course: " + tmpCourse);
			System.out.println("Courses: " + tmpCourse.getStudentns());

//			delete pacman course from db
			session.delete(tmpCourse);

//			commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			session.close();
			factory.close();
		}
	}
}
