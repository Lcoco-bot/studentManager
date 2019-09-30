package com.rimi.studentmanager.dao.impl;

import com.rimi.studentmanager.dao.IcourselistDao;
import com.rimi.studentmanager.entity.course;
import com.rimi.studentmanager.util.JDBCUtils;

import java.util.List;

/**
 * @author admin
 * @date 2019/9/29 17:47
 */
public class IcourselistDaoImpl implements IcourselistDao {
    @Override
    public List<course> selectByPage(Integer currentPage, Integer pageSize) {
        String sql = "select * from course limit ?,?";

        //执行sql语句
        return JDBCUtils.executeQuery(course.class,sql,currentPage,pageSize);
    }

    @Override
    public Integer count() {
        String sql ="select count(1) from course ";
        return JDBCUtils.executeQueryForCount(sql);
    }
}

