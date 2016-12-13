package persistence;

import entity.User;
import entity.UserFile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 12/13/16.
 */
public class UserFilesDaoTest {
    public User user;
    public UserDao userDao;

    @Before
    public void setup() {
        userDao = new UserDao();
        user = userDao.getUser(1);
        System.out.println(user.getId() + user.getUserName());
        //user.setId(0);


    }

    @Test
    public void addUser() throws Exception {
        UserFile userFile = new UserFile(0, "test/original/file/path", "test/modified/file/path", "testFileName", 0, user);

        UserFilesDao userFilesDao = new UserFilesDao();

        userFilesDao.addUserFile(userFile);



    }

}