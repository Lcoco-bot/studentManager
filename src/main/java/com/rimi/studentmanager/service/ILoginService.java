package com.rimi.studentmanager.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @date 2019/9/24 14:26
 */
public interface ILoginService {
    boolean loginStudent(String username, String password, String remember, HttpServletRequest request, HttpServletResponse response);
    boolean loginTeacher(String username, String password, String remember, HttpServletRequest request, HttpServletResponse response);
}
