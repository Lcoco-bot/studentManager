package com.rimi.studentmanager.dao;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.entity.Teacher;

/**
 * @author admin
 * @date 2019/9/24 14:41
 */
public interface ILoginDao {
   Student selectnameAndpassword(String username, String password);
   Teacher selectTeachnameAndpassword(String username, String password);
}
