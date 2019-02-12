package by.dorozhuk.stressjsp.servlets;

import by.dorozhuk.stressjsp.connections.MySqlConnector;
import by.dorozhuk.stressjsp.dao.UserMySqlDao;
import by.dorozhuk.stressjsp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User(
                    req.getParameter("username"),
                    req.getParameter("password"),
                    req.getParameter("firstname"),
                    req.getParameter("lastname"),
                    req.getParameter("email")
            );

            UserMySqlDao.Registration(user);


            if (!user.isValid() && !user.isDupl()){
                resp.sendRedirect("successReg.jsp");
            } else {
                resp.sendRedirect("invalidRegistration.jsp");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
