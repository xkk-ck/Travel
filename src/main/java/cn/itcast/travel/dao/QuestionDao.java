package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Question;

import java.util.List;

public interface QuestionDao {
    //保存
    public void save(Question question);
   //查询所有
//    public List<Question> findAll();
    //删除
    public void delect(Question question);

    public List<Question> findByPage(int start, int pageSize);

    public int findTotalCount();

    public Question findOne(int id);
}
