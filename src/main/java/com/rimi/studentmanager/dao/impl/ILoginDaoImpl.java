package com.rimi.studentmanager.dao.impl;


import com.rimi.studentmanager.dao.ILoginDao;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.entity.Teacher;
import com.rimi.studentmanager.util.JDBCUtils;

/**
 * @author admin
 * @date 2019/9/24 15:21
 */
public class ILoginDaoImpl implements ILoginDao {
    @Override
    public Student selectnameAndpassword(String username, String password) {
        String sql = "select * from student where  username = ? and password =? ";
        return JDBCUtils.executeQueryForOne(Student.class, sql, username, password);
    }

    @Override
    public Teacher selectTeachnameAndpassword(String username, String password) {
        String sql="select * from student where  username = ? and password =? ";
        return JDBCUtils.executeQueryForOne(Teacher.class,sql,username,password);
    }
}
