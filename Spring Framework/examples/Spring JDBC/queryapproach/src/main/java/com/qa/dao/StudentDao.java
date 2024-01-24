package com.qa.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.qa.bo.CourseBo;
import com.qa.bo.StudentBo;

@Repository
public class StudentDao {
	private final String SQL_GET_ALL_STUDENTS_WITH_COURSES = "select s.student_no, s.student_nm, s.age, s.gender, s.mobile_no, s.email_address, s.qualification, c.course_no, c.course_nm, c.duration, c.fee from student s inner join student_course sc on s.student_no = sc.student_no inner join course c on sc.course_no = c.course_no order by s.student_nm";
	private final String SQL_GET_ALL_STUDENTS_SORTBY_NM = "select student_no, student_nm, age, gender, mobile_no, email_address, qualification from student order by student_nm";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Collection<StudentBo> getAllStudentsWithCourses() {
		return jdbcTemplate.query(SQL_GET_ALL_STUDENTS_WITH_COURSES, (rs) -> {
			Map<Integer, StudentBo> studentCourseMap = new HashMap<>();
			StudentBo studentBo = null;
			CourseBo courseBo = null;
			int studentNo = 0;
			List<StudentBo> students = null;

			while (rs.next()) {
				studentNo = rs.getInt(1);

				if (studentCourseMap.containsKey(studentNo) == false) {
					studentBo = new StudentBo();
					studentBo.setStudentNo(rs.getInt(1));
					studentBo.setStudentName(rs.getString(2));
					studentBo.setAge(rs.getInt(3));
					studentBo.setGender(rs.getString(4));
					studentBo.setQualification(rs.getString(5));
					studentBo.setMobileNo(rs.getString(6));
					studentBo.setEmailAddress(rs.getString(7));
					studentBo.setCourses(new ArrayList<>());
					studentCourseMap.put(studentNo, studentBo);
				}

				studentBo = studentCourseMap.get(studentNo);
				courseBo = new CourseBo();
				courseBo.setCourseNo(rs.getInt(8));
				courseBo.setCourseName(rs.getString(9));
				courseBo.setDuration(rs.getInt(10));
				courseBo.setFee(rs.getDouble(11));
				studentBo.getCourses().add(courseBo);
			}
			return studentCourseMap.values();

		});
	}
	
	public List<StudentBo> getAllStudentsByPagination(final int pageNo,final int pageSize) {
		return jdbcTemplate.query(SQL_GET_ALL_STUDENTS_SORTBY_NM, (rs)->{
			int startIndex = (pageSize * (pageNo - 1)) + 1;
			int endIndex = pageSize * pageNo;
			List<StudentBo> students = null;
			int rowNum = 1;
			
			students = new ArrayList<>();
			while(rs.next() && rowNum <= endIndex) {
				if(rowNum >= startIndex) {
					StudentBo studentBo = new StudentBo();
					studentBo.setStudentNo(rs.getInt(1));
					studentBo.setStudentName(rs.getString(2));
					studentBo.setAge(rs.getInt(3));
					studentBo.setGender(rs.getString(4));
					studentBo.setQualification(rs.getString(5));
					studentBo.setMobileNo(rs.getString(6));
					studentBo.setEmailAddress(rs.getString(7));
					students.add(studentBo);
				}
				rowNum++;
			}
			
			return students;
		});
	}

}

























