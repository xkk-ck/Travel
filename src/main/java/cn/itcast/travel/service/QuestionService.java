package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Question;

public interface QuestionService {

    //发布问题
    public void post(Question question);

    //分页查找
    public PageBean<Question> pageQuery( int currentPage, int pageSize);

    //删除问题
    public void delect(Question question);

//    根据id查询
    public Question findOne(String id);
}
