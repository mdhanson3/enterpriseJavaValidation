package persistence;

import entity.User;
import entity.UserFile;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class UserFilesDaoTest {


    private final Logger log = Logger.getLogger(this.getClass());
    public User user;
    public UserDao userDao;

    @Before
    public void setup() {
        userDao = new UserDao();
        user = userDao.getUser(1);
        System.out.println(user.getId() + user.getUserName());
    }

    @Test
    public void addUser() throws Exception {
        UserFile userFile = new UserFile(0, "test/original/file/path", "test/modified/file/path", "testFileName", 0, user);
        UserFilesDao userFilesDao = new UserFilesDao();
        userFilesDao.addUserFile(userFile);
    }

    @Test
    public void getUserFile() throws Exception {

    }

    @Test
    public void getFilesByUserId() throws Exception {
        UserFilesDao userFilesDao = new UserFilesDao();

        List<UserFile> fileList = userFilesDao.getFilesByUserId(user);

        System.out.println(fileList.size());
        if(!fileList.isEmpty()) {

        } else {
            log.debug("Test list is empty.");
        }
    }

    @Test
    public void deleteUserFile() throws Exception {
        UserFilesDao userFilesDao = new UserFilesDao();
        UserFile userFile = userFilesDao.getUserFile(10);

        System.out.println(userFile.getOriginalFileLocation());
        System.out.println(userFile.getId());
        System.out.println(userFile.getIsDeleted());

        userFilesDao.deleteUserFile(userFile);


    }
}