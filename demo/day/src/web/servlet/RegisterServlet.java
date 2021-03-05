package web.servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            User registeruser = new User();
            registeruser.setName(username);
            registeruser.setPassword(password);

            Map<String, String[]> map = req.getParameterMap();
            User registerUser = new User();
            try {
                BeanUtils.populate(registerUser, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            UserDao dao = new UserDao();
            int var = dao.register(registeruser);
            if (var == 0) {
                req.getRequestDispatcher("/registerFailServlet").forward(req, resp);
            } else {
                req.setAttribute("user", registeruser);
                req.getRequestDispatcher("/registerSuccessServlet").forward(req, resp);
            }
        } else {
            if (checkCode_session == null) {
                req.setAttribute("cc_notfound", "验证码过期");
            } else {
                req.setAttribute("cc_error", "验证码错误");
            }
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
