package com.rimi.studentmanager.dao.impl;

import com.rimi.studentmanager.dao.ImodstudentInfoDao;
import com.rimi.studentmanager.util.JDBCUtils;

import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 20:09
 */
public class ImodstudentInfoDaoImpl implements ImodstudentInfoDao {
    @Override
    public void modstuInformation(Map<String, String[]> modistudent) {
        String sql = "update student set " +
                "username = ?, " +
                "password = ?, " +
                "collegname = ?, " +
                "sex= ? , " +
                "score = ?, " +
                "realname= ? where id = ?";
        // 执行
        JDBCUtils.executeUpdate(sql,
                modistudent.get("username")[0],
                modistudent.get("password")[0],
                modistudent.get("collegname")[0],
                modistudent.get("sex")[0],
                modistudent.get("score")[0],
                modistudent.get("realname")[0],
                modistudent.get("id")[0]);

    }
}
