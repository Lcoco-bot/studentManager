package com.rimi.studentmanager.dao.impl;

import com.rimi.studentmanager.dao.IdeleteStudentDao;
import com.rimi.studentmanager.util.JDBCUtils;


/**
 * @author admin
 * @date 2019/9/26 18:20
 */
public class IdeleteStudentDaoImpl implements IdeleteStudentDao {
    @Override
    public void deleteStudentById(Integer id) {
        String sql="delete   from student where  id=?";
        JDBCUtils.executeUpdate(sql,id);
    }
}
