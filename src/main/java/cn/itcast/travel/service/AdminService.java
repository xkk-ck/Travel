package cn.itcast.travel.service;

import cn.itcast.travel.domain.Admin;
import cn.itcast.travel.domain.PageBean;

public interface AdminService {

    boolean regist(Admin admin);

    Admin login(Admin admin);

    PageBean pageQuery(int currentPage, int pageSize);

    public void frozenuser(int uid);

    void delectquestion(int id);
}
