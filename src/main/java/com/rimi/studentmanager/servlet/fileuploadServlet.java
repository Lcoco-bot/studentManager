package com.rimi.studentmanager.servlet;

import com.alibaba.excel.EasyExcel;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.listener.StudentDataListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * ${Description}
 *
 * @author admin
 * @date 2019/9/26 11:30
 */
@MultipartConfig
@WebServlet("/fileupload")
public class fileuploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("file");
        InputStream inputStream = part.getInputStream();
        EasyExcel.read(inputStream, Student.class,new StudentDataListener()).sheet().doRead();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              this.doPost(request,response);
    }
}
