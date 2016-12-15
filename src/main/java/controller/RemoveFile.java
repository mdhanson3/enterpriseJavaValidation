package controller;

import entity.UserFile;
import persistence.UserFilesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * This class marks a file in the database as removed
 *
 * @author Mitchell Hanson
 */
@WebServlet(name = "RemoveFile", urlPatterns = { "/RemoveFile" })
public class RemoveFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFilesDao userFilesDao = new UserFilesDao();
        System.out.println(request.getParameter("fileId"));
        int id = Integer.valueOf(request.getParameter("fileId"));
        UserFile userFile = userFilesDao.getUserFile(id);
        userFilesDao.deleteUserFile(userFile);

        response.sendRedirect("/fileDisplay");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
