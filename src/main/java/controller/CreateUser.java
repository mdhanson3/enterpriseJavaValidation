package controller;

import entity.User;
import org.apache.log4j.Logger;
import persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * This class creates a user in the database
 *
 * @author Mitchell Hanson
 */

@WebServlet(name = "CreateUser", urlPatterns = {"/createUser"})

public class CreateUser extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = 0;
        User newUser = new User(0, req.getParameter("userName"), req.getParameter("password"));

        log.debug("adding user: " + newUser);
        UserDao dao = new UserDao();
        id = dao.addUser(newUser);

        if(id != 0) {
            new File("/home/student/Documents/WebApplication/" + Integer.toString(id)).mkdirs();
        } else {
            System.out.println("FAILED TO GET ID");
            System.out.println("User ID from entity: " + newUser.getId());
            System.out.println("User ID returned from add: " + id);
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(
                req, resp);

    }
}
