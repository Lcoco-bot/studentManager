package com.rimi.studentmanager.servlet;

import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.service.ITeacherSearchService;
import com.rimi.studentmanager.service.impl.ITeacherSearchServiceImpl;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * ${Description}
 *
 * @author admin
 * @date 2019/9/28 11:52
 */
@WebServlet("/createxcel")
public class CreatexcelServlet extends HttpServlet {
    private ITeacherSearchService iTeacherSearchService = new ITeacherSearchServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        //创建文件本地文件
        String filePath = "C:\\Users\\admin\\Desktop\\人员数据.xls";
        File dbfFile = new File(filePath);
        System.out.println(dbfFile);
        //首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
        WritableWorkbook wwb = Workbook.createWorkbook(dbfFile);
        if (!dbfFile.exists() || dbfFile.isDirectory()) {
            dbfFile.createNewFile();
        }
        try {
            WritableSheet ws = wwb.createSheet("列表 1", 0);  //创建一个可写入的工作表
            ws.addCell(new Label(0,0,"ID号"));
            ws.addCell(new Label(1,0,"密码"));
            ws.addCell(new Label(2,0,"学院名字"));
            ws.addCell(new Label(3,0,"性别"));
            ws.addCell(new Label(4,0,"学分"));
            ws.addCell(new Label(5,0,"真实名字"));
            ws.addCell(new Label(6,0,"学生年级"));
            List<Student> students = iTeacherSearchService.excelfindStudents(username);
            //  StudentDao studentDao = new StudentDao();
           // List<Student> students = studentDao.selectAllStudent(username);
           // request.setAttribute("list",students);
           // request.getRequestDispatcher("index.jsp").forward(request,response);
            int index=0;
            for (Student student : students) {
                //（这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行）
                ws.addCell(new Label(0, index + 1, String.valueOf(student.getId())));
                ws.addCell(new Label(1, index + 1, student.getUsername()));
                ws.addCell(new Label(2, index + 1, String.valueOf(student.getPassword())));
                ws.addCell(new Label(3, index + 1, student.getCollegname()));
                ws.addCell(new Label(4, index + 1, student.getSex()));
                ws.addCell(new Label(4, index + 1, student.getScore()));
                ws.addCell(new Label(4, index + 1, student.getRealname()));
                ws.addCell(new Label(4, index + 1, student.getStudentclass()));
            }
            wwb.write();//从内存中写入文件中
            wwb.close();//关闭资源，释放内存
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              this.doPost(request,response);
    }
}
