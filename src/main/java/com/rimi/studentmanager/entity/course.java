package com.rimi.studentmanager.entity;

/**
 * @author admin
 * @date 2019/9/29 17:35
 */
public class course {
     private Integer id;
     private String coursename;
     private String coursescore;
     private String coursetearch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursescore() {
        return coursescore;
    }

    public void setCoursescore(String coursescore) {
        this.coursescore = coursescore;
    }

    public String getCoursetearch() {
        return coursetearch;
    }

    public void setCoursetearch(String coursetearch) {
        this.coursetearch = coursetearch;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", coursescore='" + coursescore + '\'' +
                ", coursetearch='" + coursetearch + '\'' +
                '}';
    }
}
