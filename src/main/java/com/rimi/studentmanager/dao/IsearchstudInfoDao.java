package com.rimi.studentmanager.dao;

import com.rimi.studentmanager.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 14:26
 */
public interface IsearchstudInfoDao {
     List<Student> IstudenAllInfo(String collegname, String studentclass);

     Integer count(Map<String, String[]> parms);

     List<Student> selectByPage(Integer currentSize, Integer pageSize, Map<String, String[]> parms);

    List<Student> findstudentByusername(String username);
}
