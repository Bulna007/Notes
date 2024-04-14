package com.college360.main;

import java.util.List;

import com.college360.dao.StudentDao;
import com.college360.dto.StudentDto;

public class Run {
    public static void main(String[] args) {
        List<StudentDto> dtos = null;
        StudentDao dao = new StudentDao();
        dtos = dao.findAll();
        dtos.forEach(System.out::println);
    }
}
