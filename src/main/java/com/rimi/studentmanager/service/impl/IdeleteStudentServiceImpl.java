package com.rimi.studentmanager.service.impl;

import com.rimi.studentmanager.dao.IdeleteStudentDao;
import com.rimi.studentmanager.dao.impl.IdeleteStudentDaoImpl;
import com.rimi.studentmanager.service.IdeleteStudentService;

/**
 * @author admin
 * @date 2019/9/26 19:52
 */
public class IdeleteStudentServiceImpl implements IdeleteStudentService {
    private IdeleteStudentDao ideleteStudentDao = new IdeleteStudentDaoImpl();
    @Override
    public void deleStudentById(Integer ids) {
            ideleteStudentDao.deleteStudentById(Integer.valueOf(ids));
        }
    }

