package com.rimi.studentmanager.service;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.entity.course;

/**
 * @author admin
 * @date 2019/9/29 17:32
 */
public interface IcourseService {
    Page<course> findPages(Page page);
}
