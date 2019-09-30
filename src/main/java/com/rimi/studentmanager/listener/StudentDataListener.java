package com.rimi.studentmanager.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.rimi.studentmanager.entity.Student;
import com.rimi.studentmanager.service.IaddStudentService;
import com.rimi.studentmanager.service.impl.IaddStudentServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2019/9/26 12:01
 */
public class StudentDataListener extends AnalysisEventListener<Student> {
    private IaddStudentService IaddStudentService = new IaddStudentServiceImpl();
    private List<Map<String,String[]>> list = new ArrayList<>();
    private static final int BATCH_COUNT = 5;
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("username",new String[]{student.getUsername()});
        map.put("password",new String[]{student.getPassword()});
        map.put("collegname",new String[]{student.getCollegname()});
        map.put("sex",new String[]{student.getSex()});
        map.put("score",new String[]{student.getScore()});
        map.put("realname",new String[]{student.getRealname()});
        map.put("studentclass",new String[]{student.getStudentclass()});
        list.add(map);
       if(list.size()>=BATCH_COUNT){
           saveData();
           list.clear();
       }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    private void saveData() {
        for (Map<String, String[]> stringMap : list) {
            System.out.println("保存表格数据");
           IaddStudentService.addStudent(stringMap);
        }
    }
}
