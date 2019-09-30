package com.rimi.studentmanager.service;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 14:22
 */

public interface ITeacherSearchService {
    List itearchStudandCollegname(String collegname, String studentclass);
    List<Student>  excelfindStudents(String username);
    Page<Student> findPages(Page page, Map<String, String[]> parameterMap);
}
