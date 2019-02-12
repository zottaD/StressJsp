package by.dorozhuk.stressjsp.servlets;

import by.dorozhuk.stressjsp.dao.UserMySqlDao;
import by.dorozhuk.stressjsp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User(
                    req.getParameter("username"),
                    req.getParameter("password")
            );

            UserMySqlDao.login(user);

            if (user.isValid()){
                HttpSession session = req.getSession(true);
                session.setAttribute("currentUser", user);
                resp.sendRedirect("userLogged.jsp");
            } else {
                resp.sendRedirect("invalidLogin.jsp");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
