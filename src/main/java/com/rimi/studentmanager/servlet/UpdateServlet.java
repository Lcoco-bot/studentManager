package com.rimi.studentmanager.servlet;

import com.rimi.studentmanager.service.IaddStudentService;
import com.rimi.studentmanager.service.impl.IaddStudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * ${Description}
 *
 * @author admin
 * @date 2019/9/25 17:19
 */
@WebServlet("/updatestudent")
public class UpdateServlet extends HttpServlet {
    private IaddStudentService iaddStudentService = new IaddStudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> addStudent = request.getParameterMap();
        iaddStudentService.addStudent(addStudent);
        response.sendRedirect(request.getContextPath()+"/studentlist");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
