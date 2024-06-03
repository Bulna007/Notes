package com.qa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qa.bo.CourseBo;
import com.qa.config.JavaConfig;
import com.qa.dao.CourseDao;
import com.qa.dao.StudentDao;

public class QATest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		CourseDao courseDao = context.getBean("courseDao", CourseDao.class);

		// int courses = courseDao.getNoOfCourses();
		// System.out.println("no of courses : " + courses);

//		String courseName = courseDao.findCourseNameByCourseNo(2);
//		System.out.println("Course Name : " + courseName);

//		CourseBo bo = courseDao.findCourseByCourseNo(1);
//		System.out.println(bo);
		// courseDao.findCoursesByDuration(6).forEach(System.out::println);
		//courseDao.findCoursesByName("Java").forEach(System.out::println);
//		CourseBo bo = new CourseBo();
//		bo.setCourseNo(4);
//		bo.setCourseName("Microservices");
//		bo.setDuration(2);
//		bo.setFee(6000);
		
//		int records = courseDao.saveCourse(bo);
//		System.out.println("records inserted : " + records);
//		int courseNo = courseDao.saveCourse("Spring Boot", 2, 6000);
//		System.out.println("courseno : " + courseNo);
		
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		studentDao.getAllStudentsWithCourses().forEach(System.out::println);
		studentDao.getAllStudentsByPagination(3, 3).forEach(System.out::println);;
		
	}
}
