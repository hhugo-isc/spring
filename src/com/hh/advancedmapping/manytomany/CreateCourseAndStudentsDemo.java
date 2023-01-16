package com.hh.advancedmapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.advancedmapping.entity.Course;
import com.hh.advancedmapping.entity.Instructor;
import com.hh.advancedmapping.entity.InstructorDetail;
import com.hh.advancedmapping.entity.Review;
import com.hh.advancedmapping.entity.Student;

public class CreateCourseAndStudentsDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

//			create a course
			Course course = new Course("Pacman - How to Score One Million Points");

//			save course ... and 
			System.out.println("Saving the course");
			session.save(course);
			System.out.println("Saved Course: " + course);

//			create students
			Student tmpStudent1 = new Student("John", "Doe", "john@hh.com");
			Student tmpStudent2 = new Student("Mary", "Public", "maty@hh.com");

//			add students to the course
			course.addStudent(tmpStudent1);
			course.addStudent(tmpStudent2);

//			save the students
			System.out.println("Saving students");
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			System.out.println("Saved students: " + course.getStudentns());

			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			session.close();
			factory.close();
		}
	}
}
