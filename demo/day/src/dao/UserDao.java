package dao;

import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import javax.sql.DataSource;

public class UserDao {
    DataSource dataSource;
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSourse());
    public User login(User loginUser){
        try {
            String sql="select * from user where username= ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
