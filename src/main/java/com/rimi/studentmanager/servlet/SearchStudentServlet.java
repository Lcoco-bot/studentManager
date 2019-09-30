package com.rimi.studentmanager.servlet;

import com.rimi.studentmanager.comm.Page;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.service.ITeacherSearchService;
import com.rimi.studentmanager.service.impl.ITeacherSearchServiceImpl;
import com.rimi.studentmanager.util.StringUtils;

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
 * @date 2019/9/25 14:10
 */
@WebServlet( "/searchstudentandcollegname")
public class SearchStudentServlet extends HttpServlet {
      private ITeacherSearchService iTeacherSearchService =new ITeacherSearchServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        String collegname = request.getParameter("collegname");
//        String studentclass = request.getParameter("studentclass");
//        List list = iTeacherSearchService.itearchStudandCollegname(collegname, studentclass);
//        request.setAttribute("listsize",1);
//        request.setAttribute("list",list);
     //搜索分页
        Map<String, String[]> parameterMap = request.getParameterMap();
        String currentPage = request.getParameter("p");
        if (StringUtils.isEmpty(currentPage)) {
            currentPage = "1";
        }
        Page page = Page.of(Integer.valueOf(currentPage));
        Page<Student> studentpages = iTeacherSearchService.findPages(page,parameterMap);
        request.setAttribute("page", studentpages);
        request.getRequestDispatcher("/member-list-search.jsp").forward(request, response);
     }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
