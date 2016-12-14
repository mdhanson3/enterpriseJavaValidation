package persistence;

import entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by student on 12/13/16.
 */
public class UserDaoTest {
    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void getUser() throws Exception {
        UserDao userDao = new UserDao();

        User user = userDao.getUser(1);

        System.out.println(user.getId() + user.getUserName());
    }

    @Test
    public void getUserByName() throws Exception {
        UserDao userDao = new UserDao();
        User user = userDao.getUserByName("user");

        assertEquals("Returned user's name doesn't match the passed user.", user.getUserName(), "user");

    }

    @Test
    public void addUser() throws Exception {
        /*
        UserDao userDao = new UserDao();
        User user = new User(0, "TestUser9", "TestPass9");

        int id = userDao.addUser(user);

        log.info("Created user with id: " + id);
        */
    }



}