package com.npjt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.npjt.bo.CourseBo;

@Repository
public class CourseDao {
	private final String SQL_GET_COURSE_NM_BY_COURSE_NO = "select course_nm from course where course_no = :courseNo";
	private final String SQL_GET_COURSES_BY_DURATION_AND_FEE = "select course_no, course_nm, duration, fee from course where duration <= :duration and (fee between :minFee and :maxFee)";
	private final String SQL_INS_COURSE = "insert into course(course_no, course_nm, duration, fee) values(:courseNo, :courseName, :duration, :fee)";

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;

	public String findCourseNameByCourseNo(int courseNo) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("courseNo", courseNo);

		return npJdbcTemplate.queryForObject(SQL_GET_COURSE_NM_BY_COURSE_NO, paramMap, String.class);
	}

	public List<CourseBo> getCoursesByDurationAndFee(final int duration, final double minFee, final double maxFee) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("duration", duration);
		paramSource.addValue("minFee", minFee);
		paramSource.addValue("maxFee", maxFee);

		return npJdbcTemplate.query(SQL_GET_COURSES_BY_DURATION_AND_FEE, paramSource, (rs, rowNum) -> {
			CourseBo bo = new CourseBo();
			bo.setCourseNo(rs.getInt(1));
			bo.setCourseName(rs.getString(2));
			bo.setDuration(rs.getInt(3));
			bo.setFee(rs.getDouble(4));

			return bo;
		});
	}
	
	public int saveCourse(CourseBo bo) {
		return npJdbcTemplate.update(SQL_INS_COURSE, new BeanPropertySqlParameterSource(bo));
	}
}






















