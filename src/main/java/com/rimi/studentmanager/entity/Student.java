package com.rimi.studentmanager.entity;

public class Student {

    private Integer id;
    private String username;
    private String password;
    private String collegname;
    private String sex;
    private String score;
    private String  realname;
    private String studentclass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCollegname() {
        return collegname;
    }

    public void setCollegname(String collegname) {
        this.collegname = collegname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(String studentclass) {
        this.studentclass = studentclass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", collegname='" + collegname + '\'' +
                ", sex='" + sex + '\'' +
                ", score='" + score + '\'' +
                ", realname='" + realname + '\'' +
                ", studentclass='" + studentclass + '\'' +
                '}';
    }
}
