package cn.itcast.travel.test;

import cn.itcast.travel.dao.AdminDao;
import cn.itcast.travel.dao.AnswerDao;
import cn.itcast.travel.dao.impl.AdminDaoImpl;
import cn.itcast.travel.dao.impl.AnswerDaoImpl;
import cn.itcast.travel.domain.Admin;
import cn.itcast.travel.domain.Answer;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Question;
import cn.itcast.travel.service.QuestionService;
import cn.itcast.travel.service.impl.QuestionServiceImpl;

import java.util.List;

public class questionserviceTest {


    public static void main(String[] args) {
        AdminDao adminDao = new AdminDaoImpl();
        Admin a = new Admin();
        a.setUsername("sssssskk");
        a.setPassword("12345678");
//        Question question = new Question(1,"渣渣","1","1","1");
       Admin admin = null;
       admin = adminDao.findByUsernameAndPassword(a.getUsername(),a.getPassword());
        System.out.println(admin);


    }
}
