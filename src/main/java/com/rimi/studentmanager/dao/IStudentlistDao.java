package com.rimi.studentmanager.dao;

import com.rimi.studentmanager.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2019/9/27 10:51
 */
public interface IStudentlistDao {
    List<Student> selectByPage(int currentSize, Integer pageSize, Map<String, String[]> parms);

    List<Student> selectAllStudent();

    List<Student> selectByPage(Integer currentPage, Integer pageSize);

    Integer count();
}
