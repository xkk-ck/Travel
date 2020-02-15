package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.AnswerDao;
import cn.itcast.travel.domain.Answer;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AnswerDaoImpl implements AnswerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void save(Answer answer) {
        //        1.定义SQL
        String sql = "insert into tab_answer( qid, username, content, time) values(?,?,?,?)";
//        2.执行SQL
        template.update(sql,
                answer.getQid(),
                answer.getUsername(),
                answer.getContent(),
                answer.getTime()
        );
    }

    @Override
    public void delect(Answer answer) {
        String sql = "delete from tab_answer where id=?";
        template.update(sql,answer.getId());
    }

    @Override
    public List<Answer> findByPage(int cid ,int start, int pageSize) {
        String sql = "select * from tab_answer limit ? ,? where cid = ?";
        return template.query(sql,new BeanPropertyRowMapper<Answer>(Answer.class),start,pageSize);
    }

    @Override
    public int findTotalCount(int qid) {
        String sql = "select count(*) from tab_answer where qid = ?";
        return template.queryForObject(sql , Integer.class, qid);
    }

    @Override
    public List<Answer> findByQid(int qid) {
        String sql = "select * from tab_answer where qid = ?";
        return template.query(sql,new BeanPropertyRowMapper<Answer>(Answer.class),qid);
    }

}
