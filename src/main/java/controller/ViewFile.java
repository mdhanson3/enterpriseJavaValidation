package controller;

import entity.UserFile;
import persistence.UserDao;
import persistence.UserFilesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet gets display information for a file
 *
 * @author Mitchell Hanson
 */
@WebServlet(name = "ViewFile", urlPatterns = { "/ViewFile" })
public class ViewFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserFilesDao userFileDao = new UserFilesDao();
        int fileId = Integer.valueOf(request.getParameter("fileId"));
        UserFile userFile = userFileDao.getUserFile(fileId);

        String fileContent = userFile.getModifiedFileContent();
        String fileName = userFile.getFileName();

        request.setAttribute("fileContent", fileContent);
        request.setAttribute("fileName", fileName);

        getServletContext().getRequestDispatcher("/user/viewFile.jsp").forward(
                request, response);

    }
}
