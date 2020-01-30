package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {


    public User findByUsername(String username);
    public void save(User user);

    public User findByCode(String code);

    public void updateStatus(User user);

    public User findByUsernameAndPassword(String username, String password);
}
