package com.mtm.entities;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
public class Job implements Serializable {
    private int jobNo;
    private String jobTitle;
    private String description;
    private int experience;
    private String qualification;
    private String company;

}
