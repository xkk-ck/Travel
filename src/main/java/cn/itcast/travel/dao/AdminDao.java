package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Admin;

public interface AdminDao {
    public Admin findByUsername(String username);

    public void save(Admin admin);

    public Admin findByUsernameAndPassword(String username, String password);


}
