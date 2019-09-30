package com.rimi.studentmanager.service.impl;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.dao.IsearchstudInfoDao;
import com.rimi.studentmanager.dao.impl.IsearchstudInfoDaoImpl;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.service.ITeacherSearchService;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2019/9/25 14:25
 */
public class ITeacherSearchServiceImpl implements ITeacherSearchService {
   private   IsearchstudInfoDao isearchstudInfoDao=new IsearchstudInfoDaoImpl();
    @Override
    public List itearchStudandCollegname(String collegname, String studentclass) {
        return isearchstudInfoDao.IstudenAllInfo(collegname, studentclass);
    }

    @Override
    public List<Student> excelfindStudents(String username) {
         return  isearchstudInfoDao.findstudentByusername(username);
    }

    @Override
    public Page<Student> findPages(Page page, Map<String, String[]> parms) {
        Integer currentPage = page.getCurrentPage();
        Integer pageSize = page.getPageSize();
        //1.通过查询获取总条数
        if (currentPage > 0) {
            currentPage -= 1;
        } else {
            currentPage = 0;
        }
        Integer count = isearchstudInfoDao.count(parms);
        page.setTotalCount(count);
        int currentSize = currentPage*pageSize;
        //判断分页开始的位置是不是大于总条数
        if (currentPage > count) {
            currentSize = (page.getPageCount() - 1)* pageSize;
        }
        List<Student> studentList = isearchstudInfoDao.selectByPage(currentSize, pageSize,parms);
        page.setPageData(studentList);
        for (Student student : studentList) {
            System.out.println(student);
        }
        return page;
    }
    }


