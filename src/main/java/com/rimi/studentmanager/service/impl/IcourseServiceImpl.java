package com.rimi.studentmanager.service.impl;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.dao.IcourselistDao;
import com.rimi.studentmanager.dao.impl.IcourselistDaoImpl;
import com.rimi.studentmanager.entity.course;
import com.rimi.studentmanager.service.IcourseService;

import java.util.List;

/**
 * @author admin
 * @date 2019/9/29 17:42
 */
public class IcourseServiceImpl implements IcourseService {
    private IcourselistDao icourselistDao = new IcourselistDaoImpl();
    @Override
    public Page<course> findPages(Page page) {
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
        Integer count = icourselistDao.count();
        page.setTotalCount(count);
        int currentSize = currentPage*pageSize;
        //判断分页开始的位置是不是大于总条数
        if (currentPage > count) {
            currentSize = (page.getPageCount() - 1)* pageSize;
        }
        List<course> courseList = icourselistDao.selectByPage(currentSize, pageSize);
        page.setPageData(courseList);
        return page;
    }
    }

