package controller;

import java.io.*;
import java.security.Principal;
import java.util.*;
//import javaValidation.validation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.User;
import entity.UserFile;
import javaValidation.FileParserWeb;
import javaValidation.Validation.FileValidator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import org.apache.log4j.Logger;
import persistence.UserDao;
import persistence.UserFilesDao;

@WebServlet(
        name = "FileUpload",
        urlPatterns = { "/FileUploadServlet" }
)

/**
 * This class uploads file information to the database
 *
 * @author Mitchell Hanson
 */
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());

    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sRootPath = "/home/student/Documents/WebApplication";
        String fileName = "defaultFileName";
        String fileContent = "";
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        FileValidator validator = new FileValidator();


        if (!isMultipart) {
            return;
        }

        //Get username
        String username = "Principal was null.";
        Principal principal = request.getUserPrincipal();
        if(principal != null) {
            username = principal.getName();
        }

        request.setAttribute("principalUserName", username);

        UserDao userDao = new UserDao();
        User user = userDao.getUserByName(username);

        sRootPath += "/" + user.getId();


        /*
         *  http://commons.apache.org/proper/commons-fileupload/using.html
         */
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = null;

        // Parse the request
        // items contains a list of file items that must be processed
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();

            if (!item.isFormField()) {

                String fieldName = item.getFieldName();
                fileName = item.getName();
                String contentType = item.getContentType();
                boolean isInMemory = item.isInMemory();
                long sizeInBytes = item.getSize();


                sRootPath += "/" + fileName;

                String[] args = new String[]{sRootPath};
                File file = new File(sRootPath);
                try {
                    item.write(file);
                } catch(Exception e) {
                    log.error("File write error: " + e.toString());
                    e.printStackTrace();
                }

                try {
                    fileContent = validator.runValidation(args);
                } catch(Exception e) {
                    System.out.println("CAUGHT ERROR");
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "Sorry bud, there was an error.  Please try again.");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(
                            request, response);
                }

                request.setAttribute("type", contentType);

            }
        }


        String htmlOutputFile = sRootPath;

        FileParserWeb parser = new FileParserWeb(htmlOutputFile);
        parser.runFileParser();
        items = parser.getFileContents();
        //System.out.println(items);




        //Create user from DB using the username, store file path in db

        UserFile userFile = new UserFile(0, sRootPath, fileContent, fileName, 0, user);

        UserFilesDao userFilesDao = new UserFilesDao();

        userFilesDao.addUserFile(userFile);

        /**
         * *********************************************************************************************************************
         */

        request.setAttribute("fileName", fileName);
        request.setAttribute("fileContents", fileContent);
        getServletContext().getRequestDispatcher("/done.jsp").forward(
                request, response);

    }

}