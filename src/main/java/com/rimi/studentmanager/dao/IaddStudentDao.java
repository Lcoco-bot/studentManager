package com.rimi.studentmanager.dao;

import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 17:40
 */
public interface IaddStudentDao {
   Integer insertnewStudent(Map<String, String[]> addStudent);
}
