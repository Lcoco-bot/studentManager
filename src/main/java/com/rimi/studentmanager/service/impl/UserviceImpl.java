package com.rimi.studentmanager.service.impl;
import com.rimi.studentmanager.service.Uservice;
import com.rimi.studentmanager.util.MaulUtil;

/**
 * @author admin
 * @date 2019/9/29 10:27
 */
public class UserviceImpl implements Uservice {
    @Override
    public boolean doSendEmail(String fromemail) {
        if(!fromemail.matches("^\\w+@(\\w+\\.)+\\w+$")){
            return false;
        }
        String content = "<html><head></head><body>点击链接激活</body><h3><a href='http://10.1.0.119:80/loginsuccess.jsp/</h3></html>";
        MaulUtil test = new MaulUtil(fromemail,content);
        new Thread(test).start();
       return true;
    }
}
