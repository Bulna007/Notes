package com.npjt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.npjt.bo.CourseBo;
import com.npjt.config.JavaConfig;
import com.npjt.dao.CourseDao;

public class NPJTTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		CourseDao courseDao = context.getBean("courseDao", CourseDao.class);
		// System.out.println(courseDao.findCourseNameByCourseNo(2));
		//courseDao.getCoursesByDurationAndFee(5, 3000, 6000).forEach(System.out::println);
		CourseBo bo = new CourseBo();
		bo.setCourseNo(7);
		bo.setCourseName("Devops with AWS");
		bo.setDuration(9);
		bo.setFee(12000);
		
		int r = courseDao.saveCourse(bo);
		System.out.println("records inserted : " + r);
		
	}
}
