package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Answer;

import java.util.List;

public interface AnswerDao {
    //保存
    public void save(Answer answer);
    //查询所有
//    public List<Question> findAll();
    //删除
    public void delect(Answer answer);

    public List<Answer> findByPage(int cid ,int start, int pageSize);

    public int findTotalCount(int qid);

    public List<Answer> findByQid(int id);

}
