package com.rimi.studentmanager.service.impl;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.dao.IStudentlistDao;
import com.rimi.studentmanager.dao.impl.IStudentlistDaoImpl;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.service.IStudentlistService;

import java.util.List;

/**
 * @author admin
 * @date 2019/9/27 10:50
 */
public class IStudentlistServiceImpl implements IStudentlistService {
    private IStudentlistDao iStudentlistDao = new IStudentlistDaoImpl();

    @Override
    public List<Student> getAllStudent() {
        return iStudentlistDao.selectAllStudent();
    }

    @Override
    public Page<Student> findPages(Page page) {
        //分页查询
        Integer currentPage = page.getCurrentPage();
        System.out.println(currentPage);
        Integer pageSize = page.getPageSize();
        //1.通过查询获取总条数
        if (currentPage > 0) {
            currentPage -= 1;
        } else {
            currentPage = 0;
        }
        Integer count = iStudentlistDao.count();
        page.setTotalCount(count);
        int currentSize = currentPage*pageSize;
        //判断分页开始的位置是不是大于总条数
        if (currentPage > count) {
            currentSize = (page.getPageCount() - 1)* pageSize;
        }
        List<Student> studentList = iStudentlistDao.selectByPage(currentSize, pageSize);
        page.setPageData(studentList);
        return page;
    }

}
