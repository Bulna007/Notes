package com.college360.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.college360.dto.StudentDto;
import com.college360.helper.ConnectionHelper;

public class StudentDao {

    public List<StudentDto> findAll() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        StudentDto dto = null;
        List<StudentDto> studentDtos = null;

        try {
            con = ConnectionHelper.newConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select student_no, student_nm, age, gender from student");
            studentDtos = new ArrayList<>();
            while (rs.next()) {
                dto = new StudentDto();
                dto.setStudentNo(rs.getInt(1));
                dto.setStudentName(rs.getString(2));
                dto.setAge(rs.getInt(3));
                dto.setGender(rs.getString(4));
                studentDtos.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("failed in creating jdbc resources", e);
        }

        return studentDtos;
    }
}
