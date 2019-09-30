package com.rimi.studentmanager.dao.impl;

import com.rimi.studentmanager.dao.IaddStudentDao;
import com.rimi.studentmanager.util.JDBCUtils;

import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 17:46
 */
public class IaddStudentDaoImpl implements IaddStudentDao {
    @Override
    public Integer insertnewStudent(Map<String, String[]> addStudent) {
        String sql = "insert into student(username,password,collegname,sex,score,realname,studentclass)values(?,?,?,?,?,?,?)";
       return JDBCUtils.executeUpdate(sql,
               addStudent.get("username")[0],
               addStudent.get("password")[0],
               addStudent.get("collegname")[0],
               addStudent.get("sex")[0],
               addStudent.get("score")[0],
               addStudent.get("realname")[0],
               addStudent.get("studentclass")[0]
        );
    }
}
