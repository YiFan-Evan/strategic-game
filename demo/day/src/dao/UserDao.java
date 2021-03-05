package dao;

import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import javax.sql.DataSource;

public class UserDao {
    private final JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSourse());
    public User login(User loginUser){
        try {
            String sql="select * from user where name= ? and password = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getName(), loginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int register(User registerUser){
        try {
            String sql="insert into user (name ,password) values ('"+registerUser.getName()+
                    "','"+registerUser.getPassword()+"')";
            return template.update(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
