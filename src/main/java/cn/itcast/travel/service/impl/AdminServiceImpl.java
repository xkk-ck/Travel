package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.AdminDao;
import cn.itcast.travel.dao.QuestionDao;
import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.AdminDaoImpl;
import cn.itcast.travel.dao.impl.QuestionDaoImpl;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.Admin;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private QuestionDao questionDao = new QuestionDaoImpl();
    @Override
    public boolean regist(Admin admin) {
        return false;
    }

    @Override
    public Admin login(Admin admin) {
        return adminDao.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }

    @Override
    public PageBean pageQuery(int currentPage, int pageSize) {
        //    封装pageBean
        PageBean<User> pb = new PageBean<User>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //设置总记录数
        int totalCount = userDao.findTotalCount();
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage-1) * pageSize;//开始的记录数
        List<User> list = userDao.findByPage( start, pageSize);
        pb.setList(list);

        //设置总页数=总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize :(totalCount/pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
    public void frozenuser(int uid){
       userDao.frozenUser(uid);
    }

    @Override
    public void delectquestion(int id) {
        questionDao.delectquestion(id);
    }
}
