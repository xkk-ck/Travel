package cn.itcast.travel.test;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Question;
import cn.itcast.travel.service.QuestionService;
import cn.itcast.travel.service.impl.QuestionServiceImpl;

public class questionserviceTest {


    public static void main(String[] args) {
        QuestionService questionService = new QuestionServiceImpl();
//        Question question = new Question(1,"渣渣","1","1","1");
        PageBean<Question> pb = questionService.pageQuery(5,3);
        System.out.println(pb.getList());


    }
}
