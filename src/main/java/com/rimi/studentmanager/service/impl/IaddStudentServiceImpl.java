package com.rimi.studentmanager.service.impl;

import com.rimi.studentmanager.dao.IaddStudentDao;
import com.rimi.studentmanager.dao.impl.IaddStudentDaoImpl;
import com.rimi.studentmanager.service.IaddStudentService;

import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 17:45
 */
public class IaddStudentServiceImpl implements IaddStudentService {
    private IaddStudentDao iaddStudentDao = new IaddStudentDaoImpl();

    @Override
    public void addStudent(Map<String, String[]> addStudent) {
        iaddStudentDao.insertnewStudent(addStudent);
    }
}
