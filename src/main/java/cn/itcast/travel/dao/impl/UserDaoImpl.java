package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
//        1.定义SQL
            String sql = "select * from tab_user where username = ?";
//        2.执行SQL
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
        } catch (Exception e) {

        }
        return user;
    }

    @Override
    public void save(User user) {
//        1.定义SQL
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
//        2.执行SQL
        template.update(sql,user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );

    }

    @Override
    public User findByCode(String code) {
        User user = null;
        try {
//        1.定义SQL
            String sql = "select * from tab_user where code = ?";
//        2.执行SQL
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),code);
        } catch (Exception e) {
             e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status ='Y' where uid = ?";
        template.update(sql,user.getUid());

    }

    /**
     * 根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
//        1.定义SQL
            String sql = "select * from tab_user where username = ? and password = ?";
//        2.执行SQL
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (Exception e) {

        }
        return user;
    }

    @Override
    public List<User> findByPage(int start, int pageSize) {
        String sql = "select * from tab_user limit ? ,?";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,pageSize);
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from tab_user";
        return template.queryForObject(sql ,Integer.class );
    }

    @Override
    public void frozenUser(int uid) {
        String sql = "update tab_user set status ='N' where uid = ?";
        template.update(sql,uid);

    }
}
