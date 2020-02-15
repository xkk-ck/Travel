package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.AdminDao;
import cn.itcast.travel.domain.Admin;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Admin findByUsername(String username) {
        Admin admin = null;
        try {
//        1.定义SQL
            String sql = "select * from tab_admin where username = ?";
//        2.执行SQL
            admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class),username);
        } catch (Exception e) {

        }
        return admin;
    }

    @Override
    public void save(Admin admin) {
//        1.定义SQL
        String sql = "insert into tab_admin(username,password,telephone) values(?,?,?)";
//        2.执行SQL
        template.update(sql,admin.getUsername(),
                admin.getPassword(),
                admin.getTelephone()
        );

    }

    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        Admin admin = null;
        try {
//        1.定义SQL
            String sql = "select * from tab_admin where username = ? and password = ?";
//        2.执行SQL
            admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class),username,password);
        } catch (Exception e) {

        }
        return admin;
    }
}
