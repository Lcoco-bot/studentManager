package com.rimi.studentmanager.servlet;

import com.rimi.studentmanager.service.IdeleteStudentService;
import com.rimi.studentmanager.service.impl.IdeleteStudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ${Description}
 *
 * @author admin
 * @date 2019/9/28 17:45
 */
@WebServlet("/delAll")
public class delAllServlet extends HttpServlet {
    private IdeleteStudentService ideleteStudentService= new IdeleteStudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("id[]");
        for (String id : ids) {
            Integer integerId = Integer.valueOf(id);
            ideleteStudentService.deleStudentById(integerId);
        }
        System.out.println("123");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             this.doPost(request,response);
    }
}
