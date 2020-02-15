package cn.itcast.travel.service;

import cn.itcast.travel.domain.Answer;
import cn.itcast.travel.domain.PageBean;

public interface AnswerService {
    //发布问题
    public void post(Answer answer);

    //分页查找
    public PageBean<Answer> pageQuery(int qid, int currentPage, int pageSize);

    //删除问题
    public void delect(Answer answer);
}
