package com.wfapi.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Student {
    @Id
    @Column("student_no")
    private int studentNo;
    @Column("student_nm")
    private String studentName;
    private int age;
    private String gender;
    private String qualification;
    @Column("mobile_no")
    private String mobileNo;
    @Column("email_address")
    private String emailAddress;
}
