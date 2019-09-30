package com.rimi.studentmanager.dao;
import com.rimi.studentmanager.entity.course;

import java.util.List;

/**
 * @author admin
 * @date 2019/9/29 17:45
 */
public interface IcourselistDao {
    List<course> selectByPage(Integer currentPage, Integer pageSize);

    Integer count();
}
