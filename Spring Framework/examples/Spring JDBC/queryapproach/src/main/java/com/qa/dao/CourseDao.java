package com.qa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.qa.bo.CourseBo;

@Repository
public class CourseDao {
	private final String SQL_GET_NO_OF_COURSES = "select count(1) from course";
	private final String SQL_GET_COURSE_NM_BY_COURSE_NO = "select course_nm from course where course_no = ?";
	private final String SQL_GET_COURSE_BY_COURSE_NO = "select course_no, course_nm, duration, fee from course where course_no = ?";
	private final String SQL_GET_COURSES_BY_MAX_DURATION = "select course_no, course_nm, duration, fee from course where duration <= ?";
	private final String SQL_GET_COURSES_BY_COURSE_NM = "select course_no, course_nm, fee from course where course_nm like ?";
	private final String SQL_INSERT_COURSE = "insert into course(course_no, course_nm, duration, fee) values(?,?,?,?)";
	private final String SQL_INSERT_COURSE_AI = "insert into course(course_nm, duration, fee) values(?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getNoOfCourses() {
		return jdbcTemplate.queryForObject(SQL_GET_NO_OF_COURSES, Integer.class);
	}

	public String findCourseNameByCourseNo(final int courseNo) {
		return jdbcTemplate.queryForObject(SQL_GET_COURSE_NM_BY_COURSE_NO, String.class, courseNo);
	}

	public CourseBo findCourseByCourseNo(final int courseNo) {
		return jdbcTemplate.queryForObject(SQL_GET_COURSE_BY_COURSE_NO, new CourseRowMapper(), courseNo);
	}

	public List<CourseBo> findCoursesByDuration(final int duration) {
		return jdbcTemplate.query(SQL_GET_COURSES_BY_MAX_DURATION, new CourseRowMapper(), duration);
	}

	public List<Map<String, Object>> findCoursesByName(final String courseName) {
		return jdbcTemplate.queryForList(SQL_GET_COURSES_BY_COURSE_NM, "%" + courseName + "%");
	}

	public int saveCourse(CourseBo bo) {
		return jdbcTemplate.update(SQL_INSERT_COURSE, bo.getCourseNo(), bo.getCourseName(), bo.getDuration(),
				bo.getFee());
	}

	public int saveCourse(String courseName, int duration, double fee) {
		int courseNo = 0;
		KeyHolder kh = new GeneratedKeyHolder();

		int records = jdbcTemplate.update((con) -> {
			PreparedStatement pstmt = con.prepareStatement(SQL_INSERT_COURSE_AI, new String[] { "course_no" });
			pstmt.setString(1, courseName);
			pstmt.setInt(2, duration);
			pstmt.setDouble(3, fee);
			return pstmt;
		}, kh);
		courseNo = kh.getKey().intValue();

		return courseNo;
	}

	private final class CourseRowMapper implements RowMapper<CourseBo> {
		@Override
		public CourseBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			CourseBo bo = new CourseBo();

			bo.setCourseNo(rs.getInt(1));
			bo.setCourseName(rs.getString(2));
			bo.setDuration(rs.getInt(3));
			bo.setFee(rs.getDouble(4));

			return bo;
		}

	}
}
