package com.rimi.studentmanager.service;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.entity.Student;

import java.util.List;

/**
 * @author admin
 * @date 2019/9/27 10:49
 */
public interface IStudentlistService {

    List<Student> getAllStudent();

    Page<Student> findPages(Page age);

}
