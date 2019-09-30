package com.rimi.studentmanager.servlet;

import com.rimi.studentmanager.service.Uservice;
import com.rimi.studentmanager.service.impl.UserviceImpl;

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
 * @date 2019/9/29 9:39
 */
@WebServlet("/emaiservl")
public class emilServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sendemail = request.getParameter("sendemail");
        Uservice uservice = new UserviceImpl();
        if (uservice.doSendEmail(sendemail)) {
            System.out.println("成功");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

