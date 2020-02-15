package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.AnswerDao;
import cn.itcast.travel.dao.QuestionDao;
import cn.itcast.travel.dao.impl.AnswerDaoImpl;
import cn.itcast.travel.dao.impl.QuestionDaoImpl;
import cn.itcast.travel.domain.Answer;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Question;
import cn.itcast.travel.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
private QuestionDao questionDao = new QuestionDaoImpl();
private AnswerDao answerDao = new AnswerDaoImpl();
    @Override
    public void post(Question question) {
        questionDao.save(question);
    }

    @Override
    public PageBean<Question> pageQuery(int currentPage, int pageSize) {
        //    封装pageBean
        PageBean<Question> pb = new PageBean<Question>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = questionDao.findTotalCount();
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int star = (currentPage-1) * pageSize;//开始的记录数
        List<Question> list = questionDao.findByPage( star, pageSize);
        pb.setList(list);

        //设置总页数=总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize :(totalCount/pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public void delect(Question question) {
        questionDao.delect(question);
    }

    @Override
    public Question findOne(String id) {
//         1.根据id查询question
        Question question = questionDao.findOne(Integer.parseInt(id));

//        2.根据question查询answer集合信息
        List<Answer> answersList = answerDao.findByQid(question.getId());
//        2.2将集合设置到question对象中
        question.setAnswerList(answersList);
        return question;

    }
}
