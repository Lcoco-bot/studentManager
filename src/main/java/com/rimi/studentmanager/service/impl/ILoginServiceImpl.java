package com.rimi.studentmanager.service.impl;
import com.rimi.studentmanager.dao.ILoginDao;
import com.rimi.studentmanager.dao.impl.ILoginDaoImpl;
import com.rimi.studentmanager.service.ILoginService;
import com.rimi.studentmanager.util.CookieUtils;
import com.rimi.studentmanager.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @date 2019/9/24 14:36
 */
public class ILoginServiceImpl implements ILoginService {
    private ILoginDao logindao=new ILoginDaoImpl();
    @Override
    public boolean loginStudent(String username, String password, String remember, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password)) {
            if (remember != null) {
                CookieUtils.setCookie("username", username, 7 * 24 * 60 * 60, response);
                CookieUtils.setCookie("password", password, 7 * 24 * 60 * 60, response);
            }
            return logindao.selectnameAndpassword(username, password) != null;
        } else {
            return false;
        }
    }

    @Override
    public boolean loginTeacher(String username, String password, String remember, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password)) {
            if (remember!=null) {
                CookieUtils.setCookie("username",username,7*24*60*60,response);
                CookieUtils.setCookie("password",password,7*24*60*60,response);
            }
            return logindao. selectTeachnameAndpassword(username, password)!=null;
        }
        return  false;
    }

}
