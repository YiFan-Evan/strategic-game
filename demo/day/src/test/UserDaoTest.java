package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("xcvf");
        loginuser.setPassword("lyf20000505");
        UserDao dao = new UserDao();
        User user =dao.login(loginuser);
        System.out.println(user);
    }
}
