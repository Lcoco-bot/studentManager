package com.rimi.studentmanager.servlet;

import com.rimi.studentmanager.service.ImodifieStudentService;
import com.rimi.studentmanager.service.impl.ImodifieStudentServiceImpl;

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
 * @date 2019/9/25 20:05
 */
@WebServlet(name = "/modifiesServlet/")
public class modifiesServlet extends HttpServlet {
    private ImodifieStudentService imodifieStudentService = new ImodifieStudentServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("UTF-8");
           Map<String, String[]> modistudent = request.getParameterMap();
          imodifieStudentService.modStudent(modistudent);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doPost(request,response);
    }
}
