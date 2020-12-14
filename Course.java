package com.example.exam;

public class Course {
    private Double fess;
    private Integer hrs;
    private String course_name;

    public Course(Double fess, Integer hrs, String course_name) {
        this.fess = fess;
        this.hrs = hrs;
        this.course_name = course_name;
    }

    public Double getFess() {
        return fess;
    }

    public void setFess(Double fess) {
        this.fess = fess;
    }

    public Integer getHrs() {
        return hrs;
    }

    public void setHrs(Integer hrs) {
        this.hrs = hrs;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
