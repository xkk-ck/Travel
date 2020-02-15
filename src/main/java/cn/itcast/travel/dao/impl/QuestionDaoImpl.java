package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.QuestionDao;
import cn.itcast.travel.domain.Question;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void save(Question question) {
        //        1.定义SQL
        String sql = "insert into tab_question( username, title, content, time) values(?,?,?,?)";
//        2.执行SQL
        template.update(sql,
                question.getUsername(),
                question.getTitle(),
                question.getContent(),
                question.getTime()
        );

    }

    @Override
    public void delect(Question question) {
        String sql = "delete from tab_question where id=?";
        template.update(sql,question.getId());

    }

    @Override
    public List<Question> findByPage(int start, int pageSize) {
        String sql = "select * from tab_question limit ? ,?";
        return template.query(sql,new BeanPropertyRowMapper<Question>(Question.class),start,pageSize);
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from tab_question";
        return template.queryForObject(sql ,Integer.class );
    }

    @Override
    public Question findOne(int id) {
        String sql = "select * from tab_question where id = ?";
        return template.queryForObject(sql ,new BeanPropertyRowMapper<Question>(Question.class),id );
    }

}
