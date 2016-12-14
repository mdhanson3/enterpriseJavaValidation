package persistence;

import entity.User;
import entity.UsersRoles;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
/**
 *
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());


    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    public User getUserByName(String userName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(User.class);
        User user = (User) criteria.add(Restrictions.eq("userName", userName)).uniqueResult();

        return user;
    }
    public int addUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer userId = null;
        log.info("User id before session save: " + user );

        try {
            transaction = session.beginTransaction();
            userId = (Integer) session.save(user);
            //session.save(user);
            log.info("User id after session save: " + userId);
            session.save(createUserRole(user));
            transaction.commit();

            log.info("Added new user: " + user + " with id of: " + userId);

        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return (int) userId;
        //return 0;
    }

    private UsersRoles createUserRole(User user) {
        UsersRoles userRoles = new UsersRoles();
        userRoles.setUserName(user.getUserName());
        userRoles.setRoleName("user");
        return userRoles;
    }
}
