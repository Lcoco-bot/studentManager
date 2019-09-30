package com.rimi.studentmanager.dao.impl;

import com.rimi.studentmanager.dao.IStudentlistDao;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.util.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2019/9/27 10:53
 */
public class IStudentlistDaoImpl implements IStudentlistDao {
    @Override
    public List<Student> selectByPage(int currentSize, Integer pageSize, Map<String, String[]> parms) {
        return null;
    }

    @Override
    public List<Student> selectAllStudent() {
        String sql = "select * from student";
        return JDBCUtils.executeQuery(Student.class, sql);
    }

    @Override
    public List<Student> selectByPage(Integer currentPage, Integer pageSize) {
        //定义sql
        String sql = "select * from student limit ?,?";

    //执行sql语句
   return JDBCUtils.executeQuery(Student.class,sql,currentPage,pageSize);
    }
    @Override
    public Integer count() {
       String sql ="select count(1) from student ";
       return JDBCUtils.executeQueryForCount(sql);
    }
}
