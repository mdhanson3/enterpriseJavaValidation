package persistence;

import entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 12/13/16.
 */
public class UserDaoTest {
    @Test
    public void getUser() throws Exception {
        UserDao userDao = new UserDao();

        User user = userDao.getUser(1);

        System.out.println(user.getId() + user.getUserName());
    }

    @Test
    public void getUserByName() throws Exception {

    }

    @Test
    public void addUser() throws Exception {

    }

}