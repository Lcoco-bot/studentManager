package com.rimi.studentmanager.servlet;
import com.rimi.studentmanager.service.ILoginService;
import com.rimi.studentmanager.service.impl.ILoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * ${Description}
 *
 * @author admin
 * @date 2019/9/24 14:23
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private ILoginService loginService = new ILoginServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index=0;
        //7天免密登录
        //1.获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            //2.遍历cookie
            for (Cookie cookie : cookies) {
                //2.获取cookie的密码值
                if ("123".equals(cookie.getValue())) {
                    ;
                   index += 1;
                }
            }

            if(index!=0){
                response.sendRedirect(request.getContextPath()+"/loginsuccess.jsp");
            }
             if(index==0){
            //7天免密登录完
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");
            if (loginService.loginStudent(username, password, remember, request, response)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
            } else if (loginService.loginTeacher(username, password, remember, request, response)) {
                request.setAttribute("user", username);
                request.getRequestDispatcher("teacher/personal.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
             }


        }
                }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
