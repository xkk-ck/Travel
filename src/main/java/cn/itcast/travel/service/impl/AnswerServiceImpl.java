package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.AnswerDao;
import cn.itcast.travel.dao.impl.AnswerDaoImpl;
import cn.itcast.travel.domain.Answer;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.service.AnswerService;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
private AnswerDao answerDao = new AnswerDaoImpl();
    @Override
    public void post(Answer answer) {
        answerDao.save(answer);
    }


    @Override
    public PageBean<Answer> pageQuery(int qid, int currentPage, int pageSize) {
        //    封装pageBean
        PageBean<Answer> pb = new PageBean<Answer>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = answerDao.findTotalCount(qid);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int star = (currentPage-1) * pageSize;//开始的记录数
        List<Answer> list = answerDao.findByPage(qid, star, pageSize);
        pb.setList(list);

        //设置总页数=总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize :(totalCount/pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public void delect(Answer answer) {
        answerDao.delect(answer);
    }
}
