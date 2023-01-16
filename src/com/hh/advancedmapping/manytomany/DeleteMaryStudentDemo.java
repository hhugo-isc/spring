package com.hh.advancedmapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;
import com.hh.advancedmapping.entity.Review;
import com.hh.advancedmapping.entity.Student;

public class DeleteMaryStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

//			start transaction
			session.beginTransaction();

//			get student mary from db
			int studentId = 2;
			Student tmpStudent = session.get(Student.class, studentId);

			System.out.println("\nLoaded student: " + tmpStudent);
			System.out.println("Courses: " + tmpStudent.getCourses());

//			delete student
			System.out.println("\nDeleting Student...");
			session.delete(tmpStudent);

//			commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			session.close();
			factory.close();
		}
	}
}
