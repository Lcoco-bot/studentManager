package com.rimi.studentmanager.servlet;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.service.IStudentlistService;
import com.rimi.studentmanager.service.impl.IStudentlistServiceImpl;
import com.rimi.studentmanager.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ${Description}
 *
 * @author admin
 * @date 2019/9/27 10:44
 */
@WebServlet("/studentlist")
public class StudentlistServlet extends HttpServlet {
    private IStudentlistService iStudentlistService = new IStudentlistServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取分页参数
        List<Student> allStudent = iStudentlistService.getAllStudent();
        request.setAttribute("allStudent", allStudent);
        String currentPage = request.getParameter("p");
        if (StringUtils.isEmpty(currentPage)) {
            currentPage = "1";
        }
        Page page = Page.of(Integer.valueOf(currentPage));
        Page<Student> studentpages = iStudentlistService.findPages(page);
        request.setAttribute("page", studentpages);
        request.getRequestDispatcher("/member-list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
