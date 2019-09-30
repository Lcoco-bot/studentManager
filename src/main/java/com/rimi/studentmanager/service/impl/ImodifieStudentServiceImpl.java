package com.rimi.studentmanager.service.impl;

import com.rimi.studentmanager.dao.ImodstudentInfoDao;
import com.rimi.studentmanager.dao.impl.ImodstudentInfoDaoImpl;
import com.rimi.studentmanager.service.ImodifieStudentService;

import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 20:07
 */
public class ImodifieStudentServiceImpl implements ImodifieStudentService {
    private ImodstudentInfoDao imodstudentInfoDao = new ImodstudentInfoDaoImpl();
    @Override
    public void modStudent(Map<String, String[]> modistudent) {
        imodstudentInfoDao.modstuInformation(modistudent);

    }
}
