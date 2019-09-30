package com.rimi.studentmanager.dao.impl;

import com.rimi.studentmanager.dao.IsearchstudInfoDao;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.util.JDBCUtils;
import com.rimi.studentmanager.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 14:35
 */
public class IsearchstudInfoDaoImpl implements IsearchstudInfoDao {
    @Override
    public  List<Student> IstudenAllInfo(String collegname, String studentclass) {
        String sql="select * from  student where collegname = ? and studentclass = ?";
        return JDBCUtils.executeQuery(Student.class, sql,collegname, studentclass);
    }

    @Override
    public Integer count(Map<String, String[]> parms) {
        StringBuffer sql = new StringBuffer("select count(1) from student where 1 = 1");
        List<String> parmsSql = new ArrayList<>();
        if (parms.get("username") != null && StringUtils.isNotEmpty(parms.get("username")[0])) {
            sql.append(" and username like ?");
            parmsSql.add("%"+parms.get("username")[0]+"%");
        }
        if (parms.get("password") != null && StringUtils.isNotEmpty(parms.get("password")[0])) {
            sql.append(" and password like ?");
            parmsSql.add("%"+parms.get("password")[0]+"%");
        }
        if (parms.get("collegname") != null && StringUtils.isNotEmpty(parms.get("collegname")[0])) {
            sql.append(" and collegname like ?");
            parmsSql.add("%"+parms.get("collegname")[0]+"%");
        }
        return JDBCUtils.executeQueryForCount(sql.toString(), parmsSql);
    }

    @Override
    public List<Student> selectByPage(Integer currentSize, Integer pageSize, Map<String, String[]> parms) {
        StringBuffer sql = new StringBuffer("select * from student where 1 = 1");
        List<Object> parmsSql = new ArrayList<>();
        if (parms.get("username") != null && StringUtils.isNotEmpty(parms.get("username")[0])) {
            sql.append(" and username like ?");
            parmsSql.add("%"+parms.get("username")[0]+"%");
        }
        if (parms.get("password") != null && StringUtils.isNotEmpty(parms.get("password")[0])) {
            sql.append(" and password like ?");
            parmsSql.add("%"+parms.get("password")[0]+"%");
        }
        if (parms.get("collegname") != null && StringUtils.isNotEmpty(parms.get("collegname")[0])) {
            sql.append(" and collegname like ?");
            parmsSql.add("%"+parms.get("collegname")[0]+"%");
        }
        // 追加分页
        sql.append(" limit ?,?");
        parmsSql.add(currentSize);
        parmsSql.add(pageSize);
        return JDBCUtils.executeQuery(Student.class, sql.toString(), parmsSql);
    }

    @Override
    public  List<Student> findstudentByusername(String username) {
        String sql="select * from student where username = ?";
        List<Student> students = JDBCUtils.executeQuery(Student.class, sql, username);
        return students;
    }


//    @Override
//    public List<Student> selectByPage(Integer currentPage, Integer pageSize) {
//        //定义sql
//        String sql = "select * from student limit ?,?";
//
//        //执行sql语句
//        return JDBCUtils.executeQuery(Student.class,sql,currentPage,pageSize);
//    }

}
