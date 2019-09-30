package com.rimi.studentmanager.servlet;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.entity.course;
import com.rimi.studentmanager.service.IcourseService;
import com.rimi.studentmanager.service.impl.IcourseServiceImpl;
import com.rimi.studentmanager.util.StringUtils;

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
 * @date 2019/9/29 17:26
 */
@WebServlet("/courselist")
public class courseServlet extends HttpServlet {
    private IcourseService icourseService = new IcourseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("p");
        if (StringUtils.isEmpty(currentPage)) {
            currentPage = "1";
        }
        Page page = Page.of(Integer.valueOf(currentPage));
        Page<course> coursepages =  icourseService.findPages(page);
        request.setAttribute("page", coursepages);
        request.getRequestDispatcher("/member-list-course.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   this.doPost(request,response);
    }
}
