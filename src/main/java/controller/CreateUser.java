package controller;

import entity.User;
import org.apache.log4j.Logger;
import persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by student on 12/12/16.
 */

@WebServlet(name = "CreateUser", urlPatterns = {"/createUser"})

public class CreateUser extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User newUser = new User(0, req.getParameter("userName"), req.getParameter("password"));

        log.debug("adding user: " + newUser);
        UserDao dao = new UserDao();
        dao.addUser(newUser);

    }
}
