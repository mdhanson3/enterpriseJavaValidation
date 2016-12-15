package controller;

import entity.User;
import entity.UserFile;
import persistence.UserDao;
import persistence.UserFilesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * This class gets all files from the database for a particular user and sends them to a jsp
 *
 * @author Mitchell Hanson
 */
@WebServlet(name = "FileDisplay", urlPatterns = { "/fileDisplay" })
public class FileDisplay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "Principal was null.";
        UserDao userDao = new UserDao();
        Principal principal = request.getUserPrincipal();
        UserFilesDao userFilesDao = new UserFilesDao();
        List<UserFile> fileList;

        //Get list of files according to username
        //Get username

        if(principal != null) {
            username = principal.getName();
        }
        request.setAttribute("principalUserName", username);

        User user = userDao.getUserByName(username);

        fileList = userFilesDao.getFilesByUserId(user);



        //Add list object to request
        request.setAttribute("fileList", fileList);

        //Redirect to fileList.jsp
        getServletContext().getRequestDispatcher("/user/user-panel.jsp").forward(
                request, response);


    }
}
